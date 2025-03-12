import java.util.*;

class Solution3 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            }
            if (ch == ')' && stack.isEmpty()) {
                return false;
            }
            if (ch == ')') {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

public class p12909 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

        String s = "()()";
        String s1 = "(())()";
        String s2 = ")()(";
        String s3 = "(()(";

        System.out.println(solution3.solution(s));
        System.out.println(solution3.solution(s1));
        System.out.println(solution3.solution(s2));
        System.out.println(solution3.solution(s3));
    }
}
