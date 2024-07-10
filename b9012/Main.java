package b9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            Stack<Character> stack = new Stack<>();
            String ps = br.readLine();
            boolean isStackEmpty = true;

            for (int j = 0; j < ps.length(); j++) {
                if (ps.charAt(j) == '(') {
                    stack.push('(');

                } else {
                    if (stack.isEmpty()) {
                        sb.append("NO\n");
                        isStackEmpty = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (isStackEmpty) {
                if (stack.isEmpty()) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }
}
