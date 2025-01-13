package p42586;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remaining = 100 - progresses[i];
            int day = (int) Math.ceil((double) remaining / speeds[i]);
            queue.offer(day);
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int count = 1;

            while (!queue.isEmpty() && queue.peek() <= current) {
                count++;
                queue.poll();
            }

            result.add(count);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] progresses1 = {95, 90, 99, 99, 80, 99};
        int[] speeds1 = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(s.solution(progresses, speeds)));
        System.out.println(Arrays.toString(s.solution(progresses1, speeds1)));
    }
}
