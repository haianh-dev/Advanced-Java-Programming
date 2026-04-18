package bai4.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {
    String text;

    public WordCounter(String text) {
        this.text = text;
    }

    public HashMap<String, Integer> analyze() {
        String lowerCaseText =  this.text.toLowerCase();
        String normalizedText = lowerCaseText.replaceAll("[^a-z0-9\\s]", "");

        String[] words = normalizedText.split("\\s+");
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        return wordCount;
    }

    public void displayResult(HashMap<String, Integer> wordCount) {
        System.out.println("- Danh sach cac tu va so luong: ");
        for (Map.Entry<String, Integer> entry: wordCount.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println(key + ": " + value);
        }

        int maxVal = 0;
        List<String> mostFrequentWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: wordCount.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
                mostFrequentWords.clear();
                mostFrequentWords.add(entry.getKey());
            }
        }

        String frequentWord = String.join(", ", mostFrequentWords);
        System.out.println("- Tu xuat hien nhieu nhat: " + frequentWord + " (xuat hien " + maxVal + " lan)");
    }

    public static void main(String[] args) {
        String text = "Hello world. This is a java program. Hello java, hello world.";
        WordCounter wordCounter = new WordCounter(text);
        HashMap<String, Integer> wordCount = wordCounter.analyze();
        wordCounter.displayResult(wordCount);

    }
}
