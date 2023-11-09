package com.queueproject;

import com.queueproject.Interfaces.IQueue;

public class Queue<T extends Object> implements IQueue<T> {
    private QueueNode<T> first;
    private QueueNode<T> last;
    private int size;

    @Override
    public void enqueue(T[] values) {
        for (T value : values) {
            enqueue(value);
        }
    }

    @Override
    public void enqueue(T value) {
        QueueNode<T> newNode = new QueueNode<>(value);

        if (isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.setNext(newNode);
            this.last = newNode;
        }
        this.size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            T value = this.first.getValue();
            this.first = this.first.getNext();
            size--;
            return value;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return this.first.getValue();
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String getContent() {
        if (isEmpty()) {
            return "";
        } else {
            StringBuilder content = new StringBuilder();
            QueueNode<T> current = this.first;
            content.append("FIRST");

            while (current != null) {
                content.append(" -> ").append(current.getValue());
                current = current.getNext();
            }

            return content.toString();
        }
    }

    @Override
    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
}