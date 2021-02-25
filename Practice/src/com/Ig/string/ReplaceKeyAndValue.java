package com.Ig.string;

import java.util.HashMap;
import java.util.Map;

public class ReplaceKeyAndValue {

   public static String replaceKeyAndValue(String str,HashMap<Character,Character> strMap){
      HashMap<Character,Character> reverseMap = new HashMap<>();
      for(Map.Entry<Character,Character> entry: strMap.entrySet()){
         reverseMap.put(entry.getValue(),entry.getKey());
      }
      char[] charArray = str.toCharArray();

      for(int i=0;i<str.length();i++){

         if(strMap.containsKey(str.charAt(i))){
            charArray[i] = strMap.get(str.charAt(i));
         }
         else if(reverseMap.containsKey(str.charAt(i))){
            charArray[i] = reverseMap.get(str.charAt(i));
         }
      }
      return String.valueOf(charArray);

   }

   public static void main(String args[]){
      String str = "abc";
      HashMap<Character, Character> hashMap = new HashMap<>();
      hashMap.put('a','c');
      System.out.println("Replaced String ="+ replaceKeyAndValue(str, hashMap));
   }
}
