package com.Ig.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

   public static int scheduleTasks(char[] tasks, int k) {
      int intervalCount =0;
      Map<Character,Integer> frequencyMap = new HashMap<>();

      for(char chr: tasks)
         frequencyMap.put(chr,frequencyMap.getOrDefault(chr,0)+1);

      PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<Map.Entry<Character,Integer>>((e1,e2)->e2.getValue()-e1.getValue());

      maxHeap.addAll(frequencyMap.entrySet());

      while(!maxHeap.isEmpty()){
         List<Map.Entry<Character,Integer>> waitList = new ArrayList<>();
         int n=k+1;
         for(;n>0 && !maxHeap.isEmpty();n--){
            intervalCount++;
            Map.Entry<Character,Integer> currentEntry = maxHeap.poll();
            if(currentEntry.getValue()>1){
               currentEntry.setValue(currentEntry.getValue()-1);
               waitList.add(currentEntry);
            }
         }
         maxHeap.addAll(waitList);
         if(!maxHeap.isEmpty())
            intervalCount+=n;
      }
      return  intervalCount;
   }

   public static void main(String[] args) {
      char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
      System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

      tasks = new char[] { 'a', 'b', 'a' };
      System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
   }
}

