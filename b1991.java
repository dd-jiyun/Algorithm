import java.io.*;
import java.util.*;

public class b1991 {
    static char[] leftChild, rightChild;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        leftChild = new char[n];
        rightChild = new char[n];

        Arrays.fill(leftChild, '.');
        Arrays.fill(rightChild, '.');

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            int idx = parent - 'A';

            leftChild[idx] = left;
            rightChild[idx] = right;
        }

        StringBuilder sb = new StringBuilder();

        preOrder(0, sb);
        sb.append("\n");

        inOrder(0, sb);
        sb.append("\n");

        postOrder(0, sb);

        System.out.print(sb);
        br.close();
    }

    private static void preOrder(int idx, StringBuilder sb) {
        sb.append((char) (idx + 'A'));
        if (leftChild[idx] != '.') {
            preOrder(leftChild[idx] - 'A', sb);
        }
        if (rightChild[idx] != '.') {
            preOrder(rightChild[idx] - 'A', sb);
        }
    }

    private static void inOrder(int idx, StringBuilder sb) {
        if (leftChild[idx] != '.') {
            inOrder(leftChild[idx] - 'A', sb);
        }
        sb.append((char) (idx + 'A'));
        if (rightChild[idx] != '.') {
            inOrder(rightChild[idx] - 'A', sb);
        }
    }

    private static void postOrder(int idx, StringBuilder sb) {
        if (leftChild[idx] != '.') {
            postOrder(leftChild[idx] - 'A', sb);
        }
        if (rightChild[idx] != '.') {
            postOrder(rightChild[idx] - 'A', sb);
        }
        sb.append((char) (idx + 'A'));
    }
}
