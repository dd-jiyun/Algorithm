package p42895;

import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }

        List<Set<Integer>> dp = new ArrayList<>();

        dp.add(new HashSet<>());

        for (int i = 1; i <= 8; i++) {
            Set<Integer> currentSet = new HashSet<>();

            String repeatedN = String.valueOf(N).repeat(i);
            currentSet.add(Integer.parseInt(repeatedN));

            for (int j = 1; j < i; j++) {
                Set<Integer> prevSet1 = dp.get(j);
                Set<Integer> prevSet2 = dp.get(i - j);

                for (int x : prevSet1) {
                    for (int y : prevSet2) {
                        currentSet.add(x + y);
                        currentSet.add(x - y);
                        currentSet.add(x * y);
                        if (y != 0) {
                            currentSet.add(x / y);
                        }
                    }
                }
            }

            if (currentSet.contains(number)) {
                return i;
            }

            dp.add(currentSet);
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, 12));
        System.out.println(solution.solution(2, 11));
    }
}
