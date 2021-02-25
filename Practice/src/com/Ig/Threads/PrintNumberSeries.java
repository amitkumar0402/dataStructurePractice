package com.Ig.Threads;

import java.util.concurrent.Semaphore;

public class PrintNumberSeries {

   private int n;
   private Semaphore zeroSem, oddSem, evenSem;

   public PrintNumberSeries(int n) {
      this.n = n;
      zeroSem = new Semaphore(1);
      oddSem = new Semaphore(0);
      evenSem = new Semaphore(0);
   }

   public void PrintZero() {
      for (int i = 0; i < n; ++i) {
         try {
            zeroSem.acquire();
         }
         catch (Exception e) {
         }
         System.out.print("0");
         // release oddSem if i is even or else release evenSem if i is odd
         (i % 2 == 0 ? oddSem : evenSem).release();
      }
   }

   public void PrintEven() {
      for (int i = 2; i <= n; i += 2) {
         try {
            evenSem.acquire();
         }
         catch (Exception e) {
         }
         System.out.print(i);
         zeroSem.release();
      }
   }

   public void PrintOdd() {
      for (int i = 1; i <= n; i += 2) {
         try {
            oddSem.acquire();
         }
         catch (Exception e) {
         }
         System.out.print(i);
         zeroSem.release();
      }
   }

   public static void main(String[] args) {

      PrintNumberSeries zeo = new PrintNumberSeries(5);

      Thread t1 = new PrintNumberSeriesThread(zeo,"zero");
      Thread t2 = new PrintNumberSeriesThread(zeo,"even");
      Thread t3 = new PrintNumberSeriesThread(zeo,"odd");

      t2.start();
      t1.start();
      t3.start();

   }
}


