import java.io.*;
import java.util.*;

public class b9934 {
    static List<List<Integer>> levelList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int nodeCount = (int) Math.pow(2, k) - 1;
        int[] inorder = new int[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            inorder[i] = Integer.parseInt(input[i]);
        }

        levelList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            levelList.add(new ArrayList<>());
        }

        buildTree(0, inorder, 0, nodeCount - 1);

        StringBuilder sb = new StringBuilder();
        for (List<Integer> level : levelList) {
            for (int node : level) {
                sb.append(node).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void buildTree(int depth, int[] inorder, int start, int end) {

        if (start > end) {
            return;
        }

        int mid = (start + end) / 2;

        levelList.get(depth).add(inorder[mid]);

        buildTree(depth + 1, inorder, start, mid - 1);
        buildTree(depth + 1, inorder, mid + 1, end);
    }
}
