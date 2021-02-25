package com.Ig.heap;

public class Element {
   public Element(int number, int frequency, int sequenceNumber) {
      this.number = number;
      this.frequency = frequency;
      this.sequenceNumber = sequenceNumber;
   }

   public int getNumber() {
      return number;
   }

   public void setNumber(int number) {
      this.number = number;
   }

   public int getFrequency() {
      return frequency;
   }

   public void setFrequency(int frequency) {
      this.frequency = frequency;
   }

   public int getSequenceNumber() {
      return sequenceNumber;
   }

   public void setSequenceNumber(int sequenceNumber) {
      this.sequenceNumber = sequenceNumber;
   }

   int number;
   int frequency;
   int sequenceNumber;
}
