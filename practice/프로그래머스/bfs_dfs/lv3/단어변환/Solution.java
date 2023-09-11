package practice.프로그래머스.bfs_dfs.lv3.단어변환;

import java.util.Arrays;

class Solution {
    static int answer;
    static int num;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        num = begin.length();
        dfs(begin, target, words);
        // words 에 포함된 글자들 중에 한 글자만 바꿔서 begin or target 으로 변환될 수 없는 경우 에러 반환.
        if (Arrays.stream(words).filter(word -> word.equals(target)).findAny().orElse("").equals("")) return 0;
        return answer;
    }

    private void dfs(String begin, String target, String[] words) {
        if (begin.equals(target)) {
            int cnt = 0;
            for (boolean b : visited) {
                if (b) cnt++;
            }
            answer = cnt;
        }
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            int cnt = 0;
            for (int j = 0; j < num; j++) {
                if (words[i].charAt(j) == begin.charAt(j)) cnt++;
            }
            if (num - cnt == 1) {
                visited[i] = true;
                dfs(words[i], target, words);
                visited[i] = false;
            }
        }
    }
}