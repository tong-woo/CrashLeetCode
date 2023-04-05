package com.tong.leetcode.problem.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 133. Clone Graph
 * DFS & BFS both can solve
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */
public class CloneGraph {

  public Node cloneGraph(Node node) {
    Map<Node, Node> traversedMap = new HashMap<>();
    return dfsGraph(node, traversedMap);
  }

  private Node dfsGraph(Node node, Map<Node, Node> traversedMap) {
    if (node == null) {
      return null;
    }
    if (traversedMap.containsKey(node)) {
      return traversedMap.get(node);
    }
    // clone
    Node cloneNode = new Node(node.val, new ArrayList<>());
    // to avoid deadlock, need a map to record visited node
    traversedMap.put(node, cloneNode);
    // traverse the neighbours of current node and update clone's neighbour list
    for (Node neighbour : node.neighbors) {
      cloneNode.neighbors.add(dfsGraph(neighbour, traversedMap));
    }
    return cloneNode;
  }

  private Node bfsGraph(Node node, Map<Node, Node> traversedMap) {
    if (node == null) {
      return null;
    }
    if (traversedMap.containsKey(node)) {
      return traversedMap.get(node);
    }
    // use a queue to store the given node
    ArrayDeque<Node> queue = new ArrayDeque<>();
    queue.offer(node);
    // clone and store into the visited map
    Node cloneNode = new Node(node.val, new ArrayList<>());
    traversedMap.put(node, cloneNode);
    // bfs begins
    while (!queue.isEmpty()) {
      Node currentNode = queue.poll();
      for (Node neighbour : currentNode.neighbors) {
//        if (!traversedMap.containsKey(neighbour)){
//          traversedMap.put(neighbour, new Node(neighbour.val, new ArrayList<>()));
//          queue.offer(neighbour);
//        }
//        cloneNode.neighbors.add(traversedMap.get(neighbour);
        cloneNode.neighbors.add(bfsGraph(neighbour, traversedMap));
      }
    }
    return cloneNode;
  }

  // Definition for a Node.
  static class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}
