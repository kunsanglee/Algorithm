package practice.프로그래머스.bfs_dfs.lv3.퍼즐조각채우기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1) DFS or BFS 를 이용하여 좌표탐색을 한다 - 조각 모음을 좌표로 저장한다
 * 2) 받은 좌표들을 사각형 형태로 가공한다.
 * 3) 사각형 형태의 가공물들을 90도 회전하는 함수를 만든다.
 * 4) 비교 및 검사
 */
class Solution {
    static boolean[][] holeVisited;
    static boolean[][] partVisited;
    static ArrayList<ArrayList<int[]>> holes = new ArrayList<>();
    static ArrayList<ArrayList<int[]>> parts = new ArrayList<>();
    static ArrayList<int[][]> fixedHoles = new ArrayList<>();
    static ArrayList<int[][]> fixedParts = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int row, col, total;
    public int solution(int[][] game_board, int[][] table) {
        total = 0;
        row = table.length;
        col = table[0].length;
        partVisited = new boolean[row][col];
        holeVisited = new boolean[row][col];

        make(game_board, holeVisited, holes, 0);
        make(table, partVisited, parts, 1);

        makeFixed(holes, fixedHoles);
        makeFixed(parts, fixedParts);

        boolean[] visited = new boolean[fixedHoles.size()]; // 일치한 빈 칸은 중복하여 비교하지 않도록 방문처리.
        for (int i = 0; i < fixedHoles.size(); i++) {
            int[][] hole = fixedHoles.get(i);
            for (int j = 0; j < fixedParts.size() && !visited[i]; j++) {
                int[][] part = fixedParts.get(j);
                for (int k = 0; k < 4; k++) { // 해당 빈 칸과 조각을 90도 4 번 회전하면서 비교.
                    if (Arrays.deepEquals(hole, part)) { // hole 과 part 배열이 일치하면 total 증가.
                        total += countCells(part);
                        fixedParts.remove(j);
                        visited[i] = true;
                        break;
                    }
                    part = rotate(part); // 일치하지 않으면 part 회전하여 다시 비교.
                }
            }
        }
        return total;
    }

    // 매치가 된 경우 매치된 조각의 크기만큼 total 증가.
    private int countCells(int[][] piece) {
        int count = 0;
        for (int[] row : piece) {
            for (int cell : row) {
                if (cell == 1) count++;
            }
        }
        return count;
    }

    // 사각형 배열로 만든 조각들을 90도 회전시켜서 반환.
    private int[][] rotate(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[][] rotatedMatrix = new int[colLength][rowLength]; // 배열이 정사각형이 아닐 수 있으므로 행과 열의 크기를 바꿔준다.

        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                rotatedMatrix[j][rowLength-1-i] = matrix[i][j]; // 90도 회전.
            }
        }

        return rotatedMatrix;
    }

    // table 에서 얻어낸 조각들을 해당 조각의 가장 긴 행과 열의 크기만큼 배열로 만들고 넣어서 반환.
    private static void makeFixed(ArrayList<ArrayList<int[]>> parts, ArrayList<int[][]> result) {
        for (int i = 0; i < parts.size(); i++) {
            ArrayList<int[]> part = parts.get(i);
            // 조각 묶음의 x, y 의 최대값에서 최소값을 빼고 1을 더한 크기만큼 배열을 생성하고,
            // x, y 좌표를 0,0 을 기준으로 최소값만큼 뺀 좌표에 배열을 저장.
            // 기존에는 정렬을 통해서 최소값과 최대값을 찾아내려 했지만, 그렇게 정렬하면 최소값과 최대값의 오차가 발생.
            // 그래서 직접 묶음의 x, y 좌표의 최소값과 최대값을 구해야한다.
            int minX = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxY = Integer.MIN_VALUE;

            for(int[] point : part){
                minX = Math.min(minX , point[1]);
                maxX = Math.max(maxX , point[1]);
                minY = Math.min(minY , point[0]);
                maxY = Math.max(maxY , point[0]);
            }

            int ySize = maxY - minY + 1; // 만약 0,0, 0,1 0,2 라면 2 - 0 = 2가 되므로 1을 더해서 3칸을 생성.
            int xSize = maxX - minX + 1;

            int[][] fixedPart = new int[ySize][xSize]; // 가장 긴 행과 열 기준으로 사각배열 생성.
            for (int j = 0; j < part.size(); j++) { // 행과 열을 0,0 기준으로 생성된 사각배열에 넣는다.
                int[] ints = part.get(j);
                int y = ints[0] - minY; // 0,0을 기준으로 하기 위해 최소값만큼 빼준다.
                int x = ints[1] - minX;
                fixedPart[y][x] = 1;
            }
            result.add(fixedPart);
        }
    }

    // game_board -> 0, table -> 1 로 구분하여 빈 칸과 그에 맞는 조각들을 bfs 로 얻어내서 list 로 묶어서 저장.
    private void make(int[][] board, boolean[][] visited, ArrayList<ArrayList<int[]>> list, int target) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && board[i][j] == target) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true; // 방문처리를 유지해야 중복으로 체크하지 않는다.
                    ArrayList<int[]> part = new ArrayList<>();
                    part.add(new int[]{i, j}); // bfs 초기값을 넣어준다.
                    bfs(board, visited, queue, part, target);
                    list.add(part); // bfs 탐색으로 찾아낸 조각 또는 빈칸 묶음을 list 에 저장한다.
                }
            }
        }
    }

    // game_board 와 table 을 bfs 로 순회하면서 이어진 빈칸 또는 조각들의 x, y 좌표를 part 에 넣는다.
    private void bfs(int[][] board, boolean[][] visited, Queue<int[]> queue, ArrayList<int[]> part, int target) {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[1];
            int y = curr[0];
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && 0 <= ny && nx < col && ny < row) {
                    if (!visited[ny][nx] && board[ny][nx] == target) {
                        visited[ny][nx] = true;
                        part.add(new int[]{ny, nx});
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
