public class SubsetWeightBook {
    public static void main(String[] args) {
        int X[] = new int[] { 2, 3, 4 };
        int W[] = new int[] { 34, 35, 100 };
        int T = 71;
        int n = X.length;
        System.out.println(SubsetWeight(T, n, W, X));
    }
    private static int SubsetWeight(int T,  int n, int[] W, int[] X) {
        if(n == 0 || T == 0) {
            return 0;
        }
        // if n = 3, then check W[2] > T
        if(W[n - 1] > T) {
            return SubsetWeight(T,  n - 1, W, X);
        }
        else {
            // return maximum of 2 cases: //(1) nth item included //(2) nth item excluded
            // X[2] + subsetWeight(60 - W[2],W,X,2), subsetWeight(60,
            int a = X[n - 1] + SubsetWeight(T - W[n - 1],  n - 1, W, X);
//            System.out.println("A" + a);
            int b = SubsetWeight(T,  n - 1, W, X);
//            System.out.println("B" + b);
            return (a > b) ? a : b;
        }
    }
}
