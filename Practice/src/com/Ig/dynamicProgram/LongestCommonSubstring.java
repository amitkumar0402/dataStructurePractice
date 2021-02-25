package com.Ig.dynamicProgram;

public class LongestCommonSubstring {

   public static void main(String[] args) {
      LongestCommonSubstring lcs = new LongestCommonSubstring();
      System.out.println(lcs.findLCSLength("abdca", "cbda"));
      System.out.println(lcs.findLCSLength("passport", "ppsspt"));
      System.out.println(lcs.findLCSLengthRecursive("abdca", "cbda"));
      System.out.println(lcs.findLCSLengthRecursive("passport", "ppsspt"));

   }

   public int findLCSLengthRecursive(String s1, String s2) {
      int maxLength = Math.min(s1.length(),s2.length());
      Integer[][][] dp = new Integer[s1.length()][s2.length()][maxLength];
      return findLcsLengthRecursiveSolution(dp,s1,s2,0,0,0);
   }

   public int findLcsLengthRecursiveSolution(Integer[][][] dp, String s1, String s2, int i1, int i2, int count) {
      if(s1.length() ==i1 && s2.length()==i2){
         return count;
      }

      if(dp[i1][i2][count] == null){
         int c1=count;
         if(s1.charAt(i1) == s2.charAt(i2))
            c1= findLcsLengthRecursiveSolution(dp,s1,s2, i1+1,i2+1,count+1);
         int c2 = findLcsLengthRecursiveSolution(dp, s1,s2,i1, i2+1,count);
         int c3 = findLcsLengthRecursiveSolution(dp, s1, s2, i1+1,i2,count);
         dp[i1][i2][count] = Math.max(c1, Math.max(c2,c3));

      }
      return dp[i1][i2][count];
   }

   public int findLCSLength(String s1, String s2) {
      int[][] dp = new int[s1.length()+1][s2.length()+1];

      int maxLength =0;

      for(int i=1; i<s1.length();i++){
         for(int j=1;j<s2.length();i++){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
               dp[i][j] = 1 + dp[i-1][j-1];
               maxLength = Math.max(maxLength, dp[i][j]);
            }
         }
      }
      return maxLength;
   }

}
