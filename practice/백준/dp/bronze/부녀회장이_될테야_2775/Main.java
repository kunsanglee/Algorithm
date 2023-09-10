package practice.백준.dp.bronze.부녀회장이_될테야_2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     * 4층 | 1   6   21  56  126
     * 3층 | 1   5   15  35  70
     * 2층 | 1   4   10  20  35
     * 1층 | 1   3   6   10  15
     * 0층 | 1   2   3   4   5
     * -----------------------
     * 호  | 1   2   3   4   5
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int n = 0; n < testCase; n++) {
            int floor = Integer.parseInt(br.readLine());
            int room = Integer.parseInt(br.readLine());

            int[][] arr = new int[floor + 1][room + 1];

            for (int i = 0; i <= room; i++) {
                arr[0][i] = i;
            }

            for (int i = 1; i <= floor; i++) {
                int sum = 0;
                for (int j = 0; j <= room; j++) {
                    sum += arr[i - 1][j];
                    arr[i][j] = sum;
                }
            }
            System.out.println(arr[floor][room]);
        }
    }
}
