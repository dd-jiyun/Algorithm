package b11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        time = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(time[0][1]);

        for (int i = 1; i < n; i++) {
            if (queue.peek() != null && queue.peek() <= time[i][0]) {
                queue.poll();
            }
            queue.add(time[i][1]);
        }

        System.out.println(queue.size());
    }
}
