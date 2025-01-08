package b1205;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] scores = new int[n];
        if (n > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }
        }

        int rank = calculate(n, scores, newScore, p);

        System.out.println(rank);
    }

    private static int calculate(int n, int[] scores, int newScore, int p) {
        int rank = 1;

        for (int i = 0; i < n; i++) {
            if (newScore < scores[i]) {
                rank++;
            } else if (newScore == scores[i]) {
                rank = i + 1;
                break;
            } else {
                break;
            }
        }

        if (n == p && newScore <= scores[n - 1]) {
            return -1;
        }

        return rank;
    }
}
