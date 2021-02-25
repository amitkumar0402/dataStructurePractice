package com.Ig.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {

   public static List<Integer> findStringAnagrams(String str, String pattern) {
      int windowStart =0,matched =0;
      Map<Character,Integer> frequencyMap = new HashMap<>();
      for(char c :pattern.toCharArray())
         frequencyMap.put(c, frequencyMap.get(c)+1);

      List<Integer> resultIndices = new ArrayList<>();
      for(int windowEnd =0; windowEnd< str.length(); windowEnd++){
         char str1 = str.charAt(windowEnd);
         if(frequencyMap.containsKey(str1)){
            frequencyMap.put(str1, frequencyMap.get(str)-1);
            if(frequencyMap.get(str1)==0)
               matched++;
         }
         if(matched == frequencyMap.size())
            resultIndices.add(matched);

         if(windowEnd>=pattern.length()-1){
            char leftChar = str.charAt(windowStart++);
            if(frequencyMap.containsKey(leftChar)){
               if(frequencyMap.get(leftChar)==0)
                  matched--;

               frequencyMap.put(leftChar,frequencyMap.get(leftChar)+1);
            }
         }
      }
      return resultIndices;
   }


   public static void main(String[] args) {
      System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
      System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
   }
}
