package com.Ig.Arrays;

import java.util.Arrays;

public class SortArraysof01and2 {

   public static void sortArrays(int[] array){

      int low = 0,mid=0;
      int high = array.length -1;

      while(mid<=high){
         if(array[mid]==0){
            swapArrays(array, low, mid);
            ++mid;
            ++low;
         }
         else if(array[mid] ==2){
            swapArrays(array,mid, high);
            --high;
         }
         else{
            ++mid;
         }
      }

   }

   public static void swapArrays(int[] array, int i, int j) {
      int temp = array[j];
      array[j] = array[i];
      array[i] = temp;
   }

   public static void main(String[] args) {
      int[] array = { 2, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

      sortArrays(array);
      System.out.println(Arrays.toString(array));
   }
}

