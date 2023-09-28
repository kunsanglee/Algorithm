package practice.백준.bfs_dfs.silver.촌수계산_2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, Integer> map = new HashMap<>();
    static ArrayList<Integer> xList = new ArrayList<>();
    static ArrayList<Integer> yList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            map.put(child, parent);
        }

        // X 의 조상을 쭉 타고 올라감.
        // Y 의 조상을 쭉 타고 올라감.
        // 둘의 공통 조상이 있는지 비교
        // 없으면 -1
        // 있으면 count

        makeList(x, xList);
        makeList(y, yList);

        Integer core = findCoreParent();
        if (core == null) {
            System.out.println(-1);
            return;
        }
        System.out.println(xList.indexOf(core) + yList.indexOf(core));
    }

    private static Integer findCoreParent() {
        int core = 0;
        for (int i = 0; i < xList.size(); i++) {
            for (int j = 0; j < yList.size(); j++) {
                if (xList.get(i) == yList.get(j)) {
                    return xList.get(i);
                }
            }
        }
        return null;
    }

    private static void makeList(int child, ArrayList<Integer> list) {
        list.add(child);
        Integer parent = map.get(child);
        if (parent != null) {
            list.add(parent);
            Integer newParent = map.get(parent);
            if (newParent != null) {
                makeList(newParent, list);
            }
        }
    }
}
