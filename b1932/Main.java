package b1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");

            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dp(0, 0));

    }

    static int dp(int x, int y) {
        if (x == N - 1) {
            return arr[x][y];
        }

        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        return dp[x][y] = Math.max(dp(x + 1, y), dp(x + 1, y + 1)) + arr[x][y];
    }

}
