import java.io.*;
import java.util.*;

public class b1303 {
    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int wPower = 0, bPower = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    int size = bfs(i, j, map[i][j]);
                    if (map[i][j] == 'W') {
                        wPower += size * size;
                    } else {
                        bPower += size * size;
                    }
                }
            }
        }

        System.out.println(wPower + " " + bPower);
    }

    private static int bfs(int x, int y, char team) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i], ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == team) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    count++;
                }
            }
        }

        return count;
    }
}
