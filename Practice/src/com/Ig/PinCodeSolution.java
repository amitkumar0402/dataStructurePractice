package com.Ig;

import java.util.Scanner;

public class PinCodeSolution {
   public static void main(String args[]){
       Scanner scanner = new Scanner(System.in);
          int t = scanner.nextInt();
          String statecode = null;
          String[][] arr = new String[t][3];
          for (int i=0; i<t; i++) {
             for (int j = 0; j < 3; j++) {
                arr[i][j] = scanner.next();
             }
             System.out.println();
          }
             int pinCode = scanner.nextInt();
          for(int i=0;i<t;i++){
             String subArray[] = arr[i];
             int lowerbound = Integer.parseInt(subArray[0]);
             int upperBound = Integer.parseInt(subArray[1]);
             if(pinCode< upperBound && pinCode>lowerbound){
                statecode= subArray[2];
             }




          }
          System.out.println(statecode);
   }
}
