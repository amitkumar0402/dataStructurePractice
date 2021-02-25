package com.Ig.graph;

public class NumberofIslandsHorizontalVertical {
   public static void main(String[] args) throws java.lang.Exception {
      int M[][] = new int[][]{{1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}};
      NumberofIslandsHorizontalVertical I = new NumberofIslandsHorizontalVertical();
      System.out.println("Number of islands is: " + I.countIslandsHorizontalVertical(M, 5, 5));
   }
   public int countIslandsHorizontalVertical(int[][] m, int N, int M){
      int count =0;
      for(int i=0;i<N;i++){
         for(int j=0;j<M;j++){
            if(m[i][j]==1){
               count+= dfs(m,N,M,i,j);
            }
         }
      }
      return count;
   }

   private int dfs(int[][] m, int N, int M, int i, int j) {
      if(i<0||i>=N || j<0 ||j>=M||m[i][j]==0){
         return 0;
      }

      m[i][j]=0;
      dfs(m,N,M,i-1,j);
      dfs(m,N,M,i+1,j);
      dfs(m,N,M,i,j-1);
      dfs(m,N,M,i,j+1);
      return 1;
   }
}

