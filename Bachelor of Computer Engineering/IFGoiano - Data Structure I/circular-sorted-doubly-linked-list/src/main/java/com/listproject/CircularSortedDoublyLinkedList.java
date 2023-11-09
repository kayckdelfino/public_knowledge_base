package com.listproject;

import com.listproject.Interfaces.IDoublyLinkedList;
import com.listproject.Interfaces.ISortedList;

public class CircularSortedDoublyLinkedList<T extends Comparable<T>>
        implements ISortedList<T>, IDoublyLinkedList<T> {

    private ListNode<T> first;
    private ListNode<T> last;
    private ListNode<T> navigationPointer;

    @Override
    public void insert(T value) {
        ListNode<T> newElement = new ListNode<>(value);

        if (this.first == null) {
            // If the list is empty, the new element becomes the only node in the list
            this.first = newElement;
            this.first.setNext(this.first);
            this.first.setPrevious(this.first);
            this.last = this.first;
        } else {
            // If the list already contains elements, find the appropriate position to
            // insert the new element
            ListNode<T> current = this.first;

            // Traverse the list to find the correct position based on the element's value
            while (current.getNext() != this.first && current.getNext().getValue().compareTo(value) < 0) {
                current = current.getNext();
            }

            if (current == this.first && current.getValue().compareTo(value) >= 0) {
                // The new element is being inserted at the beginning of the list
                newElement.setNext(this.first);
                newElement.setPrevious(this.last);
                this.first.setPrevious(newElement);
                this.last.setNext(newElement);
                this.first = newElement;
            } else if (current.getNext() == this.first) {
                // The new element is being inserted at the end of the list
                current.setNext(newElement);
                newElement.setPrevious(current);
                newElement.setNext(this.first);
                this.last = newElement;
                this.first.setPrevious(newElement);
            } else {
                // The new element is being inserted in the middle of the list
                newElement.setNext(current.getNext());
                newElement.setPrevious(current);
                current.getNext().setPrevious(newElement);
                current.setNext(newElement);
            }
        }
    }

    @Override
    public boolean remove(T value) {
        if (this.first == null) {
            // If the list is empty, there's nothing to remove
            return false;
        }

        ListNode<T> current = this.first;

        do {
            // Loop to find the desired value in the list
            if (current.getValue().equals(value)) {
                if (current == this.first) {
                    // If the element to be removed is the first node in the list, update this.first pointer to the next node
                    this.first = this.first.getNext();

                    // Check if this.first is now the same as the current node, indicating that the last element was removed
                    if (this.first == current) {
                        this.first = null;
                        this.last = null;
                    }
                }

                if (current == this.last) {
                    // If the element to be removed is the last node in the list, update the this.last pointer to the previous node
                    this.last = this.last.getPrevious();
                }

                // Update pointers to remove the node from the list
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());

                // Removal was successful
                return true;
            }
            current = current.getNext();
        } while (current != this.first);

        // The value was not found in the list, no removal is necessary
        return false;
    }

    @Override
    public T find(T value) {
        if (this.first == null) {
            // If the list is empty, there are no elements to find. Return null
            return null;
        }

        ListNode<T> current = this.first;

        do {
            // Loop to find the desired value in the list
            if (current.getValue().equals(value)) {
                // The value was found, return the found value
                return current.getValue();
            }
            current = current.getNext();
        } while (current != this.first);

        // The value was not found in the list, return null
        return null;
    }

    @Override
    public void clear() {
        // Clears the list by removing all references to nodes
        this.first = null; // Set the first node to null
        this.last = null; // Set the last node to null
        this.navigationPointer = null; // Set the navigation pointer to null
    }

    @Override
    public String listContent() {
        if (this.first == null) {
            // If the list is empty, return a message indicating that the list is empty
            return "List is empty";
        }

        StringBuilder listContent = new StringBuilder();
        ListNode<T> current = this.first;

        do {
            // Loop to build the string representation of the list's elements
            listContent.append(current.getValue()).append(" -> ");
            current = current.getNext();
        } while (current != this.first);

        listContent.append("(circular)"); // Indicates that the list is circular

        return listContent.toString();
    }

    @Override
    public String listContentReverse() {
        if (this.first == null) {
            // If the list is empty, return a message indicating that the list is empty
            return "List is empty";
        }

        StringBuilder listContent = new StringBuilder();
        ListNode<T> current = this.last;

        do {
            // Loop to build the string representation of the elements of the list in
            // reverse order
            listContent.append(current.getValue()).append(" -> ");
            current = current.getPrevious();
        } while (current != this.last);

        listContent.append("(circular)"); // Indicates that the list is circular

        return listContent.toString();
    }

    @Override
    public void clearNavigation() {
        // Reset the navigation pointer, making it point to the first node in the list
        this.navigationPointer = this.first;
    }

    @Override
    public T getNextElement() {
        if (this.navigationPointer == null) {
            // If the navigation pointer is null, point it to the first node in the list
            this.navigationPointer = this.first;
        } else {
            // Advance the navigation pointer to the next node in the list
            this.navigationPointer = this.navigationPointer.getNext();
        }

        return this.navigationPointer.getValue(); // Return the value of the node pointed to by the navigation pointer
    }

    @Override
    public T getPreviousElement() {
        if (this.navigationPointer == null) {
            // If the navigation pointer is null, point it to the last node in the list
            this.navigationPointer = this.last;
        } else {
            // Move the navigation pointer back to the previous node in the list
            this.navigationPointer = this.navigationPointer.getPrevious();
        }

        return this.navigationPointer.getValue(); // Return the value of the node pointed to by the navigation pointer
    }
}