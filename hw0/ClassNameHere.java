package HW0;

public class ClassNameHere {
    /** Returns the maximum value from m. */
//    public static int max(int[] m) {
//        int length = m.length;
//        int i = 1;
//        int address = 0;
//        while (i<length){
////            if (m[address] <= m[i]){
////                address = i;
////            }
////            i++;
////        }


    /** Returns the maximum value from m using a for loop. */
    public static int forMax(int[] m) {
        int length = m.length;
        int address = 0;
        for (int i = 1; i<length;i++){
            if (m[address] <= m[i]){
                address = i;
            }
        }
        System.out.println(m[address]);
        return address;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        int max_address = forMax(numbers);
//        int max_address = max(numbers);

    }
}