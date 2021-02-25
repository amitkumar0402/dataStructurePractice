package com.Ig;

public class PinCode {

   public static String getPinCode(String a[][]) {
       int size = a.length;
       int pinCode = Integer.parseInt(a[size-1][0]);
       String stateCode = null;
      for (int i = 1; i < size-1; i++) {
         String subArray[] = a[i];
            int lowerbound = Integer.parseInt(subArray[0]);
            int upperBound = Integer.parseInt(subArray[1]);
            if(pinCode< upperBound && pinCode>lowerbound){
               stateCode= subArray[2];
               }


      }
      return  stateCode;
   }

   public static void main(String[] args){
      String pinCodes[][] = {{"3"},
            {"1", "100", "NK"},
            {"101", "200", "KL"},
            {"201", "300", "KA" },
            {"150"}};
      System.out.println(getPinCode(pinCodes) );


      };
   }

