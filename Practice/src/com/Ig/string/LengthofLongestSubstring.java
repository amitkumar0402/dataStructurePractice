package com.Ig.string;

import java.util.HashMap;
import java.util.Map;

public class LengthofLongestSubstring {

   public static int LongestSubstring(String str){
      int windowStart =0,maxLength =0;
      Map<Character,Integer>  charMap = new HashMap<>();
      for(int windowEnd =0;windowEnd< str.length(); windowEnd++){
         char rightChar = str.charAt(windowEnd);
          if(charMap.containsKey(rightChar)){
             windowStart = Math.max(windowStart, charMap.get(rightChar)+1);
          }
          charMap.put(rightChar, windowEnd);
          maxLength = Math.max(maxLength, windowEnd - windowStart +1);
      }
      return maxLength;
   }

   public static void main(String[] args) {
      System.out.println("Length of the longest substring: " + LongestSubstring("aabccbb"));
      System.out.println("Length of the longest substring: " + LongestSubstring("abbbb"));
      System.out.println("Length of the longest substring: " + LongestSubstring("abccde"));
   }
}
