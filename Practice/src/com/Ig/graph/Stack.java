package com.Ig.graph;

public class Stack<V> {
   public int maxSize;
   public int top;
   private V array[];
   private int currentSize;


   public int getMaxSize() {
      return maxSize;
   }

   public void setMaxSize(int maxSize) {
      this.maxSize = maxSize;
   }

   public int getTop() {

      return top;
   }




   public Stack(int maxSize) {
      this.maxSize = maxSize;
      this.top = -1;
      array = (V[]) new Object[maxSize];
      this.currentSize =0;
   }

   public int getCurrentSize() {
      return currentSize;
   }

   public boolean isEmpty() {
      return top == -1;

   }

   public boolean isFull() {
      return top == maxSize - 1;
   }

   public void push(V value) {
      if (isFull())
         System.out.println("Stack is Full");
      array[++top] = value;
      currentSize++;
   }

   public V top() {
      if (isEmpty())
         return null;
      return array[top];
   }

   public V pop() {
      if (isEmpty())
         return null;
      currentSize--;
      return array[top--];

   }
   public static void main(String[] args) {

      Stack<Integer> stack = new Stack<Integer>(5);
      System.out.print("Elements pushed in the Stack: ");
      for (int i = 0; i < 5; i++) {
         stack.push(i); //pushes 5 elements (0-4 inclusive) to the stack
         System.out.print(i + " ");
      }
      System.out.println("\nIs Stack full? \n" + stack.isFull());
      System.out.print("Elements popped from the Stack: ");
      for (int i = 0; i < 5; i++) {
         System.out.print(stack.pop()+" "); //pops all 5 elements from the stack and prints them
      }
      System.out.println("\nIs Stack empty? \n" + stack.isEmpty());

   }
}

