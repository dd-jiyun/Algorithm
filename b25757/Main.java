package b25757;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String gameType = st.nextToken();

        Map<String, Integer> gameRules = getRules();
        int requiredPlayers = gameRules.get(gameType);

        String mainPlayer = br.readLine().trim();
        Set<String> uniquePlayers = new HashSet<>();
        uniquePlayers.add(mainPlayer);

        for (int i = 1; i < n; i++) {
            String playerName = br.readLine().trim();
            if (isValidName(playerName)) {
                uniquePlayers.add(playerName);
            }
        }

        int totalPlayers = uniquePlayers.size();
        int maxGames = totalPlayers / (requiredPlayers - 1);

        System.out.println(maxGames);
        br.close();
    }

    private static Map<String, Integer> getRules() {
        return Map.of(
                "Y", 2,
                "F", 3,
                "O", 4
        );
    }

    private static boolean isValidName(String name) {
        if (name.length() > 20) {
            return false;
        }

        return name.matches("[a-zA-Z0-9]+");
    }

}
