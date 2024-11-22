package b16234;

import java.io.*;
import java.util.*;

public class Main {
    private static int N, L, R;
    private static int[][] population;
    private static boolean[][] visited;

    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        population = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(calculateDays());
    }

    private static int calculateDays() {
        int days = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && processGroup(i, j)) {
                        moved = true;
                    }
                }
            }

            if (!moved) {
                break;
            }
            days++;
        }

        return days;
    }

    private static boolean processGroup(int x, int y) {
        List<int[]> group = findGroup(x, y);
        if (group.size() > 1) {
            updatePopulation(group);
            return true;
        }
        return false;
    }

    private static List<int[]> findGroup(int startX, int startY) {
        List<int[]> group = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startX, startY});
        group.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + DX[d];
                int ny = y + DY[d];

                if (isRange(nx, ny) && !visited[nx][ny]) {
                    int diff = Math.abs(population[x][y] - population[nx][ny]);

                    if (L <= diff && diff <= R) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        group.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return group;
    }

    private static void updatePopulation(List<int[]> group) {
        int total = group.stream()
                .mapToInt(cell -> population[cell[0]][cell[1]])
                .sum();

        int average = total / group.size();
        group.forEach(cell -> population[cell[0]][cell[1]] = average);
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

}
