package p43238;

public class Main {
    public static long solution(int n, int[] times) {
        long start = 1;
        long end = (long) n * getMin(times);

        while (start <= end) {
            long mid = (start + end) / 2;

            long cnt = 0;
            for (int time : times) {
                cnt += mid / time;
            }

            if (cnt < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
        return start;
    }

    private static int getMin(int[] times) {
        int min = times[0];
        for (int time : times) {
            if (time < min) {
                min = time;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        solution(6, new int[]{7, 10});
    }
}
