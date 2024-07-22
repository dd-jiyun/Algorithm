package b15663;

import java.util.*;

public class Main {
    static int N, M;
    static int[] numbers;
    static boolean[] visited;
    static List<int[]> results;
    static Deque<Integer> current;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);
        visited = new boolean[N];
        results = new ArrayList<>();
        current = new ArrayDeque<>();

        backtrack(0);

        StringBuilder sb = new StringBuilder();
        for (int[] result : results) {
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void backtrack(int depth) {
        if (depth == M) {
            results.add(current.stream().mapToInt(i -> i).toArray());
            return;
        }

        int lastUsed = -1;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && (lastUsed == -1 || lastUsed != numbers[i])) {
                visited[i] = true;
                current.addLast(numbers[i]);
                lastUsed = numbers[i];
                backtrack(depth + 1);
                visited[i] = false;
                current.removeLast();
            }
        }
    }
}
