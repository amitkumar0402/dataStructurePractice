package com.Ig.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDuplicates {
   public static List<List<Integer>> findSubsetsWithDuplicates(int[] nums) {
      // sort the numbers to handle duplicates
      Arrays.sort(nums);
      List<List<Integer>> subsets = new ArrayList<>();
      subsets.add(new ArrayList<>());
      int startIndex = 0, endIndex = 0;
      for (int i = 0; i < nums.length; i++) {
         startIndex = 0;
         // if current and the previous elements are same, create new subsets only from the subsets
         // added in the previous step
         if (i > 0 && nums[i] == nums[i - 1])
            startIndex = endIndex + 1;
         endIndex = subsets.size() - 1;
         for (int j = startIndex; j <= endIndex; j++) {
            // create a new subset from the existing subset and add the current element to it
            List<Integer> set = new ArrayList<>(subsets.get(j));
            set.add(nums[i]);
            subsets.add(set);
         }
      }
      return subsets;
   }

   public static List<List<Integer>> findSubsets(int[] nums) {
      List<List<Integer>> subsets = new ArrayList<>();
      // start by adding the empty subset
      subsets.add(new ArrayList<>());
      for (int currentNumber : nums) {
         // we will take all existing subsets and insert the current number in them to create new subsets
         int n = subsets.size();
         for (int i = 0; i < n; i++) {
            // create a new subset from the existing subset and insert the current element to it
            List<Integer> set = new ArrayList<>(subsets.get(i));
            set.add(currentNumber);
            subsets.add(set);
         }
      }
      return subsets;
   }


   public static void main(String[] args) {
      List<List<Integer>> result = SubsetsWithDuplicates.findSubsetsWithDuplicates(new int[] { 1, 3, 3 });
      System.out.println("Here is the list of subsets: " + result);

      result = SubsetsWithDuplicates.findSubsetsWithDuplicates(new int[] { 1, 5, 3, 3 });
      System.out.println("Here is the list of subsets: " + result);

      List<List<Integer>> result1 = SubsetsWithDuplicates.findSubsets(new int[] { 1, 3 });
      System.out.println("Here is the list of subsets: " + result1);

      result1 = SubsetsWithDuplicates.findSubsets(new int[] { 1, 5, 3 });
      System.out.println("Here is the list of subsets: " + result1);
   }
}


