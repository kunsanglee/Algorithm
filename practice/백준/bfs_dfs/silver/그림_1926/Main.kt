// package practice.백준.bfs_dfs.silver.그림_1926
//
// import java.io.BufferedReader
// import java.io.BufferedWriter
// import java.util.*
//
// fun main() {
//    val solution = Solution()
//    solution.solve()
// }
//
// class Solution(
//    private val reader: BufferedReader = System.`in`.bufferedReader(),
//    private val writer: BufferedWriter = System.out.bufferedWriter(),
// ) {
//    // 상하좌우 이동을 위한 배열
//    private val dx = intArrayOf(0, 0, -1, 1)
//    private val dy = intArrayOf(-1, 1, 0, 0)
//
//    fun solve() {
//        val inputs = reader.readLine().split(" ").map { it.toInt() }
//        val n = inputs[0] // 세로 크기(행)
//        val m = inputs[1] // 가로 크기(열)
//
//        val grid = Array(n) { IntArray(m) }
//        val visited = Array(n) { BooleanArray(m) }
//
//        // 그리드 입력 받기
//        for (i in 0 until n) {
//            val line = reader.readLine().split(" ").map { it.toInt() }
//            for (j in 0 until m) {
//                grid[i][j] = line[j]
//            }
//        }
//
//        var count = 0 // 그림의 개수
//        var maxSize = 0 // 가장 큰 그림의 넓이
//
//        // 모든 칸을 확인
//        for (i in 0 until n) {
//            for (j in 0 until m) {
//                // 색칠된 부분(1)이고 아직 방문하지 않았다면 BFS 실행
//                if (grid[i][j] == 1 && !visited[i][j]) {
//                    count++ // 새로운 그림 발견
//                    val size = bfs(i, j, grid, visited, n, m)
//                    maxSize = maxOf(maxSize, size) // 최대 넓이 갱신
//                }
//            }
//        }
//
//        // 결과 출력
//        writer.write("$count\n$maxSize")
//        writer.flush()
//        writer.close()
//    }
//
//    // BFS 함수: 연결된 그림의 넓이를 반환
//    private fun bfs(
//        startX: Int,
//        startY: Int,
//        grid: Array<IntArray>,
//        visited: Array<BooleanArray>,
//        n: Int,
//        m: Int,
//    ): Int {
//        val queue: Queue<Pair<Int, Int>> = LinkedList()
//        queue.offer(Pair(startX, startY))
//        visited[startX][startY] = true
//        var size = 1 // 시작 지점을 포함해서 크기 1부터 시작
//
//        while (queue.isNotEmpty()) {
//            val (x, y) = queue.poll()
//
//            // 상하좌우 탐색
//            for (i in 0 until 4) {
//                val nx = x + dx[i]
//                val ny = y + dy[i]
//
//                // 범위 내에 있고, 색칠된 부분(1)이며, 아직 방문하지 않았다면
//                if (nx in 0 until n && ny in 0 until m && grid[nx][ny] == 1 && !visited[nx][ny]) {
//                    queue.offer(Pair(nx, ny))
//                    visited[nx][ny] = true
//                    size++ // 그림의 넓이 증가
//                }
//            }
//        }
//
//        return size
//    }
// }
