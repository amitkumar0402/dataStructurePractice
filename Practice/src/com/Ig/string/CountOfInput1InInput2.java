package com.Ig.string;

import java.util.StringTokenizer;

public class CountOfInput1InInput2 {

   public static void getvalues(String s1, String s2) {
      int count=0;
      StringTokenizer st=new StringTokenizer(s2," ");
      String s3=st.nextToken();
      String s4=st.nextToken();
//System.out.println(s4);
      StringTokenizer st1=new StringTokenizer(s1," ");
      while(st1.hasMoreTokens())
      {
         String s5=st1.nextToken();
         if(s4.equals(s5))
         {
            count++;
         }
      }
      System.out.println(count);
   }

   public static void main(String[] args){
      String input1 = "abc bcd abc bcd abc abc";

      String input2 = "av abc";

      getvalues(input1, input2);


   }
}

