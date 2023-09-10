//package practice.BOJ;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class Main {
//
//    static boolean[][] visited;
//    static int[][] apt;
//    static int[] xDirection = {0, 0, -1, 1};
//    static int[] yDirection = {1, -1, 0, 0};
//    static ArrayList<Integer> result = new ArrayList<>();
//    static ArrayList<Node> needVisit = new ArrayList<>();
//    static int n, count;
//
//    static class Node {
//        int x;
//        int y;
//
//        public Node(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    private static void bfsFunc(int xStart, int yStart) {
//        needVisit.add(new Node(xStart, yStart));
//        visited[xStart][yStart] = true;
//
//        while (needVisit.size() > 0) {
//            Node removed = needVisit.remove(0);
//            count++;
//
//            for (int i = 0; i < 4; i++) {
//                int nextX = removed.x + xDirection[i];
//                int nextY = removed.y + yDirection[i];
//                if (isPosition(nextX, nextY) && !visited[nextX][nextY] && apt[nextX][nextY] == 1) {
//                    needVisit.add(new Node(nextX, nextY));
//                    visited[nextX][nextY] = true;
//                }
//            }
//        }
//    }
//
//    private static boolean isPosition(int nextX, int nextY) {
//        if (0 <= nextX && nextX < apt.length &&
//                0 <= nextY && nextY < apt.length) {
//            return true;
//        }
//        return false;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//        visited = new boolean[n][n];
//        apt = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            String tmp = br.readLine();
//            for (int j = 0; j < n; j++) {
//                apt[i][j] = Character.getNumericValue(tmp.charAt(j));
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (apt[i][j] == 1 && !visited[i][j]) {
//                    count = 0;
//                    bfsFunc(i, j);
//                    result.add(count);
//                }
//            }
//        }
//
//        System.out.println(result.size());
//        Collections.sort(result);
//        for (Integer i : result) {
//            System.out.println(i);
//        }
//    }
//}


package practice.백준.bfs_dfs.silver.단지번호붙이기_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static boolean[][] visited;
    static int[][] apt;
    static int[] xDirection = {0, 0, -1, 1};
    static int[] yDirection = {1, -1, 0, 0};
    static ArrayList<Integer> result = new ArrayList<>();
    static ArrayList<Node> needVisit = new ArrayList<>();
    static int n, count;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void dfsFunc(int xStart, int yStart) {
        visited[xStart][yStart] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int nextX = xStart + xDirection[i];
            int nextY = yStart + yDirection[i];
            if (isPosition(nextX, nextY) && !visited[nextX][nextY] && apt[nextX][nextY] == 1) {
                dfsFunc(nextX, nextY);
            }
        }
    }

    private static boolean isPosition(int nextX, int nextY) {
        if (0 <= nextX && nextX < apt.length &&
                0 <= nextY && nextY < apt.length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        apt = new int[n][n];

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                apt[i][j] = Character.getNumericValue(tmp.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (apt[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfsFunc(i, j);
                    result.add(count);
                }
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
