package com.Ig.tree;

import java.util.HashMap;
import java.util.Map;


public class VerticalSumOfBinaryTree {

   public static void verticalSum(Nodes root, int dist, Map<Integer,Integer> map){
      if(root == null)
         return;

      verticalSum(root.left, dist-1, map);

      map.put(dist, map.getOrDefault(dist,0)+ root.data);

      verticalSum(root.right, dist+1, map);
   }


   public static void verticalSumofTree(Nodes root)
   {
      Map<Integer,Integer> map = new HashMap<>();

      verticalSum(root,0, map);

      if(map!= null){
         System.out.println(map.values());
      }
   }

   public static void main(String[] args)
   {
        /* Construct the following tree
                1
              /   \
             /     \
            2       3
                  /   \
                 /     \
                5       6
              /   \
             /     \
            7       8
        */

      Nodes root = new Nodes(1);
      root.left = new Nodes(2);
      root.right = new Nodes(3);
      root.right.left = new Nodes(5);
      root.right.right = new Nodes(6);
      root.right.left.left = new Nodes(7);
      root.right.left.right = new Nodes(8);

      verticalSumofTree(root);
   }
}








