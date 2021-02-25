package com.Ig.Arrays;

import java.util.Arrays;

public class MinimumNumberOfPlatforms {

   public static  int minimumNumberOfPlatform(int array[], int departure[], int n)
   {
      //Sort arrival and departure arrays
      Arrays.sort(array);
      Arrays.sort(departure);
      //plat_needed indicates number of platforms needed at a time
      int plat_needed = 1, maxPlatform = 1;
      int i = 1, j = 0;

      while (i < n && j < n) {
         //If next event in sorted order is arrival, increment count of platforms needed
         if (array[i] <= departure[j])
         {
            plat_needed++;
            i++;
            if (plat_needed > maxPlatform)
               maxPlatform = plat_needed;
         } //Else decrement count of platforms needed
         else if (array[i] > departure[j]) {
            plat_needed--;
            j++;
         }

      }

      return maxPlatform;
   }
   public static void main(String[] args)
   {
      int[] arrival = { 100, 140, 150, 200, 215, 400 };
      int[] departure = {110, 300, 220, 230, 315, 600};
      int n = arrival.length;

      System.out.print("Minimum platforms required is "
            + minimumNumberOfPlatform(arrival, departure,n));
   }
}