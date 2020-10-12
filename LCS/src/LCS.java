class LCS
{
    public static void main(String[] args)
    {
        String A = "ABCBDAB", B = "BDCABA";
        int lenA = A.length();
        int lenB = B.length();
        System.out.print("The length of LCS is " + length_LCS(A, B, lenA, lenB));
    }
    // Function to find length of Longest Common Subsequence of
    // sequences A[0..m-1] and B[0..n-1]
    public static int length_LCS(String A, String B, int lenA, int lenB)
    {
        // return if we have reached the end of either sequence
        if (lenA == 0 || lenB == 0) {
            return 0;
        }

        // if last character of X and Y matches
        if (A.charAt(lenA - 1) == B.charAt(lenB - 1)) {
            int res = length_LCS(A, B, lenA - 1, lenB - 1) + 1;
            return res;
        }

        // else if last character of X and Y don't match
        int res = Integer.max(length_LCS(A, B, lenA, lenB - 1),
                length_LCS(A, B, lenA - 1, lenB));
        return res;
    }
}