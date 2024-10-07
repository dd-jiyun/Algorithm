package b9093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] words = br.readLine().split(" ");

            for (String word : words) {
                for (int j = word.length() - 1; j >= 0; j--) {
                    result.append(word.charAt(j));
                }
                result.append(" ");
            }
            result.append("\n");
        }

        System.out.println(result);
    }
}
