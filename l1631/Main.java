package l1631;

import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] efforts = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0, 0});
        efforts[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int effort = poll[0];
            int x = poll[1];
            int y = poll[2];

            if (x == rows - 1 && y == cols - 1) {
                return effort;
            }

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) {
                    continue;
                }

                int newEffort = Math.max(effort, Math.abs(heights[x][y] - heights[nx][ny]));
                if (newEffort < efforts[nx][ny]) {
                    efforts[nx][ny] = newEffort;
                    pq.add(new int[]{newEffort, nx, ny});
                }
            }
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        int[][] heights2 = {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};
        int[][] heights3 = {{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}};

        System.out.println(solution.minimumEffortPath(heights));
        System.out.println(solution.minimumEffortPath(heights2));
        System.out.println(solution.minimumEffortPath(heights3));
    }
}
