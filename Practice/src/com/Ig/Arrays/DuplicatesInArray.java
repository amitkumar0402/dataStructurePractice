package com.Ig.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class DuplicatesInArray {

   public static ArrayList<Integer> findDuplicates(int[] arr) {
      ArrayList<Integer> arrayList = new ArrayList<>();
      HashSet<Integer> hashSet = new HashSet<>();
      for(int i=0; i<arr.length; i++){
         if(!hashSet.add(arr[i])){
            if(!arrayList.contains(arr[i]))
            arrayList.add(arr[i]);
         }
         hashSet.add(arr[i]);
      }
return arrayList;
   }

   public static void main(String[] args) {
      int arr[] = {
            7,
            5,
            4,
            3,
            11,
            5,
            11,
            9,
            3,
            11
      };
      ArrayList < Integer > dupes = findDuplicates(arr);
      System.out.println("Duplicates in " + Arrays.toString(arr) + " are " + dupes);

      int arr1[] = {
            6,
            5,
            17
      };
      dupes = findDuplicates(arr1);
      System.out.println("Duplicates in " + Arrays.toString(arr1) + " are " + dupes);
   }
}


