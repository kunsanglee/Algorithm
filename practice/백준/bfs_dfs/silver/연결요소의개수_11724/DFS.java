package practice.백준.bfs_dfs.silver.연결요소의개수_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class DFS {
    static int vertices, edges, count;
    static boolean[] visited;
    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertices = Integer.parseInt(st.nextToken());
        edges = Integer.parseInt(st.nextToken());
        visited = new boolean[vertices + 1];

        for (int i = 0; i < vertices; i++) {
            graph.put(i + 1, new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int vertex = Integer.parseInt(st.nextToken());
            graph.get(key).add(vertex);
            graph.get(vertex).add(key);
        }

        for (int i = 1; i <= vertices; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int vertex) {
        visited[vertex] = true;
        for (Integer i : graph.get(vertex)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
