public class ArrayDeque<T> {
    /* Starting size of the array should be 8 */
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    public void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst -= 1;
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast += 1;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }
//
//    public void printDeque() {
//
//    }
//
//    public T removeFirst() {
//        nextFirst += 1;
//    }
//
//    public T removeLast() {
//        nextLast -= 1;
//        return items[nextLast-1]
//    }
//
//    public T get(int index) {
//
//    }

    public static void main(String[] args) {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        for (int i =0;i<8;i++) {
            A.addLast(i);
        }
//        A.addLast(4);
//        A.addLast(45);
        System.out.println(A);
    }

}
