package com.listproject.Interfaces;

public interface ISortedList<T extends Comparable<?>> extends IList<T> {
    public void insert(T value);
}