package com.Ig.string;

import java.util.HashMap;

public class MinimumModificationtoMake2StringsAnagram {

   public static int getMinimumDifference(String a , String b){
      HashMap<Character,Integer> hm = new HashMap<>();
      for(char c: a.toCharArray()){
         if(hm.containsKey(c)){
            hm.put(c, hm.get(c)+1);
         }
         else{
            hm.put(c,1);
         }
      }

      for(char c: b.toCharArray()){
         if(hm.containsKey(c)){
            hm.put(c,hm.get(c)-1);
         }
      }
      int ans =0;
      for(char c: hm.keySet()){
         if(hm.get(c)>0){
            ans+= hm.get(c);
         }
      }
      return ans;
   }

  public static void main(String[] args)
   {

      String s1 = "ddcf";
      String s2 = "cedk";
      System.out.println(getMinimumDifference(s1, s2));
   }
}

