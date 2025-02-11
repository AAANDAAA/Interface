import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShortListener {
    public static void main(String[] args) {
        // Create a file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a text file");

        // Show the file chooser dialog
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Read words from the file and filter short words
            // I tried to do this without making a different method it did NOT work
            List<String> words = readFromFile(selectedFile);
            List<String> shortWords = filterShortWords(words);

            System.out.println("Short words (length < 5):");
            for (String word : shortWords) {
                System.out.println(word);
            }
        } else {
            System.out.println("No file selected.");
        }
    }
    private static List<String> readFromFile(File file) {
        ArrayList<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file.getAbsolutePath());
        }
        return words;
    }

    // Filter words using ShortWordFilter
    private static List<String> filterShortWords(List<String> words) {
        Filter filter = new ShortWordFilter();
        ArrayList<String> shortWords = new ArrayList<>();
        for (String word : words) {
            if (filter.accept(word)) {
                shortWords.add(word);
            }
        }
        return shortWords;
    }
}

    // Read words from a file
