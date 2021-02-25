package com.Ig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {

   public static void main(String args[]){
       List<Person> persons = new ArrayList<>();

       persons.add(new Person("tarun", 28));
       persons.add(new Person("arun", 29));
      persons.add(new Person("varun", 12));
      persons.add(new Person("arun", 22));

      Collections.sort(persons, Comparator.comparing(Person::getFname).thenComparingInt(Person::getAge));
      System.out.println(persons);
      for(int k =-1;k>=-3;k--){
         System.out.println("seudocode");
      }
      /*Integer input1 =6;
      Integer input2 = 9;
      Integer result=null;
      for(int e =1;e<= input1 && e<=input2;e++){
         if(input1%e ==0 && input2%e ==0){
            result =e;
         }
      }
      System.out.println("Result ="+result);
*/


   }
}
