package b24042;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<int[]>[] graph;
    static long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(new int[]{B, i});
            graph[B].add(new int[]{A, i});
        }

        long result = dijkstra();
        System.out.println(result == INF ? -1 : result);
        br.close();
    }

    private static long dijkstra() {
        long[] time = new long[N + 1];
        Arrays.fill(time, INF);

        time[1] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        pq.offer(new long[]{0, 1});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long currentTime = current[0];
            int currentNode = (int) current[1];

            if (currentTime > time[currentNode]) {
                continue;
            }

            for (int[] edge : graph[currentNode]) {
                int nextNode = edge[0];
                int signalTime = edge[1];

                long waitTime = (signalTime - (currentTime % M) + M) % M;
                long nextTime = currentTime + waitTime + 1;

                if (time[nextNode] > nextTime) {
                    time[nextNode] = nextTime;
                    pq.offer(new long[]{nextTime, nextNode});
                }
            }
        }

        return time[N];
    }
}