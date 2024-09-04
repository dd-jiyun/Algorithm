package p43162;

class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (computers[i][i] == 1) {
                dfs(i, n, computers);
                count++;
            }
        }
        return count;
    }

    public void dfs(int x, int n, int[][] computers) {
        computers[x][x] = 0;

        for (int i = 0; i < n; i++) {
            if (computers[x][i] == 1 && computers[i][i] == 1) {
                dfs(i, n, computers);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        Solution s = new Solution();
        System.out.println(s.solution(n, computers));
    }
}
