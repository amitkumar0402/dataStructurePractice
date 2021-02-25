package com.Ig.tree;

public class KthMaximum {

   public static int findKthMax(Node root, int k) {

      StringBuilder result = new StringBuilder();
      result = findInOrderTraversal(root, result);
      String[] array = result.toString().split(",");
      if((array.length-k)>0)
         return Integer.parseInt(array[array.length -k]);

      return  -1;
   }

   private static StringBuilder findInOrderTraversal(Node root, StringBuilder result) {

      if(root.getLeftChild()!= null){
         findInOrderTraversal(root.getLeftChild(), result);
      }
      result.append(root.getData() +",");

      if(root.getRightChild()!= null){
         findInOrderTraversal(root.getRightChild(), result);
      }
      return  result;

   }

   public static void main(String args[]) {

      BinarySearchTree bsT = new BinarySearchTree();

      bsT.add(6);

      bsT.add(4);
      bsT.add(9);
      bsT.add(5);
      bsT.add(2);
      bsT.add(8);

      System.out.println(findKthMax(bsT.getRoot(),3));
   }
}



