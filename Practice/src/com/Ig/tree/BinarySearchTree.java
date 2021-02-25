package com.Ig.tree;

public class BinarySearchTree {
   private Node root;

   public Node getRoot() {
      return root;
   }

   public void setRoot(Node root) {
      this.root = root;
   }

   public Node recursive_insert(Node currentNode, int value) {

      if (currentNode == null) {
         return new Node(value);
      }

      if (value < currentNode.getData()) {
         currentNode.setLeftChild(recursive_insert(currentNode.getLeftChild(), value));
      } else if (value > currentNode.getData()) {
         currentNode.setRightChild(recursive_insert(currentNode.getRightChild(), value));
      } else {
         return currentNode;
      }
      return currentNode;

   }

   public boolean add(int value) {
      root = recursive_insert(this.root, value);
      return true;
   }


   public Node search(int value) {
      if (isEmpty())
         return null;
      return recursive_search(this.root, value);

   }

   private Node recursive_search(Node currentNode, int value) {
      if (currentNode == null || currentNode.getData() == value) {
         return currentNode;
      }

      if (value < currentNode.getData()) {
         return recursive_search(currentNode.getLeftChild(), value);
      } else {
         return recursive_search(currentNode.getRightChild(), value);
      }
   }

   public boolean isEmpty() {
      return root == null;
   }

   public void printTree(Node current) {
      if (current == null) return;

      System.out.print(current.getData() + ",");
      printTree(current.getLeftChild());
      printTree(current.getRightChild());

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
      bsT.add(10);
      bsT.add(14);
      bsT.printTree(bsT.getRoot());

      Node temp = bsT.search(5);
      if (temp != null) {
         System.out.println("\n" + temp.getData() + " found in Tree !");
      } else
         System.out.println("\n Not found in Tree !");

      temp = bsT.search(51);
      if (temp != null) {
         System.out.println("\n" + temp.getData() + " found in Tree !");
      } else
         System.out.println("\n Not found in Tree !");
   }

}
