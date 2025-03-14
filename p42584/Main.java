package p42584;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && prices[deque.peek()] > prices[i]) {
                int idx = deque.pop();
                answer[idx] = i - idx;
            }
            deque.push(i);
        }

        while (!deque.isEmpty()) {
            int idx = deque.pop();
            answer[idx] = n - 1 - idx;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] prices = {1, 2, 3, 2, 3};

        System.out.println(Arrays.toString(s.solution(prices)));
    }
}
