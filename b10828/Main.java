package b10828;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int[] stack;
    private static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int input = Integer.parseInt(br.readLine());

        stack = new int[input];

        for (int i = 0; i < input; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
        br.close();
    }

    private static void push(int x) {
        stack[size++] = x;
    }

    private static int pop() {
        if (size == 0) {
            return -1;
        } else {
            return stack[--size];
        }
    }

    private static int size() {
        return size;
    }

    private static int empty() {
        return size == 0 ? 1 : 0;
    }

    private static int top() {
        if (size == 0) {
            return -1;
        } else {
            return stack[size - 1];
        }
    }
}
