package p150370;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        LocalDate todayDate = toLocalDate(today);

        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            String type = split[0];
            int period = Integer.parseInt(split[1]);
            termsMap.put(type, period);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            String date = split[0];
            String type = split[1];

            LocalDate privacyDate = toLocalDate(date);

            LocalDate expirationDate = getExpirationDate(privacyDate, termsMap.get(type));

            if (expirationDate.isBefore(todayDate) || expirationDate.isEqual(todayDate)) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private LocalDate toLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return LocalDate.parse(date, formatter);
    }

    private LocalDate getExpirationDate(LocalDate privacyDate, int period) {
        return privacyDate.plusMonths(period);
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // test case 1
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        // test case 2
        String today2 = "2020.01.01";
        String[] terms2 = {"Z 3", "D 5"};
        String[] privacies2 = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        System.out.println(Arrays.toString(solution.solution(today, terms, privacies)));
        System.out.println(Arrays.toString(solution.solution(today2, terms2, privacies2)));
    }
}
