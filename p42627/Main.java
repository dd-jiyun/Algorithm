package p42627;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int time = 0;
        int idx = 0;
        int totalWaitTime = 0;
        int completedJobs = 0;

        while (completedJobs < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(jobs[idx]);
                idx++;
            }

            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                time += job[1];
                totalWaitTime += time - job[0];
                completedJobs++;
            } else {
                time = jobs[idx][0];
            }
        }

        return totalWaitTime / jobs.length;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution.solution(jobs));
    }
}
