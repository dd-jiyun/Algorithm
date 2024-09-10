package p84512;

class Solution {
    public int solution(String word) {
        int answer = 0;

        String[] vowels = {"A", "E", "I", "O", "U"};
        int[] weight = {781, 156, 31, 6, 1};

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (vowels[j].equals(String.valueOf(word.charAt(i)))) {
                    answer += 1 + j * weight[i];
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

        System.out.println(solution.solution("AAAAE")); // 6
        System.out.println(solution.solution("AAAE")); // 10
        System.out.println(solution.solution("I")); // 1563
        System.out.println(solution.solution("EIO")); // 1189
    }
}
