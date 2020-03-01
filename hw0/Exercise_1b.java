public class HW0_Exercise_1b {
    public static void drawTriangle(int N){
        int i=1;
        while (i <= N) {
            int j =0;
            while (j<i) {
                System.out.print("*");
                j++;
            }
            System.out.println("");
            i++;
        }
    }
    public static void main(String[] args) {
        drawTriangle(8);
    }
}
