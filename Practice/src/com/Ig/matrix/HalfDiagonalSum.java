package com.Ig.matrix;

public class HalfDiagonalSum {

   public static boolean HalfDiagonalSums(int[][] a, int n) {
      int diag1_left=0,diag1_right=0,diag2_left =0,diag2_right =0;

      for(int i =0,j=n-1;i<n;i++,j--){

         if(i<n/2){
            diag1_left += a[i][i];
            diag2_left += a[j][i];
         }
         if(i>n/2){
            diag1_right+= a[i][i];
            diag2_right+=a[j][i];
         }
      }
      return diag1_left == diag1_right&&
            diag1_right == diag2_right &&
            diag2_right == diag2_left &&
            diag2_left == a[n/2][n/2];

   }

   public static void main(String args[])
   {

      int a[][] = { { 2, 9, 1, 4, -2},
            { 6, 7, 2, 11, 4},
            { 4, 2, 9, 2, 4},
            { 1, 9, 2, 4, 4},
            { 0, 2, 4, 2, 5} };

      System.out.print ( HalfDiagonalSums(a, 5)
            ? "Yes" : "No" );
   }

}

