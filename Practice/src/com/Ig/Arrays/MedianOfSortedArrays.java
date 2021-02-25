package com.Ig.Arrays;

import java.util.Arrays;

public class MedianOfSortedArrays {
   public static void main(String args[]) {
      int array1[] = {
            5,
            8,
            10,
            11,
            20
      };
      int array2[] = {
            900
      };

      System.out.println("The median of " + Arrays.toString(array1) + " and " + Arrays.toString(array2) + " is " + getMedian(array1, array2));

      // Example 2
      int array3[] = {
            1,
            2,
            3,
            4,
            5
      };
      int array4[] = {
            100,
            200,
            300,
            400
      };

      System.out.println("The median of " + Arrays.toString(array3) + " and " + Arrays.toString(array4) + " is " + getMedian(array3, array4));
   }

   public static double getMedian(int[] array1, int[] array2) {
      int arraySize1= array1.length;
      int arraySize2= array2.length;
      int arraySize= arraySize1 + arraySize2;
      int arrayMid = arraySize/2;
      int median =-1;
      int previousMedian =-1;
      int i=0;
      int j=0;
      int count;

      if(arraySize %2 ==1){
         for(count =0;count<=arrayMid;count ++){
            if(i!= arraySize1 && j!=arraySize2){
               if(array1[i]> array2[j]){
                  median = array2[j];
                  j++;
               }
               else{
                  median = array1[i];
                  i++;
               }
            }
            else if(i<arraySize1){
               median = array1[i];
               i++;
            }
            else if(j<arraySize2){
               median = array2[i];
            }

         }
         return median;
      }
      else{
         for(count =0;count<=arrayMid;count ++){
            previousMedian =median;
            if(i!= arraySize1 && j!=arraySize2){
               if(array1[i]> array2[j]){
                  median = array2[j];
                  j++;
               }
               else{
                  median = array1[i];
                  i++;
               }
            }
            else if(i<arraySize1){
               median = array1[i];
               i++;
            }
            else if(j<arraySize2){
               median = array2[i];
            }

         }
         return (median + previousMedian)/2.0;

      }
   }
}

