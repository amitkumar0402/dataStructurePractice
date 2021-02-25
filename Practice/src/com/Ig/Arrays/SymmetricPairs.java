package com.Ig.Arrays;

import java.util.HashMap;

public class SymmetricPairs {

   public static String findSymmetric(int[][] arr) {
      String result ="";
      HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
      for( int i =0;i< arr.length; i++){
         Integer first = arr[i][0];
         Integer second = arr[i][1];

         Integer value = hashMap.get(second);
          if(value!= null && value == first){
            result+= "{"+ String.valueOf(second) +","+ String.valueOf(first) + "}";
          }
          hashMap.put(first,second);
      }
      return result;
   }

   public static void main(String args[]) {

      int[][] arr = {{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}};
      String symmetric = findSymmetric(arr);
      System.out.println(symmetric);

   }

}
