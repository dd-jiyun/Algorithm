import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings,
                Comparator.comparing((String s) -> s.charAt(n))
                        .thenComparing(s -> s)
        );
        // 기능은 동일하지만 위의 코드가 더 간결하다.
//        Arrays.sort(strings, (o1, o2) -> {
//            if (o1.charAt(n) == o2.charAt(n)) {
//                return o1.compareTo(o2);
//            }
//            return o1.charAt(n) - o2.charAt(n);
//        });
        return strings;
    }
}

public class p12915 {
    public static void main(String[] args) {
        Solution s = new Solution();

        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        System.out.println(Arrays.toString(s.solution(strings, n)));
    }
}
