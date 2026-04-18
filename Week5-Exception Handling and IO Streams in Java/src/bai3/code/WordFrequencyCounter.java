package bai3.code;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordFrequencyCounter {
    public void main(String[] args) {
        String essay = "The rain had just stopped, leaving the streets shimmering under the soft glow of streetlights. " +
                "Puddles reflected fragments of the city, like broken mirrors scattered across the ground. A quiet breeze " +
                "drifted through the air, carrying the faint scent of wet asphalt and blooming flowers. People moved a " +
                "little slower, as if the world had briefly paused and hadn’t fully started again. In that calm moment, " +
                "everything felt strangely clear, like a deep breath after a long, restless day.";
        String lowerCaseEssay = essay.toLowerCase();
        String normalizedEssay = lowerCaseEssay.replaceAll("[^a-z0-9\\s]", "");


        String[] words = normalizedEssay.split(" ");
        HashMap<String, Integer> mapWord = new HashMap<>();
        for (String word : words) {
            if (mapWord.containsKey(word)) {
                mapWord.put(word, mapWord.get(word) + 1);
            } else {
                mapWord.put(word, 1);
            }
        }

        int maxVal = 0;
        List<String> mostFrequentWords = new ArrayList<>();
        List<String> uniqueWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mapWord.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (count == 1) {
                uniqueWords.add(word);
            }
            if (count > maxVal) {
                maxVal = count;
                mostFrequentWords.clear();
                mostFrequentWords.add(word);
            } else if (count == maxVal) {
                mostFrequentWords.add(word);
            }
        }

        String frequentWord = String.join(", ", mostFrequentWords);
        System.out.println("- Tu xuat hien nhieu nhat: " + frequentWord + " (xuat hien " + maxVal + " lan)");
        String uniqueWord = String.join(", ", uniqueWords);
        System.out.println("- Cac tu chi xuat hien 1 lan: " + uniqueWord);
    }
}