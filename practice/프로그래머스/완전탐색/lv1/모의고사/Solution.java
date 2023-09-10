package practice.프로그래머스.완전탐색.lv1.모의고사;

class Solution {
    public int[] solution(int[] answers) {
        // 1번 : 1 2 3 4 5 ...
        // 2번 : 2 1 2 3 2 4 2 5 ... 홀수번 문제는 2, 짝수일때만 1씩 증가
        // 3번 : 3 3 1 1 2 2 4 4 5 5 ... 3 1 2 4 5 를 각각 두번씩 반복
        int[] aa = {1,2,3,4,5};
        int[] bb = {2,1,2,3,2,4,2,5};
        int[] cc = {3,3,1,1,2,2,4,4,5,5};
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == aa[i%5]) a++;
            if (answers[i] == bb[i%8]) b++;
            if (answers[i] == cc[i%10]) c++;
        }
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        if (max == min) {
            return new int[]{1, 2, 3};
        } else {
            if (max == a && a == b) {
                return new int[]{1, 2};
            } else if (max == a && a == c) {
                return new int[]{1, 3};
            } else if (max == b && b == c) {
                return new int[]{2, 3};
            }
        }
        if (a == max) {
            return new int[]{1};
        } else if (b == max) {
            return new int[]{2};
        }
        return new int[]{3};
    }
}
