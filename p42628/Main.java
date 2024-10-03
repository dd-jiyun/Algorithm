package p42628;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer;

        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (String operation : operations) {
            String[] split = operation.split(" ");
            String command = split[0];
            int number = Integer.parseInt(split[1]);

            switch (command) {
                case "I":
                    minpq.add(number);
                    maxpq.add(number);
                    break;
                case "D":
                    if (minpq.isEmpty()) {
                        break;
                    }
                    if (number == 1) {
                        int max = maxpq.poll();
                        minpq.remove(max);
                    } else {
                        int min = minpq.poll();
                        maxpq.remove(min);
                    }
                    break;
            }
        }

        if (minpq.isEmpty()) {
            answer = new int[]{0, 0};
        } else {
            answer = new int[]{maxpq.poll(), minpq.poll()};
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution soultion = new Solution();

        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        String[] operation3 = {"I 1", "I 2", "I 3", "I 4", "I 5", "D -1", "D -1", "D -1", "D -1"};

        System.out.println(Arrays.toString(soultion.solution(operations)));
        System.out.println(Arrays.toString(soultion.solution(operations2)));
        System.out.println(Arrays.toString(soultion.solution(operation3)));
    }
}
