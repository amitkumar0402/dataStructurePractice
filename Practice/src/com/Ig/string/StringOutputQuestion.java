package com.Ig.string;

public class StringOutputQuestion {

   public static void main(String args[]){
      String s = "abcd";
      String s2 = s;
      s = s.concat("efgh");
      System.out.println("String s =" +s);
      System.out.println("String s2 ="+s2);
   }
}
