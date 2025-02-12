import java.util.*;

class Solution2 {
    static Set<Integer> primeSet = new HashSet<>();
    static boolean[] visited;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];

        generatePermutations(numbers, "", 0);

        return countPrimes();
    }

    private void generatePermutations(String numbers, String current, int depth) {
        if (!current.isEmpty()) {
            primeSet.add(Integer.parseInt(current));
        }

        if (depth == numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                generatePermutations(numbers, current + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }

    private int countPrimes() {
        int maxNum = primeSet.stream().max(Integer::compareTo).orElse(0);
        boolean[] isPrime = new boolean[maxNum + 1];

        for (int i = 2; i <= maxNum; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= maxNum; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxNum; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int num : primeSet) {
            if (num > 1 && isPrime[num]) {
                count++;
            }
        }

        return count;
    }
}

public class p42839 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.solution("17"));
        System.out.println(s.solution("011"));
    }
}
