// Count of subsets with sum equal to X using Recursion
public class SubsetSumBook {
    public static void main(String[] args) {

        int X[] = { 1, 2, 3, 4, 5 };
        int sum = 10;
        int noOfElements = X.length;

        System.out.print(subsetSum(X, noOfElements, sum, 0, 0));
    }

    // Recursive function to return the count of subsets with sum = given value
    private static int subsetSum(int[] X, int noOfElements, int sum, int count, int i) {
        // Base Case - Recursion stops at Nth level where all the subsets of given array
        // have been checked.
        if(i == noOfElements) {
            // Incrementing the count if sum == 0 and returning the count
            if(sum == 0) {
                count++;
            }
            return count;
        }
        // Recursively calling the function for two cases
        // Either the element can be counted in the subset
        // If the element is counted, then the remaining sum
        // to be checked is sum - the selected element
        // If the element is not included, then the remaining sum
        // to be checked is the total sum
        count = subsetSum(X, noOfElements, sum, count, i + 1);
        count = subsetSum(X, noOfElements, sum - X[i], count, i+1);
        return count;

    }
}
// Simple return true or false if there is subset of sum in the array as per book -page 78
//public class SubsetSumBook {
//    public static void main(String[] args) {
//
//        int X[] = { 3, 34, 4, 12, 5, 2 };
//        int sum = 9;
//        int i = X.length;
//
//        if(subsetSum(X, i, sum) == true) {
//            System.out.println("Found a subset with a given sum");
//        }
//        else {
//            System.out.println("No Subset with given sum");
//        }
//    }
//
//    private static boolean subsetSum(int[] X, int i, int sum) {
//        // Base Cases
//        if(sum == 0) {
//            return true;
//        }
//        if( sum < 0 || i==0) {
//            return false;
//        }
//        // if last element > sum, then ignore it
//        if(X[i-1] > sum) {
//            return subsetSum(X, i-1, sum);
//        }
//        // else check if sum can be obtained by any of following:
//        // a) incl. last element
//        // b) excl. last element
//        else {
//            boolean with = subsetSum(X, i-1, sum - X[i-1]);
//            boolean without = subsetSum(X, i-1, sum);
//            return with || without;
//        }
//
//    }
//}
