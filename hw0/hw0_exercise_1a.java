public class hw0_exercise_1a {
    public static void main(String[] args){
        int count=5;
        int i=1;
        while (i <= count) {
            int j =0;
            while (j<i) {
                System.out.print("*");
                j++;
            }
            System.out.println("");
            i++;
        }
    }
}
