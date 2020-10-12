public class TurnPike {
    public static void main(String args[]) {
        // Solution 2.a
//        int i = 1;
//        int j = 3;
//        int cost = 0;
//        int[] c = {5,7,4,9};
//
//        for(int k=i-1; k <= j-2; k++) {
//            cost = cost + c[k];
//        }
//        System.out.println(cost);

        // Solution 2.b
//        final int[][] matrix = {
//                { 0, 5, 12, 16, 25 },
//                { 5, 0, 7, 11, 20 },
//                { 12, 7, 0, 4, 13 },
//                { 16, 11, 4, 0, 9},
//                { 25, 20, 13, 9, 0}
//        };

//        for (int i = 0; i < matrix.length; i++) { //this equals to the row in our matrix.
//            for (int j = 0; j < matrix[i].length; j++) { //this equals to the column in each row.
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println(); //change line on console as row comes to end in the matrix.
//        }

//        int i = 1;
//        int j = 3;
//        int cost = matrix[i-1][j-1];
//        System.out.println(cost);

        // Solution 2.c
        int[] totalCost = {0,5,12,16,25};
        int i = 1;
        int j = 5;
        int cost = Math.abs(totalCost[i-1] - totalCost[j-1]);
        System.out.println(cost);
    }
}
