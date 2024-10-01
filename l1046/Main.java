package l1046;

import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (x != y) {
                pq.add(y - x);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] stones = {2, 7, 4, 1, 8, 1};
        int[] stones2 = {1};

        System.out.println(solution.lastStoneWeight(stones));
        System.out.println(solution.lastStoneWeight(stones2));
    }
}
