/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobIntTester.java
 * Purpose    :  Test Harness for the BrobInt java class
 * @author    :  A.Volosin
 * Date       :  2019-03-01
 * Description:  
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2019-03-01  A.Volosin     Initial writing and release
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class BrobIntTester {

   private static String g01String = "144127909719710664015092431502440849849506284148982076191826176553";
   private static String g02String = "144127909719710664015092431502440849849506284148982076191826176553";
   private static String g03String = "144127909719710664015092431502440849849506284108982076191826176553";
   private static String g04String = "14412790971971066401509243150244084984950628410898207";
   private static String g05String = "0";
   private static String g06String = "1";
   private static String g07String = "10";
   private static String g11String = "10";
   private static String g12String = "20";
   private static String g13String = "234567";
   private static String g14String = "-234567";
   private static String g15String = "-10";
   private static String g16String = "-999999";
   private static String g17String = "765";
   private static String g18String = "23";
   private static String g19String = "56789";
   private static String g20String = "37";
   // 21-40 are my personally created private constants
   private static String g21String = "1234783877382938729374298348372937423342492479237492374927";
   private static String g22String = "1234783877382938729374298348372937423342492479237492374927";
   private static String g23String = "45342332";
   private static String g24String = "-23424325";
   private static String g25String = "";
   private static String g26String = "Good day";
   private static String g27String = "-185";
   private static String g28String = "185";
   private static String g29String = "1!@#4%5";
   private static String g30String = "4";
   private static String g31String = "0000";
   private static String g32String = "100000000";
   private static String g33String = "2300";
   private static String g34String = "-4583";
   private static String g35String = "8989";
   private static String g36String = "-990";
   private static String g37String = "00123";
   private static String g38String = "467";
   private static String g39String = "2";
   private static String g40String = "435";

   private static BrobInt g1 = null;
   private static BrobInt g2 = null;
   private static BrobInt g3 = null;
   private static BrobInt g4 = null;
   private static BrobInt g5 = null;
   private static BrobInt g6 = null;
   private static BrobInt g7 = null;
   private static BrobInt g8 = null;
   private static BrobInt g9 = null;
   private static BrobInt g10 = null;
   private static BrobInt g11 = null;
   private static BrobInt g12 = null;
   private static BrobInt g13 = null;
   private static BrobInt g14 = null;
   private static BrobInt g15 = null;
   private static BrobInt g16 = null;
   private static BrobInt g17 = null;
   private static BrobInt g18 = null;
   private static BrobInt g19 = null;
   private static BrobInt g20 = null;
   // 21-40 are my personally created constants
   private static BrobInt g21 = null;
   private static BrobInt g22 = null;
   private static BrobInt g23 = null;
   private static BrobInt g24 = null;
   private static BrobInt g25 = null;
   private static BrobInt g26 = null;
   private static BrobInt g27 = null;
   private static BrobInt g28 = null;
   private static BrobInt g29 = null;
   private static BrobInt g30 = null;
   private static BrobInt g31 = null;
   private static BrobInt g32 = null;
   private static BrobInt g33 = null;
   private static BrobInt g34 = null;
   private static BrobInt g35 = null;
   private static BrobInt g36 = null;
   private static BrobInt g37 = null;
   private static BrobInt g38 = null;
   private static BrobInt g39 = null;
   private static BrobInt g40 = null;


   public BrobIntTester() {
      
   }

   public static void main( String[] args ) {
      BrobIntTester git = new BrobIntTester();

      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );

      System.out.println( "    TESTING CONSTRUCTOR AND CONSTANTS:\n" +
                          "    ==================================" );
      try {
         System.out.println( "    Test 001: Making a new BrobInt: " );
         g1 = new BrobInt( g01String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + g01String + "\n" +
                             "        and got: " + g1.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 002: Making a second new BrobInt [same as first]: " );
      try {
         g2 = new BrobInt( g02String );
         System.out.println( "      expecting: " + g02String + "\n" +
                             "        and got: " + g2.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 003: Comparing equality of g1 and g2 with 'equals()': " );
         System.out.println( "      expecting: true\n" + "        and got: " + g1.equals( g2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 004: Making a third new BrobInt [differs at position 47    |]: " +
                             "\n           [position indicated by down arrow]                  v   " );
         g3 = new BrobInt( g03String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + g03String + "\n" +
                             "        and got: " + g3.toString() );
         System.out.println( "          g1 is: " + g1.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 005: Comparing equality of g1 and g3 [detect different digit]: " );
         System.out.println( "      expecting: false\n" + "        and got: " + g1.equals( g3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 006: Making a fourth new BrobInt [same as g3 but truncated]: "  );
         g4 = new BrobInt( g04String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + g04String + "\n" +
                             "        and got: " + g4.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 007: Comparing equality of g3 and g4 [detect different length prior to detecting different digit]: " );
         System.out.println( "      expecting: false\n" + "        and got: " + g3.equals( g4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 008: Making a fifth new BrobInt, checking BrobInt.ZERO: "  );
         g5 = new BrobInt( "0" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + BrobInt.ZERO + "\n" +
                             "        and got: " + g5.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 009: Making a sixth new BrobInt, checking BrobInt.ONE: "  );
         g6 = new BrobInt( "1" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + BrobInt.ONE + "\n" +
                             "        and got: " + g6.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 010: Making a seventh new BrobInt, checking BrobInt.TEN: "  );
         g7 = new BrobInt( g07String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + BrobInt.TEN + "\n" +
                             "        and got: " + g7.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING VALUEOF( LONG ) METHOD:\n" +
                          "    ===============================" );
      System.out.println( "\n    Test 011: Creating several long type values to check the 'valueOf()' method: " );
      long long01 = Long.MAX_VALUE;
      long long02 = Long.MIN_VALUE;
      long long03 = 1234567890;
      try {
         System.out.println( "      expecting: " + Long.MAX_VALUE + "\n" +
                             "        and got: " + long01 );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + Long.MIN_VALUE + "\n" +
                             "        and got: " + long02 );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 1234567890\n" +
                             "        and got: " + long03 );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 012: Now testing 'valueOf()' method: " );
         g8  = BrobInt.valueOf( long01 );
         g9  = BrobInt.valueOf( long02 );
         g10 = BrobInt.valueOf( long03 );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + Long.MAX_VALUE + "\n" +
                             "        and got: " + g8.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + Long.MIN_VALUE + "\n" +
                             "        and got: " + g9.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 1234567890\n" +
                             "        and got: " + g10.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING ADD() METHODS:\n" +
                          "    ==========================" );
      try {
         System.out.println( "\n    Test 013: Making an eleventh and twelfth new BrobInt, calling add method: "  );
         g11 = new BrobInt( g11String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 10\n" +
                             "        and got: " + g11.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         g12 = new BrobInt( g12String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 20\n" +
                             "        and got: " + g12.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014: Adding g11 and g12: " );
         System.out.println( "      expecting: 30 and got " + g11.add( g12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 015: Making a thirteenth new BrobInt, calling add methods: "  );
      try {
         g13 = new BrobInt( g13String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 234567\n" +
                             "        and got: " + g13.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016: Adding g11 and g13 [10 + 234567] using bytes: " );
         System.out.println( "      expecting: 234577 and got " + g11.add( g13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 017: Adding g13 and g11 [234567 + 10] using bytes: " );
         System.out.println( "      expecting: 234577 and got " + g13.add( g11 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 018: Making a fourteenth new BrobInt, calling add methods: "  );
      try {
         g14 = new BrobInt( g14String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: -234567\n" +
                             "        and got: " + g14.toString() );
         System.out.println( "\n    Test 019: Making a fifteenth new BrobInt, calling add methods: "  );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         g15 = new BrobInt( g15String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: -10\n" +
                             "        and got: " + g15.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 020: Adding g14 and g15 [-234567 + -10] using bytes: " );
         System.out.println( "      expecting: -234577 and got " + g14.add( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 021: Adding g15 and g14 [-10 + -234567] using bytes: " );
         System.out.println( "      expecting: -234577 and got " + g15.add( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 022: Making a sixteenth new BrobInt, calling add methods: "  );
      try {
         g16 = new BrobInt( g16String );
         System.out.println( "      expecting: -999999\n" +
                             "        and got: " + g16.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 023: Adding g14 and g16 [-234567 + -999999] using bytes: " );
         System.out.println( "      expecting: -1234566 and got " + g14.add( g16 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 024: Adding g16 and g14 [-999999 + -234567] using bytes: " );
         System.out.println( "      expecting: -1234566 and got " + g16.add( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n      Test 025: Adding g1 and g4 using bytes: " );
         System.out.println( "      expecting: 144127909719725076806064402568842359092656528233967026820237074760\n" +
                             "        and got: " + g1.add( g4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING COMPARETO() METHOD:\n" +
                          "    ===========================\n" +
                          "    NOTE: this.compareTo(that) returns: -1 if this < that\n" +
                          "                               returns: +1 if this > that\n" +
                          "                               returns:  0 if this = that" );
      try {
         System.out.println( "\n    Test 026: Checking compareTo() method on g1.compareTo g2: "  );
         System.out.println( "      expecting: 0 and got: " + g1.compareTo( g2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 027: Checking compareTo() method on g2.compareTo g1: "  );
         System.out.println( "      expecting: 0 and got: " + g2.compareTo( g1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 028: Checking compareTo() method on g1.compareTo g3: "  );
         System.out.println( "      expecting: positive value and got: " + g1.compareTo( g3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 029: Checking compareTo() method on g3.compareTo g1: "  );
         System.out.println( "      expecting: negative value and got: " + g3.compareTo( g1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030: Checking compareTo() method on g3.compareTo g4: "  );
         System.out.println( "      expecting: positive value and got: " + g3.compareTo( g4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030a: Checking compareTo() method on 123456789.compareTo 234: "  );
         System.out.println( "      expecting: positive value and got: " + (new BrobInt("123456789").compareTo( new BrobInt("234"))) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030b: Checking compareTo() method on 123.compareTo 123456789: "  );
         System.out.println( "      expecting: ngative value and got: " + (new BrobInt("123").compareTo( new BrobInt("123456789"))) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030c: Checking compareTo() method on g3.compareTo 999: "  );
         System.out.println( "      expecting: positive value and got: " + g3.compareTo( new BrobInt( "999" ) ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030d: Checking compareTo() method on 1234.compareTo -999: "  );
         System.out.println( "      expecting: positive value and got: " + (new BrobInt("1234").compareTo( new BrobInt( "-999" ) ) ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030e: Checking compareTo() method on -999.compareTo G3: "  );
         System.out.println( "      expecting: negative value and got: " + new BrobInt( "-999" ).compareTo( g3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING SUBTRACTBYTE() METHOD:\n" +
                          "    ==============================" );
      System.out.println( "\n      Test 031: Subtracting g13 take away g11 [234567 - 10] using bytes: " );
      try {
         System.out.println( "      expecting: 234557\n" +
                             "        and got: " + g13.subtract( g11 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 032: Subtracting g11 take away g13 [10 - 234567] using bytes: " );
      try {
         System.out.println( "      expecting: -234557\n" +
                             "        and got: " + g11.subtract( g13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 033: Subtracting g13 take away g15 [234567 - (-10)] using bytes: " );
      try {
         System.out.println( "      expecting: 234577\n" +
                             "        and got: " + g13.subtract( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 034: Subtracting g15 take away g13 [(-10) - 234567] using bytes: " );
      try {
         System.out.println( "      expecting: -234577\n" +
                             "        and got: " + g15.subtract( g13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 035: Subtracting g14 take away g16 [(-234567) - (-999999)] using bytes: " );
      try {
         System.out.println( "      expecting: 765432\n" +
                             "        and got: " + g14.subtract( g16 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 036: Subtracting g16 take away g14 [(-999999) - (-234567)] using bytes: " );
      try {
         System.out.println( "      expecting: -765432\n" +
                             "        and got: " + g16.subtract( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037: Subtracting g1 take away g1 [too long to list] using bytes: " );
      try {
         System.out.println( "      expecting: 000000000000000000000000000000000000000000000000000000000000000000\n" +
                             "        and got: " + g1.subtract( g1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING MULTIPLY() METHOD:\n" +
                          "    ==========================" );
      System.out.println( "\n      Test 038: Multiplying g7 by g12 [10 * 20]: " );
      try {
         System.out.println( "      expecting: 200\n" +
                             "        and got: " + g7.multiply( g12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n    Test 039: Making a seventeenth new BrobInt: "  );
      try {
         g17 = new BrobInt( g17String );
         System.out.println( "      expecting: 765\n" +
                             "        and got: " + g17.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 040: Making a eightteenth new BrobInt: "  );
      try {
         g18 = new BrobInt( g18String );
         System.out.println( "      expecting: 23\n" +
                             "        and got: " + g18.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 041: Making a nineteenth new BrobInt: "  );
      try {
         g19 = new BrobInt( g19String );
         System.out.println( "      expecting: 56789\n" +
                             "        and got: " + g19.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 042: Making a twentieth new BrobInt: "  );
      try {
         g20 = new BrobInt( g20String );
         System.out.println( "      expecting: 37\n" +
                             "        and got: " + g20.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 043: Multiplying g17 by g18 [765 * 23]: " );
      try {
         System.out.println( "      expecting: 17595\n" +
                             "        and got: " + g17.multiply( g18 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 044: Multiplying g18 by g20 [23 * 37]: " );
      try {
         System.out.println( "      expecting: 851\n" +
                             "        and got: " + g18.multiply( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 045: Multiplying g19 by g20 [56789 * 37]: " );
      try {
         System.out.println( "      expecting: 2101193\n" +
                             "        and got: " + g19.multiply( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 046: Multiplying g18 by g17 [23 * 765]: " );
      try {
         System.out.println( "      expecting: 17595\n" +
                             "        and got: " + g18.multiply( g17 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 047: Multiplying g17 by g19 [765 * 56789]: " );
      try {
         System.out.println( "      expecting: 43443585\n" +
                             "        and got: " + g17.multiply( g19 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048: Multiplying g20 by g19 [37 * 56789]: " );
      try {
         System.out.println( "      expecting: 2101193\n" +
                             "        and got: " + g20.multiply( g19 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n\n    TESTING DIVIDE() METHOD:\n" +
                          "    ========================" );
      System.out.println( "\n      Test 049: Dividing g19 by g20 [56789 / 37]: " );
      try {
         System.out.println( "      expecting: 1534\n" +
                             "        and got: " + g19.divide( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050: Dividing g17 by g20 [765 / 37]: " );
      try {
         System.out.println( "      expecting: 20\n" +
                             "        and got: " + g17.divide( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n\n    TESTING REMAINDER() METHOD:\n" +
                          "    ===========================" );
      System.out.println( "\n      Test 051: Modding g17 by g18 [765 % 23]: " );
      try {
         System.out.println( "      expecting: 6\n" +
                             "        and got: " + g17.remainder( g18 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052: Modding g19 by g20 [56789 % 37]: " );
      try {
         System.out.println( "      expecting: 31\n" +
                             "        and got: " + g19.remainder( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
            System.out.println("    End of Provided Testing\n" +
                          "    ==================================" );



    /**
    * Start of personally created BrobInt tests
    */
    System.out.println("\n\n    Start of Personal Testing\n" +
                        "    ==================================" );
    System.out.println("\n\n    Testing CONSTRUCTOR, Equals(), and CONSTANTS\n" +
                        "    ==========================================" );
    try {
    	System.out.println("\n   Test 053: Making  Twenty-First BrobInt [g21]: ");
    	g21 = new BrobInt(g21String);
    }
    catch(Exception e) { System.out.println("        Exception thrown:  "); }
    try {
    	System.out.println("      expecting: " + g21String + "\n" +
    						"            and got: " + g21.toString());
    }
    catch(Exception e) { System.out.println("        Exception thrown:  "); }

    try {
    	System.out.println("\n   Test 054: Making Twenty-Second BrobInt [Same as the first]");
    	g22 = new BrobInt(g22String);
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }
    try {
    	System.out.println("      expecting: " + g22String + "\n" + 
    						"            and got: " + g22.toString());
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
    	System.out.println("\n   Test 055: Comparing equality between g21 and g23 with 'equals()':  ");
    	System.out.println("\n      expecting: true\n" + "       and got: " + g21.equals(g22));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
    	System.out.println("\n      Test 056: Making Twenty-Third BrobInt using g23");
    	g23 = new BrobInt(g23String);
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }
    try{
    	System.out.println("      expecting: " + g23String + "\n" +
    						"            and got: " + g23.toString());
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
    	System.out.print("\n  Test 057: Comparing equality between g21 and g23 with 'equals()':  ");
    	System.out.println("\n      expecting: false\n" + "      and got: " + g21.equals(g23));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
    	System.out.println("\n   Test 058: Making Twenty-Fourth BrobInt with g24");
    	g24 = new BrobInt(g24String);
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }
    try {
    	System.out.println("      expecting: " + g24String + "\n" +
    						"            and got: " + g24.toString());
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
    	System.out.println("\n   Test 059: Attempt at making BrobInt with invalid argument ['']: ");
    	g25 = new BrobInt(g25String);
    	System.out.println("\n      expecting: thrown error\n" + "      Instead got: " + g25.toString());
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    try {
    	System.out.println("\n   Test 060: Attempt at making BrobInt with Invlaid argument ['Good Bye']:  ");
    	g26 = new BrobInt(g26String);
    	System.out.println("\n       expecting: thrown error\n" + "      Instead got: " + g25.toString());
    }
    catch (Exception e) {System.out.println("        Exception thrown:  " + e.toString()); }

    try {
    	System.out.println("\n  Test 061: Creating Twenty-Fifth BrobInt: ");
    	g27 = new BrobInt(g27String);
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }
    try {
    	System.out.println("      expecting: " + g27String + "\n" +
    						"            and got: " + g27.toString());
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
    	System.out.println("\n   Test 062: Creating Twenty-Sixth BrobInt:  ");
    	g28 = new BrobInt(g28String);
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }
    try {
    	System.out.println("      expecting: " + g28String + "\n" +
    						"            and got: " + g28.toString());
    }
    catch (Exception e) {System.out.println("        Exception thrown:  "); }

    try {
    	System.out.println("\n   Test 063: Comparing equality between g28 and g27 using 'equals()':  ");
    	System.out.println("         expecting: false\n" + "        and got: " + g28.equals(g27));
    }
    catch (Exception e) { System.out.println("       Exception thrown:  "); }

    try {
    	System.out.println("\n   Test 064: Attempt at making BrobInt with Invlaid Argument ['1!@#4%5']");
    	g29 = new BrobInt(g29String);
    	System.out.println("\n       expecting: thrown Exception\n" + "        Instead got: " + g29.toString());
    }
    catch (Exception e) { System.out.println("        Exception thrown: Invalid Argument"); }

    try {
    	System.out.println("\n  Test 064: Making Twenty-Seventh BrobInt, testing BrobInt.FOUR:  ");
    	g30 = new BrobInt(g30String);
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }
    try{
    	System.out.println("      expecting: " + BrobInt.FOUR + "\n" +
    						"            and got: " + g30.toString());
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
    	System.out.println("\n   Test 065: Making Twenty-Eighth BrobInt, test BrobInt.ZERO with '0000':  ");
    	g31 = new BrobInt(g31String);
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }
    try {
    	System.out.println("      expecting: " + BrobInt.ZERO + "\n" +
    						"            and got: " + g31.toString());
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
    	System.out.println("\n  Test 066: Testing equality between g27 and g5 using 'equals()':   ");
    	System.out.println("\n      expecting: false\n" + "      and got: " + g5.equals(g27));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
    	System.out.println("\n   Test 067: Testing equality between g24 and g23 using 'equals()':  ");
    	System.out.println("\n      expecting: false\n" + "       and got: " + g24.equals(g23));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }



    System.out.println("\n\n   Testing Add() Method\n" +
                        "    ==================================" );
    try {
      System.out.println("\n   Test 068: Making Twenty-Nineth and Thirtyth BrobInt:  ");
      g32 = new BrobInt(g32String);
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }
    try {
      System.out.println ("      expecting: " + g32String + "\n" +
                     "             and got: " + g32.toString());
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }
    try {
      g33 = new BrobInt(g33String);
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }
    try {
      System.out.println("      expecting: " + g33String + "\n" +
                     "            and got: " + g33.toString());
    }
    catch (Exception e) { System.out.println("        Execption thrown:  "); }

    try {
      System.out.println("\n   Test 069: Adding g32 and g33 [100000000 + 2300]");
      System.out.println("      expecting 100002300 and got: " + g32.add(g33));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
      System.out.println("\n   Test 070: Making Thiry-First BrobInt:  ");
      g34 = new BrobInt(g34String);
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }
    try {
      System.out.println("      expecting: " + g34String + "\n" +
                     "            and got: " + g34.toString());
    }
    catch (Exception e) { System.out.println("         Exception thrown:  "); }

    try {
      System.out.println("\n   Test 071: Adding g34 and g34 [-4583 + -4583]:  ");
      System.out.println("      expecting -9166 and got: " + g34.add(g34));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
      System.out.println("\n   Test 072: Adding g34 and g24 [-4583 + -23424325:  ");
      System.out.println("      expecting -23428908 and got: " + g34.add(g24));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
      System.out.println("\n   Test 073: Adding g36 and g36 [-990 + -990]:  ");
      System.out.println("      expecting  -1980 and got: " + g36.add(g36));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
      System.out.println("\n   Test 074: Making Thrity-Second BrobInt:  ");
      g35 = new BrobInt(g35String);
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }
    try{
      System.out.println("      expecting: " + g35String + "\n" +
                     "            and got: " + g35.toString());
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
      System.out.println("\n   Test 075: Adding g35 and g33 [8989 + 2300]:  ");
      System.out.println("      expecting 11289 and got: " + g35.add(g33));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
      System.out.println("\n   Test 076: Adding g35 and g20 [8989 + 37]:  ");
      System.out.println("      expecting 9026 and got: " + g35.add(g20));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
      System.out.println("\n   Test 077: Adding g23 and g33 [45342332 + 2300]:  ");
      System.out.println("      expecting 45244632 and got: " + g23.add(g33));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
      System.out.println("\n   Test 078: Making Thrity-Third BrobInt:  ");
      g36 = new BrobInt(g36String);
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }
    try {
      System.out.println("      expecting: " + g36String + "\n" +
                     "            and got: " + g36.toString());
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
      System.out.println("\n   Test 079: Adding g36 and g34 [-990 + -4583]:  ");
      System.out.println("      expecting -5573 and got: " + g36.add(g34));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
      System.out.println("\n   Test 080: Adding an invalid argument, g29, with a valid argument g28 [1!@#4%5 + 185]:  ");
      System.out.println("      expecting: thrown exception" + "\n" + 
                     "            and got: " + g29.add(g28));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    try {
      System.out.println("\n   Test 081: Adding g31 and g5 [0000 + 0]:  ");
      System.out.println("      expecting 0 and got: " + g31.add(g5));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    try {
      System.out.println("\n   Test 082: Adding invlaid arguments g26 and g25 ['Good day' + '']:  ");
      System.out.println("      expecting: thrown Execption" + "\n" +
                     "            and got: " + g26.add(g25));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }



    System.out.println("\n\n    Testing Subtract() Method\n" +
                        "    ==================================" );

      System.out.println("\n    Test 083: Subtract g36 take away g34 [-990 - (-4583)] using bytes:  ");
      try {
      System.out.println("      expecting: 3593" + "\n" +
                     "            and got: " + g36.subtract(g34));   
      }
      catch (Exception e) { System.out.println("        Exception thrown:  "); }

      System.out.println("\n    Test 084: Subtract g31 take away g23 [0000 - 45342332] using bytes:  ");
      try {
         System.out.println("      expecting: -45342332" + "\n" +
                        "            and got: " + g31.subtract(g23));
      }
      catch (Exception e) { System.out.println("        Exception thrown:  "); }

      System.out.println("\n    Test 085: Subtract g23 take away g28 [45342332 - 185 using bytes:  ");
      try {
         System.out.println("      expecting: 45342147" + "\n" +
                        "            and got: " + g23.subtract(g29));
      }
      catch (Exception e) { System.out.println("        Exception thrown:  "); }

      try {
         System.out.println("\n    Test 086: Making Thirty-Fourth and Thirty-Fifth BrobInt:  ");
         g37 = new BrobInt(g37String);
      }
      catch (Exception e) { System.out.println("        Exception thrown:  "); }
      try {
         System.out.println("      expecting: " + g37String + "\n" +
                        "            and got: " + g37.toString());
      }
      catch (Exception e) { System.out.println("        Exception thrown:  "); }
      try{
         g38 = new BrobInt(g38String);
      }
      catch (Exception e) { System.out.println("        Exception thrown:  "); }
      try {
         System.out.println("      expecting: " + g38String + "\n" +
                     "               and got: " + g38.toString());
      }
      catch (Exception e) { System.out.println("        Exception thrown:  "); }

      System.out.println("\n    Test 087: Subtract g38 take away g37 [467 - 00123] using bytes:  ");
      try {
         System.out.println("      expecting: 344" + "\n" +
                        "            and got: " + g38.subtract(g37));
      }
      catch (Exception e) {System.out.println("        Exception thrown:  "); }

      System.out.println("\n    Test 088: Subtract g7 take away g11 [10 - 10] using bytes:  ");
      try {
         System.out.println("      expecting: 0" + "\n" +
                        "            and got: " + g7.subtract(g11));
      }
      catch (Exception e) { System.out.println("        Exception thrown:  "); }

      System.out.println("\n    Test 089: Subtract g1 take away g2 [to large to list] using bytes:  ");
      try {
         System.out.println("      expecting: 0" + "\n" +
                        "            and got: " + g1.subtract(g2));
      }
      catch (Exception e) { System.out.println("        Exception thrown:  "); }

      System.out.println("\n    Test 090: Subtract g38 take away g28 [467 - 185] using bytes:  ");
      try {
         System.out.println("      expecting: 282" + "\n" +
                        "            and got: " + g38.subtract(g28));
      }
      catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

      System.out.println("\n    Test 091: Subtract g26 take away g29 ['Good day' - 1!@#4%5] using bytes:  ");
      try {
         System.out.println("      expecting: thrown exception" + "\n" +
                        "            and got: " + g26.subtract(g29));
      }
      catch (Exception e) { System.out.println("        Exception thrown:  "); }

      System.out.println("\n    Test 092: Subtract g29 take away g33 [1!@#4%5 - 2300] using bytes:  ");
      try {
         System.out.println("      expecting: thrown exception" + "\n" +
                        "           and got: " + g29.subtract(g33));
      }
      catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

      System.out.println("\n    Test 093: Subtract g35 take away g33 [8989 - 2300] using bytes:  ");
      try {
         System.out.println("      expecting: 6689" + "\n" +
                        "            and got: " + g35.subtract(g33));
      }
      catch (Exception e) { System.out.println("        Exception thrown: "); }

    System.out.println("\n\n    Testing multiply() Method\n" +
                        "    ==================================" );

    System.out.println("\n    Test 094: Multiplying g33 by g35 [2300 * 8989]:  ");
    try {
      System.out.println("      expecting: 20674700" + "\n" +
                     "            and got: " + g33.multiply(g35));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 095: Multiplying g23 by g24 [45342332 * -23424325]:  ");
    try {
      System.out.println("      expecting: -1.062lle15" + "\n" +
                     "            and got: " + g23.multiply(g24));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 096: Multiplying g28 by g27 [185 * -185]:  ");
    try {
      System.out.println("      expecting: -34225" + "\n" +
                     "            and got: " + g28.multiply(g27));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 097: Multiplying g30 by g38 [4 * 467]:  ");
    try {
      System.out.println("      expecting: 1868" + "\n" +
                     "            and got: " + g30.multiply(g38));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 098: Multiplying g27 by g36 [-185 * -990:  ");
    try {
      System.out.println("      expecting: 183150" + "\n" +
                     "            and got: " + g27.multiply(g36));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    try {
      System.out.println("\n    Test 099: Making Thrity-Sixth and Thirty-Seventh BrobInt:  ");
      g39 = new BrobInt(g39String);
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }
    try {
      System.out.println("      expecting: " + BrobInt.TWO + "\n" +
                     "            and got: " + g39.toString());
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }
    try {
      g40 = new BrobInt(g40String);
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }
    try {
      System.out.println("      expecting: " + g40String + "\n" +
                     "            and got: " + g40.toString());
    }
    catch (Exception e) { System.out.println("        Exception thrown:  "); }

    System.out.println("\n    Test 100: Multiplying g39 by g40 [2 * 435]:  ");
    try {
      System.out.println("      expecting: 870" + "\n" +
                     "            and got: " + g39.multiply(g40));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 101: Multiplying g31 by g21 [to big to list]:  ");
    try {
      System.out.println("      expecting: 0" + "\n" +
                     "            and got: " + g31.multiply(g21));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 102: Multiplying g25 by g26 ['' * 'Good day']:  ");
    try {
      System.out.println("      expecting: thrown exception" + "\n" +
                     "            and got: " + g25.multiply(g26));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 103: Multiplying g26 by g29 ['Good day' + 1!@#4%5]:  ");
    try {
      System.out.println("      expecting: thrown exception" + "\n" +
                     "            and got: " + g26.multiply(g29));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 104: Multiplying g34 by g39 [-4583 * 2]:  ");
    try {
      System.out.println("      expecting: -9166" + "\n" +
                     "            and got: " + g34.multiply(g39));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }


    System.out.println("\n\n    Testing divide() Method\n" +
                        "    ==================================" );

    System.out.println("\n    Test 105: Dividing g33 by g30 [2300 / 4]:  ");
    try {
      System.out.println("      expecting: 575" + "\n" +
                    "             and got: " + g33.divide(g30));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 106: Dividing g32 by g40 [100000000 / 435]:  ");
    try {
      System.out.println("      expecting: 229885.057" + "\n" +
                    "             and got: " + g32.divide(g40));
    }
    catch (Exception e) {System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 107: Dividing g35 by g35 [ 8989 / 8989]:  ");
    try {
      System.out.println("      expecting: 1" + "\n" +
                     "            and got: " + g35.divide(g35));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 108: Dividing g33 by g35 [2300 / 0000]:  ");
    try {
      System.out.println("      expecting: thrown error" + "\n" +
                     "            and got: " + g33.divide(g35));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 109: Dividing g24 by g23 [-23424325 / 45342332]:  ");
    try {
      System.out.println("      expecting: -0.5166105" + "\n" +
                     "            and got: " + g24.divide(g23));
    }
    catch (Exception e) { System.out.println("       Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 110: g22 by g23 [too large to list]:  ");
    try {
      System.out.println("      expecting: 2.7232474e+49" + "\n" +
                     "            and got: " + g22.divide(g23));
    }
    catch (Exception e) {System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 111: Dividing g34 by g06 [-4583 / 1]:  ");
    try {
      System.out.println("      expecting: -4583" + "\n" +
                     "            and got: " + g34.divide(g6));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 112: Dividing g29 by g39 [1!@#4%5 / 2]:  ");
    try {
      System.out.println("      expecting: thrown exception" + "\n" +
                     "            and got: " + g29.divide(g39));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 113: Dividing g30 by g39 [4 / 2]:  ");
    try {
      System.out.println("      expecting: 2" + "\n" +
                     "            and got: " + g30.divide(g39));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 114: Dividing g25 by g40 ['' / 435]:  ");
    try {
      System.out.println("      expecting: thrown exception" + "\n" +
                     "            and got: " + g25.divide(g40));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 115: Divding g37 by g26 [00123 / 'Good day']:  ");
    try {
      System.out.println("      expecting: thrown exception" + "\n" +
                     "            and got: " + g37.divide(g26));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 116: Dividing g38 by g20 [467 / 37]:  ");
    try {
      System.out.println("      expecting: 12" + "\n" +
                     "            and got: " + g38.divide(g20));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }


    System.out.println("\n\n    Testing remainder() Method\n" +
                        "    ==================================" );

    System.out.println("\n    Test 117: Modding g33 by g28 [2300 % 185]:  ");
    try {
      System.out.println("      expecting: 80" + "\n" +
                     "            and got: " + g33.remainder(g28));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 118: Modding g28 by g27 [185 % -185]:  ");
    try {
      System.out.println("      expecting: 0" + "\n" +
                     "            and got: " + g28.remainder(g27));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 119: Modding g39 by g30 [2 % 4]"  );
    try {
      System.out.println("      expecting: 2" + "\n" +
                     "            and got: " + g39.remainder(g30));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 120: Modding g33 by g29 [2300 % 1!@#4%5]:  ");
    try {
      System.out.println("      expecting: thrown exception" + "\n" +
                     "            and got: " + g33.remainder(g29));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n    Test 122: Modding g34 by g36 [-4583 % -990]:  ");
    try {
      System.out.println("      expecting: -623" + "\n" +
                     "            and got: " + g34.remainder(g36));
    }
    catch (Exception e) { System.out.println("        Exception thrown:  " + e.toString()); }

    System.out.println("\n\n    End of Personal Tests\n" +
                        "    ==================================" );
    System.exit(0); 
   }
}