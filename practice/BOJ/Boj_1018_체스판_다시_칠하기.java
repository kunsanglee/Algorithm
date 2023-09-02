package practice.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1018_체스판_다시_칠하기 {

    static int n, m;
    static char[][] arr;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); // 가나다라마바사
        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            arr[i] = tmp.toCharArray();
        }

        for (int i = 0; i <= n-8; i++) {
            for (int j = 0; j <= m-8; j++) {
                int bCount = 0;
                int wCount = 0;
                for (int k = i, y = 0; k < 8+i; k++, y++) {
                    for (int l = j, x = 0; l < 8+j; l++, x++) {
                        if (y % 2 == 0) { // BWBWBWBW
                            if (x % 2 == 0) { // 0 2 4 6
                                if (arr[k][l] != 'B') bCount++;
                                else wCount++;
                            } else { // 1 3 5 7
                                if (arr[k][l] != 'W') bCount++;
                                else wCount++;
                            }
                        } else { // WBWBWBWB
                            if (x % 2 == 0) { // 0 2 4 6
                                if (arr[k][l] != 'W') bCount++;
                                else wCount++;
                            } else { // 1 3 5 7
                                if (arr[k][l] != 'B') bCount++;
                                else wCount++;
                            }
                        }
                    }
                }
                list.add(Math.min(bCount, wCount));
            }

        }
        System.out.println(list.stream().mapToInt(i -> i).min().orElse(0));
    }
}