package com.Ig.dynamicProgram;

public class LongestRepeatingSubsequence {
   public int findLRSLength(String str) {
      Integer dp[][] = new Integer[str.length()][str.length()];
      return findLRSRecursiveLength(dp, str, 0, 0);
   }

   private int findLRSRecursiveLength(Integer[][] dp, String str, int i1, int i2) {
      if (i1 == str.length() || i2 == str.length())
         return 0;

      if (dp[i1][i2] == null) {
         if (i1 != i2 && str.charAt(i1) == str.charAt(i2))
            dp[i1][i2] = 1 + findLRSRecursiveLength(dp, str, i1 + 1, i2 + 1);
         else {
            int c1 = findLRSRecursiveLength(dp, str, i1, i2 + 1);
            int c2 = findLRSRecursiveLength(dp, str, i1 + 1, i2);
            dp[i1][i2] = Math.max(c1, c2);
         }
      }
      return dp[i1][i2];
   }

   public static int findlRSLengthBottom(String str){

      int[][] dp = new int[str.length()+1][str.length()+1];
      int maxlength =0;

      for(int i1= 1;i1<=str.length();i1++){
         for(int i2=1;i2<=str.length();i2++){
            if(i1!=i2 && str.charAt(i1-1)== str.charAt(i2-1)){
               dp[i1][i2]= 1+ dp[i1-1][i2-1];
            }
            else{
               dp[i1][i2]= Math.max(dp[i1-1][i2],dp[i1][i2-1]);
            }
            maxlength = Math.max(maxlength,dp[i1][i2]);
         }
      }
      return maxlength;
   }

   public static void main(String[] args) {
      LongestRepeatingSubsequence lrs = new LongestRepeatingSubsequence();
      System.out.println(lrs.findLRSLength("tomorrow"));
      System.out.println(lrs.findLRSLength("aabdbcec"));
      System.out.println(lrs.findLRSLength("fmff"));
      System.out.println(lrs.findlRSLengthBottom("tomorrow"));
      System.out.println(lrs.findlRSLengthBottom("aabdbcec"));
      System.out.println(lrs.findlRSLengthBottom("fmff"));
   }
}
