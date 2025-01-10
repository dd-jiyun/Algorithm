package b19637;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static String[] titles;
    static int[] upperLimits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        titles = new String[N];
        upperLimits = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            titles[i] = st.nextToken();
            upperLimits[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());
            sb.append(find(power)).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    public static String find(int power) {
        int left = 0;
        int right = N - 1;
        int answer = N;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (upperLimits[mid] >= power) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return titles[answer];
    }

}
