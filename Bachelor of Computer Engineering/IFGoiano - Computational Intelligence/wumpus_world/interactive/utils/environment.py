import random
from typing import Tuple, Dict, List


class World:
    DIRECTIONS: Dict[str, Tuple[int, int]] = {
        "w": (0, 1),  # Norte (y+1)
        "s": (0, -1),  # Sul (y-1)
        "a": (-1, 0),  # Oeste (x-1)
        "d": (1, 0),  # Leste (x+1)
    }

    def __init__(self, size: int = 6, debug: bool = False):
        self.size: int = size
        self.debug: bool = debug

        # Cada célula é uma lista de strings: 'wumpus','pit','gold','bat'
        self.grid: List[List[List[str]]] = [
            [[] for _ in range(size)] for _ in range(size)
        ]

        # Gera lista de posições disponíveis (exceto ponto de entrada)
        positions = [
            (x, y) for x in range(size) for y in range(size) if (x, y) != (0, 0)
        ]
        random.shuffle(positions)

        # Aloca exatamente um elemento por célula, sem sobrescrever
        for element, count in (("wumpus", 2), ("pit", 4), ("gold", 3), ("bat", 2)):
            placed = 0
            while placed < count:
                if not positions:
                    raise RuntimeError("Not enough free positions to place elements.")
                x, y = positions.pop()
                if not self.grid[y][x]:
                    self.grid[y][x].append(element)
                    placed += 1

        self.wumpus_count: int = 2

    def in_bounds(self, x: int, y: int) -> bool:
        return 0 <= x < self.size and 0 <= y < self.size

    def get_percepts(self, agent) -> Dict[str, bool]:
        percepts = {
            "stench": False,
            "breeze": False,
            "shine": False,
            "bat_screech": False,
        }
        x, y = agent.x, agent.y

        # Verifica cada direção
        for dx, dy in self.DIRECTIONS.values():
            nx, ny = x + dx, y + dy
            if self.in_bounds(nx, ny):
                cell = self.grid[ny][nx]
                if "wumpus" in cell:
                    percepts["stench"] = True
                if "pit" in cell:
                    percepts["breeze"] = True
                if "bat" in cell:
                    percepts["bat_screech"] = True

        # Brilho direto de ouro
        if "gold" in self.grid[y][x]:
            percepts["shine"] = True

        return percepts

    def perform_action(self, agent, action: str):
        reward = -1
        event = None

        try:
            # Movimentação
            if action in self.DIRECTIONS:
                dx, dy = self.DIRECTIONS[action]
                nx, ny = agent.x + dx, agent.y + dy
                if not self.in_bounds(nx, ny):
                    event = "bump"
                else:
                    agent.x, agent.y = nx, ny

            # Pegar ouro
            elif action == "pick":
                if "gold" in self.grid[agent.y][agent.x]:
                    agent.gold += 1
                    reward = 1000
                    self.grid[agent.y][agent.x].remove("gold")
                    event = "gold"

            # Atirar 4 flechas nas 4 direções adjacentes
            elif action == "shoot":
                if agent.arrows >= 4:
                    agent.arrows -= 4
                    reward = -4
                    killed = 0
                    for dx, dy in self.DIRECTIONS.values():
                        nx, ny = agent.x + dx, agent.y + dy
                        if self.in_bounds(nx, ny) and "wumpus" in self.grid[ny][nx]:
                            self.grid[ny][nx].remove("wumpus")
                            self.wumpus_count -= 1
                            killed += 1
                    if killed > 0:
                        event = f"wumpus_killed_{killed}"
                else:
                    event = "no_arrows"

            # Subir
            elif action == "climb":
                if (agent.x, agent.y) == (0, 0):
                    event = "exit"
                else:
                    event = "invalid_action"

            else:
                event = "invalid_action"

        except Exception:
            event = "error"

        # Após movimento ou se ação não definiu event
        if event is None:
            cell = self.grid[agent.y][agent.x]

            # Poço
            if "pit" in cell:
                event, reward = "pit", -1000

            # Wumpus
            elif "wumpus" in cell:
                event, reward = "wumpus", -1000

            # Morcego
            elif "bat" in cell:
                # Enquanto cair em 'bat', continua teleport
                while "bat" in cell:
                    self._teleport(agent)

                    # Se cair em pit ou Wumpus, fim de jogo
                    cell = self.grid[agent.y][agent.x]
                    if "pit" in cell:
                        return self.get_percepts(agent), "pit", -1000
                    if "wumpus" in cell:
                        return self.get_percepts(agent), "wumpus", -1000
                event = "bat"

        percepts = self.get_percepts(agent)
        return percepts, event, reward

    def _teleport(self, agent):
        x0, y0 = agent.x, agent.y
        while True:
            nx, ny = random.randrange(self.size), random.randrange(self.size)
            if (nx, ny) != (x0, y0):
                agent.x, agent.y = nx, ny
                break
