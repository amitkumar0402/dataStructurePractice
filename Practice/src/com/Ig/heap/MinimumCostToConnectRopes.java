package com.Ig.heap;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCostToConnectRopes {

   // Function to calculate the minimum cost to join `n` ropes into a single rope
   public static int findMinCost(List<Integer> prices) {
      int cost = 0;
      PriorityQueue<Integer> pq = new PriorityQueue<>(prices);

      while (pq.size() > 1) {
         int x = pq.poll();
         int y = pq.poll();

         int sum = x + y;

         pq.add(sum);

         cost += sum;
      }
      return cost;
   }


   public static void main(String[] args) {
      List<Integer> prices = Arrays.asList(5, 4, 2, 8);
      System.out.println("The minimum cost is " + findMinCost(prices));
   }
}




