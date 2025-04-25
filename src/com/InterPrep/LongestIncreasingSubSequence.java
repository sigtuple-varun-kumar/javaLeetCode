package com.InterPrep;

/*
Given an integer array nums, return the length of the longest strictly increasing

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1

*/


import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int result = 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] >= nums[i]) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
                result = Math.max(dp[i], result);
            }
        }
        return result;
    }
    private int recurse(int[] nums, int currIdx, int[] cache) {
        int n = nums.length;
        if(currIdx >= n) {
            return -1;
        }
        if(cache[currIdx] != -1) {
            return cache[currIdx];
        }
        int longest = 0;
        for(int i = currIdx; i < n; i++) {
           if(nums[i] > nums[currIdx]) {
               longest = Math.max(longest, recurse(nums, i, cache));
           }
        }
        cache[currIdx] = longest + 1;
        return cache[currIdx];
    }
}
