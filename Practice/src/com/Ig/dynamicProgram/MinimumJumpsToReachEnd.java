package com.Ig.dynamicProgram;

public class MinimumJumpsToReachEnd {
   public int countMinJumps(int[] jumps) {
      return this.countMinJumpsRecursive(jumps, 0);
   }

   public int countMinJumpsTopMemoization(int[] jumps){
      int[] dp = new int[jumps.length];
      return this.countMinJumpsTopMemoizationRecursive(dp,jumps,0);
   }

   private int countMinJumpsTopMemoizationRecursive(int[] dp, int[] jumps, int currentIndex) {
      if(currentIndex == jumps.length-1){
         return 0;
      }
      if(jumps[currentIndex]==0){
         return Integer.MAX_VALUE;
      }

      if(dp[currentIndex]!=0) {
         return dp[currentIndex];
      }

      int totalJumps = Integer.MAX_VALUE;
      int start = currentIndex +1;
      int end = currentIndex + jumps[currentIndex];
      while(start<jumps.length && start<=end){
         int minJumps = countMinJumpsTopMemoizationRecursive(dp,jumps,start++);
         if(minJumps!= Integer.MAX_VALUE){
            totalJumps = Math.min(totalJumps,minJumps+1);
         }
      }
      dp[currentIndex]= totalJumps;
      return dp[currentIndex];
   }


   private int countMinJumpsRecursive(int[] jumps, int currentIndex) {
      if(currentIndex == jumps.length-1){
         return 0;
      }
      if(jumps[currentIndex]==0){
         return Integer.MAX_VALUE;
      }

      int totalJumps = Integer.MAX_VALUE;
      int start = currentIndex +1;
      int end = currentIndex + jumps[currentIndex];
      while(start<jumps.length && start<=end){
         int minJumps = countMinJumpsRecursive(jumps,start++);
         if(minJumps!= Integer.MAX_VALUE){
            totalJumps = Math.min(totalJumps,minJumps+1);
         }
      }
      return totalJumps;
   }
   public static void main(String[] args) {
      MinimumJumpsToReachEnd aj = new MinimumJumpsToReachEnd();
      int[] jumps = {2, 1, 1, 1, 4};
      System.out.println(aj.countMinJumps(jumps));
  //    System.out.println(aj.countMinJumpsTopMemoization(jumps));
      jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
      System.out.println(aj.countMinJumps(jumps));
   }
}

