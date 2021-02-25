package com.Ig.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestCommonInBothArrays {
    public static int getMaximum(Integer[] arr1, Integer[] arr2){
       Set<Integer> hashSet = new HashSet<>(Arrays.asList(arr1));
       int currentMax = Integer.MIN_VALUE;
       for(Integer n: arr2){
          if(hashSet.contains(n)){
             if(currentMax<n){
                currentMax = n;
             }
          }
       }
       return currentMax;

    }

    public static void main(String args[]){
       Integer[] arr1= {1,4,7,9,10};
       Integer[] arr2 = {5,9,8};
       System.out.println("Maximum common number="+getMaximum(arr1,arr2));
    }
}
