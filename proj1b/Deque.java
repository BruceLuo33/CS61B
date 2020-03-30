public interface Deque<T> {


    public void addFirst(T item);

    public void addLast(T item);

    public T removeFirst();

    public T removeLast();

    public boolean isEmpty();

    public int size();

    public T get(int index);

    public void printDeque();

    /* The getRecursive method only implemented in the LinkedListDeque*/
//    public T getRecursive(int index);



}
