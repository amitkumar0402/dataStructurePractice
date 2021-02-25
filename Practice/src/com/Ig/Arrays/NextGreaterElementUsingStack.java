package com.Ig.Arrays;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementUsingStack {

   public static int[] nextGreaterElement(int[] arr) {
      int[] result = new int[arr.length];
      int resultIndex = 0;
      Stack<Integer> stack = new Stack<>();
      // iterate for rest of the elements
      for (int i = arr.length - 1; i >= 0; i--) {
         if (!stack.isEmpty()) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
               stack.pop();
            }
         }
         if(stack.isEmpty()){
            result[i] = -1;
         }
         else
            result[i]  = stack.peek();
         stack.push(arr[i]);
      }
      return result;
   }
   public static void main(String[] args)
   {
      int arr[] = {4,6,3,2,8,1,11};
      printNextGreaterElement(arr);
    //  System.out.println(Arrays.toString(arr));
   //   int result[] = nextGreaterElement(arr);
   //   System.out.println(Arrays.toString(result));
   }
   public static void printNextGreaterElement(int[] arr){
      Stack<Integer> stack = new Stack<Integer>();
      int n = arr.length;
      stack.push(arr[0]);
      for(int i=1;i<n;i++){
         while(!stack.isEmpty() && stack.peek()<arr[i]){
          System.out.println("Next greater element using stack for "+ stack.pop() + "\t = " +arr[i]);
         }
         stack.push(arr[i]);
      }

      while(!stack.isEmpty()){
         int top =stack.pop();
         System.out.println("Next greater element using stack for "+top+ "\t = " + -1);
      }

   }
}
