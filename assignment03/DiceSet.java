/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  A. Volosin
 *  Date          :  2020-02.03
 *  Description   :  This helper class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then stolen from B.J. Johnson, then modified to show some 
 *                   interesting things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 *  @version 2.0.0  2019-02-03  A. Volosin    Update naming conventions and comments
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] ds = null;

   // public constructor:
  /**
   * This constructor is a method you will run to CREATE a DiceSet
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
    if (count <= 0 || sides < 4) {
      throw new IllegalArgumentException("Invalid values.");
    }

    this.count = count;
    this.sides = sides;
    this.ds = new Die[count];

    for (int i = 0; i < count; i++) {
      this.ds[i] = new Die(sides);
      this.ds[i].roll();
    }

   }

  /**
   * Sums up all dice in the DiceSet
   * @return the sum of all the dice values in the set
   */
   public int sum() {
    int sumDiceValue = 0;

    for (int i = 0; i < this.ds.length; i++) {
      sumDiceValue = sumDiceValue + this.ds[i].getValue();
    }

      return sumDiceValue;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  This method does not return anything, it just rolls new values for all die
   *  in the DiceSet.
   *  You will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
    for (int i = 0; i < this.ds.length; i++) {
     
      this.ds[i].roll();
    }
    
   }

  /**
   * Rolls a single die of the dice in this set indexed by 'dieIndex' to a random value
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @throws IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
    if (dieIndex > count || dieIndex < 0){
      throw new IllegalArgumentException("Index is out of range.");
    }

      return this.ds[dieIndex].roll();
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
    if (dieIndex > count || dieIndex < 0){
      throw new IllegalArgumentException("Index is out of range.");
   }

   return this.ds[dieIndex].getValue();

 }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
      String result = "";
      for (int i = 0; i < this.ds.length; i++) {
        result += this.ds[i].toString();
      }

      return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {
      return ds.toString();
   }



  /**
   * A little test main to check things out
   * Write tests that out put results of each method at least twice
   * This main method only serves as a tester.
   */
   public static void main( String[] args ) {
      DiceSet ds2 = new DiceSet(4, 6);
      try {
        System.out.println();
        System.out.println("Testing The Creation of a DiceSet");
        System.out.println("Successfully created ds2 of count 4 and sides 6");
        System.out.println(ds2.toString());
      } catch(IllegalArgumentException iae) {
        System.out.println("No DiceSet created, can't make a DiceSet of 0 die");
      }

      System.out.println();

      System.out.println("Testing Collective Roll of ds2");
      ds2.roll();
      System.out.println("New numbers after Collective roll are: " + ds2.toString());
      System.out.println();

      System.out.println("Testing the Sum Method for ds2");
      System.out.println();
      System.out.println("Sum of the Diceset is: " + ds2.sum());
      System.out.println();

      System.out.println("Testing the Roll Indiviual Method for ds2");
      try{
        ds2.rollIndividual(3);
        System.out.println("Value after individual roll is: " + ds2.toString());
        System.out.println("Testing sum after individual roll, the new sum is: " + ds2.sum());
      } catch(IllegalArgumentException iae) {
        System.out.println("Index is invalid");
      }

      System.out.println();

      System.out.println("Testing to get Indivual Die Value in ds2");
      try{
        System.out.println("Value of first die (index 0): " + ds2.getIndividual(0));
        System.out.println("Value of second die (index 1): " + ds2.getIndividual(1));
        System.out.println("Value of third die (index 2): " + ds2.getIndividual(2));
        System.out.println("Value of fourth die (index 3): " + ds2.getIndividual(3));
      } catch(IllegalArgumentException iae) {
        System.out.println("index is out of range");
      }

      System.out.println();

      System.out.println("Second Round of Testing with DiceSet ds3");
      DiceSet ds3 = new DiceSet(5, 8);
      try{
        System.out.println("Successfully created ds3 of count 5 and sides 8");
        System.out.println(ds3.toString());
      } catch(IllegalArgumentException iae) {
        System.out.println("No DiceSet created, can't make a DiceSet of 0 die");
      }

      System.out.println();

      System.out.println("Testing Collective Roll of ds3");
      ds3.roll();
      System.out.println("New value of ds3 after rolling all die are: " + ds3.toString());

      System.out.println("Testing the Sum of All Dice Values in ds3");
      System.out.println("The sum of the DiceSet is: " + ds3.sum());

      System.out.println();

      System.out.println("Testing Indiviual Roll Method for ds3");
      try {
       ds3.rollIndividual(2);
      System.out.println("Value after indivdual roll is: " + ds3.toString());
      ds3.rollIndividual(4);
      System.out.println("Value after individual roll is: " + ds3.toString());
      System.out.println();
      System.out.println("Testing sum() after indiviual roll, new sum of set is: " + ds3.sum()); 
      } catch(IllegalArgumentException iae) {
        System.out.println("Index is out of range");
      }

      System.out.println();

      System.out.println("Testing to get Indiviual Die Value in ds3");
      try{
        System.out.println("Value of first die (index 0): " + ds3.getIndividual(0));
        System.out.println("Value of second die (index 1): " + ds3.getIndividual(1));
        System.out.println("Value of third die (index 2): " + ds3.getIndividual(2));
        System.out.println("Value of fourth die (index 3): " + ds3.getIndividual(3));
        System.out.println("Value of fifth die (index 4): " + ds3.getIndividual(4));
      } catch(IllegalArgumentException iae) {
        System.out.println("Index is out of range");
      }

      System.out.println();
      System.out.println("End of DiceSet Testing");
      
      }

   }
