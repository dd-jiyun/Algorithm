import java.util.*;

public class b10974 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean[] visited = new boolean[n + 1];
        List<Integer> permutation = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        backtracking(n, visited, permutation, sb);

        System.out.println(sb);
        sc.close();
    }

    private static void backtracking(int n, boolean[] visited, List<Integer> permutation, StringBuilder sb) {
        if (permutation.size() == n) {
            for (int num : permutation) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation.add(i);
                backtracking(n, visited, permutation, sb);
                permutation.remove(permutation.size() - 1);
                visited[i] = false;
            }
        }
    }
}
