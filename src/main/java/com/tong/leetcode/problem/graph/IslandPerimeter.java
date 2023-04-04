package com.tong.leetcode.problem.graph;

/**
 * LeetCode 463. Island Perimeter
 */
public class IslandPerimeter {

  public int islandPerimeter(int[][] grid) {
    int res = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] == 1) {
          res = dfsGrid(grid, r, c);
        }
      }
    }
    return res;
  }

  private int dfsGrid(int[][] grid, int r, int c) {
    if (!inArea(grid, r, c)) {
      return 1;
    }

    if (grid[r][c] == 0) {
      return 1;
    } else if (grid[r][c] == 2) {
      return 0;
    }

    grid[r][c] = 2;
    return dfsGrid(grid, r - 1, c) + dfsGrid(grid, r + 1, c) + dfsGrid(grid, r, c - 1)
        + dfsGrid(grid, r, c + 1);
  }

  private boolean inArea(int[][] grid, int r, int c) {
    return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
  }
}
