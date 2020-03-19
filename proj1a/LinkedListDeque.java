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
        

        sentinel.next.next.prev = sentinel;
        sentinel = sentinel.next.next;
        size-=1;
        return sentinel.next.item;

    }

//    public T removeLast() {
//
//    }

//    public T get(int index) {
//
//    }

//    public T getRecursive(int index) {
//
//    }

    public static void main(String[] args) {
//        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        LinkedListDeque<Integer> L = new LinkedListDeque<>(5);
        L.addFirst(10);
        L.addLast(20);
        L.addLast(30);
        L.addLast(40);
        L.addFirst(6);
//        L.printDeque();
        System.out.println(L.isEmpty());
        L.removeFirst();
        System.out.println(L.removeFirst());
//        System.out.println("Passed");
    }

}
