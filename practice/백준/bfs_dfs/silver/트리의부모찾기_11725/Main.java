package practice.백준.bfs_dfs.silver.트리의부모찾기_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    static int[] parent; // 부모 node 여부에 따라 처리하기 때문에 boolean 사용하지 않음.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>()); // 1부터 N까지 빈 ArrayList 초기화.
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.get(x).add(y); // 연결돼있는 node 끼리 서로 추가함. x -> y
            map.get(y).add(x); // y -> x
        }

        bfs(1); // 1부터 차례로 시작.

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>(); // 각 start 하는 숫자에 따라 queue 공간을 따로 갖음.
        queue.offer(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : map.get(current)) { // map 에서 current 숫자와 연결된 숫자들 리스트를 돌면서.
                if (parent[next] == 0) { // current 와 연결된 숫자 next 가 부모가 아직 정해지지 않았으면
                    parent[next] = current; // next 의 부모를 current 로 저장.
                    queue.offer(next); // next 를 queue 에 넣고 연결이 끊어질 때 까지 반복.
                }
            }
        }
    }
}
