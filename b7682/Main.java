package b7682;

import java.io.*;
import java.util.*;

public class Main {
    private static final String END = "end";
    private static final String VALID = "valid";
    private static final String INVALID = "invalid";
    private static final Character PLAYER_2_MARK = 'O';
    private static final Character PLAYER_1_MARK = 'X';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> board = new ArrayList<>();

        while (true) {
            String line = br.readLine();
            if (line.equals(END)) {
                break;
            }
            board.add(line);
        }

        StringBuilder sb = new StringBuilder();
        for (String game : board) {
            sb.append(isValid(game) ? VALID : INVALID).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean isValid(String s) {
        int count1 = count(s, PLAYER_1_MARK);
        int count2 = count(s, PLAYER_2_MARK);

        if (count1 < count2 || count1 > count2 + 1) {
            return false;
        }

        boolean win1 = isWin(s, PLAYER_1_MARK);
        boolean win2 = isWin(s, PLAYER_2_MARK);

        if (win1 && win2) {
            return false;
        }

        if (win1 && count1 != count2 + 1) {
            return false;
        }

        if (win2 && count1 != count2) {
            return false;
        }

        if (!win1 && !win2 && count1 + count2 != 9) {
            return false;
        }

        return true;
    }

    private static int count(String s, char c) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }

        return count;
    }

    private static boolean isWin(String s, char c) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = s.charAt(i);
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == c && board[i][1] == c && board[i][2] == c) {
                return true;
            }
            if (board[0][i] == c && board[1][i] == c && board[2][i] == c) {
                return true;
            }
        }

        if (board[0][0] == c && board[1][1] == c && board[2][2] == c) {
            return true;
        }

        if (board[0][2] == c && board[1][1] == c && board[2][0] == c) {
            return true;
        }

        return false;
    }
}
