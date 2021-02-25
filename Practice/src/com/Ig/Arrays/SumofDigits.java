package com.Ig.Arrays;

public class SumofDigits {

   public static int getSumOfDigits(int number){
      int sum = 0;

      while (number != 0) {
         sum = sum + number % 10;
         number = number / 10;
      }
      return sum;
   }

   public static Character  getCharacterForNumber(int n) {
      return n > 0 && n < 27 ? (char)(n + 64) : null;
   }

   public static void getExaminationCode(int n){
      Character ch = null;
      int sum = 0;
      while(n>0 || sum>27) {
         if (n == 0) {
            n = sum;
            sum = 0;
         }
         sum += n % 10;
         n /= 10;

      }

      if (sum > 0 && sum <27) {
         ch = getCharacterForNumber(sum);
         System.out.println("Character ="+ch);
      }



   }

   public static void main(String args[]){
      int n = 6878;

      getExaminationCode(n);

   }
}
