package practice.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2869_달팽이는_올라가고_싶다 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int a = list.get(0);
        int b = list.get(1);
        int v = list.get(2);
        int total = 0;
        int day = 1;
        while (true) {
            total += a;
            if (total >= v) {
                System.out.println(day);
                return;
            }
            total -= b;
            day++;
        }
    }
}
