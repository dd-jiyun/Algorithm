package p118667;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;

        for (int num : queue1) {
            q1.offer(num);
            sum1 += num;
        }
        for (int num : queue2) {
            q2.offer(num);
            sum2 += num;
        }

        long totalSum = sum1 + sum2;
        if (totalSum % 2 != 0) {
            return -1;
        }

        long target = totalSum / 2;
        int moveCount = 0, maxMoves = 3 * (queue1.length + queue2.length);

        while (moveCount <= maxMoves) {
            if (sum1 == target) {
                return moveCount;
            }

            if (sum1 < target) {
                int value = q2.poll();
                q1.offer(value);
                sum1 += value;
                sum2 -= value;
            } else {
                int value = q1.poll();
                q2.offer(value);
                sum1 -= value;
                sum2 += value;
            }
            moveCount++;
        }
        return -1;
    }

}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};

        int[] queue3 = {1, 2, 1, 2};
        int[] queue4 = {1, 10, 1, 2};

        System.out.println(solution.solution(queue1, queue2));
        System.out.println(solution.solution(queue3, queue4));
    }
}
