package b17413;

import java.io.*;
import java.util.*;

public class Main {

    private static final char TAG_START = '<';
    private static final char TAG_END = '>';
    private static final char SPACE = ' ';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder result = new StringBuilder();
        Deque<Character> deque = new ArrayDeque<>();
        boolean insideTag = false;

        for (char c : input.toCharArray()) {
            if (c == TAG_START) {
                flushStack(deque, result);
                insideTag = true;
                result.append(c);
            } else if (c == TAG_END) {
                insideTag = false;
                result.append(c);
            } else if (insideTag) {
                result.append(c);
            } else if (c == SPACE) {
                flushStack(deque, result);
                result.append(c);
            } else {
                deque.addLast(c);
            }
        }

        flushStack(deque, result);
        System.out.println(result);
        br.close();
    }

    private static void flushStack(Deque<Character> deque, StringBuilder result) {
        while (!deque.isEmpty()) {
            result.append(deque.removeLast());
        }
    }
}
