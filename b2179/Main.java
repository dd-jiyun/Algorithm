package b2179;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Word> words = readWords(br, n);

        List<Word> result = findSimilarWords(words);

        printResult(result);

        br.close();
    }

    private static List<Word> readWords(BufferedReader br, int n) throws IOException {
        List<Word> words = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            words.add(new Word(i, br.readLine()));
        }

        return words;
    }

    private static List<Word> findSimilarWords(List<Word> words) {
        int maxPrefixLength = 0;

        Word first = new Word(Integer.MAX_VALUE, "");
        Word second = new Word(Integer.MAX_VALUE, "");

        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                Word w1 = words.get(i);
                Word w2 = words.get(j);

                int prefixLength = getPrefixLength(w1.value, w2.value);

                if (prefixLength > maxPrefixLength) {
                    maxPrefixLength = prefixLength;
                    first = w1;
                    second = w2;
                }
                if (prefixLength == maxPrefixLength) {
                    if (w1.index < first.index ||
                            (w1.index == first.index && w2.index < second.index)) {
                        first = w1;
                        second = w2;
                    }
                }
            }
        }
        return Arrays.asList(first, second);
    }

    private static int getPrefixLength(String s1, String s2) {
        int length = 0;

        while (length < s1.length() && length < s2.length() && s1.charAt(length) == s2.charAt(length)) {
            length++;
        }

        return length;
    }

    private static void printResult(List<Word> result) {
        System.out.println(result.get(0).value);
        System.out.println(result.get(1).value);
    }

    static class Word {
        int index;
        String value;

        Word(int index, String value) {
            this.index = index;
            this.value = value;
        }
    }
}
