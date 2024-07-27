package b6987;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] results;
    static int[][] matches = new int[15][2];
    static boolean isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        results = new int[6][3];

        int matchIndex = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 6; j++) {
                matches[matchIndex][0] = i;
                matches[matchIndex][1] = j;
                matchIndex++;
            }
        }

        for (int testCase = 0; testCase < 4; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            boolean validInput = true;
            int totalMatches = 0;

            for (int i = 0; i < 6; i++) {
                results[i][0] = Integer.parseInt(st.nextToken());
                results[i][1] = Integer.parseInt(st.nextToken());
                results[i][2] = Integer.parseInt(st.nextToken());
                totalMatches += results[i][0] + results[i][1] + results[i][2];
                if (results[i][0] + results[i][1] + results[i][2] != 5) {
                    validInput = false;
                }
            }

            if (validInput && totalMatches == 30) {
                isPossible = false;
                backtrack(0);
                sb.append(isPossible ? 1 : 0);
            } else {
                sb.append(0);
            }

            if (testCase < 3) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    static void backtrack(int matchIndex) {
        if (isPossible) {
            return; // 이미 가능한 경우 찾았으면 더 이상 탐색하지 않음
        }
        if (matchIndex == 15) {
            isPossible = true;
            return;
        }

        int team1 = matches[matchIndex][0];
        int team2 = matches[matchIndex][1];

        // Team1 승리
        if (results[team1][0] > 0 && results[team2][2] > 0) {
            results[team1][0]--;
            results[team2][2]--;
            backtrack(matchIndex + 1);
            results[team1][0]++;
            results[team2][2]++;
        }

        // 무승부
        if (results[team1][1] > 0 && results[team2][1] > 0) {
            results[team1][1]--;
            results[team2][1]--;
            backtrack(matchIndex + 1);
            results[team1][1]++;
            results[team2][1]++;
        }

        // Team2 승리
        if (results[team1][2] > 0 && results[team2][0] > 0) {
            results[team1][2]--;
            results[team2][0]--;
            backtrack(matchIndex + 1);
            results[team1][2]++;
            results[team2][0]++;
        }
    }
}
