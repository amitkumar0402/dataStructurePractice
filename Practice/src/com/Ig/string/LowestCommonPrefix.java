package com.Ig.string;

import java.util.Arrays;
import java.util.List;

public class LowestCommonPrefix {

   public static String LCP(String X, String Y){
      int i=0,j=0;
      while(i<X.length() && j<Y.length()){
         if(X.charAt(i)!= Y.charAt(j)){
            break;
         }
         i++;j++;
      }
      return X.substring(0,i);

   }


   public static String findLCP(List<String> words, int low, int high){
      if(low>high){
        return "";
      }

      if(low == high){
         words.get(low);
      }

      int mid = (low+high)/2;

      String X = findLCP(words, low, mid);
      String Y = findLCP(words, mid+1, high);

      return LCP(X,Y);
   }


   public static void main(String[] args)
   {
      List<String> words = Arrays.asList("techie delight", "tech", "techie",
            "technology", "technical");

      System.out.print("The longest common prefix is " +
            findLCP(words, 0, words.size() - 1));
   }

}
