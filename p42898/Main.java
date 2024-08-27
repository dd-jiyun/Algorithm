package p42898;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer;

        // stack overflow 방지를 위한 모듈러 연산(나머지 연산)
        int MOD = 1000000007;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int[] puddle : puddles) {
            dp[puddle[0] - 1][puddle[1] - 1] = -1;
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                if(i != 0) {
                    dp[i][j] += dp[i - 1][j] % MOD;
                }
                if(j != 0) {
                    dp[i][j] += dp[i][j - 1] % MOD;
                }
            }
        }

        answer = dp[m - 1][n - 1] % MOD;
        return answer;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] puddles = {{2, 2}};

        System.out.println(solution.solution(4, 3, puddles));
    }
}
