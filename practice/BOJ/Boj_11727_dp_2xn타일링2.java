package practice.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11727_dp_2xn타일링2 {
    static int[] arr = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr[1] = 1;
        arr[2] = 3;
        arr[3] = 5;
        arr[4] = 11;
//        ㅁㅁ ㅁ11 11ㅁ 1ㅁ1 ㅁ= =ㅁ 11= 1=1 =11 == 1111

        System.out.println(dpFunc(n));
    }

    /**
     * mod 연산을 한 결과값을 출력해야 할 때에는 반드시 연산할 때마다 mod 연산을 해주어야 한다.
     * 계속 숫자를 더하고 마지막 출력시에만 mod연산을 해줄 경우
     * Integer.MAX_VALUE를 넘어 Overflow가 발생하기 때문에 잘못된 값이 출력될 수 있다.
     */
    public static int dpFunc(int n) {
        for (int i = 3; i < n+1; i++) {
            arr[i] = (arr[i-1] + 2*(arr[i-2])) % 10007;
        }
        return arr[n];
    }
}