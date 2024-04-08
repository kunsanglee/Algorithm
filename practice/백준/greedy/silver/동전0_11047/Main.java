package practice.백준.greedy.silver.동전0_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputList = Arrays.asList(br.readLine().split(" "));
        int coinKinds = Integer.parseInt(inputList.get(0));
        int targetMoney = Integer.parseInt(inputList.get(1));
        int coinCounts = 0;

        ArrayList<Integer> coins = new ArrayList<>();
        while (coinKinds-- > 0) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        for (int i = coins.size() - 1; i >= 0; i--) {
            int currentCoin = coins.get(i);
            if (currentCoin <= targetMoney) {
                int divide = targetMoney / currentCoin;
                targetMoney -= currentCoin * divide;
                coinCounts += divide;
            }
        }

        System.out.println(coinCounts);
    }
}
