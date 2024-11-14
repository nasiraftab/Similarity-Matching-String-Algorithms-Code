import java.util.HashSet;
import java.util.Set;
// Mr M. Nasir Create and Test this code using eclipse
// If you want more advance version of this algorithm you can ping :
// sendtonasir@gmail.com
public class JaccardSimilarity {

    public static double calculateJaccardSimilarity(String s1, String s2) {
        // Convert both strings to uppercase
        s1 = s1.toUpperCase();
        s2 = s2.toUpperCase();

        // Use sets to store unique characters from each string
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        // Add characters of s1 to set1
        for (char ch : s1.toCharArray()) {
            set1.add(ch);
        }

        // Add characters of s2 to set2
        for (char ch : s2.toCharArray()) {
            set2.add(ch);
        }

        // Find intersection of set1 and set2
        Set<Character> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);  // Keeps only elements that are in both sets

        // Find union of set1 and set2
        Set<Character> union = new HashSet<>(set1);
        union.addAll(set2);  // Combines elements from both sets

        // Calculate the Jaccard similarity
        double jaccardSimilarity = (double) intersection.size() / union.size();
        return jaccardSimilarity;
    }

    public static void main(String[] args) {
        String str1 = "example";
        String str2 = "samples";

        double similarity = calculateJaccardSimilarity(str1, str2);
        System.out.println("Jaccard Similarity: " + similarity);
    }
}
