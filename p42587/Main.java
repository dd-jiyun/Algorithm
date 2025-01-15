package p42587;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
            pq.offer(priorities[i]);
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int index = current[0];
            int priority = current[1];

            if (priority == pq.peek()) {
                answer++;
                pq.poll();

                if (index == location) {
                    break;
                }
            } else {
                queue.offer(current);
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        int[] priorities1 = {1, 1, 9, 1, 1, 1};
        int location1 = 0;

        System.out.println(s.solution(priorities, location));
        System.out.println(s.solution(priorities1, location1));
    }
}
