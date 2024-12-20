package b7568;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] info = new int[n][2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] ranks = calculateRanks(info, n);

        StringBuilder sb = new StringBuilder();
        for (int rank : ranks) {
            sb.append(rank).append(" ");
        }

        System.out.println(sb);

        br.close();
    }

    private static int[] calculateRanks(int[][] info, int n) {
        int[] ranks = new int[n];
        Arrays.fill(ranks, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && info[j][0] > info[i][0] && info[j][1] > info[i][1]) {
                    ranks[i]++;
                }
            }
        }
        return ranks;
    }
}