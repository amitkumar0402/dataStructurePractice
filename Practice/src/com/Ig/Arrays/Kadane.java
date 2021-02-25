package com.Ig.Arrays;

public class Kadane {

   public static int maxSubarraySum( int[] A){
      int size = A.length;
      int maxSoFar = Integer.MIN_VALUE;
      int maxEnding = 0;

      for(int i=0; i<size;i++){
         maxEnding+= A[i];
         maxSoFar = Math.max(maxSoFar, maxEnding);
         if(maxEnding<0){
            maxEnding =0;
         }
      }
      return maxSoFar;
   }
   public static void main (String[] args)
   {
      int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
      System.out.println("Maximum contiguous sum is " +
            maxSubarraySum(a));
   }
}
