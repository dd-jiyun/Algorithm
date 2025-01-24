package b2293;

import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] values;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[k + 1];
        dp[0] = 1;

        for (int value : values) {
            for (int j = value; j <= k; j++) {
                dp[j] += dp[j - value];
            }
        }

        System.out.println(dp[k]);
        br.close();
    }
}
