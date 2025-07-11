from collections import deque
from typing import Dict, Tuple, List, Set


class Agent:
    DIRECTIONS: Dict[str, Tuple[int, int]] = {
        "w": (0, 1),  # Norte
        "s": (0, -1),  # Sul
        "a": (-1, 0),  # Oeste
        "d": (1, 0),  # Leste
    }

    def __init__(self, world):
        self.world = world
        self.x = 0
        self.y = 0
        self.arrows = 8
        self.gold = 0
        self.score = 0

        # Memória de exploração
        self.visited: Set[Tuple[int, int]] = {(0, 0)}

        # Base de conhecimento simplificada: para cada célula, pit e wumpus = {'unknown', 'possible', 'safe'}
        self.knowledge: Dict[Tuple[int, int], Dict[str, str]] = {
            (i, j): {"pit": "unknown", "wumpus": "unknown"}
            for i in range(world.size)
            for j in range(world.size)
        }
        self.knowledge[(0, 0)] = {"pit": "safe", "wumpus": "safe"}

        # Fila de ações
        self.action_queue: List[str] = []

    def _neighbors(self, coord: Tuple[int, int]) -> List[Tuple[int, int]]:
        x, y = coord
        nbrs = []
        for dx, dy in self.DIRECTIONS.values():
            nx, ny = x + dx, y + dy
            if 0 <= nx < self.world.size and 0 <= ny < self.world.size:
                nbrs.append((nx, ny))
        return nbrs

    def update_knowledge(self, percepts: Dict[str, bool]):
        coord = (self.x, self.y)
        self.visited.add(coord)

        # Para pit e wumpus
        for hazard, flag in (("pit", "breeze"), ("wumpus", "stench")):
            nbrs = self._neighbors(coord)
            if percepts.get(flag):
                # Vizinhos unknown -> possible
                for n in nbrs:
                    if self.knowledge[n][hazard] == "unknown" and n not in self.visited:
                        self.knowledge[n][hazard] = "possible"
            else:
                # Vizinhos unknown/possible -> safe
                for n in nbrs:
                    if self.knowledge[n][hazard] in ("unknown", "possible"):
                        self.knowledge[n][hazard] = "safe"

    def _is_safe(self, cell: Tuple[int, int]) -> bool:
        kb = self.knowledge[cell]
        return kb["pit"] == "safe" and kb["wumpus"] == "safe"

    def _bfs(
        self, start: Tuple[int, int], goals: Set[Tuple[int, int]]
    ) -> List[Tuple[int, int]]:
        queue = deque([[start]])
        seen = {start}
        while queue:
            path = queue.popleft()
            if path[-1] in goals:
                return path
            for n in self._neighbors(path[-1]):
                if n not in seen and self._is_safe(n):
                    seen.add(n)
                    queue.append(path + [n])
        return []

    def _path_to_actions(self, path: List[Tuple[int, int]]) -> List[str]:
        acts = []
        for (cx, cy), (nx, ny) in zip(path, path[1:]):
            if nx == cx and ny == cy + 1:
                acts.append("w")
            if nx == cx and ny == cy - 1:
                acts.append("s")
            if nx == cx + 1 and ny == cy:
                acts.append("d")
            if nx == cx - 1 and ny == cy:
                acts.append("a")
        return acts

    def plan(self, percepts: Dict[str, bool]):
        # Atualiza conhecimento e gera uma nova fila de ações:
        # 1) 'pick' se glitter
        # 2) 'shoot' se stench
        # 3) explorar próximo safe não-visitado
        # 4) se gold>0 e nenhum 'safe' restante, retornar
        # 5) se nada para explorar e sem gold, 'climb'
        self.update_knowledge(percepts)
        coord = (self.x, self.y)

        # 1) Pegar ouro
        if percepts.get("shine"):
            self.action_queue = ["pick"]
            return

        # 2) Atirar em wumpus adjacente possível
        if percepts.get("stench") and self.arrows > 0:
            for d, (dx, dy) in self.DIRECTIONS.items():
                n = (self.x + dx, self.y + dy)
                if n in self.knowledge and self.knowledge[n]["wumpus"] == "possible":
                    self.action_queue = ["shoot"]
                    return

        # 3) Explorar conjunto de células 'safe' mas não visitadas
        frontier = {
            c
            for c, kb in self.knowledge.items()
            if kb["pit"] == "safe" and kb["wumpus"] == "safe" and c not in self.visited
        }
        if frontier:
            path = self._bfs(coord, frontier)
            if path:
                self.action_queue = self._path_to_actions(path)
                return

        # 4) Se coletou algo, retorna à entrada
        if self.gold > 0:
            path = self._bfs(coord, {(0, 0)})
            if path:
                self.action_queue = self._path_to_actions(path) + ["climb"]
                return

        # 5) Nada a fazer -> 'climb'
        self.action_queue = ["climb"]

    def next_action(self, percepts: Dict[str, bool]) -> str:
        if not self.action_queue:
            self.plan(percepts)
        return self.action_queue.pop(0)
