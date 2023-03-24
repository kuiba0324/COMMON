/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solutiona {
    int count = 0;

    public static void main(String[] args) {
        char[][] grid = { { '1', '1', '1', '1', 0 }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        Solutiona solution = new Solutiona();
        int ts = solution.numIslands(grid);
        System.out.println(ts);
    }

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == '1') {
                    count = count + 1;
                    printIsland(grid, i, j);
                }

            }
        }
        return count;

    }

    public void printIsland(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == '1') {
            grid[i][j] = '2';
            printIsland(grid, i + 1, j);
            printIsland(grid, i, j + 1);
            printIsland(grid, i - 1, j);
            printIsland(grid, i, j - 1);

        } else {

        }
    }
}
// @lc code=end
