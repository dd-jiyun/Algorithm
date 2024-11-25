package b2816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] channels = new String[n];
        for (int i = 0; i < n; i++) {
            channels[i] = br.readLine();
        }

        int pointer = 0;
        StringBuilder commands = new StringBuilder();

        int kbs1Index = findIndex(channels, "KBS1");

        movePointer(commands, pointer, kbs1Index);
        pointer = kbs1Index;

        moveToTop(commands, channels, kbs1Index);
        pointer = 0;

        int kbs2Index = findIndex(channels, "KBS2");

        movePointer(commands, pointer, kbs2Index);
        pointer = kbs2Index;

        moveToSecond(commands, channels, kbs2Index);
        pointer = 1;

        System.out.println(commands);
        br.close();
    }

    private static int findIndex(String[] channels, String target) {
        for (int i = 0; i < channels.length; i++) {
            if (channels[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    private static void movePointer(StringBuilder commands, int currentIdx, int targetIdx) {
        int moveCount = Math.abs(currentIdx - targetIdx);
        commands.append("1".repeat(moveCount));
    }

    private static void moveToTop(StringBuilder commands, String[] channels, int index) {
        moveToPosition(commands, channels, index, 0);
    }

    private static void moveToSecond(StringBuilder commands, String[] channels, int index) {
        moveToPosition(commands, channels, index, 1);
    }

    private static void moveToPosition(StringBuilder commands, String[] channels, int currentIdx, int targetIdx) {
        while (currentIdx > targetIdx) {
            commands.append('4');
            swap(channels, currentIdx, currentIdx - 1);
            currentIdx--;
        }
    }

    private static void swap(String[] channels, int i, int j) {
        String temp = channels[i];
        channels[i] = channels[j];
        channels[j] = temp;
    }

}
