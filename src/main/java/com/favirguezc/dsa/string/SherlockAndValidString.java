package com.favirguezc.dsa.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SherlockAndValidString {

    public static String isValid(String s) {
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charFreq.computeIfPresent(s.charAt(i), (c, f) -> f + 1);
            charFreq.computeIfAbsent(s.charAt(i), (c) -> 1);
        }
        Map<Integer, Long> freq = charFreq.values().stream()
                .collect(Collectors.groupingBy(f -> f, Collectors.counting()));
        if (freq.size() == 1) {
            return "YES";
        } else if (freq.size() == 2) {
            List<Integer> keys = freq.keySet().stream().sorted().collect(Collectors.toList());
            int lessFrequentFrequency;
            int moreFrequentFrequency;
            if (freq.get(keys.get(0)) <= freq.get(keys.get(1))) {
                lessFrequentFrequency = keys.get(0);
                moreFrequentFrequency = keys.get(1);
            } else {
                lessFrequentFrequency = keys.get(1);
                moreFrequentFrequency = keys.get(0);
            }
            long minFrequencyCount = freq.get(lessFrequentFrequency);
            // 'minFrequencyCount == 1' means that the frequency of a character is unique
            // 'lessFrequentFrequency == 1' means that the character is unique
            // 'lessFrequentFrequency - 1 == moreFrequentFrequency' means the most repeated
            // character appears only once more than the other characters
            if (minFrequencyCount == 1
                    && (lessFrequentFrequency == 1 || lessFrequentFrequency - 1 == moreFrequentFrequency)) {
                return "YES";
            }
        }
        return "NO";
    }
}
