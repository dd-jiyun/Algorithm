package b1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static String[] Alpha;
    static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Alpha = new String[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            Alpha[i] = String.valueOf(st.nextToken());
        }

        Arrays.sort(Alpha); // 알파벳 사전 순 정렬

        backtrack(0, 0, "");

        System.out.println(sb.toString());

    }

    // v : 모음 , tst : 완성되는 문자
    public static void backtrack(int index, int v, String tst) {
        // 종료 조건
        // 1. 문자열의 길이가 L과 같고 모음이 1개 이상, 전체 길이에서 모음의 길이를 뺀 값(자음)이 2개 이상이어야 문자열에 저장됨.
        // 2. 배열의 인덱스가 C와 같다.
        if (tst.length() == L && v >= 1 && L - v >= 2) {
            sb.append(tst).append("\n");
            return;
        }
        if (index == C) {
            return;
        }

        // 현재 문자를 포함할 경우
        char currentChar = Alpha[index].charAt(0);
        // 모음일 경우
        if (vowels.contains(currentChar)) {
            backtrack(index + 1, v + 1, tst + currentChar);
        } else { // 자음일 경우
            backtrack(index + 1, v, tst + currentChar);
        }

        // 현재 문자를 포함하지 않을 경우
        backtrack(index + 1, v, tst);

    }
}
