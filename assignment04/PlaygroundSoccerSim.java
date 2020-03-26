/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  PlaygroundSoccerSim.java
 *  Purpose       :  A class for kicking an arbitrary number of balls on a playground and detecting a 
 *                   collision or a goal
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
import java.text.DecimalFormat;

public class PlaygroundSoccerSim {

  // private data for 
  //    - default playground height and width
  private static double DEFAULT_PLAYGROUND_HEIGHT = 500;
  private static double DEFAULT_PLAYGROUND_WIDTH = 500;
  //    - default time slice
  private static double DEFAULT_TIME_SLICE = 1.0;


  // private instance data for
  //    - are any balls still moving (still a chance of a collision)
  //    - time slice
  private double timeSlice = DEFAULT_TIME_SLICE;
  //    - playground size
  private double playGroundHeight = DEFAULT_PLAYGROUND_HEIGHT;
  private double playGroundWidth = DEFAULT_PLAYGROUND_WIDTH;
  //    - number of balls
  private int ballCount = 0;
  //    - array of soccer balls
  private Ball[] soccerBalls = null;
  //    - clock
  private Clock c = new Clock();
  private int[] ballsCollided;
  private int ball1Collided = 0;
  private int ball2Collided = 0;
  private int ball3Collided = 0;

  // You can put a private static final String here that includes the intro message
  //  or how to use the program
  private static final String introMessage = "\n Welcome to the Playground Soccer Simulation Program!" + 
    "\n You will need to enter a minium of 4 arguments: " + 
    "\n 1. Enter a number to describe the location of the ball (radius of 4.45) along the x-axis, the playground width is from -500 to 500." + 
    "\n 2. Enter a number to describe  the location of the ball along the y-axis, the playground height is from -500 to 500." +
    "\n 3. Enter a number to describe the speed of the ball in the x-direction." + 
    "\n 4. Enter a number to describe the speed of the ball in the y-dirction" + 
    "\n 5. This argument is optional, but if you want to you can enter a number that will set the time slice, the clock starts at 00:00:0000.";



   public PlaygroundSoccerSim() {
  
   }

  /**
   *  Method to validate the input arguments
   *  @param arguments String array of the arguments supplied to the program
   */
   public void validateArgsAndSetupSim( String arguments[])  {

    // if no arguments specified OR if number of arguments is NOT a factor of 4 
    // OR if number of arguments is NOT a factor of 4 plus 1
    // then dispay message about how to run this program, how it works
    // else if argument count % 4 is 1, assume last is timeslice in seconds
    // try to call validateTimeSliceArg from Clock class
    // else if argument count % 4 is 0, there is no optional time slice, use the defualt
    if (arguments.length % 4 == 0) {
      try {
        timeSlice = DEFAULT_TIME_SLICE;
      } catch (NumberFormatException nfe) {
        System.out.println("Make sure the inputs are in double format");
      } catch (IllegalArgumentException iae) {
        System.out.println("Please have at least 4 arguments");
      }
    } else if (arguments.length % 4 == 1) {
      try {
        timeSlice = Double.parseDouble(arguments[arguments.length - 1]);
      } catch (NumberFormatException nfe) {
        System.out.println("Make sure the inputs are in double format");
      } catch (IllegalArgumentException iae) {
        System.out.println("Remeber to type in at least 4 arguments");
      }
    } else {
      throw new IllegalArgumentException("Invalid number of arguments please enter at least 4.");
    }                  

    // now handle and validate the ball arguments
    //    - ballCount
    ballCount = (int)Math.floor(arguments.length / 4);
  
    // populate soccerBall array, similar to DiceSet
    // converting args to doubles should be in a try / catch   
    // java PlaygroungSS 4 4 1 1 5 5 2 2 6 6 3 3
     soccerBalls = new Ball[ballCount];

    for ( int i = 0; i < soccerBalls.length; i++ ){
        try {
          soccerBalls[i] = new Ball(Double.parseDouble(arguments[i * 4]),
                                    Double.parseDouble(arguments[i * 4 + 1]),
                                    Double.parseDouble(arguments[i * 4 + 2]),
                                    Double.parseDouble(arguments[i * 4 + 3]));

        } catch ( NumberFormatException nfe ){
          System.out.println("The arguments must be typed in as doubles, Examples: 1.0, 2.0, 1.5");
        }
    }

   }

  /**
   *  method to report the status of the simulation for every clock tick
   *  @param  c  Clock object which keeps track of time
   *  NOTE: this method calls the clock.tick() method to get one second to elapse
   */
   public void report() {
    for (int i = 0; i < soccerBalls.length; i++) {
      while (soccerBalls[i].isStillMoving() == true) {
        c.tick(timeSlice);
        soccerBalls[i].updateSpeedsForOneTick(timeSlice);
        System.out.println();
        System.out.println("Ball" + i + " " + "Progress Report at: " + c.toString());
        System.out.println("Ball" + i + " " + "Progress: " + soccerBalls[i].toString());
        simUpdate();
      } 
       DecimalFormat dfl = new DecimalFormat("#0.00");
        DecimalFormat dfs = new DecimalFormat("#0.0000");
        System.out.println("Ball" + i + " " + "is out of Bounds or has Stopped moving at time: " + c.toString() + " " + "location: " + "[" + dfl.format(soccerBalls[i].getPosition("x")) + ", " + dfl.format(soccerBalls[i].getPosition("y")) + "]" 
          + " " + "speed: " + "[" + dfs.format(soccerBalls[i].getSpeed("x")) + ", " + dfs.format(soccerBalls[i].getSpeed("y")) + "]");
        System.out.println();
    }
   }

  /**
   *  method to move the balls in the soccerBall array
   *
   */
   public void simUpdate() {
    // for each ball
    //  - if the ball is not out of bounds and not at rest, move the ball
    //  - if the ball is out of bounds after the move or at rest, set the ball out of bounds or at rest
    for (int i = 0; i < soccerBalls.length; i++) {
      if(soccerBalls[i].isBallOutOfBounds(DEFAULT_PLAYGROUND_WIDTH,DEFAULT_PLAYGROUND_HEIGHT) == false && soccerBalls[i].isStillMoving() == true) {
        soccerBalls[i].move(timeSlice);
      } 
      else if (soccerBalls[i].isBallOutOfBounds(DEFAULT_PLAYGROUND_WIDTH,DEFAULT_PLAYGROUND_HEIGHT) == true || soccerBalls[i].isStillMoving() == false) {
        soccerBalls[i].isStillMoving();
      }
    }
}
  /**
   *  method to check for a collision soccerBall array
   *
   */
   public boolean collisionCheck() {

    // Compare location of each ball, to every other ball in the array (unless the ball is out of bounds)
    // Use the distance formula (from our dart assignment) to determind if the balls have collided
    // balls have colided if their distance is <= the radius of ball 1 plus the radius of ball 2
    
    // you can decide what you want this method to return
    // if it returns an array of integers, perhaps the array should contain the indexes
    // of the two balls that collided
double ballRadius = 4.45;
    b1_outer: for (int i = 0; i < soccerBalls.length - 1; i++) {
      for (int j = i + 1; j < soccerBalls.length; j++) {
        if (Math.sqrt(Math.pow(soccerBalls[j].getPosition("x") - soccerBalls[i].getPosition("x"), 2) + Math.pow(soccerBalls[j].getPosition("y") - soccerBalls[i].getPosition("y"), 2)) <= ballRadius) {
          System.out.println("The balls that have collided are: " + "[" + (i + 1) + (j + 1) +"]");
          return true;
        }
         break b1_outer;
      }
      for (int k = i + 2; k < soccerBalls.length; k++) {
        if (Math.sqrt(Math.pow(soccerBalls[k].getPosition("x") - soccerBalls[i].getPosition("x"), 2) + Math.pow(soccerBalls[k].getPosition("y") - soccerBalls[i].getPosition("y"), 2)) <= ballRadius) {
          System.out.println("The balls that have collided are: " + "[" + (i + 1) + (k + 1) +"]");
          return true;
        }
        break b1_outer;
      }
      for (int l = i + 3; i < soccerBalls.length; i++) {
        if (Math.sqrt(Math.pow(soccerBalls[l].getPosition("x") - soccerBalls[i].getPosition("x"), 2) + Math.pow(soccerBalls[l].getPosition("y") - soccerBalls[i].getPosition("y"), 2)) <= ballRadius) {
          System.out.println("The balls that have collided are: " + "[" + (i + 1) + (l + 1) +"]");
          return true;
        }
        break b1_outer;
      }
    }

  b2_outer: for (int i = 1; i < soccerBalls.length - 2; i++) {
    for (int j = i + 1; j < soccerBalls.length; j++) {
      if (Math.sqrt(Math.pow(soccerBalls[j].getPosition("x") - soccerBalls[i].getPosition("x"), 2) + Math.pow(soccerBalls[j].getPosition("y") - soccerBalls[i].getPosition("y"), 2)) <= ballRadius) {
        System.out.println("The balls that have collided are: " + "[" + (i + 1) + (j + 1) +"]");
        return true;
      }
      break b2_outer;
    }
    for (int k = i + 2; k < soccerBalls.length; k++) {
      if(Math.sqrt(Math.pow(soccerBalls[k].getPosition("x") - soccerBalls[i].getPosition("x"), 2) + Math.pow(soccerBalls[k].getPosition("y") - soccerBalls[i].getPosition("y"), 2)) <= ballRadius) {
        ball2Collided = i;
        ballsCollided[1] = ball2Collided;
        System.out.println("The balls that have collided are: " + "[" + (i + 1) + (k + 1) +"]");
        return true;
      }
      break b2_outer;
    }
  }

  b3_outer: for (int i = 2; i < soccerBalls.length - 3; i++) {
    for (int j = i + 1; j < soccerBalls.length; j++) {
      if(Math.sqrt(Math.pow(soccerBalls[j].getPosition("x") - soccerBalls[i].getPosition("x"), 2) + Math.pow(soccerBalls[j].getPosition("y") - soccerBalls[i].getPosition("y"), 2)) <= ballRadius) {
        ball3Collided = i;
        ballsCollided[3] = ball3Collided;
        System.out.println("The balls that have collided are: " + "[" + (i + 1) + (j + 1) +"]");
        return true;
      }
      break b3_outer;
    }
  }
return false;
}


  /**
   *  main method of the simulation
   *  @param  args  String array of the command line arguments
   */
   public static void main( String args[] ) {
    PlaygroundSoccerSim myPSS = new PlaygroundSoccerSim();
    System.out.println(introMessage);
    System.out.println();

    myPSS.validateArgsAndSetupSim(args);
    myPSS.collisionCheck();
    myPSS.report();
  }
}
