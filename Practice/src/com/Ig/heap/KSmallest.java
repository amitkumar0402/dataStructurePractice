package com.Ig.heap;


import java.util.PriorityQueue;

public class KSmallest {


   private static int[] findKSmallest(int[] heap, int k) {
      int arraySize = heap.length;
      int[] result = new int[k];
      if (k <= arraySize) {

         for (int i = 0; i < k; i++) {
            result[i] = removeMin(heap, arraySize);
            --arraySize;
         }

      }

      return result;
   }

   private static int removeMin(int[] heap, int arraySize) {
      buildMinHeap(heap, arraySize);
      int min = heap[0];
      heap[0] = heap[arraySize - 1];
      return min;

   }

   private static void buildMinHeap(int[] heap, int arraySize) {

      for (int i = (arraySize - 1) / 2; i >= 0; i--) {
         minHeapifyA(heap, i, arraySize);
      }
   }

   private static void minHeapifyA(int[] heap, int index, int arraySize) {
      int smallest = index;
      while (smallest < arraySize / 2) {

         int left = (2 * index) + 1;
         int right = (2 * index) + 2;

         if (left < arraySize && heap[left] < heap[index]) {
            smallest = left;
         }

         if (right < arraySize && heap[right] < heap[smallest]) {
            smallest = right;
         }
         if (smallest != index) {
            int temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;
            index = smallest;
         } else {
            break;
         }

      }

   }

   public static int findKthSmallestNumber(int[] nums, int k) {
      PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1,n2)->n2-n1);

      for(int i=0;i<k;i++)
         maxHeap.add(nums[i]);

      for(int i=k;i<nums.length;i++){
         if(nums[i]<maxHeap.peek()){
            maxHeap.poll();
            maxHeap.add(nums[i]);
         }
      }
      return maxHeap.peek();
   }


   public static void main(String args[]) {
      int[] input = {9, 4, 7, 1, -2, 6, 5};
      int[] output = findKSmallest(input, 2);

      for (int i = 0; i < output.length; i++)
         System.out.println(output[i]);


      int result = KSmallest.findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 5}, 3);
      System.out.println("Kth smallest number is: " + result);

      // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
      result = KSmallest.findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 5}, 4);
      System.out.println("Kth smallest number is: " + result);

      result = KSmallest.findKthSmallestNumber(new int[]{5, 12, 11, -1, 12}, 3);
      System.out.println("Kth smallest number is: " + result);
   }
}

