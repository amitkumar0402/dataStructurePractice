package com.Ig.string;

public class MaximumDiscount {

   public static long maxDiscount(int N, int x, int y, int a,int b){
      long lcm = (x*y)/gcd(x,y);

     // for(int i=1;i<=N;i++) {
       long  maxDiscount = (N/ x) * a + (N / y) * b - (N/lcm*Math.min(a,b));
    //  }
      return  maxDiscount;

   }

   public static long  gcd(long x, long y){
      if(y==0)
         return x;
      return gcd(y,x%y);

   }
   public static void main(String args[]){
      System.out.println("Max Discount ="+maxDiscount(12,2,3,5,7));
   }
}
