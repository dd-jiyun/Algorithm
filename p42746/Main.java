package p42746;

import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        if (strNumbers[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String strNumber : strNumbers) {
            sb.append(strNumber);
        }

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};

        System.out.println(solution.solution(numbers));
        System.out.println(solution.solution(numbers2));
    }
}
