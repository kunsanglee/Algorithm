package practice.BOJ;

import java.util.ArrayList;

public class Boj_9963_back_tracking_NQueen {
    public void dfsFunc(Integer N, Integer currentRow, ArrayList<Integer> candidates) {
        if (candidates.size() == N) {
            System.out.println(candidates);
            return ;
        }

        for (int index = 0; index < N; index++) {
            if (isAvailable(candidates, currentRow, index)) {
                candidates.add(index);
                dfsFunc(N, currentRow + 1, candidates);
                // dfsFunc를 거치고 isAvailable 조건을 통과하지 못해 다음 dfsFunc를 호출하지 않고 넘어온다면,
                // candidates의 마지막 후보를 삭제하고 다음 column의 후보를 탐색한다.
                candidates.remove(candidates.size() - 1);
            }
        }
    }

    private boolean isAvailable(ArrayList<Integer> candidates, Integer currentRow, Integer currentCol) {
        for (int index = 0; index < candidates.size(); index++) {
            // 같은 열이면 거르고
            if (candidates.get(index) == currentCol ||
                    // 후보에서 현재 열을 뺀 절대값과, 현재 행과 현재 후보의 행의 차이가 같으면 ex)01 : 10 or 12 한칸차이 대각선 or 01 : 23 두칸차이 대각선...
                    Math.abs(candidates.get(index) - currentCol) == currentRow - index) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Boj_9963_back_tracking_NQueen nQueen = new Boj_9963_back_tracking_NQueen();
        nQueen.dfsFunc(4, 0, new ArrayList<Integer>());
    }
}
