public class LinkedListDeque<T> {

    private class TNode {
        public TNode prev;
        public T item;
        public TNode next;
        public TNode(TNode p, T t, TNode n) {
            prev = p;
            item = t;
            next = n;
//            System.out.println("Size of the node is: "+size);
        }
    }

    //    private T item;
    private int size;
    private TNode sentinel;
    /* Initialization for an empty LinkedListDeque */
    public LinkedListDeque() {
        sentinel = new TNode(null,(T)"null",null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
//        sentinel.next = new TNode(sentinel,(T)"null",sentinel);
        size = 0;
    }

    /* The first item(if it exists) is at sentinel.next. */
    public LinkedListDeque(T t) {
        T t1 = null;
        sentinel =  new TNode(null, (T)"null",null);
        sentinel.next = new TNode(sentinel, t,sentinel);
        sentinel.prev =  sentinel.next;
//        sentinel.next.next = sentinel.prev;
        size = 1;
        System.out.println("The new size is: "+size);
    }

    public void addFirst(T item) {
        sentinel.next = new TNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size+=1;
    }

    public void addLast(T item) {
        sentinel.prev = new TNode(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
//        sentinel.prev.prev.next.next = sentinel.prev;
//        sentinel.prev.prev = sentinel.prev.prev.next;
        size+=1;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return  size;
    }

    public void printDeque() {
        if (sentinel.next.item == sentinel.item) {
            System.out.println("It is a null list.");
            return;
        }
        for (int i = 0; i<size; i++) {
            System.out.println(sentinel.next.item);
            sentinel.next = sentinel.next.next;
        }
    }

    public T removeFirst() {
        if (sentinel.next.item == sentinel.item) {
            return null;
        }
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
//        sentinel.next.next.prev = sentinel;
//        sentinel = sentinel.next.next;
        size-=1;
        return sentinel.next.item;
    }

    public T removeLast() {
        if (sentinel.prev.item == sentinel.item) {
            return null;
        }
        sentinel.prev = sentinel.prev.prev;
//        sentinel.next = sentinel.prev.prev.next;
        sentinel.prev.next = sentinel;
        return sentinel.prev.item;
    }

    public T get(int index) {
        if (sentinel.prev.item == sentinel.item) {
            return null;
        }
        if (index > size - 1) {
            return null;
        }
        for (int i = 0; i <= index; i++) {
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
        }
        return sentinel.next.item;
    }

    public T getRecursive(int index) {
        if (sentinel.prev.item == sentinel.item) {
            return null;
        }
        if (index > size - 1) {
            return null;
        }
        int cnt = 0;
        return getRecursiveHelper(cnt, sentinel, index);

    }

    public T getRecursiveHelper(int cnt, TNode sentinel, int index) {
        if (cnt == index) {
            return sentinel.next.item;
        }
        return getRecursiveHelper(cnt+1, sentinel.next, index);
    }

    public static void main(String[] args) {
        /* Create a null list */
//        LinkedListDeque<Integer> L = new LinkedListDeque<>();

        /* Create a Integer list of [6, 10, 5, 20,30,40] */
        LinkedListDeque<Integer> L = new LinkedListDeque<>(5);
        L.addFirst(10);
        L.addLast(20);
        L.addLast(30);
        L.addLast(40);
        L.addFirst(6);
//        L.printDeque();
        System.out.println(L.isEmpty());
//        System.out.println("The last item after the removeFirst function is: "+ L.removeFirst());
//        System.out.println("The last item after the removeLast function is: "+ L.removeLast());
        int Index = 2;
//        System.out.println("The item in index "+ Index + " is " + L.get(Index));
//        System.out.println("The item in index "+ Index + " is " + L.getRecursive(Index));
        System.out.println("Passed");
    }

}
