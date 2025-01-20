package b11053;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> dp = new ArrayList<>();

        for (int num : a) {
            int pos = Collections.binarySearch(dp, num);

            if (pos < 0) {
                pos = -(pos + 1);
            }

            if (pos < dp.size()) {
                dp.set(pos, num);
            } else {
                dp.add(num);
            }
        }

        System.out.println(dp.size());
    }
}
