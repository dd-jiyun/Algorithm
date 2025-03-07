import java.io.*;
import java.util.*;

public class b8980 {
    static class Delivery implements Comparable<Delivery> {
        int from, to, box;

        public Delivery(int from, int to, int box) {
            this.from = from;
            this.to = to;
            this.box = box;
        }

        @Override
        public int compareTo(Delivery o) {
            return this.to - o.to;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        Delivery[] deliveries = new Delivery[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int box = Integer.parseInt(st.nextToken());
            deliveries[i] = new Delivery(from, to, box);
        }

        Arrays.sort(deliveries);

        int[] truck = new int[n + 1];
        int total = 0;

        for (Delivery d : deliveries) {
            int maxLoad = 0;
            for (int i = d.from; i < d.to; i++) {
                maxLoad = Math.max(maxLoad, truck[i]);
            }

            int loadable = Math.min(d.box, c - maxLoad);

            for (int i = d.from; i < d.to; i++) {
                truck[i] += loadable;
            }

            total += loadable;
        }

        System.out.println(total);
    }
}
