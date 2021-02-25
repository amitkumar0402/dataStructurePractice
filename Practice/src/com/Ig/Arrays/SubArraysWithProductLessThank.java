package com.Ig.Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubArraysWithProductLessThank {
   public static List<List<Integer>> findSubarrays(int[] arr, int target) {
      List<List<Integer>> subarrays = new ArrayList<>();

      int left =0,product = 1;

      for(int right =0;right<arr.length;right++){
         product*=arr[right];
         while(product>=target && left<arr.length)
            product/= arr[left++];
         List<Integer> tempList = new LinkedList<>();
         for(int i=right;i>=left;i-- ){
            tempList.add(0,arr[i]);
            subarrays.add(new ArrayList<>(tempList));
         }
      }

      return subarrays;
   }
   public static void main(String[] args) {
      System.out.println(SubArraysWithProductLessThank.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
      System.out.println(SubArraysWithProductLessThank.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
   }
}

