public interface Animal {
    default void greet(Animal a) {
        System.out.println("hello animal");
    }
    default void sniff(Animal a) {
        System.out.println("sniff animal");
    }
    default void flatter(Animal a) {
        System.out.println("u r cool animal");
    }
}
