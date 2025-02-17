import java.io.*;

public class b1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();

        System.out.println(convertBoard(board));
    }

    private static String convertBoard(String board) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (char c : board.toCharArray()) {
            if (c == 'X') {
                count++;
            } else {
                if (!replacePolyomino(result, count)) {
                    return "-1";
                }
                result.append(".");
                count = 0;
            }
        }

        if (!replacePolyomino(result, count)) {
            return "-1";
        }

        return result.toString();
    }

    private static boolean replacePolyomino(StringBuilder result, int count) {
        if (count % 2 != 0) {
            return false;
        }

        while (count >= 4) {
            result.append("AAAA");
            count -= 4;
        }

        if (count == 2) {
            result.append("BB");
        }

        return true;
    }
}
