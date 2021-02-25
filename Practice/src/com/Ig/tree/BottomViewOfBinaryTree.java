package com.Ig.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {

   public static void bottomView(Nodes root, int dist, int level, Map<Integer,NodeLevel<Integer,Integer>> map){

      if(root == null){
         return;
      }

      if(!map.containsKey(dist) || level >= map.get(dist).second){
          map.put(dist, NodeLevel.of(root.data,level));
      }

      bottomView(root.left, dist-1,level+1, map);
      bottomView(root.right, dist+1, level+1, map);
   }

   public static void printBottomView(Nodes root){
      Map<Integer, NodeLevel<Integer, Integer>> map = new TreeMap<>();
      //do pre-order traversal of the tree and fill the dictionary
      bottomView(root, 0, 0, map);
      //traverse the dictionary in sorted order of their keys and print the bottom view
      for (NodeLevel<Integer, Integer> it: map.values()) {
         System.out.print(it.first + " ");
      }
   }

   public static void main(String[] args)
   {
      Nodes root = new Nodes(1);
      root.left = new Nodes(2);
      root.right = new Nodes(3);
      root.left.right = new Nodes(4);
      root.right.left = new Nodes(5);
      root.right.right = new Nodes(6);
      root.right.left.left = new Nodes(7);
      root.right.left.right = new Nodes(8);

      printBottomView(root);
   }
}




