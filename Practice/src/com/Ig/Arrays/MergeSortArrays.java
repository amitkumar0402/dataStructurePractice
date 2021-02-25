package com.Ig.Arrays;

import java.util.Arrays;

public class MergeSortArrays {

   public static void mergeSort(int arr[], int result[], int start, int end){
      if(start ==end){
         return;
      }
      int mid = start + (end -start)/2;

      mergeSort(arr, result, start, mid);

      mergeSort(arr, result, mid+1, end);

      merge(arr, result,start, mid, end);

   }

   public static void merge(int arr[], int result[], int low, int mid, int high){

      int i= low,k=low,j=mid+1;
      while(i<=mid && j<= high){
         if(arr[i]<=arr[j]){
            result[k++] = arr[i++];
         }
         else{
            result[k++] = arr[j++];
         }

      }
      while(i<= mid){
         result[k++] = arr[i++];
      }
      while(j<= high){
         result[k++] = arr[j++];
      }
      for(i= low;i<= high;i++){
         arr[i] = result[i];
      }

   }
   // Function to check if arr is sorted in ascending order or not
   public static boolean isSorted(int[] arr)
   {
      int prev = arr[0];
      for (int i = 1; i < arr.length; i++) {
         if (prev > arr[i]) {
            System.out.println("MergeSort Fails!!");
            return false;
         }
         prev = arr[i];
      }

      return true;
   }


   public static void main(String[] args)
   {
      int[] arr = {8,4,3,12,25,6,13,10};
      int[] aux = Arrays.copyOf(arr, arr.length);

      // sort array 'arr' using auxiliary array 'aux'
      mergeSort(arr, aux, 0, arr.length - 1);

      if (isSorted(arr)) {
         System.out.println(Arrays.toString(arr));
      }
   }
}

