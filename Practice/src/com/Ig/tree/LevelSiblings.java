package com.Ig.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelSiblings {

   public static void connectAllLevel(TreeNodeNext root) {
      if(root == null){
         return ;
      }

      Queue<TreeNodeNext> queue = new LinkedList<>();
      queue.offer(root);
      TreeNodeNext currentNode = null;
      TreeNodeNext previousNode = null;
      while(!queue.isEmpty()){
         currentNode = queue.poll();
         if(previousNode!= null)
            previousNode.next = currentNode;
         previousNode = currentNode;

         if(currentNode.left!= null){
            queue.offer(currentNode.left);
         }
         if(currentNode.right!= null){
            queue.offer(currentNode.right);
         }
      }

   }




   public static void main(String[] args) {
      TreeNodeNext root = new TreeNodeNext(12);
      root.left = new TreeNodeNext(7);
      root.right = new TreeNodeNext(1);
      root.left.left = new TreeNodeNext(9);
      root.right.left = new TreeNodeNext(10);
      root.right.right = new TreeNodeNext(5);
      connectAllLevel(root);
      root.printTree();

   }
}
