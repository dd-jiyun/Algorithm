package p42577;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();

        Collections.addAll(set, phone_book);

        for (String phone : phone_book) {
            StringBuilder prefix = new StringBuilder();

            for (int i = 0; i < phone.length() - 1; i++) {
                prefix.append(phone.charAt(i));
                if (set.contains(prefix.toString())) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // test1
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution.solution(phone_book));

        // test2
        String[] phone_book2 = {"123", "456", "789"};
        System.out.println(solution.solution(phone_book2));

        // test3
        String[] phone_book3 = {"12", "123", "1235", "567", "88"};
        System.out.println(solution.solution(phone_book3));
    }
}
