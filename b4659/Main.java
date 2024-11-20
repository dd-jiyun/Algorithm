package b4659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final String VOWELS = "aeiou";
    private static final String END_POINT = "end";

    private static final String RESULT_MESSAGE = "<%s> is %s.";
    private static final String ACCEPTABLE = "acceptable";
    private static final String NOT_ACCEPTABLE = "not acceptable";

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        List<String> inputs = main.input();
        List<String> results = main.validate(inputs);
        System.out.print(main.output(results));
    }

    private List<String> input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return br.lines()
                .takeWhile(line -> !line.equalsIgnoreCase(END_POINT))
                .collect(Collectors.toList());
    }

    private List<String> validate(List<String> inputs) {
        return inputs.stream()
                .map(input -> String.format(RESULT_MESSAGE,
                        input, isValid(input) ? ACCEPTABLE : NOT_ACCEPTABLE))
                .collect(Collectors.toList());
    }

    private boolean isValid(String input) {
        return hasVowel(input) && !hasThreeContinuous(input) && !hasInvalidRepeats(input);
    }

    private boolean hasVowel(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .anyMatch(this::isVowel);
    }

    private boolean hasThreeContinuous(String input) {
        int[] counts = new int[2];

        for (char ch : input.toCharArray()) {
            if (isVowel(ch)) {
                counts[0]++;
                counts[1] = 0;
            } else {
                counts[1]++;
                counts[0] = 0;
            }
            if (counts[0] == 3 || counts[1] == 3) {
                return true;
            }
        }

        return false;
    }

    private boolean isVowel(char ch) {
        return VOWELS.indexOf(ch) >= 0;
    }

    private boolean hasInvalidRepeats(String input) {
        for (int i = 1; i < input.length(); i++) {
            char prev = input.charAt(i - 1);
            char curr = input.charAt(i);

            if (prev == curr && !(prev == 'e' || prev == 'o')) {
                return true;
            }
        }

        return false;
    }

    private String output(List<String> results) {
        StringBuilder sb = new StringBuilder();
        results.forEach(result -> sb.append(result).append("\n"));

        return sb.toString();
    }

}
