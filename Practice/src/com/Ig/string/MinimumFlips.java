package com.Ig.string;

public class MinimumFlips {

   public static int flipsCount(String str){
      int result =0;
      int[] arr = new int[str.length()];
      for(int i =0; i< arr.length; i++){
         arr[i] = Integer.valueOf(str.charAt(i) +"");
      }
      for(int i=0; i<arr.length;i++){
         result += (result%2) ^ arr[i];
      }
      return result;
   }

   public static int flipCount(String str){
      int ans =0;
      for( int i=0; i<str.length();i++){

         if(i%2==0 && str.charAt(i) =='1'){
            ans++;
         }
         if(i%2==1 && str.charAt(i) =='0'){
            ans++;
         }
      }
      return Math.min(ans, str.length() - ans);
   }

   public static void main(String args[])
   {
      String str ="0011";
      System.out.println(flipsCount(str));
      System.out.println(flipCount(str));
   }
}

