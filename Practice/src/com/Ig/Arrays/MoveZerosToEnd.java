package com.Ig.Arrays;

import java.util.Arrays;

public class MoveZerosToEnd {

   public static void moveZerosToEnd(int A[]){
      if(A.length<1)
         return;

      int readIndex = 0;
      int writeIndex = 0;

      while(readIndex<A.length){
         if(A[readIndex] != 0){
            A[writeIndex] = A[readIndex];
            writeIndex++;
         }
         readIndex++;
      }

      while(writeIndex<A.length){
         A[writeIndex] = 0;
         writeIndex++;
      }
   }
   public static void main(String[] args) {
      int[] v = new int[]{1, 10, 20, 0, 59, 63, 0, 88, 0};
      System.out.println("Original Array: " + Arrays.toString(v));

      moveZerosToEnd(v);

      System.out.println("After Moving Zeroes to Left: " + Arrays.toString(v));
   }
}
