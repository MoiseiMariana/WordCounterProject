import java.util.HashMap;
import java.util.Map;

public class CountWords {

    public static void countTheWords(String providedText){

        String[] sentences = providedText.split("\\.\\s*");

        Map<String, Integer> wordCount = new HashMap<>();

        for (int i = 1; i < sentences.length; i++) {
            // Split the sentence into words
            String[] wordsFromASentence = sentences[i].split("\\s+");

            // Count word frequencies
            for (String word : wordsFromASentence) {
                // Remove special characters and convert to lowercase
                word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

                // Update word count
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }

        // Check if there are duplicated words
        boolean hasRepeatedWords = false;
        for (int count : wordCount.values()) {
            if (count > 1) {
                hasRepeatedWords = true;
                break;
            }
        }

        // If there are no repeated words, throw an exception
        if (!hasRepeatedWords) {
            throw new RuntimeException("No repeated words");
        }

        // Print duplicated words and their counts
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Word: " + entry.getKey() + ", Repeats: " + entry.getValue());
            }
        }
    }
}
