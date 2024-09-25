package b10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        List<Integer> nList = Arrays.stream(N.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (!nList.contains(0)) {
            System.out.println("-1");
            return;
        }

        int sum = nList.stream().mapToInt(Integer::intValue).sum();

        if (sum % 3 != 0) {
            System.out.println("-1");
            return;
        }

        nList.sort(Collections.reverseOrder());

        nList.forEach(System.out::print);
    }
}
