package b1244;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] switches = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            toggleSwitches(sex, num, switches);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(switches[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void toggleSwitches(int sex, int num, int[] switches) {
        if (sex == 1) {
            switchMan(num, switches);
        } else if (sex == 2) {
            switchWoman(num, switches);
        }
    }

    private static void switchMan(final int num, final int[] switches) {
        for (int i = num; i < switches.length; i += num) {
            switches[i] ^= 1;
        }
    }

    private static void switchWoman(final int num, final int[] switches) {
        int left = num;
        int right = num;

        while (left >= 1 && right < switches.length && switches[left] == switches[right]) {
            left--;
            right++;
        }

        for (int i = left + 1; i < right; i++) {
            switches[i] ^= 1;
        }
    }
}