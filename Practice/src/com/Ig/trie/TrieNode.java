package com.Ig.trie;

public class TrieNode {
   TrieNode[] children;
   boolean isEndWord;
   static int ALPHABET_SIZE =26;

   TrieNode(){
      this.children = new TrieNode[ALPHABET_SIZE];
      this.isEndWord = false;
   }

   public void markAsLeaf(){
      this.isEndWord = true;
   }

   public void unmarkAsLeaf(){
      this.isEndWord = false;
   }
}
