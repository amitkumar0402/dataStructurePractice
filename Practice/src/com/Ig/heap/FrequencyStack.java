package com.Ig.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencyStack {

   PriorityQueue<Element> maxHeap = new PriorityQueue<Element>((e1,e2)->{
      if (e1.getFrequency() != e2.getFrequency())
         return e2.getFrequency() - e1.getFrequency();
      return e2.getSequenceNumber() - e1.getSequenceNumber();
      });
   Map<Integer,Integer> frequencyMap = new HashMap<>();
   int sequenceNumber =0;

   public void push(int num){
      frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
      maxHeap.offer(new Element(num,frequencyMap.get(num),sequenceNumber++));
   }

   public int pop(){

      int number = maxHeap.poll().number;

      if(frequencyMap.get(number)>1){
         frequencyMap.put(number, frequencyMap.getOrDefault(number,0)+1);
      }
      else{
         frequencyMap.remove(number);
      }
      return number;
   }

   public static void main(String[] args) {
      FrequencyStack frequencyStack = new FrequencyStack();
      frequencyStack.push(1);
      frequencyStack.push(2);
      frequencyStack.push(3);
      frequencyStack.push(2);
      frequencyStack.push(1);
      frequencyStack.push(2);
      frequencyStack.push(5);
      System.out.println(frequencyStack.pop());
      System.out.println(frequencyStack.pop());
      System.out.println(frequencyStack.pop());
   }
}


