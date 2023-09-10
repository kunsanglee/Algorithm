package practice.백준.bfs_dfs.silver.dfs와bfs_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int vertices, edges, start;
    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    static ArrayList<Integer> visited = new ArrayList<>();
    static ArrayList<Integer> needVisit = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreElements()) {
            vertices = Integer.parseInt(st.nextToken());
            edges = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < vertices; i++) {
            graph.put(i+1, new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int vertex = Integer.parseInt(st.nextToken());
            graph.get(key).add(vertex);
            graph.get(vertex).add(key);
        }

        dfs(graph, start);

        needVisit.clear();
        visited.clear();
        System.out.println();

        bfs(graph, start);
    }

    private static void dfs(HashMap<Integer, ArrayList<Integer>> graph, int start) {
        for (Integer key : graph.keySet()) {
            Collections.sort(graph.get(key), Collections.reverseOrder());
        }
        needVisit.add(start);

        while (needVisit.size() > 0) {
            Integer removed = needVisit.remove(needVisit.size()-1);
            if (!visited.contains(removed)) {
                visited.add(removed);
                needVisit.addAll(graph.get(removed));
            }
        }
        for (Integer i : visited) {
            System.out.print(i+ " ");
        }
    }

    private static void bfs(HashMap<Integer, ArrayList<Integer>> graph, int start) {
        for (Integer key : graph.keySet()) {
            Collections.sort(graph.get(key));
        }
        needVisit.add(start);

        while (needVisit.size() > 0) {
            Integer removed = needVisit.remove(0);
            if (!visited.contains(removed)) {
                visited.add(removed);
                needVisit.addAll(graph.get(removed));
            }
        }
        for (Integer i : visited) {
            System.out.print(i+ " ");
        }
    }
}
