package es.datastructur.synthesizer;

public interface BoundedQueue<T> {

    // return size of the buffer
    int capacity();

    // return number of items currently in the buffer
    int fillCount();

    // add item x to the end
    void enqueue(T x);

    // delete and return item from the front
    T dequeue();

    // return (but do not delete) item form the front
    T peek();

    // is the buffer empty (fillCount equals zero)?
    default boolean isEmpty() {
        return false;
    }

    // if the buffer full (fullCount is same as capacity)?
    default boolean isFull() {
        return false;
    }



}
