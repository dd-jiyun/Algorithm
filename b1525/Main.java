package b1525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder init = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                init.append(st.nextToken());
            }
        }

        String start = init.toString();

        System.out.println(bfs(start));
    }

    public static int bfs(String start) {
        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();

        map.put(start, 0);
        q.offer(start);

        String target = "123456780";

        while (!q.isEmpty()) {
            String cur = q.poll();

            if (cur.equals(target)) {
                return map.get(cur);
            }

            int idx = cur.indexOf('0');
            int x = idx / 3;
            int y = idx % 3;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위를 벗어나면 그냥 진행
                if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) {
                    continue;
                }

                StringBuilder next = new StringBuilder(cur);
                // 빈칸과 이동할 좌표 바꾸기
                next.setCharAt(x * 3 + y, cur.charAt(nx * 3 + ny));
                // 이동할 좌표에 빈칸 넣기
                next.setCharAt(nx * 3 + ny, '0');

                if (!map.containsKey(next.toString())) {
                    map.put(next.toString(), map.get(cur) + 1);
                    q.offer(next.toString());
                }
            }
        }

        return -1;
    }
}
