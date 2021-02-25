package com.Ig.systemDesign;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadderProblem {
   private static class Player{
      String playerName;
      int oldPosition;
      int currentPosition;
   }
   private static Scanner scanner = new Scanner(System.in);
   private static Random random = new Random();
   private static int noOfPlayers;
   private static Map<Integer, Integer> ladderPositionMap = new HashMap<>();
   private static Map<Integer, Integer> snakePositionMap = new HashMap<>();
   private static Map<Integer, Player> playerMap = new HashMap<>();

   public static void main(String[] args) {

      constructSnakePostion();
      constructLadderPostion();
      noOfPlayers = setUpNoOfPlayers();
      playGame();

   }

   private static void constructLadderPostion() {

      ladderPositionMap.put(3, 16);
      ladderPositionMap.put(5, 7);
      ladderPositionMap.put(15, 25);
      ladderPositionMap.put(18, 20);
      ladderPositionMap.put(21, 32);

   }

   private static void constructSnakePostion() {

      snakePositionMap.put(12, 2);
      snakePositionMap.put(14, 11);
      snakePositionMap.put(17, 4);
      snakePositionMap.put(31, 19);
      snakePositionMap.put(35, 22);

   }

   private static int setUpNoOfPlayers() {

      System.out.println("Input the no of player...");
      int noOfUsers = 0;

      try {

         noOfUsers = scanner.nextInt();

         for (int i = 1; i <= noOfUsers; i++) {
            Player player = new Player();
            player.playerName = "Player: " + i;
            playerMap.put(i, player);
         }

      } catch (Exception e) {
         e.printStackTrace();
      }

      return noOfUsers;
   }

   private static void playGame() {

      int currentPlayer = 1;

      while(true) {

         try {
            Thread.sleep(100);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }

         //scanner.nextLine();

         System.out.println("Its Player: " + currentPlayer
               + " chance to play, Role the dice by pressing enter...");

         Player player = playerMap.get(currentPlayer);
         player.oldPosition = player.currentPosition;

         //scanner.nextLine();

         int currentPosition = random.nextInt(6) + 1;

         System.out.println(player.playerName + " has rolled no "
               + currentPosition + " in the dice");

         player.currentPosition = player.oldPosition + currentPosition;

         Integer newLadderPosition = checkIfLadderExists(player,
               player.currentPosition);
         Integer newSnakePosition = checkIfSnakeExists(player,
               player.currentPosition);

         if (newLadderPosition == null && newSnakePosition == null) {
            System.out.println(player.playerName
                  + " has moved from the position: " + player.oldPosition
                  + " to position: " + player.currentPosition);
         }

         if (player.currentPosition >= 36) {
            System.out.println(player.playerName
                  + " has finished the game...");
            break;
         }

         if (noOfPlayers == currentPlayer) {
            currentPlayer = 1;
            continue;
         }

         currentPlayer++;

      }

   }

   private static Integer checkIfLadderExists(Player player,
                                              int currentPosition) {

      Integer newLadderPosition = ladderPositionMap.get(currentPosition);

      if (newLadderPosition != null) {

         player.currentPosition = newLadderPosition;
         System.out.println(player.playerName + " has found a ladder: "
               + "at position: " + currentPosition
               + " hence moving up to a new position: "
               + player.currentPosition + " from position: "
               + currentPosition);

      }

      return newLadderPosition;
   }

   private static Integer checkIfSnakeExists(Player player, int currentPosition) {

      Integer newSnakePosition = snakePositionMap.get(currentPosition);

      if (newSnakePosition != null) {

         player.currentPosition = newSnakePosition;
         System.out.println(player.playerName + " has found a snake: "
               + "at position: " + currentPosition
               + " hence moving down to a new position: "
               + newSnakePosition + " from position: " + currentPosition);

      }

      return newSnakePosition;
   }



}


