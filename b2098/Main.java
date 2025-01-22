package b2098;

import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 16_000_000;
    static int n;
    static int[][] w;
    static int[][] dp;
    static int END_STATE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        dp = new int[n][1 << n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        END_STATE = (1 << n) - 1;

        int result = tsp(0, 1);

        System.out.println(result);
    }

    private static int tsp(int current, int visited) {
        if (visited == END_STATE) {
            return (w[current][0] > 0) ? w[current][0] : INF;
        }

        if (dp[current][visited] != -1) {
            return dp[current][visited];
        }

        dp[current][visited] = INF;

        for (int next = 0; next < n; next++) {
            if ((visited & (1 << next)) != 0 || w[current][next] == 0) {
                continue;
            }

            int nextVisited = visited | (1 << next);

            dp[current][visited] = Math.min(dp[current][visited],
                    w[current][next] + tsp(next, nextVisited));
        }

        return dp[current][visited];
    }
}