import java.io.*;
import java.util.*;

public class b3190 {
    static int n, k, l;
    static int[][] map;
    static Map<Integer, Character> moves;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
        }

        l = Integer.parseInt(br.readLine());
        moves = new HashMap<>();
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            moves.put(time, direction);
        }

        System.out.println(runSnakeGame());
        br.close();
    }

    private static int runSnakeGame() {
        Deque<int[]> snake = new LinkedList<>();
        Set<String> body = new HashSet<>();

        snake.add(new int[]{0, 0});
        body.add("0,0");

        int time = 0, dir = 0;
        int x = 0, y = 0;

        while (true) {
            time++;
            x += dx[dir];
            y += dy[dir];

            if (x < 0 || x >= n || y < 0 || y >= n || body.contains(x + "," + y)) {
                break;
            }

            snake.add(new int[]{x, y});
            body.add(x + "," + y);

            if (map[x][y] == 0) {
                int[] tail = snake.pollFirst();
                body.remove(tail[0] + "," + tail[1]);
            } else {
                map[x][y] = 0;
            }

            if (moves.containsKey(time)) {
                dir = changeDirection(dir, moves.get(time));
            }
        }

        return time;
    }

    private static int changeDirection(int dir, char direction) {
        if (direction == 'L') {
            return (dir + 3) % 4;
        } else {
            return (dir + 1) % 4;
        }
    }

}
