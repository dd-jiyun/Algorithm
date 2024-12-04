package p258712;

import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> friendIndexMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendIndexMap.put(friends[i], i);
        }

        int[] giftIndex = new int[friends.length];
        int[][] giftRecord = new int[friends.length][friends.length];

        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            int giver = friendIndexMap.get(parts[0]);
            int receiver = friendIndexMap.get(parts[1]);

            giftIndex[giver]++;
            giftIndex[receiver]--;

            giftRecord[giver][receiver]++;
        }

        return calculateMaxGifts(friends, giftIndex, giftRecord);
    }

    private int calculateMaxGifts(String[] friends, int[] giftIndex, int[][] giftRecord) {
        int maxGifts = 0;
        for (int i = 0; i < friends.length; i++) {
            int giftCount = 0;

            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;

                if (giftRecord[i][j] > giftRecord[j][i]) {
                    giftCount++;
                } else if (giftRecord[i][j] == giftRecord[j][i] && giftIndex[i] > giftIndex[j]) {
                    giftCount++;
                }
            }

            maxGifts = Math.max(maxGifts, giftCount);
        }
        return maxGifts;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 예제 1
        String[] friends1 = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts1 = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi",
                "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(solution.solution(friends1, gifts1));

        // 예제 2
        String[] friends2 = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts2 = {"alessandro brad", "alessandro joy", "alessandro conan",
                "david alessandro", "alessandro david"};
        System.out.println(solution.solution(friends2, gifts2));

        // 예제 3
        String[] friends3 = {"a", "b", "c"};
        String[] gifts3 = {"a b", "b a", "c a", "a c", "a c", "c a"};
        System.out.println(solution.solution(friends3, gifts3));
    }
}
