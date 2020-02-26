package HW0;

public class ClassNameHere {
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
    }
}
