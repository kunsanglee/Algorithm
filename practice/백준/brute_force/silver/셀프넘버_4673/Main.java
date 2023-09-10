package practice.백준.brute_force.silver.셀프넘버_4673;

public class Main {

    static boolean[] arr = new boolean[10001];

    private static int d(int i) {
        int sum = i;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        for (int i = 1; i < 10001; i++) {
            int n = d(i);

            if (n < 10001) {
                arr[n] = true;
            }
        }

        for (int i = 1; i < 10001; i++) {
            if (!arr[i]) {
                System.out.println(i);
            }
        }
    }
}
