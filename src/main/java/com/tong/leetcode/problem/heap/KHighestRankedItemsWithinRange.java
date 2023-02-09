package com.tong.leetcode.problem.heap;

import java.util.*;

/**
 * LeetCode 2146
 * BFS + Heap(Priority Queue)
 * @link https://leetcode.cn/problems/k-highest-ranked-items-within-a-price-range/
 */
public class KHighestRankedItemsWithinRange {

    private final static int [] direction = {0, 1, 0, -1, 0};

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        int startX = start[0], startY = start[1], low = pricing[0], high = pricing[1];
        Set<String> passedSet = new HashSet<>();

        passedSet.add(startX+","+startY);
        // PriorityQueue ranked by distance > price > row > col
        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell a, Cell b) {
                if (a.distance != b.distance) return a.distance - b.distance;
                else if (a.price != b.price) return a.price - b.price;
                else if (a.x != b.x) return a.x - b.x;
                else return a.y - b.y;
            }
        }
        );

        pq.offer(new Cell(startX, startY, grid[startX][startY], 0));
        // BFS starts
        while(!pq.isEmpty()&&answer.size()<k){
            Cell currentCell = pq.poll();
            int distance = currentCell.distance, price = currentCell.price,
                    currentRow = currentCell.x, currentColumn = currentCell.y;
            // price in range?
            if (low <= price && price <= high){
                answer.add(List.of(currentRow, currentColumn));
            }

            for (int i=0; i<4; i++){
                int neighbourX = currentRow + direction[i], neighbourY = currentColumn + direction[i+1];
                //check if in boundary, not wall, and not visited before
                if (0<=neighbourX && neighbourX<m && 0<=neighbourY && neighbourY<n && grid[neighbourX][neighbourY] > 0 && passedSet.add(neighbourX+","+neighbourY)){
                    pq.offer(new Cell(neighbourX, neighbourY, grid[neighbourX][neighbourY], distance+1));
                }
            }
        }
        return answer;
    }

    static class Cell{
        int x, y;
        int price;
        int distance;

        public Cell(int x, int y, int price, int distance){
            this.x = x;
            this.y = y;
            this.price = price;
            this.distance = distance;
        }
    }
}
