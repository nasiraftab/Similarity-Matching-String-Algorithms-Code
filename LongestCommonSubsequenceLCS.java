//The Java code that implements the provided algorithm for finding the longest common subsequence (LCS) between two strings, S1 and S2:
// If you want detailed implementation of this code you may PM
// sendtonasir@gmail.com
public class LongestCommonSubsequenceLCS {

    public static int findLCS(String S1, String S2) {
        // Convert both strings to uppercase
        S1 = S1.toUpperCase();
        S2 = S2.toUpperCase();

        int len1 = S1.length();
        int len2 = S2.length();

        // Create a 2D array to store the LCS lengths
        int[][] F = new int[len1 + 1][len2 + 1];

        // Initialize the first row and first column to 0
        for (int i = 0; i <= len1; i++) {
            F[i][0] = 0;
        }
        for (int j = 0; j <= len2; j++) {
            F[0][j] = 0;
        }

        // Fill the 2D array with LCS lengths
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    F[i][j] = F[i - 1][j - 1] + 1;
                } else {
                    F[i][j] = Math.max(F[i - 1][j], F[i][j - 1]);
                }
            }
        }

        // The length of the longest common subsequence
        int lcsLength = F[len1][len2];

        // Calculate d, the difference between the max length of either string and the LCS length
        int d = Math.max(len1, len2) - lcsLength;

        return d;
    }

    public static void main(String[] args) {
        String S1 = "ABC";
        String S2 = "CDEF";

        int d = findLCS(S1, S2);
        System.out.println("Difference d (max length - LCS length) is: " + d);
    }
}
