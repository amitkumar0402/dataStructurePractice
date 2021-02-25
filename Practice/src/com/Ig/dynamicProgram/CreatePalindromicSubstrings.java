package com.Ig.dynamicProgram;

public class CreatePalindromicSubstrings {
   public int findCPS(String st) {
      boolean[][] dp = new boolean[st.length()][st.length()];
      int count = 0;

      for (int i = 0; i < st.length(); i++) {
         dp[i][i] = true;
         count++;
      }

      for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
         for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
            if (st.charAt(startIndex) == st.charAt(endIndex)) {
               if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
                  dp[startIndex][endIndex] = true;
                  count++;
               }
            }
         }
      }
      return count;
   }


   public static void main(String[] args) {
      CreatePalindromicSubstrings cps = new CreatePalindromicSubstrings();
      System.out.println(cps.findCPS("abdbca"));
      System.out.println(cps.findCPS("cdpdd"));
      System.out.println(cps.findCPS("pqr"));
   }
}

