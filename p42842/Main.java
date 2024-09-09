package p42842;

import java.util.Arrays;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;

        for (int i = 3; i <= sum / 3; i++) {
            if (sum % i == 0) {
                int j = sum / i;
                if ((i - 2) * (j - 2) == yellow) {
                    answer = new int[]{j, i};
                    break;
                }
            }
        }
        return answer;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int brown = 10;
        int yellow = 2;
        int[] answer = solution.solution(brown, yellow);
        System.out.println(Arrays.toString(answer));
    }
}
