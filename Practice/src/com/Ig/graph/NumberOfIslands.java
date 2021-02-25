package com.Ig.graph;

public class NumberOfIslands {
   public static void main(String[] args) throws java.lang.Exception {
      int M[][] = new int[][]{{1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}};
      NumberOfIslands I = new NumberOfIslands();
      System.out.println("Number of islands is: " + I.countIslands(M, 5, 5));
   }

   public int countIslands(int[][] m, int N, int M) {
      int count = 0;
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < M; j++) {
            if (m[i][j] == 1) {
               count++;
               check(m, N, M, i, j);
            }
         }
      }
      return count;
   }

   public static void check(int[][] m, int N, int M, int i, int j) {
      if (i >= N || i < 0 || j >= M || j < 0 || m[i][j] == 0 || m[i][j] == -1) {
         return;
      }
      m[i][j] = -1;
      check(m, N, M, i + 1, j);
      check(m, N, M, i - 1, j);
      check(m, N, M, i, j - 1);
      check(m, N, M, i, j + 1);
      check(m, N, M, i + 1, j - 1);
      check(m, N, M, i + 1, j + 1);
      check(m, N, M, i - 1, j - 1);
      check(m, N, M, i - 1, j + 1);
   }

}