package com.Ig.linkedlist;

public class HappyNumber {
   public static void main(String[] args) {
      System.out.println(HappyNumber.find(23));
      System.out.println(HappyNumber.find(12));
   }

   public static boolean find(int num) {
      int fast = num,slow =num;

      do{
         slow = findSquareNum(slow);
         fast = findSquareNum(findSquareNum(fast));

   }while(slow!= fast);

      return slow ==1;
}

   private static int findSquareNum(int num) {
      int digit ,sum =0;
      while(num>0){
         digit = num%10;
         sum+= digit * digit;
         num/=10;
         }
         return sum;
   }
}
