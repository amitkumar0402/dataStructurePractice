package com.Ig.Arrays;

import java.util.HashSet;

public class FindSumOfTwo {

   public static int[] findSum(int[] arr, int n){
       int[] result = new int[2];
       HashSet<Integer> hashSet = new HashSet<>();
       for(int a: arr){
          if(hashSet.contains(n-a)){
             result[0] = a;
             result[1] = n-a;
             break;
          }
          hashSet.add(a);

       }
       return result;
   }

   public static void main(String args[])
   {
      int n = 9;
      int[] arr1 = {5, 7, 1, 2, 8, 4, 3};
      if(arr1.length > 0){
         int[] arr2 = findSum(arr1, n);
         int num1 = arr2[0];
         int num2 = arr2[1];

         if((num1 + num2) != n)
            System.out.println("Not Found");
         else {
            System.out.println("Number 1 = " + num1);
            System.out.println("Number 2 = " + num2);
            System.out.println("Sum = " +  (n) );

         }
      } else {
         System.out.println("Input Array is Empty!");
      }
   }
}

