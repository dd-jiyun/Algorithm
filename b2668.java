import java.io.*;
import java.util.*;

public class b2668 {
    static int n;
    static int[] arr;
    static boolean[] visited, finished;
    static Set<Integer> result = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        visited = new boolean[n + 1];
        finished = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            dfs(i, i);
        }

        printOutput();
    }

    private static void dfs(int start, int current) {
        if (!visited[current]) {
            visited[current] = true;
            dfs(start, arr[current]);
            visited[current] = false;
        } else if (start == current) {
            result.add(start);
        }
    }

    private static void printOutput() {
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (int num : result) {
            sb.append(num).append("\n");
        }

        System.out.print(sb);
    }
}
