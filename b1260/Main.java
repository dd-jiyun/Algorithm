package b1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static class Graph {
        private int vertices;
        private LinkedList<Integer> adjList[];

        Graph(int v) {
            vertices = v;
            adjList = new LinkedList[v + 1];
            for (int i = 0; i <= v; ++i) {
                adjList[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w) {
            adjList[v].add(w);
            adjList[w].add(v);
        }

        void sortEdges() {
            for (int i = 1; i <= vertices; i++) {
                Collections.sort(adjList[i]);
            }
        }

        void DFSUtil(int v, boolean visited[]) {
            visited[v] = true;
            System.out.print(v + " ");

            for (int n : adjList[v]) {
                if (!visited[n]) {
                    DFSUtil(n, visited);
                }
            }
        }

        void DFS(int startNode) {
            boolean visited[] = new boolean[vertices + 1];
            DFSUtil(startNode, visited);
        }

        void BFS(int startNode) {
            boolean visited[] = new boolean[vertices + 1];
            LinkedList<Integer> queue = new LinkedList<>();

            visited[startNode] = true;
            queue.add(startNode);

            while (!queue.isEmpty()) {
                startNode = queue.poll();
                System.out.print(startNode + " ");

                for (int n : adjList[startNode]) {
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer startSt = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(startSt.nextToken());
        int M = Integer.parseInt(startSt.nextToken());
        int V = Integer.parseInt(startSt.nextToken());

        Graph g = new Graph(N);

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            g.addEdge(v, w);
        }

        g.sortEdges();

        g.DFS(V);
        System.out.println();
        g.BFS(V);
    }
}
