package practice.프로그래머스.bfs_dfs.lv3.단어변환;

import java.util.Arrays;

class Solution2 {
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        // words 에 포함된 글자들 중에 한 글자만 바꿔서 begin or target 으로 변환될 수 없는 경우 에러 반환.
        if (Arrays.stream(words).noneMatch(word -> word.equals(target))) return 0;

        visited = new boolean[words.length];
        dfs(begin, target, words, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private void dfs(String begin, String target, String[] words, int depth) {
        if (begin.equals(target)) {
            answer = Math.min(answer , depth);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && canChange(begin , words[i])) {
                visited[i] = true;
                dfs(words[i], target , words , depth+1);
                visited[i] = false;
            }
        }
    }

    private boolean canChange(String s1, String s2){
        int cnt = 0;
        for(int i=0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        return cnt == 1;
    }
}

