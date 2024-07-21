package p12906;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // 해당 예제는 입출력 예에서의 1번을 테스트하기 위해 추가한 값입니다.
        int[] arr = new int[]{1, 1, 3, 3, 0, 1, 1};
        Stack<Integer> stack = new Stack<>();

        for (int j : arr) {
            if (stack.isEmpty() || stack.peek() != j) {
                stack.push(j);
            }
        }
        /*
         // 프로그래머스 문제에서는 배열을 반환해야해서 추가적으로 스택에서 배열로 변환하는 코드를 추가해야한다.

        int[] answer = new int[stack.size()];
            for (int i = stack.size() - 1; i >= 0; i--) {
                answer[i] = stack.pop();
            }
            return answer;
        }
         */
        System.out.println(stack);

    }
}
