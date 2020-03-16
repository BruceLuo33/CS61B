package Flik;

public class HorribleSteve {
    public static void main(String [] args) {
        int i = 0;
//        int tmp = 0;
        for (int j = 0; i < 500; ++i, ++j) {
//            tmp = i;
//            System.out.print("i is " + i +", ");
//            System.out.println("j is "+ j);
            if (!Flik.isSameNumber(i, j)) {
                break; // break exits the for loop!
            }
//            if (i!=j) {
//                break;
//            }
        }
        System.out.println("i is " + i);
    }
}
