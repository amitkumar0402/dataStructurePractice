package com.Ig.matrix;

public class Spiralmatrix {
   static int R = 4;
   static int C = 4;

   // Function for printing matrix in spiral
   // form i, j: Start index of matrix, row
   // and column respectively m, n: End index
   // of matrix row and column respectively
   public static void print(int arr[][], int i, int j, int m,
                            int n) {

      if (i >= m || j >= n)
         return;
      //print 1st row
      for (int p = i; p < n; p++) {
         System.out.print(arr[i][p] + " ");
      }

      for (int p = i + 1; p < m; p++) {
         System.out.print(arr[p][n - 1] + " ");
      }
      for (int p = n - 1; p > 0; p--) {
         System.out.print(arr[m - 1][p] + " ");
      }
      if ((m - 1) != i) {
         for (int p = n - 2; p >= j; p--) {
            System.out.print(arr[m - 1][p] + " ");
         }
      }
      if ((n - 1) != j) {
         for (int p = m - 2; p > i; p--) {
            System.out.print(arr[p][j] + " ");
         }
      }
      print(arr, i + 1, j + 1, m - 1, n - 1);
   }

   public static void main(String[] args) {
      int a[][] = {{1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}};

      // Function Call
      // print(a, 0, 0, R, C);
      spiralPrint(R, C, a);
   }

   public static void spiralPrint(int m, int n, int matrix[][]) {
      int i, k = 0, l = 0;
      //checking k or l lies outside the matrix
      while (k < m && l < n) {
         //Print First Row
         for (i = l; i < n; ++i) {
            System.out.print(matrix[k][i] + " ");
         }
         k++;
         //Print Last Column
         for (i = k; i < m; ++i) {
            System.out.print(matrix[i][n - 1] + " ");
         }
         n--;
         //Print the last row
         if (k < m) {
            for (i = n - 1; i >= l; --i) {
               System.out.print(matrix[m - 1][i] + " ");
            }
            m--;
         }
         //Print the first column
         if (l < n) {
            for (i = m - 1; i >= k; --i) {
               System.out.print(matrix[i][l] + " ");
            }
            l++;
         }
      }
   }
}
