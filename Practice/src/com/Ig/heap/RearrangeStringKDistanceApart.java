package com.Ig.heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeStringKDistanceApart {

   public static String reorganizeString(String str, int k) {

      Map<Character, Integer> frequencyMap = new HashMap<>();

      for (char chr : str.toCharArray())
         frequencyMap.put(chr, frequencyMap.getOrDefault(chr, 0) + 1);

      PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>((e1, e2) -> e2.getValue() - e1.getValue());

      maxHeap.addAll(frequencyMap.entrySet());


      Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
      StringBuilder result = new StringBuilder(str.length());

      while (!maxHeap.isEmpty()) {
         Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
         result.append(currentEntry.getKey());
         currentEntry.setValue(currentEntry.getValue() - 1);
         queue.offer(currentEntry);
         if (queue.size() == k) {
            Map.Entry<Character, Integer> entry = queue.poll();
            if (entry.getValue() > 0) {
               maxHeap.add(entry);
            }
         }
      }
      return result.length() == str.length() ? result.toString() : "";
   }


   public static void main(String[] args) {
      System.out.println("Reorganized string: " +
            RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
      System.out.println("Reorganized string: " +
            RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
      System.out.println("Reorganized string: " +
            RearrangeStringKDistanceApart.reorganizeString("aab", 2));
      System.out.println("Reorganized string: " +
            RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
   }
}
