package p42626;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : scoville) {
            queue.add(i);
        }

        while (queue.peek() < K) {
            if (queue.size() < 2) {
                return -1;
            }

            int first = queue.poll();
            int second = queue.poll();
            int mix = first + (second * 2);

            queue.add(mix);
            answer++;
        }

        return answer;
    }
}


public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));

        System.out.println(solution.solution(new int[]{1, 2, 3}, 35));
    }
}
