package com.Ig.Arrays;

import java.util.ArrayList;

public class MaximumProfitForStockBuyAndSell {
   static class Result {
      int buy, sell;
   }
   void findProfit(int array[], int n)
   {
      //Prices must be given for at least two days
      if (n == 1)
         return;
      //Traverse through given price array
      int count = 0;

      ArrayList<Result> result = new ArrayList<Result>();

      int i;
      for (i=0;i<array.length;i++)
      {
         //Find Local Minima Note that the limit is (n-2) as we are comparing present element to the next element
         while ((i < n - 1) && (array[i + 1] <= array[i]))
            i++;
         //If we reached the end, break as no further solution possible
         if (i == n - 1)
            break;
         //Store the index of minima
         Result temp = new Result();
         temp.buy = i++;
         //Find Local Maxima Note that the limit is (n-1) as we are comparing to previous element
         while ((i < n) && (array[i] >= array[i - 1]))
         {
            i++;
         }
         //Store the index of maxima
         temp.sell = i - 1;
         result.add(temp);

         count++;
         i--;
      }

      if (count == 0)
         System.out.println("Profit Can't be Make");
      else
         for (int j = 0; j < count; j++)
            System.out.println("Buy on day: " + result.get(j).buy +"Sell on day : " + result.get(j).sell);

      return;
   }

   public static void main(String args[])
   {
      MaximumProfitForStockBuyAndSell stock = new MaximumProfitForStockBuyAndSell();

      int array[] = { 98, 178, 250, 300, 40, 540, 690 };
      int n = array.length;

      stock.findProfit(array, n);
   }
}

