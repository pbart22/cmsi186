/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  A clock.
 *  @author       :  Alissa Volosin
 *  Date          :  2019-08-06
 *  Description   :  Coming soon...
 *  Notes         :  Coming soon...
 *  Warnings      :  None
 *  Exceptions    :  Coming soon...
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.3.0  2019-01-05  A. Volosin    Update method code
 *  @version 2.1.0  2020-02-2   A. Volosin    Convert to Playground problem
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

// Use to format string output of a clock
import java.text.DecimalFormat;

public class Clock {
  /**
   *  Class field definitions go here
   */

   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 1.0;
   //private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double MAXIMUM_TIMESLICE_VALUE = 43500;


  // private fields
   private double[] timeJunque = new double[3];       // [0] = seconds, [1] = minutes, [2] = hours
   private double totalSeconds = 0.0;
   //private double hourHandDegrees = 0.0;
   //private double minuteHandDegrees = 0.0; 

  /**
   *  Constructor
   *   Not really anything to do here, all clocks are the same
   */
   public Clock() {
   }

  /**
   *  Method to calculate the next tick from the time increment
   *   each "tick" will be the number of seconds in the time slice
   *  @param  timeSlice double-precision value of the time slice being used
   *  @return three-element double array containing new seconds, minutes, and hours
   */
   public double[] tick(  double timeSlice ) {
      // Increase total second by timeSlice
      totalSeconds += timeSlice;
      // Update each value in timeJunque
      timeJunque[0]  = totalSeconds % 60;
      timeJunque[1]  = (int)(totalSeconds / 60) % 60;
      timeJunque[2]  = (int)totalSeconds / 3600;



      // Optional to have this method return a double for total seconds instead of
      // the time in an

      return timeJunque;
   }


  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   */
   public double validateTimeSliceArg( String argValue ) {
      double returnValue = 0.0;

      try {
         returnValue = Double.parseDouble( argValue );
      } catch (NumberFormatException nfe) {
         throw new NumberFormatException("the time slice is not a number");
      }
      // try to parse the arg to a double
      // catch the correct exception
      // throw number format exception if the time slice value is not a number
      // throw illegal argument exception if the time slice value is out of range

      if ( returnValue <= 0 || returnValue > MAXIMUM_TIMESLICE_VALUE) {
         throw new IllegalArgumentException (" Cannot have negative or 0 time slice or a time slice that exceeds 43,500.");
      }

      return returnValue;
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
      return totalSeconds;
   }

  /**
   *  Method to return a string representation of the clock
   *  @return String value of the clock, separated by colons
   */
   public String toString() {
      // This method has been completed for you
      DecimalFormat df  = new DecimalFormat( "00.0000" );
      DecimalFormat dfi = new DecimalFormat( "00" );
      return dfi.format(timeJunque[2]) + ":" + dfi.format(timeJunque[1]) + ":" + df.format(timeJunque[0]);
   }

  /**
   *  The main program starts here and should contain tests.
   *  Be sure to make LOTS of tests!!
   *  Remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {
      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock();
      System.out.println( "    New clock created: " + clock.toString() );

      System.out.println( "\nTESTING .TICK()\n" +
                          "-----------------\n" );
      try {
      Clock clock1 = new Clock(); 
      clock1.tick(2);
      System.out.println("clock1 with .tick(2): " + clock1.toString());
      clock1.tick(3);
      System.out.println("clock1 with .tick(3): "+ clock1.toString());
      clock1.tick(20);
      System.out.println("clock1 with .tick(20): " + clock1.toString());
      clock1.tick(100);
      System.out.println("clock1 with .tick(100): " + clock1.toString());
      clock1.tick(46);
      System.out.println("clock1 with .tick(46): " + clock1.toString());
      } catch (Exception e) {
      System.out.println("code not working properly");   
        }
      System.out.println();

      System.out.println("\nTESTING VALIDATE TIME SLICE ARGS\n" +
                "-----------------------------\n");
      System.out.println("Entering '0.03 seconds', expecting return of 0.03/Successful result");
      try {
      System.out.println((0.03 == clock.validateTimeSliceArg("0.03")) ? "        Result: Successful" : clock.validateTimeSliceArg("0.03"));
      } catch (Exception e) {
        System.out.println("          Result: Failed");
      }
      System.out.println();

      System.out.println("Entering '35.9 seconds', expecting return of 35.9/Succesful result");
      try {
        System.out.println((35.9 == clock.validateTimeSliceArg("35.9")) ? "        Result: Successful" : clock.validateTimeSliceArg("35.9"));
        } catch (Exception e) {
          System.out.println("        Result: Failed");
    }
    System.out.println();

        System.out.println("Entering '0 seconds', expecting an error/failed result");
        try {
          System.out.println(( 0 == clock.validateTimeSliceArg("0")) ? "       Result: Successful" : clock.validateTimeSliceArg("0"));
        } catch (Exception e) {
          System.out.println("        Result: Failed");
    }
    System.out.println();


        System.out.println("Entering '-45.4 seconds', expecting an error/failed result");
        try {
          System.out.println(( -45.4 == clock.validateTimeSliceArg("-45.4")) ? "       Result: Successful" : clock.validateTimeSliceArg("-45.4"));
        } catch (Exception e) {
          System.out.println("        Result: Failed");
    }
    System.out.println();

      System.out.println("Entering '35.9 seconds', expecting return of 185/Succesful result");
      try {
        System.out.println((185 == clock.validateTimeSliceArg("185")) ? "        Result: Successful" : clock.validateTimeSliceArg("185"));
        } catch (Exception e) {
          System.out.println("        Result: Failed");
    }
    System.out.println();

        System.out.println("Entering '46000 seconds', expecting an error/failed result");
        try {
          System.out.println(( 46000 == clock.validateTimeSliceArg("46000")) ? "       Result: Successful" : clock.validateTimeSliceArg("46000"));
        } catch (Exception e) {
          System.out.println("        Result: Failed");
    }
    System.out.println();

    System.out.println("\nTESTING GET TOTAL SECONDS\n" +
                          "--------------------------\n");
      System.out.println( "  Creating a new clock: " );
      Clock clock2 = new Clock();
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println();

      clock2.tick(180);
      clock2.tick(2);
      clock2.validateTimeSliceArg("36.7");
      System.out.println("Clock time after ticks of 180 and 2: " + clock2.toString());
      System.out.println("Total Number of seconds is: " + clock2.getTotalSeconds());
      System.out.println(); 
      clock2.tick(400);
      System.out.println("Time after tick of 400: " + clock2.toString());
      System.out.println("Total Number of seconds is: " + clock2.getTotalSeconds());
      System.out.println();
      clock2.tick(186.5);
      clock2.tick(23.6);
      clock2.tick(19.1);
      System.out.println("Time after ticks of 186.5, 23.6, and 19.1: " + clock2.toString());
      System.out.println("Total Number of seconds is: " + clock2.getTotalSeconds());
      System.out.println();
      clock2.tick(650.76);
      clock2.tick(98.45);
      clock2.tick(350.02);
      System.out.println("Time after ticks of 650.76, 98.45, and 350.02: "+ clock2.toString());
      System.out.println("Total Number of seconds is: " + clock2.getTotalSeconds());
      System.out.println();

      System.out.println("\n END OF TESTING FOR CLOCK CLASS\n" + 
                            "------------------------------");
  }
}
