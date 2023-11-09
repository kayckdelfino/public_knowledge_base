package com.listproject.Interfaces;

public interface IDoublyLinkedList<T extends Object> extends IList<T> {
    public String listContent();

    public String listContentReverse();

    public T getNextElement();

    public T getPreviousElement();
}