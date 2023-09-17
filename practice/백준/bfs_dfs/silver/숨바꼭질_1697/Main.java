package practice.백준.bfs_dfs.silver.숨바꼭질_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited = new int[100001]; // bfs 단계를 저장하기 위해 boolean[] 이 아닌 int[]로 생성.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        Arrays.fill(visited, -1); // 초기 상태에서 모든 위치는 방문되지 않았음을 표시
        queue.offer(start); // 큐에 시작 위치 세팅.
        visited[start] = 0; // 시작위치 초기값 0으로 세팅.
        bfs(target);
    }

    private static void bfs(int target) {
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == target) {
                System.out.println(visited[current]); // target 위치에 도착하면 target 위치까지 걸린 횟수 반환.
                break;
            }
            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) next = current - 1;
                else if(i == 1) next = current + 1;
                else next = current * 2;

                // next 범위가 0과 100000 사이가 아니면 continue.
                // visited[next]의 값이 -1이 아니라면 방문했던 경로이기 때문에 continue.
                if (next < 0 || 100000 < next || visited[next] != -1) continue;

                queue.offer(next);
                visited[next] = visited[current] + 1; // visited[next]에 현재 경로에 도달한 값 + 1 하여 방문처리.
            }
        }
    }
}
