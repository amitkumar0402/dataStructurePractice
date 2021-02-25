package com.Ig.Threads;

public class PrintNaturalNumbers {

   static int N;
   int counter =1;

   public void printOddNumbers(){
    synchronized(this){

       while(counter<N){

          while(counter%2==0){
             try{
                wait();
             }
             catch(InterruptedException e){
                e.printStackTrace();
             }
          }

          System.out.print(counter + " ");

          counter++;

          notify();
       }

     }
   }

   public void printEvenNumbers() {
      synchronized (this) {
         while (counter < N) {

            while (counter % 2 == 1) {
               try {
                  wait();
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            }

            System.out.print(counter + " ");

            counter++;

            notify();
         }
      }
   }

   public static void main(String args[]){
      N=10;
      PrintNaturalNumbers pt = new PrintNaturalNumbers();

      Thread t1 = new Thread(new Runnable() {
         @Override
         public void run() {
            pt.printEvenNumbers();
         }
      });

      Thread t2 = new Thread(new Runnable() {
         @Override
         public void run() {
            pt.printOddNumbers();
         }
      });
      t1.start();
      t2.start();
   }
}
