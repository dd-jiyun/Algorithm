package p43164;

import java.util.*;

class Solution {
    private List<String> answer;
    private Map<String, List<String>> graph;
    private int count;

    public String[] solution(String[][] tickets) {
        graph = new HashMap<>();
        answer = new ArrayList<>();
        count = tickets.length;

        for (String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new ArrayList<>());
            graph.get(ticket[0]).add(ticket[1]);
        }

        for (String key : graph.keySet()) {
            Collections.sort(graph.get(key));
        }

        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs("ICN", path, 0);

        return answer.toArray(new String[0]);
    }

    private boolean dfs(String current, List<String> path, int count) {
        if (count == this.count) {
            answer = new ArrayList<>(path);
            return true;
        }

        if (graph.containsKey(current)) {
            List<String> destinations = graph.get(current);
            for (int i = 0; i < destinations.size(); i++) {
                String next = destinations.get(i);

                destinations.remove(i);
                path.add(next);

                if (dfs(next, path, count + 1)) {
                    return true;
                }

                path.remove(path.size() - 1);
                destinations.add(i, next);
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        String[][] tickets = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(tickets)));
    }
}
