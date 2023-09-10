package practice.백준.math.bronze.벌집_2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        /*1 7 19 37 61
           6 12 18 24 ...*/
        int answer = 1;
        if (n == 1) {
            System.out.println(answer);
            return;
        }
        int k = 1;
        while (k < n) {
            k += answer * 6;
            answer++;
        }

        System.out.println(answer);
    }
}
