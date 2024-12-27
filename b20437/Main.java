package b20437;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            int[] result = solve(W, K);
            if (result[0] == -1) {
                sb.append("-1").append("\n");
            } else {
                sb.append(result[0]).append(" ").append(result[1]).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static int[] solve(String W, int K) {
        HashMap<Character, List<Integer>> wordPositions = new HashMap<>();

        for (int i = 0; i < W.length(); i++) {
            char c = W.charAt(i);
            wordPositions.putIfAbsent(c, new ArrayList<>());
            wordPositions.get(c).add(i);
        }

        int minLength = Integer.MAX_VALUE;
        int maxLength = -1;

        for (Map.Entry<Character, List<Integer>> entry : wordPositions.entrySet()) {
            List<Integer> positions = entry.getValue();

            if (positions.size() < K) {
                continue;
            }

            for (int i = 0; i <= positions.size() - K; i++) {
                int start = positions.get(i);
                int end = positions.get(i + K - 1);
                int length = end - start + 1;

                minLength = Math.min(minLength, length);
                maxLength = Math.max(maxLength, length);
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{minLength, maxLength};
    }

}
