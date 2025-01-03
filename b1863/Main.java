package b1863;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<int[]> stack = new ArrayDeque<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && (stack.peek()[1] > y || y == 0)) {
                stack.pop();
            }
            if (y > 0 && (stack.isEmpty() || stack.peek()[1] < y)) {
                stack.push(new int[]{x, y});
                count++;
            }
        }

        System.out.println(count);
    }
}
