import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String providedText = "The enormous room on the ground floor faced towards the north. Cold for all the summer beyond the panes, for all the tropical heat of the room itself, a harsh thin light glared through the windows, hungrily seeking some draped lay figure, some pallid shape of academic gooseflesh, but finding only the glass and nickel and bleakly shining porcelain of a laboratory. Wintriness responded to wintriness. The overalls of the workers were white, their hands gloved with a pale corpse-colored rubber. The light was frozen, dead, a ghost. Only from the yellow barrels of the microscopes did it borrow a certain rich and living substance, lying along the polished tubes like butter, streak after luscious streak in long recession down the worktables.";

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