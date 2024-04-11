package practice.백준;

public class Main {
    public static void main(String[] args) {
        recursive(11545);
    }

    public static void recursive(int count) {
        if (count == 0) {
            return;
        }
        System.out.println("count = " + count);
        recursive(count - 1);
    }
}
