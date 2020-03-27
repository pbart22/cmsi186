/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  A class for a single ball that has a location and speed.
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

// Use to format string output of location and speed doubles
import java.text.DecimalFormat;

public class Ball {

   // Private class wide data
       private static final double BALL_RADIUS = 4.45; // radius in inches as given by the problem
       private static final double FRICTION_COEFFICIENT = .99; // one percent slowdown per second due to friction
       private static final int X_INDEX = 0; // index of X values within location and speed arrays
       private static final int Y_INDEX = 1; // index of Y values within location and speed arrays

   // Private instance data
       private boolean outOfBounds = false; // all balls will start in bounds by default
       private boolean atRest = false; // all balls will start moving by default
       private double[] ballLocation = new double[2];// array containing both coordinate values
       private double[] ballSpeed = new double[2];// array containing both direction speed values

  /**
   * Constructor to make a new Ball
   *  @param xLoc double-precision value of the X location of the ball
   *  @param yLoc double-precision value of the Y location of the ball
   *  @param xSpeed double-precision value for the initial speed of the ball in X direction
   *  @param ySpeed double-precision value for the initial speed of the ball in Y direction
   */
   public Ball( double xLoc, double yLoc, double xSpeed, double ySpeed ) {
      // To create an instance of a ball, set the private instance data equal to argument values
      ballLocation[X_INDEX] = xLoc;
      ballLocation[Y_INDEX] = yLoc;
      ballSpeed[X_INDEX] = xSpeed;
      ballSpeed[Y_INDEX] = ySpeed;

   }

  /**
   *  method to fetch the current speed of the ball
   *  @return  double-precision two-element array of X and Y speed values
   */
   public double[] getSpeed() {
      return ballSpeed;
   }

   public double getSpeed( String xy ) {
      if ( xy.equals("x") || xy.equals("X")) {
        return ballSpeed[X_INDEX];
      } else if (xy.equals("y") || xy.equals("Y ")) {
        return ballSpeed[Y_INDEX];
      } else {
        throw new IllegalArgumentException("Must Specify if you want the x or y speed");
      }
      // else if... equals y
      // else... throw exception

   }

  /**
   *  method to fetch the current position of the ball
   *  @return  double-precision two-element array of X and Y location values
   */
   public double getPosition(String xy) {
      if ( xy.equals("x") || xy.equals("X")) {
        return ballLocation[X_INDEX];
      } else if (xy.equals("y") || xy.equals("Y ")) {
        return ballLocation[Y_INDEX];
      } else {
        throw new IllegalArgumentException("Must Specify if you want the x or y location");
      }
  }
    


  /**
   *  method to flag the ball as "is still moving"
   *  @return  boolean true if ball is moving, false if at rest
   *  @note    at rest is defined as speed <= 1.0 inch/second
   */
   public boolean isStillMoving() {
    if (ballSpeed[X_INDEX] * 12 <= 1.0 && ballSpeed[Y_INDEX] * 12 <= 1.0) {
      return false;
    } else {
      return true;
    }
   }


  /**
   *  method to flag the ball as "out of bounds" which will set its speed to zero and its
   *    "outOfBounds" value to true so it will effectively no longer be in the simulation
   *  @param playgroundWidth    double-precision value of 1/2 the designated playground width
   *  @param playgroundHeight   double-precision value of 1/2 the designated playground height
   */
   public boolean isBallOutOfBounds( double playgroundWidth, double playgroundHeight ) {
      //Check to see if ball is out of bounds given a playground size
      if (ballLocation[X_INDEX] < (-playgroundWidth/2) || ballLocation[X_INDEX] > playgroundHeight/2 || ballLocation[Y_INDEX] < (-playgroundHeight/2) || ballLocation[Y_INDEX] > playgroundHeight/2) {
        ballSpeed[X_INDEX] = 0;
        ballSpeed[Y_INDEX] = 0;
        outOfBounds = true;
        return outOfBounds;
      }

      return false;
   }

  /**
   *  method to update the speed of the ball for one slice of time
   *  @param timeSlice     double-precision value of time slace for simulation
   *  @return  double-precision two element array of new velocity values
   */
   public double[] updateSpeedsForOneTick( double timeSlice ) {
     for (int i = 0;  i < timeSlice; i++){
      // Update x index of ballSpeed
      ballSpeed[X_INDEX] *= Math.pow(FRICTION_COEFFICIENT, timeSlice);
      // Update y index of ballSpeed
      ballSpeed[Y_INDEX] *= Math.pow(FRICTION_COEFFICIENT, timeSlice);      
     }

      return ballSpeed;
   }

  /**
   *  method to update the ball's position and velocity
   *  @param timeSlice     double-precision value of time slace for simulation
   */
   public void move( double timeSlice ) {
    for (int i = 0; i < timeSlice; i++){
      // Update x index of ballLocation
      ballLocation[X_INDEX] += ballSpeed[X_INDEX] * timeSlice;
      // Update y index of ballLocation
      ballLocation[Y_INDEX] += ballSpeed[Y_INDEX] * timeSlice;     
    }

   }

  /**
   *  "toString()" representation of this ball
   *  @return  String-y version of what this Ball is
   */
   public String toString() {
      // Use to format ball location
      DecimalFormat dfl = new DecimalFormat( "#0.00");

      // Use to format speed
      DecimalFormat dfs = new DecimalFormat( "#0.0000" );

      //  location and speed
      // OR
      //  Out of bounds
      // OR
      // at rest
      if (isStillMoving() == false) {
        return "Location: [" + dfl.format(ballLocation[X_INDEX]) + "," + dfl.format(ballLocation[Y_INDEX]) + "]" + " Speed: Ball is at rest.";
      } else if (outOfBounds == true) {
        return "Ball is out of bounds at " + "Location: [" + dfl.format(ballLocation[X_INDEX]) + "," + dfl.format(ballLocation[Y_INDEX]) + "]";
      } else {
        return "Location: [" + dfl.format(ballLocation[X_INDEX]) + "," + dfl.format(ballLocation[Y_INDEX]) + "]" + " Speed: [" + dfs.format(ballSpeed[X_INDEX]) + "," + dfs.format(ballSpeed[Y_INDEX]) + "]"; 
      }
   }

  /**
   * a main method for testing -- pretty simple
   *  @param args[] String array of command line arguments
   */
   public static void main( String args[] ) {
      System.out.println( "\n   Testing the Ball class b1................" );
      Ball b1 = new Ball( 10.0, 50.0, 2.0, 6.0 );
      
      System.out.println( "Ball b1: " + b1.toString() );
      b1.move( 1.0 );
      System.out.println("Ball b1 after move of 1.0: " + b1.toString());
      System.out.println("Ball b1 speed for X: " + b1.getSpeed("x"));
      System.out.println("Ball b1 speed for Y: " + b1.getSpeed("y"));
      b1.updateSpeedsForOneTick(20);
      System.out.println("Ball b1 updated speeds after one tick of 20: " + b1.getSpeed("x") + " " + b1.getSpeed("y"));
      System.out.println("Is Ball b1 currently out bounds with a playground hieght/width of 1000?" + " " + b1.isBallOutOfBounds(1000, 1000));
      System.out.println("What about a 10x10 sized playground?" + " " + b1.isBallOutOfBounds(10,10));
      System.out.println("What about a 100x150 sized Playground?" + " " + b1.isBallOutOfBounds(100, 150));
      System.out.println("Is Ball b1 still moving?" + " " + b1.isStillMoving());
      System.out.println("The current Position of Ball b1 is: " + "[" + b1.getPosition("x") + "," + b1.getPosition("y") + "]");

      System.out.println( "\n   Testing the Ball class b2................" );
      Ball b2 = new Ball(12.0, 75.0, 13.0, 10.0);

      System.out.println("Ball b2: " + b2.toString());
      System.out.println("The Current Position of Ball b2 is: " + "[" + b2.getPosition("x") + "," + b1.getPosition("y") + "]");
      b2.move(2.0);
      System.out.println("The New Position of Ball b2 after move of 2.0 is: " + "[" + b2.getPosition("x") + "," + b1.getPosition("y") + "]");
      b2.move(12.2);
      System.out.println("The New Position of Ball b2 after move of 12.2 is: " + "[" + b2.getPosition("x") + "," + b1.getPosition("y") + "]");
      b2.updateSpeedsForOneTick(15.6);
      System.out.println("Ball b2 updated speeds after tick of 15.2: " + "[" + b2.getSpeed("x") + "]" + "[" + b2.getSpeed("y") + "]");
      b2.updateSpeedsForOneTick(4);
      System.out.println("Ball b2 updated speeds after tick of 4: " + "[" + b2.getSpeed("x") + "]" + "[" + b2.getSpeed("y") + "]");
      System.out.println("Is Ball b2 still moving? " + b2.isStillMoving());
      System.out.println("Is Ball b2 out of bounds in a 235x300 sized playground? " + b2.isBallOutOfBounds(235, 300));
      System.out.println("What about a 600x600 sized playground? " + b2.isBallOutOfBounds(600,600));
      System.out.println("What about a 750x800 sized playground? " + b2.isBallOutOfBounds(750, 800));
   }

}