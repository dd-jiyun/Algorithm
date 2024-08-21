package p43236;

import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int left = 1;
        int right = distance;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int remove = 0;
            int previous = 0;

            for (int rock : rocks) {
                if (rock - previous < mid) {
                    remove++;
                } else {
                    previous = rock;
                }
            }

            if (distance - previous < mid) {
                remove++;
            }

            if (remove <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;

        System.out.println(solution.solution(distance, rocks, n));
    }
}
