package practice.백준.brute_force.silver.사탕게임_3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    static ArrayList<Integer> rowList = new ArrayList<>();
    static ArrayList<Integer> colList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        int[][] cnt = new int[n][2];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        ArrayList<Integer> row = rowFunc(n, arr);
        ArrayList<Integer> col = colFunc(n, arr);


        for (Integer c : row) {
            System.out.print(c + ", ");
        }
        System.out.println();

        for (Integer c : col) {
            System.out.print(c + ", ");
        }
    }

    private static ArrayList<Integer> rowFunc(int n, char[][] arr) {

        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> row = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (row.get(arr[i][j]) == null) {
                    row.put(arr[i][j], 1);
                } else {
                    row.put(arr[i][j], row.get(arr[i][j]) + 1);
                }
            }
            for (Character c : row.keySet()) {
                rowList.add(row.get(c));
            }
        }
        return rowList;
    }

    private static ArrayList<Integer> colFunc(int n, char[][] arr) {
        ArrayList<Integer> colList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> col = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (col.get(arr[j][i]) == null) {
                    col.put(arr[j][i], 1);
                } else {
                    col.put(arr[j][i], col.get(arr[j][i]) + 1);
                }
            }
            for (Character c : col.keySet()) {
                colList.add(col.get(c));
            }
        }
        return colList;
    }
}
