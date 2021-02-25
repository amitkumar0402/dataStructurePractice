package com.Ig.matrix;

public class SumOfDiagonals {

   public static void printDiagonalSums(int[][] a, int n) {
      int principalDiagonal =0,secondaryDiagonal=0;
       for(int i=0;i<a.length;i++){
          principalDiagonal+= a[i][i];
          secondaryDiagonal+= a[i][n-i -1];
       }

       System.out.println("PrincipalDiagonal ="+principalDiagonal);

       System.out.println("SecondaryDiagonalSum="+secondaryDiagonal);

   }

   public static  void main (String[] args)
   {
      int [][]a = { { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 } };

      printDiagonalSums(a, 4);
   }

}

