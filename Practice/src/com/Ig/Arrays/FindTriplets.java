package com.Ig.Arrays;

import java.util.HashSet;

public class FindTriplets {

   // Driver code
   public static void main(String[] args)
   {
      int arr[] = {0, -1, 2, -3, 1};
      int n = arr.length;
      findTripletsA(arr,n);
      findTriplets(arr, n);

   }

   public static void findTripletsA(int[] arr, int n) {
      boolean found = false;
      for(int i=0;i<n-1;i++){
         int l= i+1;
         int r= n-1;
         int x= arr[i];
         while(l<r){
            if(x+arr[l] +arr[r] ==0){
               System.out.print(x + " ");
               System.out.print(arr[l]+ " ");
               System.out.println(arr[r]+ " ");
               l++;
               r--;
               found = true;
            }
            else if(x + arr[l] + arr[r]<0){
               l++;
            }
            else{
               r--;
            }
         }
      }
      if(found == false){
         System.out.println("No Triplets found");
      }
   }

   public static void findTriplets(int[] arr, int n) {
     boolean found =false;
      for(int i=0;i<n-1;i++){
         HashSet<Integer> sumSet = new HashSet<>();
         for(int j=i+1;j<n;j++){
            int x = -(arr[i] + arr[j]);
            if(sumSet.contains(x)){
               System.out.printf("%d %d %d\n",x,arr[i],arr[j]);
               found =true;
            }
            else{
             sumSet.add(arr[j]);
            }
         }

   }
      if(found == false){
         System.out.println("No Triplets found");
      }
}

}
