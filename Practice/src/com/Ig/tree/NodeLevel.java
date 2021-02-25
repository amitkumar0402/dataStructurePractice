package com.Ig.tree;

public class NodeLevel<U,V>{
   public final U first;
   public final V second;

   private NodeLevel(U first,V second){
      this.first = first;
      this.second = second;
   }

   public static <U,V> NodeLevel<U,V> of(U a, V b){
      return new NodeLevel<>(a,b);
   }
}
