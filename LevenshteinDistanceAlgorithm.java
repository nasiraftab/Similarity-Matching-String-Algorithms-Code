public class LevenshteinDistanceAlgorithm  {

    public static int calculateLevenshteinDistance(String S1, String S2) {
        // Convert both strings to uppercase for case-insensitive comparison
        S1 = S1.toUpperCase();
        S2 = S2.toUpperCase();

        int len1 = S1.length();
        int len2 = S2.length();

        // Create a 2D array to store distances
        int[][] F = new int[len1 + 1][len2 + 1];

        // Initialize the first column and first row with incremental values
        for (int i = 0; i <= len1; i++) {
            F[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            F[0][j] = j;
        }

        // Fill the 2D array with minimum edit distances
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    F[i][j] = F[i - 1][j - 1]; // No change needed if characters match
                } else {
                    // Minimum of delete (F[i-1][j]), insert (F[i][j-1]), or replace (F[i-1][j-1]) + 1
                    F[i][j] = Math.min(F[i - 1][j], Math.min(F[i][j - 1], F[i - 1][j - 1])) + 1;
                }
            }
        }

        // The Levenshtein distance is found at F[len1][len2]
        return F[len1][len2];
    }

    public static void main(String[] args) {
        String S1 = "kittenu";
        String S2 = "sitting";

        int distance = calculateLevenshteinDistance(S1, S2);
        System.out.println("Levenshtein distance: " + distance);
    }
}
