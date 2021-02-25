package com.Ig.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
   public static void main(String[] args) {
      Integer[] l1 = new Integer[] { 2, 6, 8 };
      Integer[] l2 = new Integer[] { 3, 6, 7 };
      Integer[] l3 = new Integer[] { 1, 3, 4 };
      List<Integer[]> lists = new ArrayList<Integer[]>();
      lists.add(l1);
      lists.add(l2);
      lists.add(l3);
      mergeKSortedArrays(lists);

   }

   public static void mergeKSortedArrays(List<Integer[]> lists) {
      PriorityQueue<ArrayNode> pq = new PriorityQueue<>(Comparator.comparingInt(n->lists.get(n.arrayIndex)[n.elementIndex]));

      for(int i=0;i<lists.size();i++){
         if(lists.get(i)!=null){
            pq.add(new ArrayNode(0,i));
         }
      }
      while(!pq.isEmpty()){
         ArrayNode node = pq.poll();
         System.out.print(lists.get(node.arrayIndex)[node.elementIndex] +" ");
         node.elementIndex++;
         if(lists.get(node.arrayIndex).length > node.elementIndex){
            pq.add(node);
         }

      }
   }
}


