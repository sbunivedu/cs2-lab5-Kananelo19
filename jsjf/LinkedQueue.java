package jsjf;

import jsjf.exceptions.EmptyCollectionException;

/**
 * LinkedQueue represents a linked implementation of a queue.
 */
public class LinkedQueue<T> implements QueueADT<T> {
    private int count; // Number of elements in the queue
    private LinearNode<T> head, tail; // References to the head and tail of the queue

    /**
     * Creates an empty queue.
     */
    public LinkedQueue() {
        count = 0;
        head = tail = null;
    }

    /**
     * Adds the specified element to the tail of this queue.
     * @param element the element to be added to the tail of the queue
     */
    public void enqueue(T element) {
        LinearNode<T> node = new LinearNode<>(element);
        if (isEmpty()) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
        count++;
    }

    /**
     * Removes the element at the head of this queue and returns it.
     * @return the element at the head of this queue
     * @throws EmptyCollectionException if the queue is empty
     */
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        T result = head.getElement();
        head = head.getNext();
        count--;
        if (isEmpty()) {
            tail = null;
        }
        return result;
    }

    /**
     * Returns the element at the head of this queue without removing it.
     * @return the element at the head of this queue
     * @throws EmptyCollectionException if the queue is empty
     */
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        return head.getElement();
    }

    /**
     * Returns true if this queue is empty, otherwise false.
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Returns the number of elements in the queue.
     * @return the number of elements in the queue
     */
    public int size() {
        return count;
    }

    /**
     * Returns a string representation of the queue.
     * @return string representing the queue
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        LinearNode<T> current = head;
        while (current != null) {
            result.append(current.getElement()).append(" ");
            current = current.getNext();
        }
        return result.toString();
    }
}
