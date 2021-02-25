package com.Ig.Arrays;

public class CelebrityProblem {
   static int matrix[][] = { { 0, 0, 1, 0 },
         { 0, 0, 1, 0 },
         { 0, 0, 0, 0 },
         { 0, 0, 1, 0 } };

  public static boolean knows(int a, int b)
   {
      //matrix[i][j] = 1, it means ith person knows jth person.
      boolean result = (matrix[a][b] == 1) ? true : false;
      return result;
   }
   // Returns -1 if celebrity is not present. If present,returns id (value from 0 to n-1).
  public static int findCelebrity(int n)
   {
      int X = 0;
      int Y = n - 1;

      while (X < Y)
      {
         if (knows(X, Y))
            X++;
         else
            Y--;
      }
      // Check if X is actually a celebrity or not
      for (int i = 0; i < n; i++)
      {
         //If any person doesn't know 'X' or 'X' doesn't know any person, return -1
         if (i != X && (knows(X, i) || !knows(i, X)))
            return -1;
      }
      return X;
   }

   public static void main(String[] args)
   {
      int n = 4;
      int result = findCelebrity(n);
      if (result == -1)
      {
         System.out.println("No Celebrity");
      }
      else
         System.out.println("Celebrity is " + result);
   }
}

