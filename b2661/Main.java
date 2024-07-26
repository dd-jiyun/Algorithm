package b2661;

import java.util.Scanner;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        backtrack("");
    }

    public static void backtrack(String str) {
        if (str.length() == N) {
            System.out.println(str);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (check(str + i)) {
                backtrack(str + i);
            }
        }
    }

    public static boolean check(String str) {
        int len = str.length();
        for (int i = 1; i <= len / 2; i++) {
            String front = str.substring(len - 2 * i, len - i);
            String back = str.substring(len - i);
            if (front.equals(back)) {
                return false;
            }
        }
        return true;
    }
}
