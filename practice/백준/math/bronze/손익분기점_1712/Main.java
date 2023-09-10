package practice.백준.math.bronze.손익분기점_1712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static int fixed;
    static int pay;
    static int price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        fixed = list.get(0);
        pay = list.get(1);
        price = list.get(2);

        if (pay >= price) {
            System.out.println(-1);
            return;
        }

        System.out.println(fixed / (price - pay) + 1);
    }
}
