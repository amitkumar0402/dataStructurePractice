package com.Ig.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParenthesis {

   public static List<String> generateValidParentheses(int num) {
      List<String> result = new ArrayList<>();
      Queue<ParenthesisString> queue = new LinkedList<>();
      queue.add(new ParenthesisString("", 0, 0));
      while (!queue.isEmpty()) {
         ParenthesisString ps = queue.poll();
         // if we've reached the maximum number of open and close parentheses, add to the result
         if (ps.openCount == num && ps.closeCount == num) {
            result.add(ps.str);
         } else {
            if (ps.openCount < num) // if we can add an open parentheses, add it
               queue.add(new ParenthesisString(ps.str + "(", ps.openCount + 1, ps.closeCount));

            if (ps.openCount > ps.closeCount) // if we can add a close parentheses, add it
               queue.add(new ParenthesisString(ps.str + ")", ps.openCount, ps.closeCount + 1));
         }
      }
      return result;
   }


   public static void main(String[] args) {
      List<String> result = GenerateParenthesis.generateValidParentheses(2);
      System.out.println("All combinations of balanced parentheses are: " + result);

      result = GenerateParenthesis.generateValidParentheses(3);
      System.out.println("All combinations of balanced parentheses are: " + result);
   }
}
