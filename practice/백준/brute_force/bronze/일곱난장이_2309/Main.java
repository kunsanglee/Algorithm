package practice.백준.brute_force.bronze.일곱난장이_2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int[] arr = new int[9];
    static ArrayList<Integer> result = new ArrayList<>();
    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - 100 == arr[i] + arr[j]) {
                    a = arr[i];
                    b = arr[j];
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i] != a && arr[i] != b) {
                result.add(arr[i]);
            }
        }
        for (Integer i : result) {
            System.out.println(i);
        }
    }

}
