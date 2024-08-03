package b1495;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S, M;
    static int[] volume;
    static boolean[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        volume = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }

        DP = new boolean[N + 1][M + 1];
        DP[0][S] = true;  // 초기 시작 볼륨

        // DP 테이블 채우기
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (DP[i - 1][j]) {
                    if (j + volume[i] <= M) {
                        DP[i][j + volume[i]] = true;
                    }
                    if (j - volume[i] >= 0) {
                        DP[i][j - volume[i]] = true;
                    }
                }
            }
        }

        // 결과 계산
        int result = -1;
        for (int j = 0; j <= M; j++) {
            if (DP[N][j]) {
                result = j;
            }
        }

        System.out.println(result);
    }
}
