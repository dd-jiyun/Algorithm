import java.util.*;

public class b11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.add(queue.poll());
            }
            result.add(queue.poll());
        }

        String convertResult = result.toString().replace("[", "<").replace("]", ">");

        System.out.println(convertResult);
        sc.close();
    }
}
