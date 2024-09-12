package b14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] copyMap;
    static int maxSafeArea = 0;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(maxSafeArea);
    }

    // 벽을 3개 세우는 조합을 구하기 위한 DFS 함수
    public static void dfs(int count) {
        if (count == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) { // 빈칸인 경우
                    map[i][j] = 1; // 벽 세우기
                    dfs(count + 1); // 다음 벽 세우러 가기
                    map[i][j] = 0;  // 백트래킹: 다시 빈칸으로 되돌림
                }
            }
        }
    }

    // 바이러스 퍼뜨리는 BFS 함수
    public static void spreadVirus() {
        for (int i = 0; i < N; i++) {
            if (M >= 0) {
                System.arraycopy(map[i], 0, copyMap[i], 0, M);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 2) { // 바이러스인 경우
                    queue.add(new int[]{i, j}); // 큐에 추가
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = 2;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        countSafeArea();
    }

    // 안전 영역 크기 계산
    public static void countSafeArea() {
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) { // 빈칸인 경우
                    safeArea++;
                }
            }
        }
        maxSafeArea = Math.max(maxSafeArea, safeArea);
    }
}
