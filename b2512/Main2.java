package b2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static int n; // 입력받을 에산 수
    static int[] budgets; // 예산 리스트
    static int m; // 총 예산

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        budgets = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(budgets);

        m = Integer.parseInt(br.readLine());

        System.out.println(binarySearch(budgets, m));
    }

    public static int binarySearch(int[] budgets, int m) {
        int left = 0;
        int right = budgets[n - 1];
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long total = 0;

            for (int budget : budgets) {
                total += Math.min(budget, mid);
            }

            if (total <= m) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
