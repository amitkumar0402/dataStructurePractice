package com.Ig.string;

import java.util.HashSet;
import java.util.Set;

public class AllDistinctSubstringsWithKDistinct {

   // Function to find all distinct substrings containing exactly `k` distinct chars
   public static Set<String> getDistinctSubstrings(String str, int k)
   {
      // create a hash set to store substrings containing exactly `k` distinct chars
      Set<String> result = new HashSet<>();

      // in each iteration of the loop, consider substring starting with `str[i]`
      for (int i = 0; i < str.length() - k + 1; i++)
      {
         // create a hash set to store distinct characters in the current substring
         Set<Character> chars = new HashSet<>();

         // Process substring starting with `str[i]`
         for (int j = i; j < str.length() && chars.size() <= k; j++)
         {
            // insert the current character `str[j]` to the hash set
            chars.add(str.charAt(j));

            // if the current character `str[j]` is seen before in the
            // substring `str[i…j-1]`, the count remains the same since
            // the hash set only allows unique values

            // if the count of distinct characters becomes `k`
            if (chars.size() == k) {
               // add the current substring to result
               result.add(str.substring(i, j + 1));
            }
         }
      }

      return result;
   }

   public static void main(String[] args)
   {
      String str = "abcadce";
      int k = 4;

      Set<String> result = getDistinctSubstrings(str, k);
      System.out.println(result);
   }
}






