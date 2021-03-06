/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobInt.java
 * Purpose    :  Learning exercise to implement arbitrarily large numbers and their operations
 * @author    :  A. Volosin
 * Date       :  2019-03-01
 * Description:  @see <a href='http://volosin.lmu.build/alissa-volosin/cmsi-186-programming-lab/cmsi-186-assignments/assignment-06/'>Assignment 06</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2019-03-01  A. Volosin    Initial writing and begin coding
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;
import java.io.IOException;

public class BrobInt {
   /**
   * Constant for "zero"
   */
   public static final BrobInt ZERO = new BrobInt(  "0" );
      /**
   * Constant for "one"
   */
   public static final BrobInt ONE = new BrobInt(  "1" );
      /**
   * Constant for "two"
   */
   public static final BrobInt TWO = new BrobInt(  "2" );
      /**
   * Constant for "three"
   */
   public static final BrobInt THREE = new BrobInt(  "3" );
      /**
   * Constant for "four"
   */
   public static final BrobInt FOUR = new BrobInt(  "4" );
      /**
   * Constant for "five"
   */
   public static final BrobInt FIVE = new BrobInt(  "5" );
      /**
   * Constant for "six"
   */
   public static final BrobInt SIX = new BrobInt(  "6" );
      /**
   * Constant for "seven"
   */
   public static final BrobInt SEVEN = new BrobInt(  "7" );
      /**
   * Constant for "eight"
   */
   public static final BrobInt EIGHT = new BrobInt(  "8" );
      /**
   * Constant for "nine"
   */
   public static final BrobInt NINE = new BrobInt(  "9" );
      /**
   * Constant for "ten"
   */
   public static final BrobInt TEN      = new BrobInt( "10" );


  /// These are the internal fields
   /**
   * internal String representation of this BrobInt
   */
   public  String internalValue = "";
   /**
   * Variable that stores if the value is positive or negative, "0" is positive, "1" is negative
   */
   public  byte   sign = 0;
   /**
   * Array that stores user input for later use during calculations
   */
   public int[] storedValues = null;
   /**
   * variable to store sign if '-' so we can attach the '-' sign to the result of our calculations if necessary
   */
   public int signType = 0;


  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  value  String value to make into a BrobInt
   */
   public BrobInt( String value ) {

     // Checking for signs
     if (value.charAt(0) == '+'){
       sign = 0;
       this.internalValue = value.substring(1);
     } else if (value.charAt(0) == '-'){
       sign = 1;
       this.internalValue = value.substring(1);
     } else {
       this.internalValue = value;
       sign = 0;
     }

     // Checking of argumnets are valid and storing input in an array
     validateDigits();
     this.storedValues = new int[(internalValue.length()/9) + 1];
     int input = storedValues.length - 1;
     for (int i = internalValue.length(); i > 0; i -= 9){
       int stop = i;
       int start = stop - 9;
       if (input == 0){
         start = 0;
       }

       storedValues[input] = Integer.parseInt(internalValue.substring(start, stop));
       input--;
     }

   }

   /**  
   *  Method to validate that all the characters in the value are valid decimal digits
   *  @return  boolean  true if all digits are good
   *  @throws  IllegalArgumentException if something is hinky
   *  note that there is no return false, because of throwing the exception
   *  note also that this must check for the '+' and '-' sign digits
   */
   public void validateDigits() {
     for (int i = 0; i < internalValue.length(); i++){
       if(Character.isDigit(internalValue.charAt(i)) == false){
         throw new IllegalArgumentException("Illegal Argument at character: " + i);
       }
     }
   }

  /**
   *  Method to add the value of a BrobInt passed as argument to this BrobInt
   *  @param  bint         BrobInt to add to this
   *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
   */
   public BrobInt add( BrobInt bint ) {
     BrobInt min = null;
     BrobInt max = null;
     int carry = 0;

     // Checking if the sign is '-' or both and storing it so we can add it to our finalResult if necessary
     if (this.sign == 1 && bint.sign == 1) {
       signType = 1;
     }

     // Checking which value is bigger
     if (compareTo(bint) == 1) {
       min = bint;
       max = this;
     } else if ((compareTo(bint) == -1) || (compareTo(bint) == 0)) {
       min = this;
       max = bint;
     }

     // Checking to see if we are adding zeros
     if((max.allZeroDetect(max) == true) && (min.allZeroDetect(min) == true)) {
       return BrobInt.ZERO;
     }

    //Creating arrays to store values, both arrays will be the same length as the max
    // any difference in length will be offset by adding zeros into the empty spaces
     int[] minArray = new int[max.storedValues.length];
     int[] maxArray = new int[max.storedValues.length];
     for (int i = 0; i < maxArray.length; i++){
       minArray[i] = 000000000;
       maxArray[i] = 000000000;
     }
     int maxIndex = max.storedValues.length - 1;
     for (int i = min.storedValues.length - 1; i >= 0; i--) {
       minArray[maxIndex] = min.storedValues[i];
       maxIndex--;
     }
     for (int i = max.storedValues.length - 1; i >= 0; i--) {
       maxArray[i] = max.storedValues[i];
     }

     // Adding the values together
     int[] sum = new int[max.storedValues.length + 1];
     int sumIndex = max.storedValues.length;
     for (int i = max.storedValues.length - 1; i >= 0 ; i--) {
       sum[sumIndex] = minArray[i] + maxArray[i] + carry;
       if(sum[sumIndex] > 999999999) {
         sum[sumIndex] -= 1000000000;
         carry = 1;
       } else {
         carry = 0;
       }
       sumIndex--;
     }

     // Returning results
     String result = "";
     for (int i = 0; i < sum.length; i++) {
       result += sum[i];
     }
     if(signType == 1){
       result = "-" + result;
     }
     BrobInt totalSum = new BrobInt(result.toString());
     totalSum = removeLeadingZeros(totalSum);
     return totalSum;
   }

  /** 
   *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt
   *  @param  bint         BrobInt to subtract from this
   *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in
   */
   public BrobInt subtract( BrobInt bint ) {
     BrobInt min = null;
     BrobInt max = null;
     int borrow = 0;

     // Checking if argument is 0
     if(this.compareTo(bint) == 0) {
       return BrobInt.ZERO;
     }

     // Checking if signs are the same and determining which value is bigger
     if (this.sign == 0 && bint.sign == 0) {
           if (compareTo(bint) == 1) {
             min = bint;
             max = this;
             signType = 0;
           } else if (compareTo(bint) == -1) {
             min = this;
             max = bint;
             signType = 1;
           } else {
             min = this;
             max = bint;
           }
         }
         if (this.sign == 1 && bint.sign == 1) {
           if (compareTo(bint) == 1) {
             min = bint;
             max = this;
             signType = 1;
           } else if (compareTo(bint) == -1) {
             min = this;
             max = bint;
             signType = 0;
           } else {
             min = this;
             max = bint;
           }
         }

         // If subtracting a positive from a negative then add the two values together
         if (this.sign == 1 && bint.sign == 0) {
           signType = 1;
           if (compareTo(bint) == 1) {
             min = this;
             max = bint;
           } else if (compareTo(bint) == -1) {
             min = bint;
             max = this;
           } else {
             min = this;
             max = bint;
           }
           BrobInt sumPositive = this.add(bint);
           return sumPositive;
         }

         // If subtracting a negative from a positive then add the two values together
         if (this.sign == 0 && bint.sign == 1) {
           signType = 0;
           if (compareTo(bint) == 1) {
             min = this;
             max = bint;
           } else if (compareTo(bint) == -1) {
             min = bint;
             max = this;
           } else {
             min = this;
             max = bint;
           }
           BrobInt sumNeg = this.add(bint);
           return sumNeg;
         }

    //Creating arrays to store values, both will be set to length of max
    //Difference in size will be filled in by zeros
     int[] minArray = new int[max.storedValues.length];
     int[] maxArray = new int[max.storedValues.length];
     for (int i = 0; i < maxArray.length; i++) {
       minArray[i] = 000000000;
       maxArray[i] = 000000000;
     }
     int maxIndex = max.storedValues.length - 1;
     for (int i = min.storedValues.length - 1; i >= 0; i--) {
       minArray[maxIndex] = min.storedValues[i];
       maxIndex--;
     }
     for (int i = max.storedValues.length - 1; i >= 0; i--) {
       maxArray[i] = max.storedValues[i];
     }

     int[] difference = new int[max.storedValues.length + 1];
     int diffIndex = max.storedValues.length;
     for (int i = max.storedValues.length - 1; i >= 0 ; i--) {
       difference[diffIndex] = maxArray[i] - minArray[i] - borrow;
       if(difference[diffIndex] < 0) {
         difference[diffIndex] -= 1;
         borrow = 1000000000;
       } else {
         borrow = 0;
       }
       diffIndex--;
     }

     // Returning result
     String diffResult = "";
     for (int i = 0; i < difference.length; i++){
       diffResult += difference[i];
     }
     if(signType == 1){
       diffResult = "-" + diffResult;
     }
     BrobInt finalDifference = new BrobInt(diffResult.toString());
     finalDifference = removeLeadingZeros(finalDifference);
     return finalDifference;
   }

  /** 
   *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt
   *  @param  bint         BrobInt to multiply this by
   *  @return BrobInt that is the product of the value of this BrobInt and the one passed in
   */
   public BrobInt multiply( BrobInt bint ) {
     BrobInt min = null;
     BrobInt max = null;
     int carry = 0;
     int count = 0;

     // Checking sign
     if((this.sign == 1 && bint.sign == 1) || (this.sign == 0 && bint.sign == 0)) {
       signType = 0;
     } else {
       signType = 1;
     }
     if(compareTo(bint) == 1){
       min = bint;
       max = this;
     } else if ((compareTo(bint) == -1) || (compareTo(bint) == 0)) {
       min = this;
       max = bint;
     }

     // If either value is zero return zero
     if((max.allZeroDetect(max) == true) || (min.allZeroDetect(min) == true)) {
       return BrobInt.ZERO;
     }

    //Creating arrays to store values using max length, making up the difference in size by plugging in zeros
     int[] minArray = new int[max.storedValues.length];
     int[] maxArray = new int[max.storedValues.length];
     for (int i = 0; i < maxArray.length; i++) {
       minArray[i] = 000000000;
       maxArray[i] = 000000000;
     }
     int maxIndex = max.storedValues.length - 1;
     for (int i = min.storedValues.length - 1; i >= 0; i--) {
       minArray[maxIndex] = min.storedValues[i];
       maxIndex--;
     }
     for (int i = max.storedValues.length - 1; i >= 0; i--) {
       maxArray[i] = max.storedValues[i];
     }

     // Multiplying the values together
     long[] product = new long[max.storedValues.length * 2];
     for (int i = 0; i < product.length; i++) {
       product[i] = 0;
     }

     int productIndex = product.length - 1;
     for(int i = minArray.length - 1; i >= 0; i--) {
       for(int j = maxArray.length - 1; j >= 0; j--) {
         product[productIndex] += (long) maxArray[j] * (long) minArray[i] + (long) carry;
         if(product[productIndex] <= 999999999) {
           carry = 0;
         } else {
           while (product[productIndex] > 999999999) {
             product[productIndex] -= 1000000000;
             carry += 1;
           }
         }
         productIndex--;
       }
       count++;
       productIndex = max.storedValues.length * 2 - count;
     }

     // Returning result
     String productResult = "";
     for (int i = 0; i < product.length; i++) {
       productResult += product[i];
     }
     if (signType == 1) {
       productResult = "-" + productResult;
     }
     BrobInt finalProduct = new BrobInt(productResult.toString());
     finalProduct = removeLeadingZeros(finalProduct);
     return finalProduct;
   }

  /** 
   *  Method to divide the value of this BrobIntk by the BrobInt passed as argument
   *  @param  bint         BrobInt to divide this by
   *  @return BrobInt that is the dividend of this BrobInt divided by the one passed in
   */
   public BrobInt divide( BrobInt bint ) {
      BrobInt dividend = bint;
      BrobInt divisor = this;
      BrobInt d3;
      BrobInt quotient = new BrobInt("0");
      int index = 0;

      // Checking if dividend is a zero
      if (dividend.equals(BrobInt.ZERO)) {
        throw new IllegalArgumentException ("Cannot divide zero by anything");
      }

      // Return one if values are equal
      if (dividend.equals(divisor)) {
        return BrobInt.ONE;
      }

      // Dividing the values
      index = dividend.toString().length();
      d3 = new BrobInt(divisor.toString().substring(0, index));

      if (dividend.compareTo(d3) == 1) {
        index++;
        d3 = new BrobInt(divisor.toString().substring(0, index));
      }

      while (index <= divisor.toString().length()) {
        while ((d3.compareTo(dividend) == 1) || (d3.compareTo(dividend) == 0)) {
          d3 = d3.subtract(dividend);
          quotient = quotient.add(BrobInt.ONE);
        }
        if(index == divisor.toString().length()) {
          break;
        } else {
          index++;
        }
        d3 = d3.multiply(BrobInt.TEN);
        quotient = quotient.multiply(BrobInt.TEN);
        BrobInt digit = new BrobInt (divisor.toString().substring(index - 1, index));
        d3 = d3.add(digit);
      }
      return quotient;
   }

  /** 
   *  Method to get the remainder of division of this BrobInt by the one passed as argument
   *  @param  bint         BrobInt to divide this one by
   *  @return BrobInt that is the remainder of division of this BrobInt by the one passed in
   */
   public BrobInt remainder( BrobInt bint ) {
     BrobInt bint1 = this;
     BrobInt bint2 = bint;
     BrobInt result = bint1.subtract(bint1.divide(bint2).multiply(bint2));
     if(result.equals(BrobInt.ZERO)){
       return BrobInt.ZERO;
     } else {
       return result;
     }
   }

  /** 
   *  Method to compare a BrobInt passed as argument to this BrobInt
   *  @param  bint  BrobInt to compare to this
   *  @return int   that is one of neg/0/pos if this BrobInt precedes/equals/follows the argument
   *  NOTE: this method does not do a lexicographical comparison using the java String "compareTo()" method
   *        It takes into account the length of the two numbers, and if that isn't enough it does a
   *        character by character comparison to determine
   */
   public int compareTo( BrobInt bint ) {

      // remove any leading zeros because we will compare lengths
       String me  = removeLeadingZeros( this ).toString();
       String arg = removeLeadingZeros( bint ).toString();

      // handle the signs here
       if( 1 == sign && 0 == bint.sign ) {
          return -1;
       } else if( 0 == sign && 1 == bint.sign ) {
          return 1;
       } else if( 0 == sign && 0 == bint.sign ) {
         // the signs are the same at this point ~ both positive
         // check the length and return the appropriate value
         //   1 means this is longer than bint, hence larger positive
         //  -1 means bint is longer than this, hence larger positive
          if( me.length() != arg.length() ) {
             return (me.length() > arg.length()) ? 1 : -1;
          }
       } else {
         // the signs are the same at this point ~ both negative
          if( me.length() != arg.length() ) {
             return (me.length() > arg.length()) ? -1 : 1;
          }
       }

      // otherwise, they are the same length, so compare absolute values
       for( int i = 0; i < me.length(); i++ ) {
          Character a = Character.valueOf( me.charAt(i) );
          Character b = Character.valueOf( arg.charAt(i) );
          if( Character.valueOf(a).compareTo( Character.valueOf(b) ) > 0 ) {
             return 1;
          } else if( Character.valueOf(a).compareTo( Character.valueOf(b) ) < 0 ) {
             return (-1);
          }
       }
       return 0;
    }

 /**
   *  Method to check if a BrobInt passed as argument is equal to this BrobInt
   *  @param  bint     BrobInt to compare to this
   *  @return boolean  that is true if they are equal and false otherwise
   */
   public boolean equals( BrobInt bint ) {
      return (internalValue.equals( bint.toString() ));
   }

  /**
   *  Method to return a BrobInt given a long value passed as argument
   *  @param  value    long type number to make into a BrobInt
   *  @return BrobInt  which is the BrobInt representation of the long
   */
   public static BrobInt valueOf( long value ) throws NumberFormatException {
      BrobInt bi = null;
      try { bi = new BrobInt( Long.valueOf( value ).toString() ); }
      catch( NumberFormatException nfe ) { throw new NumberFormatException( "\n  Sorry, the value must be numeric of type long." ); }
      return bi;
   }

  /**
   *  Method to return a String representation of this BrobInt
   *  @return String  which is the String representation of this BrobInt and appends a "-" in front if value is negative
   */
   public String toString() {
     if(sign == 1){
       return "-" + internalValue;
     }
     return internalValue;
   }

  /**
   *  Method to remove leading zeros from a BrobInt passed as argument
   *  @param  bint     BrobInt to remove zeros from
   *  @return BrobInt that is the argument BrobInt with leading zeros removed
   *  Note that the sign is preserved if it exists
   */
   public BrobInt removeLeadingZeros( BrobInt bint ) {
      Character sign = null;
      String returnString = bint.toString();
      int index = 0;

      if( allZeroDetect( bint ) ) {
         return bint;
      }
      if( ('-' == returnString.charAt( index )) || ('+' == returnString.charAt( index )) ) {
         sign = returnString.charAt( index );
         index++;
      }
      if( returnString.charAt( index ) != '0' ) {
         return bint;
      }

      while( returnString.charAt( index ) == '0' ) {
         index++;
      }
      returnString = bint.toString().substring( index, bint.toString().length() );
      if( sign != null ) {
         returnString = sign.toString() + returnString;
      }
      return new BrobInt( returnString );

   }

  /**
   *  Method to return a boolean if a BrobInt is all zeros
   *  @param  bint     BrobInt to compare to this
   *  @return boolean  that is true if the BrobInt passed is all zeros, false otherwise
   */
   public boolean allZeroDetect( BrobInt bint ) {
      for( int i = 0; i < bint.toString().length(); i++ ) {
         if( bint.toString().charAt(i) != '0' ) {
            return false;
         }
      }
      return true;
   }

  /**
   *  Method to display an Array representation of this BrobInt as its bytes
   *  @param   d  byte array from which to display the contents
   *  NOTE: may be changed to int[] or some other type based on requirements in code above
   */
   public void toArray( int[] d ) {
      System.out.println( "Array contents: " + Arrays.toString( d ) );
   }

  /**
   *  the main method redirects the user to the test class
   *  @param  args  String array which contains command line arguments
   *  NOTE:  we don't really care about these, since we test the BrobInt class with the BrobIntTester
   */
   public static void main( String[] args ) {
      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );
      System.out.println( "\n   You should run your tests from the BrobIntTester...\n" );

      BrobInt b1 = null;;
      try { System.out.println( "   Making a new BrobInt: " ); b1 = new BrobInt( "147258369789456123" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try { System.out.println( "   expecting: 147258369789456123\n     and got: " + b1.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      System.out.println( "\n    Multiplying 82832833 by 3: " );
      try { System.out.println( "      expecting: 248498499\n        and got: " + new BrobInt("82832833").multiply( BrobInt.THREE ) ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n    Multiplying 3 by 82832833 and adding 1: " );
      try { System.out.println( "      expecting: 248498500\n        and got: " + BrobInt.THREE.multiply( new BrobInt( "82832833" ) ).add( BrobInt.ONE ) ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      System.exit( 0 );

   }

}


   

