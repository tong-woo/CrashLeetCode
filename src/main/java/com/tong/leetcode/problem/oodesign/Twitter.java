package com.tong.leetcode.problem.oodesign;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * LeetCode 355
 * <a href="https://leetcode.cn/problems/design-twitter/">...</a>
 */
public class Twitter {

  private static int timestamp = 0;
  private final Map<Integer, User> localUserRepository;

  public Twitter() {
    this.localUserRepository = new HashMap<>();
  }

  public void postTweet(int userId, int tweetId) {
    if (!localUserRepository.containsKey(userId)) {
      User newUser = new User(userId);
      localUserRepository.put(userId, newUser);
    }
    localUserRepository.get(userId).postTweet(tweetId);
  }

  /**
   * Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must
   * be posted by users who the user followed or by the user themself. Tweets must be ordered from
   * most recent to least recent.
   */
  public List<Integer> getNewsFeed(int userId) {
    List<Integer> newsList = new LinkedList<>();
    if (!localUserRepository.containsKey(userId)) {
      return newsList;
    }
    Set<Integer> followedUsers = localUserRepository.get(userId).getFollowedSet();
    // max heap
    PriorityQueue<Tweet> pq = new PriorityQueue<>(new Comparator<Tweet>() {
      @Override
      public int compare(Tweet t1, Tweet t2) {
        return t2.getTweetTime() - t1.getTweetTime();
      }
    });
    for (int user : followedUsers) {
      Tweet headTweet = localUserRepository.get(user).getHeadTweet();
      if (headTweet != null) {
        pq.offer(headTweet);
      }
    }
    int count = 0;
    while (!pq.isEmpty() && count < 10) {
      Tweet head = pq.poll();
      newsList.add(head.getId());
      count++;
      // update the pq to include new tweet
      if (head.getNext() != null) {
        pq.offer(head.getNext());
      }
    }
    return newsList;
  }

  /**
   * Follower follows a followee.
   */
  public void follow(int followerId, int followeeId) {
    if (!localUserRepository.containsKey(followerId)) {
      User newUser = new User(followerId);
      localUserRepository.put(followerId, newUser);
    }

    if (!localUserRepository.containsKey(followeeId)) {
      User newUser = new User(followeeId);
      localUserRepository.put(followeeId, newUser);
    }
    localUserRepository.get(followerId).followUser(followeeId);
  }

  public void unfollow(int followerId, int followeeId) {
    if (!localUserRepository.containsKey(followerId) || followerId == followeeId) {
      return;
    }
    localUserRepository.get(followerId).unfollowUser(followeeId);
  }

  /**
   * Linked list to store Tweet
   */
  private static class Tweet {

    private int id;
    private int tweetTime;
    private Tweet next;

    public Tweet(int id) {
      this.id = id;
      this.tweetTime = timestamp++;
      this.next = null;
    }

    private int getId() {
      return this.id;
    }

    private void setId(int id) {
      this.id = id;
    }

    private int getTweetTime() {
      return this.tweetTime;
    }

    private void setTweetTime(int timestamp) {
      this.tweetTime = timestamp;
    }

    private Tweet getNext() {
      return this.next;
    }

    private void setNext(Tweet tweet) {
      this.next = tweet;
    }
  }

  /**
   * User Class to decouple the user follow/unfollow, and post function
   */
  public class User {

    private int id;
    private Set<Integer> followedSet;
    private Tweet headTweet;

    public User(int id) {
      this.id = id;
      this.followedSet = new HashSet<>();
      // user will need to follow itself
      followUser(id);
      this.headTweet = null;
    }

    private int getId() {
      return this.id;
    }

    private void setId(int id) {
      this.id = id;
    }

    private Set<Integer> getFollowedSet() {
      return this.followedSet;
    }

    private void setFollowedSet(Set<Integer> followedSet) {
      this.followedSet = followedSet;
    }

    private Tweet getHeadTweet() {
      return this.headTweet;
    }

    private void setHeadTweet(Tweet tweet) {
      this.headTweet = tweet;
    }

    public void followUser(int id) {
      followedSet.add(id);
    }

    public void unfollowUser(int id) {
      followedSet.remove(id);
    }

    // add new Tweet to the head of the linked list
    public void postTweet(int id) {
      Tweet newTweet = new Tweet(id);
      newTweet.next = headTweet;
      headTweet = newTweet;
    }
  }
}
