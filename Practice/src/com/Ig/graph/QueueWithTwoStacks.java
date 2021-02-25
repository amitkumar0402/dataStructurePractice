package com.Ig.graph;

public class QueueWithTwoStacks<V> {
   Stack<V> stack1;
   Stack<V> stack2;

   public QueueWithTwoStacks(int maxSize){
      stack1 = new Stack<>(maxSize);
      stack2 = new Stack<>(maxSize);
   }

   public boolean isEmpty(){
      return stack1.isEmpty() && stack2.isEmpty();
   }

   public void enqueue(V value){
      stack1.push(value);
   }
   public V dequeue(){
      if(isEmpty()){
         return null;
      }
      else if(stack2.isEmpty()){
         while(!stack2.isEmpty()){
            stack2.push(stack1.pop());
         }
         return stack2.pop();
      }
      else{
        return stack2.pop();
      }
   }
   public static void main() {
      QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<Integer>(5);

      queue.enqueue(1);
      queue.enqueue(2);
      queue.enqueue(3);
      queue.enqueue(4);
      queue.enqueue(5);

      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue()); //this will output null because queue will be empty
   }
}

