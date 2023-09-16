package practice.프로그래머스.완전탐색.lv1.최소직사각형;


class Solution {
    public int solution(int[][] sizes) {
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < sizes.length; i++) {
            changeXY(sizes, i);
            if (maxX < sizes[i][0]) maxX = sizes[i][0];
            if (maxY < sizes[i][1]) maxY = sizes[i][1];
        }
        return maxX * maxY;
    }

    private static void changeXY(int[][] sizes, int i) {
        int tmp = 0;
        if (sizes[i][0] < sizes[i][1]) {
            tmp = sizes[i][0];
            sizes[i][0] = sizes[i][1];
            sizes[i][1] = tmp;
        }
    }
}