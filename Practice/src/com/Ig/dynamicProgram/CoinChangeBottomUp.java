package com.Ig.dynamicProgram;

public class CoinChangeBottomUp {

   public int countChange(int[] denominations, int total) {
      int n = denominations.length;
      int[][] dp = new int[n][total +1];

      for(int i=0;i<n;i++){
         dp[i][0] =1;
      }

      for(int i=0;i<n;i++){
         for(int t =1; t<=total;t++){
            if(i>0)
               dp[i][t] = dp[i-1][t];
            if(t >= denominations[i])
               dp[i][t] += dp[i][t-denominations[i]];
         }
         }
      return dp[n-1][total];
}
   public static void main(String[] args) {
      CoinChangeBottomUp cc = new CoinChangeBottomUp();
      int[] denominations = {1, 2, 3};
      System.out.println(cc.countChange(denominations, 5));
      System.out.println(cc.countChangeRecursive(denominations, 5));
   }

   public int countChangeRecursive(int[] denominations, int total) {
      Integer[][] dp = new Integer[denominations.length][total];
      return countCoinChangeRecursive(dp, denominations, total, 0);
   }

   public int countCoinChangeRecursive(Integer[][] dp, int[] denominations, int total, int currentIndex) {
      if(total ==0)
         return 1;
      if(denominations.length ==0 || currentIndex>= denominations.length)
         return 0;

      if(dp[currentIndex][total]!=null){
         return dp[currentIndex][total];
      }

      int sum1=0;
      if(denominations[currentIndex]<=total){
         countCoinChangeRecursive(dp, denominations, total - denominations[currentIndex], currentIndex );
      }

      int sum2 = countCoinChangeRecursive(dp, denominations, total, currentIndex +1);

      dp[currentIndex][total] = sum1 + sum2;
      return dp[currentIndex][total];
   }
}

