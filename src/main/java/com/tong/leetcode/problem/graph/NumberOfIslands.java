package com.tong.leetcode.problem.graph;

/**
 * LeetCode 200. Number Of Islands DFS problem for multiple grid based islands problem. similar ones
 * are: LeetCode 827. Making A Large Island, 463. Island Perimeter, 695. Max Area of Island, 827.
 * Making A Large Island
 */
public class NumberOfIslands {

  public int numIslands(char[][] grid) {
    int res = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] == '1') {
          dfsGrid(grid, r, c);
          res++;
        }
      }
    }
    return res;
  }

  private void dfsGrid(char[][] grid, int row, int column) {
    if (!inArea(grid, row, column)) {
      return;
    }
    if (grid[row][column] != '1') {
      return;
    }

    // mark the traversed node
    grid[row][column] = '2';

    // traverse up, down, left, right
    dfsGrid(grid, row - 1, column);
    dfsGrid(grid, row + 1, column);
    dfsGrid(grid, row, column - 1);
    dfsGrid(grid, row, column + 1);
  }

  private boolean inArea(char[][] grid, int r, int c) {
    return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
  }

}
