package com.Ig.Arrays;

public class MinimumJumps {
   public static void main(String[] args) {
      int num[] = {2, 3, 1, 1, 4};

      System.out.println("Minimum number of jumps to reach end is : "
            + Jump(num));
   }

   public static int Jump(int[] num) {

      int i = 0;
      int a = num[0];
      int b = num[0];
      int jump = 1;
      for (i = 1; i < num.length; i++) {
         if (i == num.length - 1)
            return jump;
         a--;
         b--;
         if (num[i] > b) {
            b = num[i];
         }
         if (a == 0) {
            jump++;
            a = b;
         }
      }
      return jump;
   }
}

