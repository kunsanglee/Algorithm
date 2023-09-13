package practice.프로그래머스.bfs_dfs.lv3.여행경로;

import java.util.ArrayList;

class Solution {
    static final String ICN = "ICN";
    static boolean[] visited;
    static ArrayList<String> bestPath = null;
    static ArrayList<String> path = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        path.add(ICN);
        dfs(tickets, ICN, 0);
        return bestPath.toArray(new String[0]);
    }

    private void dfs(String[][] tickets, String currentAirport, int count) {
        if (count == tickets.length) {
            if (bestPath == null || isBetterPath(path, bestPath)) {
                bestPath = new ArrayList<>(path);
            }
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(currentAirport)) {
                String nextAirport = tickets[i][1];
                path.add(nextAirport);
                visited[i] = true;
                dfs(tickets, nextAirport, count + 1);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isBetterPath(ArrayList<String> path, ArrayList<String> bestPath) {
        for (int i = 0; i < path.size(); i++) {
            int compare = path.get(i).compareTo(bestPath.get(i));
            if (compare != 0) {
                return compare < 0;
            }
        }
        return false;
    }
}
