import java.util.Scanner;

public class DanceRecital {

    public static String[] dancrs;
    public static int[][] expense;
    public static int noOfRoutines;

    public static int quickChange(String x, String y) {
//        System.out.println("X: " + x);
//        System.out.println("Y: " + y);
        int count = 0;
        for (int i = 0; i < x.length(); i++) {
            if (y.contains(x.charAt(i) + ""))
                count++;
        }
        return count;
    }

    public static int solve(int[] permutation, boolean[] usedLetter, int m) {

        // Base Case
        if (m == noOfRoutines) {
            return evaluate(permutation);
        }

        int result = 1000000;

        for (int i = 0; i < noOfRoutines; i++) {
            if (!usedLetter[i]) {

                permutation[m] = i;
                usedLetter[i] = true;
                // Recursive call
                result = Math.min(result, solve(permutation, usedLetter, m+1));
                usedLetter[i] = false;
            }
        }
        return result;
    }

    public static int evaluate(int[] permutation) {
        int result = 0;

        for (int i = 0; i < noOfRoutines - 1; i++) {
            result = result + expense[permutation[i]][permutation[i+1]];
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        noOfRoutines = input.nextInt();
        //System.out.println("R:" + noOfRoutines);

        if((2 <= noOfRoutines) && (noOfRoutines <=10)) {
            // Setting values in dancers
            dancrs = new String[noOfRoutines];
            for (int i = 0; i < noOfRoutines; i++) {
                dancrs[i] = input.next();
            }

            expense = new int[noOfRoutines][noOfRoutines];
            // Pre-computing the expense table
            for (int i = 0; i < noOfRoutines; i++) {
                for (int j = 0; j < noOfRoutines; j++) {
                    expense[i][j] = quickChange(dancrs[i], dancrs[j]);
                }
            }

            boolean[] usedLetter = new boolean[noOfRoutines];
            int[] permutation = new int[noOfRoutines];
            System.out.println(solve(permutation, usedLetter, 0));
        }
    }
}
