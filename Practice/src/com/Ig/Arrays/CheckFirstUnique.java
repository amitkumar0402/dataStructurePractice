package com.Ig.Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class CheckFirstUnique {
   public static int findFirstUnique(int[] arr) {

      HashMap<Integer, Integer> uniqueMap = new HashMap<>();

      for(int i =0; i< arr.length; i++){
         if(uniqueMap.containsKey(arr[i])){
            uniqueMap.put(arr[i], uniqueMap.get(arr[i]) + 1);
         }
         else{
            uniqueMap.put(arr[i], 0);
         }
      }

      for(int i = 0; i< arr.length; i++){
         if(uniqueMap.get(arr[i]) == 0){
            return arr[i];
         }
      }
      return -1;

   }

   public static void main(String args[]) {

      int[] arr = {2, 54, 7, 2, 6, 54};

      System.out.println("Array: " + Arrays.toString(arr));

      int unique = findFirstUnique(arr);
      System.out.print("First Unique in an Array: " + unique);

   }
}
