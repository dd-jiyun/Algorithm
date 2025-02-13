class Sol {
    static boolean[] visited;
    static int maxResult = 0;

    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        visited = new boolean[n];

        backtracking(k, dungeons, 0);

        return maxResult;
    }

    private void backtracking(int fatigue, int[][] dungeons, int count) {
        maxResult = Math.max(maxResult, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                visited[i] = true;

                backtracking(fatigue - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }
    }
}

public class p87946 {
    public static void main(String[] args) {
        Sol s = new Sol();
        System.out.println(s.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}
