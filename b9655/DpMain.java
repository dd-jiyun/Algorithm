package b9655;

import java.util.Scanner;

public class DpMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[] dp = new String[N + 1];

        dp[1] = "SK";
        if (N >= 2) {
            dp[2] = "CY";
        }

        for (int i = 3; i <= N; i++) {
            if (dp[i - 1].equals("CY") || dp[i - 3].equals("CY")) {
                dp[i] = "SK";
            } else {
                dp[i] = "CY";
            }
        }

        System.out.println(dp[N]);
    }
}
