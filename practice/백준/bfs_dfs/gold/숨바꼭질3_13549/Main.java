package practice.백준.bfs_dfs.gold.숨바꼭질3_13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, MIN, MAX;
    static boolean[] visited = new boolean[100001];
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        MIN = Integer.MAX_VALUE;
        MAX = 100000;
        queue.offer(new Node(N, 0));
        bfs();
        System.out.println(MIN);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.x == K) {
                MIN = Math.min(MIN, current.time);
            }
            visited[current.x] = true;
            if (current.x * 2 <= MAX && !visited[current.x * 2]) queue.offer(new Node(current.x * 2, current.time));
            if (current.x + 1 <= MAX && !visited[current.x + 1]) queue.offer(new Node(current.x + 1, current.time + 1));
            if (current.x - 1 >= 0 && !visited[current.x - 1]) queue.offer(new Node(current.x - 1, current.time + 1));
        }
    }

    static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
