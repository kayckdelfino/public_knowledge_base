from collections import deque


def bfs(graph, start, goal):
    """
    Implementação tradicional da Busca em Largura (BFS).
    Exibe no console a camada e o nó sendo analisado.
    Retorna uma lista representando o caminho do nó 'start' até o nó 'goal'.
    """
    queue = deque([start])
    visited = {start}
    parent = {start: None}

    layer = {start: 0}

    while queue:
        current = queue.popleft()
        current_layer = layer[current]
        print(f"[BFS] [Layer {current_layer}] Analyzing node: {current}")

        if current == goal:
            path = []
            while current:
                path.append(current)
                current = parent[current]
            return path[::-1]

        for neighbor in graph.get(current, []):
            if neighbor not in visited:
                visited.add(neighbor)
                parent[neighbor] = current
                queue.append(neighbor)
                layer[neighbor] = current_layer + 1

    return None


def bidirectional_bfs(graph, start, goal):
    """
    Implementação da Busca Bidirecional.
    Exibe no console a camada e o nó sendo analisado de cada lado (start e goal).
    Retorna uma lista representando o caminho do nó 'start' até o nó 'goal', se existir.
    """
    if start == goal:
        return [start]

    queue_start = deque([start])
    queue_goal = deque([goal])
    visited_start = {start}
    visited_goal = {goal}
    parent_start = {start: None}
    parent_goal = {goal: None}

    layer_start = {start: 0}
    layer_goal = {goal: 0}

    def construct_path(meet):
        """
        Função auxiliar para reconstruir o caminho a partir do ponto de encontro.
        Combina o caminho da origem até o ponto de encontro e o caminho do objetivo até o ponto de encontro.
        """
        path_start = []
        current = meet
        while current is not None:
            path_start.append(current)
            current = parent_start[current]
        path_start = path_start[::-1]

        path_goal = []
        current = parent_goal[meet]
        while current is not None:
            path_goal.append(current)
            current = parent_goal[current]

        return path_start + path_goal

    while queue_start and queue_goal:
        current_start = queue_start.popleft()
        current_layer_start = layer_start[current_start]
        print(
            f"[Bidirectional BFS - Start Side] [Layer {current_layer_start}] Analyzing node: {current_start}"
        )
        for neighbor in graph.get(current_start, []):
            if neighbor not in visited_start:
                visited_start.add(neighbor)
                parent_start[neighbor] = current_start
                queue_start.append(neighbor)
                layer_start[neighbor] = current_layer_start + 1
                if neighbor in visited_goal:
                    return construct_path(neighbor)

        current_goal = queue_goal.popleft()
        current_layer_goal = layer_goal[current_goal]
        print(
            f"[Bidirectional BFS - Goal Side] [Layer {current_layer_start}] Analyzing node: {current_goal}"
        )
        for neighbor in graph.get(current_goal, []):
            if neighbor not in visited_goal:
                visited_goal.add(neighbor)
                parent_goal[neighbor] = current_goal
                queue_goal.append(neighbor)
                layer_goal[neighbor] = current_layer_goal + 1
                if neighbor in visited_start:
                    return construct_path(neighbor)

    return None
