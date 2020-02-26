package HW0;

public class BreakContinue {
    public static void windowPosSum(int[] a, int n) {
        /** your code here */
        int length = a.length;
        if (n>length){
            System.out.println("Error, n is bigger than array length");
        }
        else {
            for (int i = 0; i<length-n; i++){
                if ( a[i] >=0 ){
                    for (int j = 1; j <= n; j++){
                        a[i] = a[i] +a[i+j];
                    }
                }
                else {
                    continue;
                }
            }
            for (int i = length-n; i<length; i++){
                if (a[i]>=0){
                    for (int j=1; j<length-i;j++){
                        a[i] = a[i]+a[i+j];
                    }
                }
                else {
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}
