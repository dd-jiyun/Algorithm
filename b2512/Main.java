package b2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] budgets;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        budgets = new int[N];

        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(budgets);

        total = Integer.parseInt(br.readLine());

        System.out.println(binarySearch(budgets, total));
    }

    public static int binarySearch(int[] budgets, int total) {
        int left = 0;
        int right = 0;
        int mid, sum;
        int max = 0;

        for (int budget : budgets) {
            if (budget > right) {
                right = budget;
            }
        }

        while (left <= right) {
            sum = 0;
            mid = (left + right) / 2;

            for (int budget : budgets) {
                sum += Math.min(budget, mid);
            }

            if (sum <= total) {
                left = mid + 1;
                max = Math.max(max, mid);
            } else {
                right = mid - 1;
            }
        }

        return max;
    }
}
