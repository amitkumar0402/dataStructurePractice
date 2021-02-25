package com.Ig.Arrays;

public class SegregateEvenAndOddNumber {

   public static void areArraysEvenAndOdd(int[] arr, int n){
      int i=-1,j=0;
      while(j!=n){
         if(arr[j]%2 ==0){
            i++;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
         }
         j++;
      }

      for(int i1=0;i1<n;i1++){
         System.out.println(arr[i1] +" ");
      }
   }

   public static void reArrangeEvenAndOdd(int[] arr){
      int j=0;
      for(int i=0;i<arr.length;i++){
         if(arr[i%2]==0){
            if(i!=j){
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
            }
            j++;
         }
      }

      for(int i1=0;i1<arr.length;i1++){
         System.out.println(arr[i1] +" ");
      }
   }


   public static void main(String args[])
   {
      int arr[] = { 1, 3, 2, 4, 7,
            6, 9, 10 };
      int n = arr.length;
      areArraysEvenAndOdd(arr, n);
     // reArrangeEvenAndOdd(arr);
   }
}


