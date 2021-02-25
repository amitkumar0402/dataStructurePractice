package com.Ig.string;

import java.util.ArrayList;
import java.util.List;

public class Subset {
   public static List<List<Integer>> findSubsets(int[] nums) {
      List<List<Integer>> subset = new ArrayList<>();

      subset.add(new ArrayList<>());
      for(int currentNumber :nums){
         int n = subset.size();

         for(int i=0;i<n;i++){

            List<Integer> set = new ArrayList<>(subset.get(i));
            set.add(currentNumber);
            subset.add(set);
         }
      }
    return subset;
   }

   public static void main(String[] args) {
      List<List<Integer>> result = Subset.findSubsets(new int[] { 1, 3 });
      System.out.println("Here is the list of subsets: " + result);

      result = Subset.findSubsets(new int[] { 1, 5, 3 });
      System.out.println("Here is the list of subsets: " + result);
   }
}
