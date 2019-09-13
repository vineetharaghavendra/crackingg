package com.dynamic.programming;
//https://www.youtube.com/watch?v=CE2b_-XfVDk
//https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestIncreasingSubsequence.java

import java.util.Arrays;

/**
 * Date 05/02/2014
 * @author tusroy
 *
 * Youtube link - https://youtu.be/CE2b_-XfVDk
 *
 * Find a subsequence in given array in which the subsequence's elements are
 * in sorted order, lowest to highest, and in which the subsequence is as long as possible
 *
 * Solution :
 * Dynamic Programming is used to solve this question. DP equation is
 * if(arr[i] > arr[j]) { T[i] = max(T[i], T[j] + 1 }
 *
 * Time complexity is O(n^2).
 * Space complexity is O(n)
 *
 * Reference
 * http://en.wikipedia.org/wiki/Longest_increasing_subsequence
 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

  /**
   * DP way of solving LIS
   */
  public int longestSubsequenceWithActualSolution(int arr[]){
    int T[] = new int[arr.length];
    int actualSolution[] = new int[arr.length];
    for(int i=0; i < arr.length; i++){
      T[i] = 1;
      actualSolution[i] = i;
    }

    for(int i=1; i < arr.length; i++){
      for(int j=0; j < i; j++){
        if(arr[i] > arr[j]){
          if(T[j] + 1 > T[i]){
            T[i] = T[j] + 1;
            //set the actualSolution to point to guy before me
            actualSolution[i] = j;
          }
        }
      }
    }

    System.out.println(Arrays.toString(T));
    System.out.println(Arrays.toString(actualSolution));
    //find the index of max number in T
    int maxIndex = 0;
    for(int i=0; i < T.length; i++){
      if(T[i] > T[maxIndex]){
        maxIndex = i;
      }
    }

    //lets print the actual solution
    int t = maxIndex;
    int newT = maxIndex;
    do{
      t = newT;
      System.out.print(arr[t] + " ");
      newT = actualSolution[t];
    }while(t != newT);
    System.out.println();

    return T[maxIndex];
  }





  public static void main(String args[]){
    LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
    int arr[] = {3,4,-1,0,6,2,3};
    System.out.println(Arrays.toString(arr));
    int result = lis.longestSubsequenceWithActualSolution(arr);
    System.out.println(result);

  }
}
