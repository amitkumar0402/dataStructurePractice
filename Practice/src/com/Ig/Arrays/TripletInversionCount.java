package com.Ig.Arrays;

public class TripletInversionCount {

   // Function to find inversion count of the given array
   public static int getInversionCount(int[] arr) {
      int n = arr.length;
      int inversionCount =0;
      for(int j=1;j<n-1;j++){
         int greater =0;
         for(int i=0;i<j;i++){
            if(arr[i]> arr[j]){
              greater++;
            }
         }
         int smaller =0;
         for(int k=j+1;k<n;k++){
            if(arr[k]<arr[j]){
               smaller++;
            }
         }
         inversionCount+=(greater* smaller);
      }
      return inversionCount;

   }

   public static void main(String[] args) {
      int[] arr = { 9, 4, 3, 5, 1 };

      System.out.println("The inversion count is " + getInversionCount(arr));
   }
}
