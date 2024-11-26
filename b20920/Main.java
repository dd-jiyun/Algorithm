package b20920;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> wordFrequency = getWordFrequency(br);

        List<String> wordList = getWordList(wordFrequency);

        for (String word : wordList) {
            bw.write(word);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static Map<String, Integer> getWordFrequency(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> wordFrequency = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            if (word.length() >= m) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        return wordFrequency;
    }

    private static List<String> getWordList(final Map<String, Integer> wordFrequency) {
        List<String> wordList = new ArrayList<>(wordFrequency.keySet());

        wordList.sort((w1, w2) -> {
            int freqCompare = wordFrequency.get(w2).compareTo(wordFrequency.get(w1));
            if (freqCompare != 0) {
                return freqCompare;
            }

            int lengthCompare = Integer.compare(w2.length(), w1.length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }

            return w1.compareTo(w2);
        });

        return wordList;
    }
}
