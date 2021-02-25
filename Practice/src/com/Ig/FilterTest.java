package com.Ig;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilterTest {

   public static void main(String[] args){
      List<Employee> employees = new ArrayList<>();

      employees.add(new Employee("tarun", LocalDate.parse("1977-01-01")));
      employees.add(new Employee("arun", LocalDate.parse("1967-01-01")));
      employees.add(new Employee("varun", LocalDate.parse("2000-01-01")));
      employees.add(new Employee("sarun", LocalDate.parse("1985-01-01")));
      employees.add(new Employee("barun", LocalDate.parse("1988-01-01")));
      employees.add(new Employee("karun", LocalDate.parse("1999-01-01")));

      employees.stream()
            .filter(Employee.ageGreaterThan(40).or(Employee.ageLesserThan(25)))
            .forEach(System.out::println);
   }
}
