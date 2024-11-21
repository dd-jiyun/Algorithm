package p17681;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            int mergedRow = arr1[i] | arr2[i];

            String binaryString = String.format("%" + n + "s", Integer.toBinaryString(mergedRow));

            answer[i] = binaryString.replace('1', '#').replace('0', ' ');
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 테스트 예제
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] result = solution.solution(n, arr1, arr2);

        for (String line : result) {
            System.out.println(line);
        }
    }
}
