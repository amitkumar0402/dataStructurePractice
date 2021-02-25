package com.Ig.string;

public class ReverseWords {

   public static void reverseWords(char[] sentence) {

      if(sentence == null || sentence.length<1){
         return;
      }

      int len = sentence.length;
      reverse(sentence,0,len -2);

      int start =0;
      int end;

      while(true){
         while(sentence[start] == ' '){
            ++start;
         }
         if(start>= sentence.length-1)
            break;

         end = start +1;
         while(end<sentence.length -1 && sentence[end] != ' '){
            ++end;
         }

         reverse(sentence,start, end);
         start =end;
      }
   }

   private static void reverse(char[] sentence, int start, int end) {
      if(sentence == null || sentence.length<2)
         return;

      while(start<end){
         char temp = sentence[start];
         sentence[start] = sentence[end];
         sentence[end] = temp;
         start++;
         end--;
      }


   }

   public static void main(String[] args) {
      char[] s = getArray("Hello World!");
      System.out.println(s);
      reverseWords(s);
      System.out.println(s);
   }

   public static char[] getArray(String s) {
      char[] charArray = new char[s.length()+1];
      for(int i=0; i<s.length();++i){
         charArray[i] = s.charAt(i);
   }
   return charArray;
}
}
