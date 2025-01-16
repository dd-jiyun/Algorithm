package b1662;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Stack<Integer> lengthStack = new Stack<>();
        Stack<Integer> repeatStack = new Stack<>();
        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                if (i + 1 < s.length() && s.charAt(i + 1) == '(') {
                    repeatStack.push(ch - '0');
                } else {
                    length++;
                }
            } else if (ch == '(') {
                lengthStack.push(length);
                length = 0;
            } else if (ch == ')') {
                int count = repeatStack.pop();
                length = lengthStack.pop() + (length * count);
            }
        }

        System.out.println(length);
    }
}
