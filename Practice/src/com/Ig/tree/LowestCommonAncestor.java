package com.Ig.tree;

public class LowestCommonAncestor {

   public static int findLcaIterative(Node currentNode, int n1, int n2){
      while(currentNode!= null){
         if(currentNode.getData() > n1 && currentNode.getData() > n2){
            currentNode = currentNode.getLeftChild();
         }
         else if(currentNode.getData() <n1 && currentNode.getData() <n2){
            currentNode = currentNode.getRightChild();
         }
         else
            break;
      }
      return currentNode.getData();
   }

   private static Node findLcaRecursive(Node root, int n1, int n2) {
      if(root == null){
         return null;
      }
      if(root.getData() > n1 && root.getData() > n2){
       return  findLcaRecursive(root.getLeftChild(),n1,n2);
      }
      if(root.getData() < n1 && root.getData() < n2){
       return  findLcaRecursive(root.getRightChild(),n1,n2);
      }

      return root;

   }
   public static void main(String args[]){
      BinarySearchTree tree = new BinarySearchTree();
		/* Construct a binary tree like this
				6
			   / \
			  4   9
			 / \  |  \
			2	5 8	  12
					  / \
					 10  14
		*/
      tree.add(6);
      tree.add(4);
      tree.add(9);
      tree.add(2);
      tree.add(5);
      tree.add(8);
      tree.add(8);
      tree.add(12);
      tree.add(10);
      tree.add(14);
      Node lcaRecursive = findLcaRecursive(tree.getRoot(), 2,5);
      System.out.println("LCA RECURSIVE =" + lcaRecursive.getData());

      int lca = findLcaIterative(tree.getRoot(),2,5);
      System.out.println("LCA  Iterative=" + lca);


   }


}
