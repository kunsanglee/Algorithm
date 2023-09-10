package practice.프로그래머스.bfs_dfs.lv3.네트워크;

class DFS {
    static boolean[] visited;
    static int cnt = 0;
    public int solution(int n, int[][] computers) {
        visited = new boolean[computers.length];
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                cnt++;
            }
        }
        return cnt;
    }

    private void dfs(int node, int[][] computers) {
        visited[node] = true;
        int[] computer = computers[node];
        for (int j = 0; j < computer.length; j++) {
            if (!visited[j] && computer[j] == 1) {
                dfs(j, computers);
            }
        }
    }
}
