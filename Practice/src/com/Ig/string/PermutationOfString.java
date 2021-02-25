package com.Ig.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationOfString {

   public static List<String> result = new ArrayList<String>();

   public static List<String> permuteString(String input) {
      permuteStrings(input.toCharArray(),0);
      return result;
   }

   private static void permuteStrings(char[] input, int index ) {
      if(index == input.length-1){
         String addInput = new String(input);
         result.add(addInput);
      }

      for(int i= index; i<=input.length-1; i++){
         swapChar(input, index,i);
         permuteStrings(input, index+1);
         swapChar(input, index,i);
      }

   }

   private static void swapChar(char[] input, int i, int j){
      char temp = input[i];
      input[i] = input[j];
      input[j] = temp;

   }

   public static void main(String[] args) {
      String input = "bad";
      System.out.println("All permutations of " + input);
      List<String> result = permuteString(input);
      System.out.println(Arrays.toString(result.toArray()));
   }
}
