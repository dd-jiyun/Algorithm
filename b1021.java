import java.io.*;
import java.util.*;

public class b1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int total = calculateTotal(targets, deque);

        System.out.println(total);
        br.close();
    }

    private static int calculateTotal(int[] targets, Deque<Integer> deque) {
        int total = 0;

        for (int target : targets) {
            int idx = 0;

            for (int num : deque) {
                if (num == target) {
                    break;
                }
                idx++;
            }

            int left = idx;
            int right = deque.size() - idx;

            if (left <= right) {
                total += left;
                for (int i = 0; i < left; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                total += right;
                for (int i = 0; i < right; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }

            deque.pollFirst();
        }
        return total;
    }
}
