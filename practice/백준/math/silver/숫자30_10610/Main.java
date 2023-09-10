package practice.백준.math.silver.숫자30_10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();
        char[] arr = num.toCharArray();

        Arrays.sort(arr);
        if (arr[0] != '0') {
            System.out.println(-1);
            return ;
        }

        int sum = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            sum += Character.getNumericValue(arr[i]);
        }

        if (sum % 3 != 0) {
            System.out.println(-1);
            return ;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        System.out.println(sb);
    }
}
