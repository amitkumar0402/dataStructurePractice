package com.Ig.tree;

public class CheckNnodes {

   public static String findNodes(Node currentNode, int k){

      StringBuilder result = new StringBuilder();
      result = findKNodes(currentNode, k, result);

      return result.toString();

   }

   public static StringBuilder findKNodes(Node currentNode, int k, StringBuilder result){

      if(currentNode == null)
         return null;

      if(k==0){
         result.append(currentNode.getData() +",");
      }
      else{
         findKNodes(currentNode.getLeftChild(), k-1, result);
         findKNodes(currentNode.getRightChild(), k-1, result);
      }
      return result;

   }

   public static void main(String args[]) {

      BinarySearchTree bsT = new BinarySearchTree();


      bsT.add(6);
      bsT.add(4);
      bsT.add(9);
      bsT.add(5);
      bsT.add(2);
      bsT.add(8);
      bsT.add(12);

      System.out.println(findNodes(bsT.getRoot(), 2));

   }
}
