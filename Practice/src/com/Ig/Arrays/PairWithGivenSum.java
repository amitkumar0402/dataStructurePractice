package com.Ig.Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class PairWithGivenSum {
   //Function to find a pair in an array with a given sum using sorting
   public static void findPair(int[] A, int sum)
   {
      // sort the array in ascending order
      Arrays.sort(A);

      // maintain two indices pointing to end-points of the array
      int low = 0;
      int high = A.length - 1;

      // reduce the search space `A[low…high]` at each iteration of the loop

      // loop till search space is exhausted
      while (low < high)
      {
         // sum found
         if (A[low] + A[high] == sum)
         {
            System.out.println("Pair found");
            return;
         }

         // increment `low` index if the total is less than the desired sum;
         // decrement `high` index if the total is more than the desired sum
         if (A[low] + A[high] < sum) {
            low++;
         } else{
            high--;
         }
      }

      // No pair with the given sum exists in the array
      System.out.println("Pair not found");
   }

   public static void printpairs(int arr[], int sum)
   {
      HashSet<Integer> s = new HashSet<Integer>();
      for (int i = 0; i < arr.length; ++i)
      {
         int temp = sum - arr[i];

         // checking for condition
         if (s.contains(temp)) {
            System.out.println(
                  "Pair with given sum "
                        + sum + " is (" + arr[i]
                        + ", " + temp + ")");
         }
         s.add(arr[i]);
      }
   }


   public static void main (String[] args)
   {
      int[] A = { 8, 7, 2, 5, 3, 1 };
      int sum = 10;

      findPair(A, sum);
      printpairs(A,sum);

   }
}

