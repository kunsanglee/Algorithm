package practice.백준.math.bronze.달팽이는_올라가고_싶다_2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

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

        int total = (v - b) / (a - b);

        if ((v - b) % (a - b) != 0) {
            total++;
        }

        System.out.println(total);
    }
}
