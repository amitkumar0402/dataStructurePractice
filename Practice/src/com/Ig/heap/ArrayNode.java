package com.Ig.heap;

public class ArrayNode {
   int elementIndex;
   int arrayIndex;

   ArrayNode(int elementIndex, int arrayIndex) {
      this.elementIndex = elementIndex;
      this.arrayIndex = arrayIndex;
   }

   public int getElementIndex() {
      return elementIndex;
   }

   public void setElementIndex(int elementIndex) {
      this.elementIndex = elementIndex;
   }

   public int getArrayIndex() {
      return arrayIndex;
   }

   public void setArrayIndex(int arrayIndex) {
      this.arrayIndex = arrayIndex;
   }
}


