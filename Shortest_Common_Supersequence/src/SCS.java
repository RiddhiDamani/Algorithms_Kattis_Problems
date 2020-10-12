public class SCS {
    public static void main(String[] args) {
        int[] X = {2, 3, 1};
        int[] Y = {3, 5, 1};
        System.out.println("Length of the shortest" +
                "supersequence is: "
                + superSeq(X, Y, String.valueOf(X).length(),String.valueOf(Y).length()));
    }

    static int superSeq(int[] X, int[] Y,
                        int m, int n)
    {
        if (m == 0) return n;
        if (n == 0) return m;

        if (X[m - 1] == Y[n - 1])
            return 1 + superSeq(X, Y, m - 1, n - 1);

        return 1 + Math.min(superSeq(X, Y, m - 1, n),
                superSeq(X, Y, m, n - 1));
    }
}
