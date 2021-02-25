package com.Ig.dynamicProgram;

public class LongestIncreasingSubsequence {

   public int findLISLength(int[] nums) {
      return findlisRecursivelength(nums, 0,-1);
   }

   private int findlisRecursivelength(int[] nums, int currentIndex, int previousIndex) {
      if(currentIndex == nums.length)
         return 0;
      int c1=0,c2;

      if(previousIndex ==-1 || nums[currentIndex]>nums[previousIndex])
          c1= 1 + findlisRecursivelength(nums, currentIndex+1, currentIndex);

       c2 = findlisRecursivelength(nums, currentIndex+1, previousIndex);

      return Math.max(c1,c2);
   }
   public static void main(String[] args) {
      LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
      int[] nums = {4,2,3,6,10,1,12};
      System.out.println(lis.findLISLength(nums));
      System.out.println(lis.findLisMemoizLength(nums));
      System.out.println(lis.findLongestIncreasingBottomlevel(nums));
      nums = new int[]{-4,10,3,7,15};
      System.out.println(lis.findLISLength(nums));
      System.out.println(lis.findLisMemoizLength(nums));
      System.out.println(lis.findLongestIncreasingBottomlevel(nums));
   }

   public int findLongestIncreasingBottomlevel(int[] nums){
      int[] dp = new int[nums.length];
      dp[0] =1;
      int maxLength =1;

      for(int i=1;i<nums.length;i++){
         dp[i] =1;
         for(int j=0;j<i;j++){
            if(nums[i] > nums[j] && dp[i]<=dp[j]){
               dp[i]=1+ dp[j];
               maxLength = Math.max(maxLength,dp[i]);
            }
         }
      }
return maxLength;

   }

   public int findLisMemoizLength(int[] nums){
      Integer dp[][] = new Integer[nums.length][nums.length+1];
      return findLisMemoizRecursiveLength(dp, nums,0,-1);
   }

   private int findLisMemoizRecursiveLength(Integer[][] dp, int[] nums, int currentIndex, int previousIndex) {
    if(currentIndex == nums.length)
       return 0;

      int c1=0;
      if(dp[currentIndex][previousIndex +1] == null){
         if(previousIndex ==-1 || nums[currentIndex]>nums[previousIndex])
           c1= 1 + findLisMemoizRecursiveLength(dp,nums, currentIndex+1, currentIndex);

        int c2 = findLisMemoizRecursiveLength(dp,nums, currentIndex+1, previousIndex);
        dp[currentIndex][previousIndex+1] = Math.max(c1,c2);


      }
      return dp[currentIndex][previousIndex+1];
   }
}
