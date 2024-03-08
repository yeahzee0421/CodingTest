import java.util.*;
import java.io.*;
class Song {
    int index;
    int playCount;

    public Song(int index, int playCount) {
        this.index = index;
        this.playCount = playCount;
    }
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, PriorityQueue<Song>> info = new HashMap<>();
        // 각 장르별 총 재생 횟수를 저장하는 Map
        HashMap<String, Integer> totalPlays = new HashMap<>();

        int num = plays.length;

        // 각 장르별로 재생 횟수를 더해줌
        for (int i = 0; i < num; i++) {
            String genre = genres[i];
            int playCount = plays[i];

            // 장르별 총 재생 횟수를 계산하여 totalPlays에 저장
            totalPlays.put(genre, totalPlays.getOrDefault(genre, 0) + playCount);
        }

        // 각 장르별로 재생 횟수가 많은 노래의 인덱스를 저장
        for (int i = 0; i < num; i++) {
            String genre = genres[i];
            int playCount = plays[i];

            if (!info.containsKey(genre)) {
                info.put(genre, new PriorityQueue<>((a, b) -> {
                    if (a.playCount != b.playCount) {
                        return b.playCount - a.playCount;
                    } else {
                        return a.index - b.index;
                    }
                }));
            }

            PriorityQueue<Song> songQueue = info.get(genre);
            songQueue.offer(new Song(i, playCount));
        }

        // 재생 횟수가 많은 장르부터 노래를 수록하여 answer 리스트에 저장
        ArrayList<Integer> answerList = new ArrayList<>();
        List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(totalPlays.entrySet());
        Collections.sort(sortedGenres, (a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : sortedGenres) {
            String genre = entry.getKey();
            PriorityQueue<Song> songQueue = info.get(genre);

            int count = Math.min(songQueue.size(), 2);
            for (int i = 0; i < count; i++) {
                answerList.add(songQueue.poll().index);
            }
        }

        // ArrayList를 int 배열로 변환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
                        
        return answer;
    }
}