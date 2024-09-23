package p42862;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int r : reserve) {
            reserveSet.add(r);
        }

        for (int l : lost) {
            if (!reserveSet.remove(l)) {
                lostSet.add(l);
            }
        }

        for (int r : new HashSet<>(reserveSet)) {
            if (lostSet.remove(r - 1) || lostSet.remove(r + 1)) {
                reserveSet.remove(r);
            }
        }

        return n - lostSet.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        System.out.println(solution.solution(n,lost,reserve));
    }
}
