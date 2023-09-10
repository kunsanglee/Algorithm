package practice.프로그래머스.bfs_dfs.lv2.타겟넘버;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    static ArrayList<Integer> numbers;
    static int target;
    static int cnt;
    public int solution(int[] numbers, int target) {
        this.numbers = Arrays.stream(numbers).boxed().collect(Collectors.toCollection(ArrayList::new));
        this.target = target;
        this.cnt = 0;

        dfs(0, 0);
        return cnt;
    }

    private void dfs(int index, int sum) {
        if (index == numbers.size()) {
            if (sum == target) {
                cnt++;
            }
            return;
        }
        dfs(index + 1, sum + numbers.get(index));
        dfs(index + 1, sum - numbers.get(index));
    }
}