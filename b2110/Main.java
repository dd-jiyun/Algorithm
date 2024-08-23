package b2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int C;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for(int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        System.out.println(binarySearch(house, C));
    }

    public static int binarySearch(int[] house, int C) {
        int left = 1;
        int right = house[N - 1] - house[0];
        int mid, cnt, prev;

        while(left <= right) {
            mid = (left + right) / 2;
            cnt = 1;
            // 첫번째 집에는 무조건 공유기를 설치한다고 가정
            prev = house[0];

            // 간격(mid)를 기준으로 공유기를 설치
            for(int i = 1; i < N; i++) {
                if(house[i] - prev >= mid) {
                    cnt++;
                    prev = house[i];
                }
            }
            // 공유기의 수가 C보다 크거나 같으면 거리를 늘려본다.
            if(cnt >= C) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
