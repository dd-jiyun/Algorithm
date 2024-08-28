package p1843;

class Solution {
    public int solution(String[] arr) {
        int n = (arr.length + 1) / 2;
        int[][] max = new int[n][n];
        int[][] min = new int[n][n];

        for (int i = 0; i < n; i++) {
            max[i][i] = Integer.parseInt(arr[2 * i]);
            min[i][i] = Integer.parseInt(arr[2 * i]);
        }

        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;

                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    String operator = arr[2 * k + 1];
                    int maxValue = 0, minValue = 0;

                    if (operator.equals("+")) {
                        maxValue = max[i][k] + max[k + 1][j];
                        minValue = min[i][k] + min[k + 1][j];
                    } else if (operator.equals("-")) {
                        maxValue = max[i][k] - min[k + 1][j];
                        minValue = min[i][k] - max[k + 1][j];
                    }

                    max[i][j] = Math.max(max[i][j], maxValue);
                    min[i][j] = Math.min(min[i][j], minValue);
                }
            }
        }

        return max[0][n - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"1", "-", "3", "+", "5", "-", "8"};
        System.out.println(solution.solution(arr));
    }
}
