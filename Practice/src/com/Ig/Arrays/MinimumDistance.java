package com.Ig.Arrays;

public class MinimumDistance {

   public static int getMinimumDistance(int n){
     if(n==1 || n==2 ||n==3||n==4||n==5)
        return 1;

     int count =0;
     int i=5;
     while(n>0 && i>0){
        n-=i;
        count++;
        i--;
     }
     return count;
   }

   public static void main(String[] args){
      System.out.println("Minimum Distance ="+MinimumDistance.getMinimumDistance(12));
   }
}
