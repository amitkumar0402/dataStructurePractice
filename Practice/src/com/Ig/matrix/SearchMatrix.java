package com.Ig.matrix;

public class SearchMatrix {
   public static Object findKey(int[][] matrix, int numberOfRows, int numberOfColumns, int target){
      int min =0;
      int max = numberOfRows * numberOfColumns -1;

      while(min<=max){
         int mid = (min + max)/2;
         int row = mid/numberOfColumns;
         int col = mid%numberOfColumns;
         if(target> matrix[row][col]){
         //   max = mid -1;
            min = max +1;
         }
         else if(target< matrix[row][col]){
          //  min = max +1;
            max = mid -1;
         }
         else{
            return true;
         }
      }
      return false;
   }
   public static void main(String args[]) {
      int[][] matrix = {
            {10, 11, 12, 13},
            {14, 15, 16, 17},
            {27, 29, 30, 31},
            {32, 33, 39, 50}
      };

      // Example 1
      Object x = findKey(matrix, 4, 4, 80);
      System.out.println("Search for 80 returned: " + x);

      // Example 2
      x = findKey(matrix, 4, 4, 15);
      System.out.println("Search for 15 returned: " + x);
   }
}

