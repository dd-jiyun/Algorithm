package b9663;

import java.util.Scanner;

public class Main {
    static int N;

    static int[] v1;
    static int[] v2;
    static int[] v3;

    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        v1 = new int[N];
        v2 = new int[2 * N];
        v3 = new int[2 * N];

        dfs(0);

        System.out.println(answer);
    }

    public static int dfs(int n) {
        if (n == N) {
            return answer++;
        }

        for (int j = 0; j < N; j++) {
            // 음수 인덱스 방지
            if (v1[j] == 0 && v2[n + j] == 0 && v3[n - j + (N - 1)] == 0) {
                v1[j] = 1;
                v2[n + j] = 1;
                v3[n - j + (N - 1)] = 1;

                dfs(n + 1);

                v1[j] = 0;
                v2[n + j] = 0;
                v3[n - j + (N - 1)] = 0;
            }
        }

        return answer;
    }

}
