package p42579;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genrePlayCount = new HashMap<>();
        HashMap<String, List<int[]>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);

            if (!genreSongs.containsKey(genre)) {
                genreSongs.put(genre, new ArrayList<>());
            }
            genreSongs.get(genre).add(new int[] {i, play});
        }

        List<String> genreOrder = new ArrayList<>(genrePlayCount.keySet());
        // 장르 재생횟수 내림차순 정렬
        genreOrder.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        List<Integer> result = new ArrayList<>();

        for (String genre : genreOrder) {
            List<int[]> songs = genreSongs.get(genre);

            // 재생횟수 내림차순, 고유번호 오름차순 정렬 (재생횟수가 같을 경우, 고유번호가 낮은 노래부터 수록)
            songs.sort((a, b) -> b[1] != a[1] ? b[1] - a[1] : a[0] - b[0]);

            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                result.add(songs.get(i)[0]);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        // 재생횟수가 같을 경우, 고유번호가 낮은 노래부터 수록 테스트
        String[] genres2 = {"classic", "pop", "classic", "classic", "pop", "pop"};
        int[] plays2 = {500, 600, 150, 500, 2500, 800};

        int[] result = solution.solution(genres, plays);
        int[] result2 = solution.solution(genres2, plays2);

        for (int i : result) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i : result2) {
            System.out.print(i + " ");
        }
    }
}
