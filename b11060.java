import java.io.*;
import java.util.*;

public class b11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(jump(n, arr));
    }

    private static int jump(final int n, final int[] arr) {
        if (n == 1) {
            return 0;
        }
        if (arr[0] == 0) {
            return -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        queue.add(0);
        visited[0] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 1; i <= arr[current]; i++) {
                int next = current + i;

                if (next >= n) {
                    break;
                }

                if (visited[next] == -1) {
                    visited[next] = visited[current] + 1;
                    queue.add(next);
                }
            }
        }

        return visited[n - 1];
    }
}
