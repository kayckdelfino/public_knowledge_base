package com.project;

public class Edge<T> {
    T value;  // Value of the adjacent vertex
    double weight = 0;  // Weight of the edge (default is 0 if not weighted)

    // Constructor for an edge without weight
    public Edge(T value) {
        this.value = value;
    }

    // Constructor for an edge with weight
    public Edge(T value, double weight) {
        this.value = value;
        this.weight = weight;
    }

    public T getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }
}