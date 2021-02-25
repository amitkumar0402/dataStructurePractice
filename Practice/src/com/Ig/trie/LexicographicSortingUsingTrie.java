package com.Ig.trie;

import java.util.ArrayList;
import java.util.Arrays;

public class LexicographicSortingUsingTrie {
   //Recursive Function to generate all words in alphabetic order
   public static void getWords(TrieNode root, ArrayList<String> result, int level, char[] str) {
      if(root.isEndWord){
         String temp ="";
       for(int x =0;x< level;x++){
          temp += Character.toString(str[x]);
       }
       result.add(temp);
      }

      for(int i =0;i<26;i++){
         if(root.children[i] != null){
            str[level]= (char)(i+'a');
            getWords(root.children[i], result, level+1,str);
         }
      }

   }

   public static ArrayList<String> sortArray(String[] arr) {
      ArrayList<String> result = new ArrayList<String>();

      //Creating Trie and Inserting words from array
      Trie trie = new Trie();
      for (int x = 0; x < arr.length ; x++)
         trie.insert(arr[x]);

      char[] char_arr = new char[20];
      getWords(trie.getRoot(),result,0,char_arr);
      return result;
   }


   public static void main(String args[]) {
      // Input keys (use only 'a' through 'z' and lower case)
      String keys[] = {"the", "a", "there", "answer", "any",
            "by", "bye", "their", "abc"};

      Trie t = new Trie();

      System.out.println("Keys: " + Arrays.toString(keys));

      // Construct trie

      for (int i = 0; i < keys.length; i++)
         t.insert(keys[i]);


      ArrayList<String> list = sortArray(keys);
      for (int i = 0; i < list.size(); i++) {
         System.out.println(list.get(i));
      }
   }
}




