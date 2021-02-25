package com.Ig.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountDistinctPairs {

   public static int getDistinct(List<Integer> numbers, int k){
      int count =0;
   Integer[] arr = new Integer[numbers.size()];
   for(int i=0;i<numbers.size();i++){
      arr[i] = numbers.get(i);
   }
   int n= arr.length;

      HashMap<Integer,Integer> map= new HashMap();
      for (int i=0;i<n;i++) {
         if (!map.containsKey(arr[i]))
            map.put(arr[i],1);
      }

      for (int i=0;i<n;i++) {
         if (map.containsKey(arr[i]+k))
            count++;
         if (map.containsKey(arr[i]-k))
            count++;
         map.remove(arr[i]);
      }
      return count;
   }

   public static int getDistinctPairs(List<Integer> numbers, int k) {
      int count = 0;
      Integer[] arr = new Integer[numbers.size()];
      for (int i = 0; i < numbers.size(); i++) {
         arr[i] = numbers.get(i);
      }
      int n = arr.length;

      Arrays.sort(arr);

      // take an empty set
      Set<Integer> set = new HashSet<>();
      int cunt =0;
      // do for each element in the array
      for (int i = 0; i < n; i++) {
         // to avoid printing duplicates (skip adjacent duplicates)
         while (i + 1 < n && arr[i] == arr[i + 1]) {
            i++;
         }

         // check if pair with given difference (A[i], A[i] - diff) exists
         if (set.contains(arr[i] - k)) {
            System.out.println("(" + arr[i] + ", " + (arr[i] - k) + ")");
            count++;
         }

         // check if pair with given difference (A[i] + diff, A[i]) exists
         if (set.contains(arr[i] + k)) {
            System.out.println("(" + (arr[i] + k) + ", " + arr[i] + ")");
            count++;
         }

         // insert element into the set
         set.add(arr[i]);
      }
return count;
   }

   public static void main(String[] args){
      List<Integer> list = new ArrayList<>();
      list.add(1);
      list.add(5);
      list.add(2);
      list.add(2);
      list.add(2);
      list.add(5);
      list.add(5);
      list.add(4);
      list.add(1);

     System.out.println("Count of pairs=" +CountDistinctPairs.getDistinct(list,-3));
      System.out.println("Count of pairs=" +CountDistinctPairs.getDistinctPairs(list,-3));

   }
}
