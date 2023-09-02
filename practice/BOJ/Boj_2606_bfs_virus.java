package practice.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_2606_bfs_virus {

    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    static ArrayList<Integer> vertices = new ArrayList<>();
    static ArrayList<Integer> visited = new ArrayList<>();
    static ArrayList<Integer> needVisit = new ArrayList<>();
    static int n, edge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            vertices.add(i+1);
            map.put(i+1, new ArrayList<Integer>());
        }

        for (int i = 1; i <= edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map.get(from).add(to);
            map.get(to).add(from);
        }

        bfsFunc(vertices, 1);
    }

    public static void bfsFunc(ArrayList<Integer> vertices, int start) {
        needVisit.add(start);
        while (needVisit.size() > 0) {
            Integer removed = needVisit.remove(0);
            if (!visited.contains(removed)) {
                visited.add(removed);
                needVisit.addAll(map.get(removed));
            }
        }
        System.out.println(visited.size()-1);
    }
}
