package b1976;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] plan = new int[m];
        for (int i = 0; i < m; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        dfs(plan[0], n);

        boolean isPossible = true;
        for (int city : plan) {
            if (!visited[city]) {
                isPossible = false;
                break;
            }
        }

        System.out.println(isPossible ? "YES" : "NO");
        br.close();
    }

    private static void dfs(int node, int n) {
        visited[node] = true;
        for (int i = 1; i <= n; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(i, n);
            }
        }
    }

}
