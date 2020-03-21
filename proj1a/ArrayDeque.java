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

    private int addOne (int idx) {
        return (idx + 1) % items.length;
    }

    private int deleteOne (int idx) {
        return (idx - 1 + items.length) % items.length;
    }

    private void resize(int capacity){
        /* The nextIndex point at the next place to add item in front of the entire array.
        * Thus, to arrange the old array to the resize array, the pointer should go back to the
        * place with item, such as int/char, then loop "size" times to reach the end of the array,
        * which is the place with index of nextLast - 1.*/
        T[] newArray = (T[]) new Object[capacity];
        int originIndex = addOne(nextFirst);
        for (int resizeIndex = 0; resizeIndex < size; resizeIndex ++) {
            newArray[resizeIndex] = items[originIndex];
            originIndex = addOne(originIndex);
        }
        items = newArray;
        nextFirst = deleteOne(0);
        nextLast = size;
    }

    public void addFirst(T item) {
        if (isFull()) {
            resize(size * 2);
        }

        items[nextFirst] = item;
        nextFirst = deleteOne(nextFirst);
//        nextFirst -= 1;
        size += 1;
    }

    public void addLast(T item) {
        if (isFull()) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = addOne(nextLast);
//        nextLast += 1;
        size += 1;
    }

    private boolean isFull() {
        return size == items.length;
    }

    private boolean isSparse() {
        return size < items.length / 4;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int count = addOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(items[count] + " ");
            count = addOne(count);
        }
        System.out.println();
    }

    private T getFirst() {
        return items[addOne(nextFirst)];
    }

    public T removeFirst() {
        if (isSparse()) {
            resize(items.length / 2);
        }
        T x = getFirst();
        nextFirst = addOne(nextFirst);
        items[nextFirst] = null;
        size -= 1;
        return x;
    }

    private T getLast() {
        return items[deleteOne(nextLast)];
    }

    public T removeLast() {
        if (isSparse()) {
            resize(items.length / 2);
        }
        T x = getLast();
        nextLast = deleteOne(nextLast);
        items[nextLast] = null;
        deleteOne(nextLast);
        size -= 1;
        return x;
    }

    public T get(int index) {
        int tmp = (addOne(nextFirst) + index)  % items.length;
        return items[tmp];
    }

//    public static void main(String[] args) {
//        ArrayDeque<Integer> A = new ArrayDeque<>();
//        for (int i =0; i<10; i++) {
//            A.addFirst(i);
//        }
////        A.addLast(4);
////        A.addLast(45);
//        A.printDeque();
//
//        A.removeFirst();
//        A.printDeque();
//
//        A.removeLast();
////        System.out.println(A);
//        A.printDeque();
//        System.out.println(A.get(2));
//    }

}
