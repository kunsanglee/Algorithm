package practice.백준.math.bronze.ACM호텔_10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        for (int i = 0; i < x; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int height = list.get(0);
            int num = list.get(2);

            int room = num / height;
            int floor = num % height;

            if (floor == 0) {
                System.out.println(height * 100 + room);
            } else {
                System.out.println(floor * 100 + room + 1);
            }
        }
    }
}
