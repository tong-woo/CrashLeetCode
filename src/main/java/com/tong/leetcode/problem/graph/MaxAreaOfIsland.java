package com.tong.leetcode.problem.graph;

/**
 * LeetCode 695. Max Area of Island
 */
public class MaxAreaOfIsland {

  public int maxAreaOfIsland(int[][] grid) {
    int res = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] == 1) {
          res = Math.max(dfsGrid(grid, r, c), res);
        }
      }
    }
    return res;
  }

  public int dfsGrid(int[][] grid, int r, int c) {
    if (!inArea(grid, r, c)) {
      return 0;
    }
    if (grid[r][c] != 1) {
      return 0;
    }

    grid[r][c] = 2;
    return 1 + dfsGrid(grid, r - 1, c) + dfsGrid(grid, r + 1, c) + dfsGrid(grid, r, c - 1)
        + dfsGrid(grid, r, c + 1);
  }

  private boolean inArea(int[][] grid, int r, int c) {
    return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
  }
}
