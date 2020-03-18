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
//        sentinel.next = new TNode(sentinel,(T)"null",sentinel);
        size = 0;
    }

//    /* The first item(if it exists) is at sentinel.next. */
//    public LinkedListDeque(T t) {
//        T t1 = null;
//        sentinel =  new TNode(null, t,null);
//        sentinel.next = new TNode(sentinel, t,sentinel);
//        sentinel.next.prev =  sentinel.next;
//        size+=1;
////        System.out.println("The new size is: "+size);
//    }
//
//    public void addFirst(T item) {
//        sentinel.next = new TNode(sentinel.prev, item, sentinel.next);
//    }
////
//    public void addLast(T item) {
//
//    }
//
//    public boolean isEmpty() {
//
//    }
//
    public int size() {
        return  size;
    }
//
//    public void printDeque() {
//
//    }
//
//    public T removeFirst() {
//
//    }
//
//    public T removeLast() {
//
//    }
//
//    public T get(int index) {
//
//    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
//        LinkedListDeque<Integer> L = new LinkedListDeque<>(5);
//        L.addFirst(20);
//        System.out.println("Passed");
    }

}
