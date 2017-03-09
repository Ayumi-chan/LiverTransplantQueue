
public interface PriorityQueue<E>
    {
    boolean isEmpty();
    void add(E x);
    //Retrieves, but does not remove, the head of this queue, returning null if this queue is empty.
    E poll();
    //Retrieves and removes the head of this queue, or null if this queue is empty.
    E peek();
    int size();
    }
