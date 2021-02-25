package com.Ig.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {

   public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {

      HashMap<Integer,Integer> frequencyMap = new HashMap<>();
      for(int n:nums){
         frequencyMap.put(n,frequencyMap.getOrDefault(n,0)+1);
      }

      PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>(Comparator.comparingInt(Map.Entry::getValue));

      for(Map.Entry<Integer,Integer> entry: frequencyMap.entrySet()){
         minHeap.add(entry);
         if(minHeap.size()>k){
            minHeap.poll();
         }
      }

      List<Integer> topKNumbers = new ArrayList<>(k);
      while(!minHeap.isEmpty())
         topKNumbers.add(minHeap.poll().getKey());

      return topKNumbers;

   }

   public static void main(String[] args) {
      List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
      System.out.println("Here are the K frequent numbers: " + result);

      result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
      System.out.println("Here are the K frequent numbers: " + result);
   }


   }
