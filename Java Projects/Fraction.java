import java.io.*;
import java.util.*;

public class Fraction {

   public static void main(String[] args) {
   
   private int numerator;
   private int denominator;
   
   public Fraction(int numerator, int denominator) {
      this.numerator = numerator;
      this.denominator = denominator;
      if(this.denominator == 0) {
         this.denominator = 1;
      }
   }
   
   public Fraction() {
      numerator = 0;
      denominator = 1;
   }
   
   public void setNumerator(int userNumerator) {
      this.numerator = userNumerator;
   }
   
   public void setdenominator(int userDenominator) {
      this.denominator = userDenominator;
      if(this.denominator == 0) {
         this.denominator = 1;
      }
   }
   
   public int getNumerator() {
      return numerator;
   }
  
   public int getDenominator() {
      return denominator;
   }
   
   public static boolean isImproper() {
      if(numerator < denominator) {
         return false;
      }
      return true;
      }
   }
}