package p340199;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (Math.min(bill[0], bill[1]) > Math.min(wallet[0], wallet[1]) || Math.max(bill[0], bill[1]) > Math.max(
                wallet[0], wallet[1])) {

            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] wallet = {30, 15};
        int[] bill = {26, 17};
        int[] wallet2 = {50, 50};
        int[] bill2 = {100, 241};

        System.out.println(solution.solution(wallet, bill));
        System.out.println(solution.solution(wallet2, bill2));
    }
}
