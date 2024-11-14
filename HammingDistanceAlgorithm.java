public class HammingDistanceAlgorithm {
// sendtonasir@gmail.com
    public static int calculateHammingDistance(String S1, String S2) {
        // Convert both strings to uppercase for case-insensitive comparison
        S1 = S1.toUpperCase();
        S2 = S2.toUpperCase();

        // Pad the shorter string with spaces until both are of equal length
        while (S1.length() != S2.length()) {
            if (S1.length() < S2.length()) {
                S1 += ' ';
            } else {
                S2 += ' ';
            }
        }

        int d = 0; // Initialize Hamming distance counter

        // Compare characters at each position in the two strings
        for (int i = 0; i < S1.length(); i++) {
            if (S1.charAt(i) != S2.charAt(i)) {
                d++; // Increment distance counter if characters differ
            }
        }

        return d; // Return the Hamming distance
    }

    public static void main(String[] args) {
        String S1 = "sendto";
        String S2 = "sendtonasir";

        int distance = calculateHammingDistance(S1, S2);
        System.out.println("Hamming distance: " + distance);
    }
}
