package practice.프로그래머스.bfs_dfs.lv3.네트워크;

import java.util.LinkedList;
import java.util.Queue;

class BFS {
    static boolean[] visited;
    static Queue<Integer> needVisit = new LinkedList<>();
    static int cnt = 0;

    public int solution(int n, int[][] computers) {
        visited = new boolean[computers.length];
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                cnt++;
            }
        }
        return cnt;
    }

    private void bfs(int node, int[][] computers) {
        needVisit.offer(node);
        while (!needVisit.isEmpty()) {
            Integer curr = needVisit.poll();
            visited[curr] = true;
            int[] computer = computers[curr];
            for (int j = 0; j < computer.length; j++) {
                if (!visited[j] && computer[j] == 1) {
                    needVisit.offer(j);
                }
            }
        }
    }
}

