import java.io.*;
import java.util.*;

public class b1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int total = calculateTotal(targets, list);

        System.out.println(total);
        br.close();
    }

    private static int calculateTotal(int[] targets, LinkedList<Integer> list) {
        int total = 0;

        for (int target : targets) {
            int idx = list.indexOf(target);

            int left = idx;
            int right = list.size() - idx;

            if (left <= right) {
                total += left;
                for (int i = 0; i < left; i++) {
                    list.addLast(list.pollFirst());
                }
            } else {
                total += right;
                for (int i = 0; i < right; i++) {
                    list.addFirst(list.pollLast());
                }
            }

            list.pollFirst();
        }

        return total;
    }
}
