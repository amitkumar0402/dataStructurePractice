package com.Ig.Arrays;

public class MergeSortedArrays {

   public static int[] mergeArrays(int[] arr1, int[] arr2) {
      int s1 = arr1.length;
      int s2 = arr2.length;
      int mergedArrayLength = s1 + s2;
      int result[] = new int[mergedArrayLength];
      int i=0,j=0,k=0;

      while(i<s1 && j<s2){
         if(arr1[i]< arr2[j])
            result[k++] = arr1[i++];
         else
            result[k++] = arr2[j++];

      }

      while(i<s1){
         result[k++] = arr1[i++];
      }
      while(j<s2){
         result[k++] = arr2[j++];
      }
      return result;
   }

   public static void main(String args[]) {

      int[] arr1 = {1,12,14,17,23}; // creating a sorted array called arr1
      int[] arr2 = {11,19,27};  // creating a sorted array called arr2

      int[] resultantArray = mergeArrays(arr1, arr2); // calling mergeArrays

      System.out.print("Arrays after merging: ");
      for(int i = 0; i < arr1.length + arr2.length; i++) {
         System.out.print(resultantArray[i] + " ");
      }
   }
   }
