package b12026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] blocks = br.readLine().toCharArray();

        int[] dp = new int[N];
        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            dp[i] = INF;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (blocks[j] == getNextChar(blocks[i])) {
                    int energy = (j - i) * (j - i);
                    if (dp[i] != INF) {
                        dp[j] = Math.min(dp[j], dp[i] + energy);
                    }
                }
            }
        }

        int result = dp[N - 1];
        if (result == INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static char getNextChar(char current) {
        if (current == 'B') return 'O';
        if (current == 'O') return 'J';
        return 'B';
    }
}
