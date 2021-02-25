package com.Ig.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestinSortedArrays {

   public static int findKthSmallest(List<Integer[]> lists, int k) {
      PriorityQueue<ArrayNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> lists.get(n.arrayIndex)[n.elementIndex]));

      for(int i=0;i<lists.size();i++){
         if(lists.get(i)!=null){
            minHeap.add(new ArrayNode(0,i));
         }
      }

      int result=0,numberCount =0;
      while(!minHeap.isEmpty()){
         ArrayNode node = minHeap.poll();
         result = lists.get(node.arrayIndex)[node.elementIndex];
         if(++numberCount ==k)
            break;
         node.elementIndex++;
         if(lists.get(node.arrayIndex).length > node.elementIndex)
            minHeap.add(node);
      }
      return result;
   }


   public static void main(String[] args) {
      Integer[] l1 = new Integer[] { 2, 6, 8 };
      Integer[] l2 = new Integer[] { 3, 6, 7 };
      Integer[] l3 = new Integer[] { 1, 3, 4 };
      List<Integer[]> lists = new ArrayList<Integer[]>();
      lists.add(l1);
      lists.add(l2);
      lists.add(l3);
      int result = KthSmallestinSortedArrays.findKthSmallest(lists, 5);
      System.out.print("Kth smallest number is: " + result);
   }
}

