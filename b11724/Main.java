package b11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = readInput(br);
        int N = nm[0];
        int M = nm[1];

        initGraph(N);
        readEdges(br, M);

        int connectedComponents = countConnectedComponents(N);
        System.out.println(connectedComponents);
    }

    public static int[] readInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        return new int[]{N, M};
    }

    public static void initGraph(int n) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
    }

    public static void readEdges(BufferedReader br, int m) throws IOException {
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
    }

    public static int countConnectedComponents(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (int connectNode : graph[node]) {
            if (!visited[connectNode]) {
                dfs(connectNode);
            }
        }
    }
}
