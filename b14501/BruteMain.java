package b14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BruteMain {
    static int N;
    static int[] T;
    static int[] P;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(max);

    }

    public static void dfs(int day, int sum) {
        if (day >= N) {
            max = Math.max(max, sum);
            return;
        }

        if (day + T[day] <= N) {
            // 상담을 하는 경우
            dfs(day + T[day], sum + P[day]);
        }

        // 상담을 하지 않는 경우
        dfs(day + 1, sum);

    }
}
