package b1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] idx = {-1, 1};
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }

    public static int bfs(int cur) {
        if (cur == K) return 0;  // 시작점과 목표가 같을 경우

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        visited[cur] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentN = queue.poll();
                if (currentN == K) {
                    return cnt;
                }
                for (int j = 0; j < 2; j++) {
                    int next = currentN + idx[j];
                    if (next >= 0 && next <= 100000 && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
                int next = currentN * 2;
                if (next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
            cnt++;
        }
        return -1;
    }
}
