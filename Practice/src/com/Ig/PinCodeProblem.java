package com.Ig;


public class PinCodeProblem {

   public static void main(String[] args){
      String str = "3\n1 100 NK\n101 200 KL\n201 300 KA\n150";
      String[] arrOfStr = str.split("\n");
      String stateCode = null;
      int pinCode = Integer.parseInt(arrOfStr[arrOfStr.length-1]);
      for( int i=1; i< arrOfStr.length-1; i++){
         String[] strings = arrOfStr[i].split("\\s+");
         int lowerbound = Integer.parseInt(strings[0]);
         int upperBound = Integer.parseInt(strings[1]);
         if(pinCode< upperBound && pinCode>lowerbound){
            stateCode = strings[2];
         }
         }
      System.out.println(stateCode);
   }

}
