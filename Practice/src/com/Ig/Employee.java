package com.Ig;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Predicate;

public class Employee {
   String fname;

   @Override
   public String toString() {
      return "Employee{" +
            "fname='" + fname + '\'' +
            ", dob=" + dob +
            '}';
   }

   public String getFname() {
      return fname;
   }

   public void setFname(String fname) {
      this.fname = fname;
   }

   public LocalDate getDob() {
      return dob;
   }

   public void setDob(LocalDate dob) {
      this.dob = dob;
   }

   public Employee(String fname, LocalDate dob) {
      this.fname = fname;
      this.dob = dob;
   }

   LocalDate dob;

   public Employee(){

   }

   public static Predicate<Employee> ageGreaterThan(int number){
      return (employee)-> Period.between(employee.getDob(),LocalDate.now()).getYears()> number;

   }

   public static Predicate<Employee> ageLesserThan(int number){
      return (employee)-> Period.between(employee.getDob(),LocalDate.now()).getYears()< number;

   }
}
