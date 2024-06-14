package com.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Graph<T> {
    // Map to store the adjacency list of each vertex
    private Map<T, List<Edge<T>>> adjacencyList;

    private final boolean weighted;
    private final boolean directed;

    // Constructors of the Graph class
    public Graph() {
        this.adjacencyList = new HashMap<>();
        this.weighted = false;
        this.directed = false;
    }

    public Graph(boolean weighted, boolean directed) {
        this.adjacencyList = new HashMap<>();
        this.weighted = weighted;
        this.directed = directed;
    }

    // Method to add a vertex to the graph
    public void addVertex(T value) {
        // Check if the vertex does not exist
        if (!this.adjacencyList.containsKey(value)) {
            // Add the vertex to the map with an empty list of neighbors
            this.adjacencyList.put(value, new ArrayList<>());
        }
    }

    // Method to add an edge between two vertices in the graph
    public void addEdge(T from, T to) {
        // Check if the graph is weighted
        if (!this.weighted) {
            // Check if the source and target vertices do not exist and add them if necessary
            if (!this.adjacencyList.containsKey(from)) {
                addVertex(from);
            }
            if (!this.adjacencyList.containsKey(to)) {
                addVertex(to);
            }

            // Add the target vertex as a neighbor in the source vertex's list
            this.adjacencyList.get(from).add(new Edge<>(to));
            
            // If the graph is not directed, add the edge in the opposite direction
            if (!this.directed) {
                this.adjacencyList.get(to).add(new Edge<>(from));
            }
        }
    }

    // Method to add a weighted edge between two vertices in the graph
    public void addEdge(T from, T to, double weight) {
        // Check if the source and target vertices do not exist and add them if necessary
        if (!this.adjacencyList.containsKey(from)) {
            addVertex(from);
        }
        if (!this.adjacencyList.containsKey(to)) {
            addVertex(to);
        }

        // Add the target vertex as a neighbor in the source vertex's list and its weight
        this.adjacencyList.get(from).add(new Edge<>(to, weight));
            
        // If the graph is not directed, add the weighted edge in the opposite direction
        if (!this.directed) {
            this.adjacencyList.get(to).add(new Edge<>(from, weight));
        }
    }

    // Method to count the loops in the graph
    public int countLoops() {
        int count = 0;

        // Traverse all vertices of the graph
        for (T vertex : this.adjacencyList.keySet()) {
            List<Edge<T>> neighbors = this.adjacencyList.get(vertex);

            // Check if the current vertex has an edge to itself
            for (Edge<T> edge : neighbors) {
                if (edge.getValue().equals(vertex)) {
                    count++;
                }
            }
        }

        // Check if the graph is directed
        if (this.directed) {
            // Return the count of loops
            return count;
        } else {
            // If the graph is not directed, each loop will be counted twice, so we divide by 2
            return count / 2;
        }
    }

    // Method to count the multiple edges in the graph
    public int countMultipleEdges() {
        int count = 0;

        // Set to store the unique edges in the graph
        Set<String> edgeSet = new HashSet<>();

        // Traverse all vertices of the graph
        for (T vertex : this.adjacencyList.keySet()) {
            List<Edge<T>> neighbors = this.adjacencyList.get(vertex);

            // Traverse the list of neighbors of a vertex
            for (Edge<T> edge : neighbors) {
                // Build a string representing the edge
                String edgeStr = vertex.toString() + "-" + edge.getValue().toString();

                // Check if the edge already exists in the set
                if (edgeSet.contains(edgeStr)) {
                    count++;
                } else {
                    edgeSet.add(edgeStr);
                }
            }
        }

        // Check if the graph is directed
        if (this.directed) {
            // Return the count of multiple edges
            return count;
        } else {
            // If the graph is not directed, each multiple edge will be counted twice, so we divide by 2
            return count / 2;
        }
    }

    // Method to check if the graph is complete
    public boolean isComplete() {
        // Check if the graph is empty
        if (this.adjacencyList.isEmpty()) {
            return false;
        }
        
        // Traverse all vertices of the graph
        for (T vertex : this.adjacencyList.keySet()) {
            // Set to store the unique edges of a vertex
            Set<Edge<T>> neighborsSet = new HashSet<>();
            
            // Traverse all edges of the current vertex
            for (Edge<T> edge : this.adjacencyList.get(vertex)) {
                // Check if the edge already exists in the set of unique edges
                if (neighborsSet.contains(edge)) {
                    return false; // Return false if there are multiple edges
                }

                // Check if the vertex has a loop
                if (edge.getValue().equals(vertex)) {
                    return false; // Return false if there is a loop
                }

                // Add the edge to the set of unique edges
                neighborsSet.add(edge);
            }
            
            // Check if the number of unique neighbors of the current vertex is equal to the number of vertices minus one
            if (neighborsSet.size() != this.adjacencyList.size() - 1) {
                return false;
            }
        }

        // If it passed all checks, the graph is complete
        return true;
    }

    // Method to get the degree of a specific vertex
    public int getDegree(T vertex) {
        // Check if the vertex does not exist
        if (!this.adjacencyList.containsKey(vertex)) {
            return 0;
        }

        // Return the number of neighbors of the vertex (degree)
        if (!this.directed) {
            // If the graph is not directed, the degree is the size of the neighbors list
            return this.adjacencyList.get(vertex).size();
        } else {
            // If the graph is directed, the degree is the number of edges that have the vertex as the source or target
            int degree = 0;

            // Traverse all vertices of the graph
            for (T vtx : this.adjacencyList.keySet()) {
                List<Edge<T>> neighbors = this.adjacencyList.get(vtx);

                // Check if the current vertex is the target vertex
                if (vtx.equals(vertex)) {
                    degree += neighbors.size(); // Add the number of edges of the target vertex
                } else {
                    // Traverse the list of neighbors of a vertex to find the edges that have the target vertex as the destination
                    for (Edge<T> edge : neighbors) {
                        if (edge.getValue().equals(vertex)) {
                            degree++;
                        }
                    }
                }
            }

            return degree;
        }
    }

    // Method to get the path from one vertex to another
    public String getPath(T from, T to) {
        List<T> path;
        
        if (this.weighted) {
            // Use Dijkstra for weighted graphs
            path = dijkstraShortestPath(from, to);
        } else {
            // Use BFS for unweighted graphs
            path = breadthFirstSearch(from, to);
        }

        // Check if there is a path between the vertices
        if (path == null) {
            return null;
        }

        StringBuilder pathString = new StringBuilder();

        // Iterate over the vertices in the path
        for (T vertex : path) {
            // Add the vertex followed by an arrow
            pathString.append(vertex).append(" -> ");
        }

        // Remove the extra arrow at the end of the path
        if (pathString.length() > 0) {
            pathString.delete(pathString.length() - 4, pathString.length());
        }

        return pathString.toString();
    }

    // Method to perform Breadth-First Search (BFS)
    private List<T> breadthFirstSearch(T from, T to) {
        // Check if the source and target vertices exist in the graph
        if (!this.adjacencyList.containsKey(from) || !this.adjacencyList.containsKey(to)) {
            return null;
        }

        // Map to store the parent of each visited vertex during BFS
        Map<T, T> parentMap = new HashMap<>();
        // Queue for BFS
        Queue<T> queue = new LinkedList<>();
        // Set to track visited vertices
        Set<T> visited = new HashSet<>();

        // Initialize the search with the source vertex
        queue.add(from);
        visited.add(from);
        parentMap.put(from, null); // The initial vertex has no parent

        // Perform BFS
        while (!queue.isEmpty()) {
            T current = queue.poll();

            // Check if the current vertex is the target vertex
            if (current.equals(to)) {
                break;
            }

            // Traverse the neighbors of the current vertex
            for (Edge<T> neighbor : this.adjacencyList.get(current)) {
                // If the neighbor has not been visited, add it to the queue and mark it as visited
                if (!visited.contains(neighbor.getValue())) {
                    queue.add(neighbor.getValue());
                    visited.add(neighbor.getValue());
                    parentMap.put(neighbor.getValue(), current); // Set the parent of the neighbor as the current vertex
                }
            }
        }

        // Check if the target vertex was visited during the search
        if (!visited.contains(to)) {
            return null; // There is no path between the vertices
        }

        // Construct the path from the parentMap
        List<T> path = new ArrayList<>();
        
        T current = to;

        while (current != null) {
            path.add(current);

            current = parentMap.get(current); // Get the next parent vertex
        }

        Collections.reverse(path); // Reverse the order to get the path from the initial vertex to the target vertex
        
        return path;
    }

    // Method to perform Dijkstra's algorithm
    private List<T> dijkstraShortestPath(T from, T to) {
        // Check if the source and target vertices exist in the graph
        if (!this.adjacencyList.containsKey(from) || !this.adjacencyList.containsKey(to)) {
            return null;
        }

        // Map to store the minimum distances of each vertex to the source vertex
        Map<T, Double> distances = new HashMap<>();
        // Map to store the parent of each vertex in the shortest path
        Map<T, T> parentMap = new HashMap<>();
        // Priority queue that orders vertices based on the shortest known distance from the source vertex, using the distances.get method to get the distance of each vertex
        PriorityQueue<T> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        // Initialize all distances as infinite
        for (T vertex : this.adjacencyList.keySet()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }

        // The distance from the source vertex to itself is 0
        distances.put(from, 0.0);

        priorityQueue.add(from);

        // Execute Dijkstra's algorithm
        while (!priorityQueue.isEmpty()) {
            T current = priorityQueue.poll();

            // Check if we have reached the target vertex
            if (current.equals(to)) {
                break;
            }

            // Explore the neighbors of the current vertex
            for (Edge<T> edge : this.adjacencyList.get(current)) {
                T neighbor = edge.getValue();
                double newDist = distances.get(current) + edge.getWeight();

                // Update the minimum distance and the parent if we find a shorter path
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    parentMap.put(neighbor, current);
                    priorityQueue.add(neighbor);
                }
            }
        }

        // Check if there is a path between the vertices
        if (distances.get(to) == Double.POSITIVE_INFINITY) {
            return null;
        }

        // Construct the path from the parentMap
        List<T> path = new ArrayList<>();
        
        T current = to;

        while (current != null) {
            path.add(current);

            current = parentMap.get(current); // Get the next parent vertex
        }

        Collections.reverse(path); // Reverse the order to get the path from the initial vertex to the target vertex
        
        return path;
    }

    // Method to represent the graph as a string
    @Override
    public String toString() {
        // Check if the graph is empty
        if (this.adjacencyList.isEmpty()) {
            return null; // Return null if the graph is empty
        }
        
        StringBuilder graphStr = new StringBuilder();

        // Traverse all vertices of the graph
        for (T vertex : this.adjacencyList.keySet()) {
            // Add the current vertex followed by "{ "
            graphStr.append(vertex).append("{ ");

            List<Edge<T>> neighbors = this.adjacencyList.get(vertex);

            // Add the neighbors of the current vertex
            for (Edge<T> edge : neighbors) {
                // Add the value of the neighbor
                graphStr.append(edge.getValue());

                // Add the weight if the graph is weighted
                if (this.weighted) {
                    graphStr.append("<").append(edge.getWeight()).append(">");
                }

                graphStr.append(" ");
            }

            // Add "}" at the end of the neighbors list of the current vertex
            graphStr.append("} ");
        }

        // Remove the last space from the StringBuilder if it is not empty
        if (graphStr.length() > 0) {
            graphStr.deleteCharAt(graphStr.length() - 1);
        }

        return graphStr.toString();
    }
}