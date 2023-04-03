package com.tong.leetcode.problem.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 981. Time Based Key-Value Store
 * HashMap embed problem
 */
public class TimeMap {

  private final Map<String, List<StorageNode>> keyValueRepository;

  public TimeMap() {
    this.keyValueRepository = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    StorageNode node = new StorageNode(timestamp, value);
    List<StorageNode> nodeList = keyValueRepository.getOrDefault(key, new ArrayList<>());
    nodeList.add(node);
    keyValueRepository.put(key, nodeList);
  }

  public String get(String key, int timestamp) {
    if (!keyValueRepository.containsKey(key)) {
      return "";
    }
    List<StorageNode> nodeList = keyValueRepository.get(key);
    // Binary search begins
    int left = 0, right = nodeList.size() - 1;
    while (left < right) {
      int mid = left + right + 1 >> 1;
      if (nodeList.get(mid).timestamp <= timestamp) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return nodeList.get(right).timestamp <= timestamp ? nodeList.get(right).value : "";
  }

  static class StorageNode {

    private final int timestamp;
    private final String value;

    public StorageNode(int timestamp, String value) {
      this.timestamp = timestamp;
      this.value = value;
    }
  }
}
