class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0, 0);
        return answer;
    }
    public static void DFS(int[] numbers, int target, int sum, int dep){
        int initial_depth = numbers.length;
        if(dep == initial_depth){
            if(sum == target) answer++;
        }
        else{
            DFS(numbers, target, sum + numbers[dep], dep+1);
            DFS(numbers, target, sum - numbers[dep], dep+1);
        }
    }
}