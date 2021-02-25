package com.Ig.Arrays;

public class StockPrices {

   public static Tuple findBuySellPrice(int[] array) {
      if (array != null && array.length < 2) {
         return null;
      }

      int currentBuy = array[0];
      int globalSell = array[1];
      int globalProfit = globalSell - currentBuy;
      int currentProfit = Integer.MIN_VALUE;

      for (int i = 1; i < array.length; i++) {
         currentProfit = array[i] - currentBuy;

         if (currentProfit > globalProfit) {
            globalProfit = currentProfit;
            globalSell = array[i];
         }

         if (currentBuy > array[i]) {
            currentBuy = array[i];
         }
      }

      Tuple<Integer, Integer> result = new Tuple<Integer, Integer>(globalSell - globalProfit, globalSell);
      return result;
   }

      public static void main(String[] args) {
         int[] array = {1, 2, 3, 4, 3, 2, 1, 2, 5};
         Tuple result = null;
         result = findBuySellPrice(array);
         System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.x, result.y));

         int[] array2 = {8, 6, 5, 4, 3, 2, 1};
         result = findBuySellPrice(array2);
         System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.x, result.y));

      }

   }

