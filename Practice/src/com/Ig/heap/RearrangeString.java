package com.Ig.heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeString {

   public static String rearrangeString(String str) {

      Map<Character, Integer> frequencyMap = new HashMap<>();

      for (char chr : str.toCharArray())
         frequencyMap.put(chr, frequencyMap.getOrDefault(chr, 0) + 1);

      PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>((e1, e2) -> e2.getValue() - e1.getValue());

      maxHeap.addAll(frequencyMap.entrySet());


      Map.Entry<Character, Integer> previousEntry = null;
      StringBuilder result = new StringBuilder(str.length());
      while(!maxHeap.isEmpty()){
         Map.Entry<Character,Integer> currentEntry = maxHeap.poll();

         if(previousEntry!=null && previousEntry.getValue()>0)
            maxHeap.offer(previousEntry);

         result.append(currentEntry.getKey());
         currentEntry.setValue(currentEntry.getValue()-1);
         previousEntry = currentEntry;
      }
    return result.length() == str.length() ? result.toString() : " ";
   }


   public static void main(String[] args) {
      System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
      System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
      System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
   }
}

