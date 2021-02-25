package com.Ig.string;

public class Atoi {
   static int myAtoi(String str)
   {
      // Initialize result
      int res = 0;

      // Iterate through all characters
      // of input string and update result
      // take ASCII character of corosponding digit and
      // subtract the code from '0' to get numerical
      // value and multiply res by 10 to shuffle
      // digits left to update running total
      for (int i = 0; i < str.length(); ++i)
         res = res * 10 + str.charAt(i) - '0';

      // return result.
      return res;
   }
   // A simple atoi() function
   static int myAtoi1(char[] str)
   {

      // Initialize result
      int res = 0;

      // Initialize sign as positive
      int sign = 1;

      // Initialize index of first digit
      int i = 0;

      // If number is negative, then
      // update sign
      if (str[0] == '-') {
         sign = -1;

         // Also update index of first
         // digit
         i++;
      }

      // Iterate through all digits
      // and update the result
      for (; i < str.length; ++i)
         res = res * 10 + str[i] - '0';

      // Return result with sign
      return sign * res;
   }



   // Driver code
   public static void main(String[] args)
   {
      String str = "89789";


      // Function call
      int val = myAtoi(str);
      System.out.println(val);

      char[] str1 = "-123".toCharArray();

      // Function call
      int val1 = myAtoi1(str1);
      System.out.println(val1);

   }
}


