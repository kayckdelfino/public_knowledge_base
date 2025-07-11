from graph.data import graph
from search_algorithms import bfs, bidirectional_bfs


def main():
    start_node = "A"
    goal_node = "P"

    path_bfs = bfs(graph, start_node, goal_node)
    print("Traditional BFS path:", path_bfs)

    path_bidirectional = bidirectional_bfs(graph, start_node, goal_node)
    print("Bidirectional BFS path:", path_bidirectional)


if __name__ == "__main__":
    main()
