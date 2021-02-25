package com.Ig.Arrays;

public class MaximumProductSubArray {

   public static int maxProduct(int[] arr, int n){
      int maxVal= arr[0];
      int minVal = arr[0];
      int maxProduct = arr[0];

      for(int i=0;i<n;i++){

         if(arr[i]<0){
            int temp = minVal;
            minVal = maxVal;
            maxVal = temp;
         }

         maxVal = Math.max(maxVal* arr[i], arr[i]);
         minVal = Math.min(minVal*arr[i], arr[i]);

         maxProduct = Math.max(maxVal,maxProduct);
      }
      return maxProduct;
   }

   public static void main (String[] args)
   {
      int arr[] = { -1, -3, -10, 0, 60 };
      int n = arr.length;

      System.out.println( "Maximum Subarray product is "
            + maxProduct(arr, n));
   }
}


