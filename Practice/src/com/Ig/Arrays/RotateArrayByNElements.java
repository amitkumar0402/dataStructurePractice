package com.Ig.Arrays;

import java.util.Arrays;
import java.util.List;

public class RotateArrayByNElements {

   static void rotateArray(List<Integer> arr, int n) {
      int len = arr.size();
      n=n%len;
      if(n<0){
         n = n+len;
      }
      List<Integer> temp = Arrays.asList(new Integer[n]);
      //Copy the temporary array
      for(int i =0; i<n; i++){
         temp.set(i, arr.get(len-n+i));
      }

      //Shift the array
      for(int i=len-1; i>=n;i--){
         arr.set(i, arr.get(i-n));
      }
      //copy tem array into original array
      for(int i=0; i<n;i++){
         arr.set(i, temp.get(i));
      }
   }

   public static void main(String []args){
      List<Integer> arr = Arrays.asList(1, 10, 20, 0, 59, 86, 32, 11, 9, 40);
      System.out.println("Array Before Rotation\n" + arr);
      rotateArray(arr, 2);
      System.out.println("Array After Rotation\n" + arr);
   }
}

