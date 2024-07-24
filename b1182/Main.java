package b1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S, count;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 0);

        // 공집합일 경우 제외
        if (S == 0) {
            count--;
        }

        System.out.println(count);

    }

    public static void backtrack(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }
        // 현재 원소를 포함하는 경우
        backtrack(index + 1, sum + num[index]);

        // 현재 원소를 포함하지 않는 경우
        backtrack(index + 1, sum);
    }
}
