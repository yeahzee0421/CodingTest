import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, Map<String, Integer>> giftLog = new HashMap<>();
        HashMap<String, Integer> score = new HashMap<>(); // 선물 지수
        HashMap<String, Integer> next = new HashMap<>(); // 다음달 선물 
        for(String friend: friends){
            giftLog.put(friend, new HashMap<>());
            score.put(friend, 0);
            next.put(friend, 0);
        }
        
         for (String gift : gifts) {
            String[] tmp = gift.split(" ");
            String give = tmp[0];
            String take = tmp[1];
            //muzi=ryan,2 
            giftLog.get(give).put(take, giftLog.get(give).getOrDefault(take, 0)+1);
            score.put(give, score.get(give) + 1);
            score.put(take, score.get(take) - 1);
        }
        for (String give : friends) {
            for (String take : friends) {
                if (!give.equals(take)) {
                    int giveToTake = giftLog.get(give).getOrDefault(take, 0);
                    int takeToGive = giftLog.get(take).getOrDefault(give, 0);

                    if (giveToTake > takeToGive) {
                        next.put(give, next.get(give) + 1);
                    } else if (giveToTake == takeToGive && score.get(give) > score.get(take)) {
                        next.put(give, next.get(give) + 1);
                    }
                }
            }
        }
        
        return Collections.max(next.values());
    }
}