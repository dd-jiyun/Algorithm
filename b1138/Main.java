package b1138;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] heights = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> result = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            result.add(heights[i], i + 1);
        }

        for (int num : result) {
            System.out.print(num + " ");
        }

        br.close();
    }
}