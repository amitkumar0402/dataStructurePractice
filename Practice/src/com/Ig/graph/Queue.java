package com.Ig.graph;

public class Queue<V> {
   private V[] array;
   private int maxSize;
   private int currentSize;
   private int front;

   public int getMaxSize() {
      return maxSize;
   }

   private int back;

   public Queue(int maxSize){
      array = (V[]) new Object[maxSize];
      this.maxSize = maxSize;
      currentSize =0;
      front = 0;
      back =-1;

   }

   public boolean isEmpty(){
      return currentSize ==0;
   }

   public boolean isFull(){
      return currentSize == maxSize;
   }

   public int getCurrentSize() {
      return currentSize;
   }

   public V dequeue(){
      if(isEmpty())
         return null;
      V temp = array[front];
      front = (front + 1)%maxSize;
      currentSize--;
      return temp;
   }

   public V top() {
      return array[front];
   }

   public void enqueue(V value){
      if(isFull())
         return;
      back = (back+1)%maxSize;
      array[back] = value;
            currentSize++;

   }

   public static void main(String[] args) {
      Queue<Integer> queue = new Queue<Integer>(5);
      //equeue 2 4 6 8 10 at the end
      queue.enqueue(2);
      queue.enqueue(4);
      queue.enqueue(6);
      queue.enqueue(8);
      queue.enqueue(10);
      //dequeue 2 elements from the start
      queue.dequeue();
      queue.dequeue();
      //enqueue 12 and 14 at the end
      queue.enqueue(12);
      queue.enqueue(14);

      System.out.println("Queue:");
      while(!queue.isEmpty()){
         System.out.print(queue.dequeue()+" ");
      }
   }


}
