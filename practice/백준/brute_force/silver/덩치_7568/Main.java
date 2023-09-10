package practice.백준.brute_force.silver.덩치_7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<DC> list = new ArrayList<>();

    static class DC {
        int weight;
        int height;
        int rank;

        public DC(int weight, int height) {
            this.weight = weight;
            this.height = height;
            this.rank = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new DC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < n; i++) {
            int rank = 1;
            DC prev = list.get(i);
            for (int j = 0; j < n; j++) {
                DC next = list.get(j);
                if (prev.weight < next.weight && prev.height < next.height) {
                    rank++;
                }
            }
            prev.rank = rank;
        }

        for (DC dc : list) {
            System.out.println(dc.rank);
        }
    }
}
