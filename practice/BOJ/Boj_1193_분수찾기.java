package practice.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1193_분수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        if (n == 1) {
            System.out.println("1/1");
            return;
        }

        /*
        1/1 2/1 1/3 4/1 1/5
         1   3   6   10  15
           2   3   4    5 ...*/

        int x = 1;
        int y = 1;

        while (x < n) {
            y += 1;
            x += y;
        }

        if (x == n) {
            if (y % 2 == 0) {
                System.out.println(y + "/1");
                return;
            }
            System.out.println("1/" + y);
            return;
        }

        int target = x - n;

        if (y % 2 == 0) {
            int tmp = 1;
            for (int i = 0; i < target; i++) {
                y--;
                tmp++;
            }
            System.out.println(y+"/"+tmp);
            return;
        }

        int tmp = 1;
        for (int i = 0; i < target; i++) {
            y--;
            tmp++;
        }
        System.out.println(tmp+"/"+y);
    }
}
