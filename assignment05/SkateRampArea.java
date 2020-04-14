import java.text.DecimalFormat;

public class SkateRampArea {

	// constants
	private static final int MINIMUM_ARG_COUNT = 3;
	private static final double DEFAULT_PERCENT = 0.01;
	private static final int MINIMUM_POLY_ARG_COUNT = 5;

	// private instance variables
	private static double[] coeffs = null;
	private static String function = "";
	private static double currentArea = 0.0;
	private static double previousArea = 0.0;
	private static double epsilon = DEFAULT_PERCENT;
	private static double percentChange = 100.0;
	private static double lowerBound = 0.0;
	private static double upperBound = 0.0;
	// n represents the rectangles (int n) from the calculatePolyArea and calculateSinArea method arguments
	private static int n = 0;
	private static DecimalFormat df = new DecimalFormat("#00.0000");

	/**
	* Constructor method
	*/
	public SkateRampArea() {

	}


	/**
	* method to check the arguments passed by the user and sets up all of the values to calculate.
	* @param args String array
	* @throws IllegalArgumentException
	*/
	public void validateArgsAndSetupIntegration(String[] args) {
		String[] functions = {"poly", "sin"};
		function = args[0];

		// Allows runMyTests method to be ran without throwing an iae
		if (function.equals("runTest")) {
			return;
		}

		// Making sure minimum argument requirments are met
		if (args.length < MINIMUM_ARG_COUNT) {
			throw new IllegalArgumentException ("\nPlease enter a minimum of 3 arguments\n Proper Format Ex: <function name> <coefficients> <lowerBound> <upperBound> <(optional) percentage>");
		} else if (function.contains(functions[0]) && args.length < MINIMUM_POLY_ARG_COUNT) {
			throw new IllegalArgumentException ("\nIf function is poly, enter a minimum of 5 arguments\n Proper Format Ex: <function name (poly)> <coefficient> <coefficient> <lowerBound> <upperBound> <(optional) percentage>");
		} else if (function.contains(functions[1]) && args.length < MINIMUM_ARG_COUNT) {
			throw new IllegalArgumentException ("\nIf function is sin, enter a minimum of 3 arguments\n Proper Format Ex: <function name (sin)> <coefficient> <lowerBound> <upperBound> <(optional) percentage>");
		}

		// Checking if last argument is a % and parsing the arguments as necessary
		if (args[args.length - 1].contains("%")) {
			if (function.contains(functions[0]) && args.length < 6) {
				throw new IllegalArgumentException ("\nIf function is poly and percentage argument is present, then at least 6 arguments are required\n Proper Format Ex: <function name (poly)> <coefficient> <coefficient> <lowerBound> <upperBound> <percentage>");
			} else if (function.contains(functions[1]) && args.length < 4) {
				throw new IllegalArgumentException ("\nIf function is sin and percentage argument is present, then at least 4 arguments are required\n Proper Format Ex: <function name (sin)> <coefficient> <lowerBound> <upperBound> <percentage>");
			}
			try {
				epsilon = (Double.parseDouble(args[args.length - 1].substring(0, args[args.length -1].length() - 1))) / percentChange;
				upperBound = Double.parseDouble(args[args.length - 2]);
				lowerBound = Double.parseDouble(args[args.length - 3]);
			} catch (IllegalArgumentException iae) {
				System.out.println("\nCould not parse percent argument or Upperbond/lowerBound arguments into a double, make sure to enter integers only");
			}
			if (upperBound < lowerBound) {
				throw new IllegalArgumentException ("\n Please enter lowerbound and upperBound arguments in numerical order\n Proper Format Ex: <function name> <coefficients> <lowerBound> <upperBound> <optional percentage>");
			}
		} else {
			epsilon = DEFAULT_PERCENT;
			try {
				upperBound = Double.parseDouble(args[args.length - 1]);
				lowerBound = Double.parseDouble(args[args.length - 2]);
			} catch (IllegalArgumentException iae) {
				System.out.println("Could not parse last two arguments into upperBound & lowerBound double, make sure to enter integers only");
			}
		}

		// Generating coefficient array
		if (function.contains(functions[0]) && args[args.length - 1].contains("%")) {
			try {
				int numCoeff = args.length - 4;
				coeffs = new double [numCoeff];
				for (int i = 0; i < numCoeff; i++) {
					coeffs[i] = Double.parseDouble(args[i + 1]);
				}
			} catch (IllegalArgumentException iae) {
				System.out.println("Could not find number of coefficients with the optional percent argument please only enter integers.");
			}
		} else if(function.contains(functions[0])) {
			try {
				int numCoeff = args.length - 3;
				coeffs = new double [numCoeff];
				for (int i = 0; i < numCoeff; i++) {
					coeffs[i] = Double.parseDouble(args[i + 1]);
				}
			} catch(IllegalArgumentException iae) {
				System.out.println("Could not find number of coefficients please only enter integers.");
			}
		} else if (function.contains(functions[1]) && args[args.length - 1].contains("%")) {
			try {
				int numCoeff = args.length - 4;
				coeffs = new double [numCoeff];
				for (int i = 0; i < numCoeff; i++) {
					coeffs[i] = Double.parseDouble(args[i + 1]);
				}
			} catch (IllegalArgumentException iae) {
				System.out.println("Could not find number of coefficients please only enter integers");
			}
		} else if (function.contains(functions[1])) {
			try {
				int numCoeff = args.length - 3;
				coeffs = new double [numCoeff];
				for (int i = 0; i < numCoeff; i++) {
					coeffs[i] = Double.parseDouble(args[i + 1]);
				}
			} catch (IllegalArgumentException iae) {
				System.out.println("Could not find number of coefficients please only enter integers");
			}
		}
	}


	/**
	* Method to calculate the area if args[0] is "poly"
	* @param lb double the lower bound
	* @param ub double the upper bound
	* @param coefficients array that contains command line arguments
	* @param n integer that represents number of rectangles needed in simulation
	* @return the calculated area
	*/
	public double calculatePolyArea(double lb, double ub, double[] coefficients, int n) {
		double midpoint = 0.0;
		double xCoord = 0.0;
		double yCoord = 0.0;
		
		while (true) {
			for (int i = 0; i < n; i++) {
				xCoord = (ub - lb) / n;
				midpoint = lb + (((ub - lb) / n) / 2) + (xCoord * i);

				for (int j = 0; j < coefficients.length; j++) {
					yCoord += coefficients[j] * Math.pow(midpoint, j);
				}
				currentArea += yCoord * xCoord;
				yCoord = 0.0;
			}

			if (Math.abs(1 - (currentArea/previousArea)) <= epsilon) {
				return currentArea;
			} else {
				previousArea = currentArea;
				currentArea = 0.0;
				System.out.print("\n Intervals Used: " + "[" + ((n++) + 1) + "]");
			}
		}
	}


	/** 
	* Method to Calculate the area if args[0] is "sin".
	* @param lb double the lower bound
	* @param ub double the upper bound
	* @param coefficients array that contains command line arguments
	* @param n integer that represents number of rectangles needed in simulation
	* @return the calculated area
	*/
	public double calculateSinArea(double lb, double ub, double[] coefficients, int n) {
		double midpoint = 0.0;
		double xCoord = 0.0;
		double yCoord = 0.0;

		while (true) {
			for (int i = 0; i < n; i++) {
				xCoord = (ub - lb) / n;
				midpoint = lb + (((ub - lb) / n) / 2) + (xCoord * i);
				if (coefficients.length >= 1) {
				for (int j = 0; j < coefficients.length; j++) {
						Math.sin(yCoord += coefficients[j] * Math.pow(midpoint, j));
					}
					currentArea += yCoord * xCoord;
				} else {
					yCoord = Math.sin(midpoint);
					currentArea += yCoord * xCoord;
				}
			}

			if (Math.abs(1 - (currentArea/previousArea)) <= epsilon) {
				return currentArea;
			} else {
				previousArea = currentArea;
				currentArea = 0.0;
				System.out.print("\n Intervals Used: " + "[" + ((n++) + 1) + "]");
			}
		}
	}




	/**
	* Method to reset the values back to zero
	* needs to be used if you want to run multiple tests, otherwise all other test output will be the same as the first test output
	*/
	private void reset(){
		lowerBound = 0.0;
		upperBound = 0.0;
		epsilon = 0.0;
		currentArea = 0.0;
		previousArea = 0.0;
		coeffs = new double [0];
	}


	/**
	* Method that runs a tests on the program
	*/
	private void runMyTest() {
		System.out.println("\n Testing Poly Arguments \n");

		SkateRampArea test = new SkateRampArea();
		System.out.println("Test 1 Arguments: {poly, 1.0, -2.1, 3.2, -10.0, +5.0, 10.0%} ");
		System.out.println("Testing valid function name with 6 arguments, should read last argument as a percentage, and assign other arguments to correct descriptors");
		try { 
			String[] test1 = {"poly", "1.0", "-2.1", "3.2", "-10.0", "+5.0", "10.0%"};
			test.validateArgsAndSetupIntegration(test1);
			System.out.println(" Lower Bound: " + lowerBound);
			System.out.println(" Upper Bound: " + upperBound);
			for (int i = 0; i < coeffs.length; i++) {
				System.out.println(" Coefficient: " + coeffs[i]);
			}
			System.out.println(" Percentage: " + epsilon);
			System.out.println("\n The area under the curve is: " + df.format(test.calculatePolyArea(lowerBound, upperBound, coeffs, n)) + "\n");
		} catch (Exception e) {
			System.out.println("Test 1 Failed");
		}
		test.reset();

		System.out.println("Test 2 Arguments: {poly, 1, 8, -2, 1, 4}");
		System.out.println("Testing valid function name with 5 arguments, should use DEFAULT_PERCENT and assign arguments to correct descriptors");
		try {
			String[] test2 = {"poly", "1", "8", "-2", "1", "4"};
			test.validateArgsAndSetupIntegration(test2);
			System.out.println(" Lower Bound: " + lowerBound);
			System.out.println(" Upper Bound: " + upperBound);
			for (int i = 0; i < coeffs.length; i++) {
				System.out.println(" Coefficient: " + coeffs[i]);
			}
			System.out.println(" Percentage: " + epsilon);
			System.out.println("\n The area under the curve is: " + df.format(test.calculatePolyArea(lowerBound, upperBound, coeffs, n)) + "\n");
		} catch (Exception e) {
			System.out.println("Test 2 Failed");
		}
		test.reset();

		System.out.println("Test 3 Arguments: {poly, 0, 1, 2}");
		System.out.println("Testing valid function name with invalid number of total arguments, should throw an Exception");
		try{
			String[] test3 = {"poly", "0", "1", "2",};
			test.validateArgsAndSetupIntegration(test3);
			System.out.println(" Lower Bound: " + lowerBound);
			System.out.println(" Upper Bound: " + upperBound);
			for (int i = 0; i < coeffs.length; i++) {
				System.out.println(" Coefficient: " + coeffs[i]);
			}
			System.out.println(" Percentage: " + epsilon);
			System.out.println("\n The area under the curve is: " + df.format(test.calculatePolyArea(lowerBound, upperBound, coeffs, n)) + "\n");
		} catch (Exception e) {
			System.out.println("Test 3 Failed\n");
		}
		test.reset();

		System.out.println("Test 4 Arguments: {poly, 2, 1, 2, 4, 1e-6%}");
		System.out.println("Testing valid poly argument with 1e-6% format for the percentage, should run program and calculate the area");
		try {
			String[] test4 = {"poly", "2", "1", "2", "4", "1e-6%"};
			test.validateArgsAndSetupIntegration(test4);
			System.out.println(" Lower Bound: " + lowerBound);
			System.out.println(" Upper Bound: " + upperBound);
			for (int i = 0; i < coeffs.length; i++) {
				System.out.println(" Coefficient: " + coeffs[i]);
			}
			System.out.println(" Percentage: " + epsilon);
			System.out.println("\n The area under the curve is: " + df.format(test.calculatePolyArea(lowerBound, upperBound, coeffs, n)) + "\n");
		} catch (Exception e) {
			System.out.println("Test 4 Failed");
		}
		test.reset();

		System.out.println("Test 5 Arguments: {poly, 2, 1, 2, 1e-6%");
		System.out.println("Test should fail, missing upperBound argument, if % is present then minimum of 6 arguments is needed");
		try {
			String[] test5 = {"poly", "2", "1", "2", "1e-6%"};
			test.validateArgsAndSetupIntegration(test5);
			System.out.println(" Lower Bound: " + lowerBound);
			System.out.println(" Upper Bound: " + upperBound);
			for (int i = 0; i < coeffs.length; i++) {
				System.out.println(" Coefficient: " + coeffs[i]);
			}
			System.out.println(" Percentage: " + epsilon);
			System.out.println("\n The area under the curve is: " + df.format(test.calculatePolyArea(lowerBound, upperBound, coeffs, n)) + "\n");
		} catch (Exception e) {
			System.out.println("Test 5 Failed");
		}
		test.reset();
		System.out.println("\nEnd of Poly Testing\n");
		System.out.println("**********************");

		System.out.println("\n Testing Sin Arguments \n");

		System.out.println("Test 1 Arguments: {sin, -0.22, +3.77}");
		System.out.println("Testing valid sin argument inputs, should not read any coefficients");
		try {
			String[] test1 = {"sin", "-0.22", "+3.77"};
			test.validateArgsAndSetupIntegration(test1);
			System.out.println(" Lower Bound: " + lowerBound);
			System.out.println(" Upper Bound: " + upperBound);
			for (int i = 0; i < coeffs.length; i++) {
				System.out.println(" Coefficient: " + coeffs[i]);
			}
			System.out.println(" Percentage: " + epsilon);
			System.out.println("\n The area under the curve is: " + df.format(test.calculateSinArea(lowerBound, upperBound, coeffs, n)) + "\n");
		} catch (Exception e) {
			System.out.println("Test 1 Failed\n");
		}
		test.reset();

		System.out.println("Test 2 Arguments: {sin, -0.22, +3.77, 4.6, -2.0, 8.76, 20%}");
		System.out.println("Testing valid sin argument inputs, with coefficients and percentage, should calculate area");
		try {
			String[] test2 = {"sin", "-0.22", "+3.77", "4.6", "-2.0", "8.76", "20%"};
			test.validateArgsAndSetupIntegration(test2);
			System.out.println(" Lower Bound: " + lowerBound);
			System.out.println(" Upper Bound: " + upperBound);
			for (int i = 0; i < coeffs.length; i++) {
				System.out.println(" Coefficient: " + coeffs[i]);
			}
			System.out.println(" Percentage: " + epsilon);
			System.out.println("\n The area under the curve is: " + df.format(test.calculateSinArea(lowerBound, upperBound, coeffs, n)) + "\n");
		} catch (Exception e) {
			System.out.println("Test 3 Failed\n");
		}
		test.reset();

			System.out.println("Test 3 Arguments: {sin, -0.22, 20%}");
			System.out.println("Invalid input, test should fail");
			try {
				String[] test3 = {"sin", "-0.22", "20%"};
				test.validateArgsAndSetupIntegration(test3);
				System.out.println(" Lower Bound: " + lowerBound);
				System.out.println(" Upper Bound: " + upperBound);
				for (int i = 0; i < coeffs.length; i++) {
					System.out.println(" Coefficient: " + coeffs[i]);
				}
				System.out.println(" Percentage: " + epsilon);
				System.out.println("\n The area under the curve is: " + df.format(test.calculateSinArea(lowerBound, upperBound, coeffs, n)) + "\n");
			} catch (Exception e) {
				System.out.println("Test 3 Failed\n");
			}
			test.reset();

			System.out.println("Test 4 Arguments: {sin, -0.22, 13, 1.5%}");
			System.out.println("Valid input with 4 arguments, should calculate area");
			try {
				String[] test4 = {"sin", "-0.22", "13", "1.5%"};
				test.validateArgsAndSetupIntegration(test4);
				System.out.println(" Lower Bound: " + lowerBound);
				System.out.println(" Upper Bound: " + upperBound);
				for (int i = 0; i < coeffs.length; i++) {
					System.out.println(" Coefficient: " + coeffs[i]);
				}
				System.out.println(" Percentage: " + epsilon);
				System.out.println("\n The area under the curve is: " + df.format(test.calculateSinArea(lowerBound, upperBound, coeffs, n)) + "\n");
			} catch (Exception e) {
				System.out.println("Test 4 Failed\n");
			}
			test.reset();

			System.out.println("Test 5 Arguments: {sin, 12}");
			System.out.println("invalid input should fail");
			try {
				String[] test5 = {"sin", "12"};
				test.validateArgsAndSetupIntegration(test5);
				System.out.println(" Lower Bound: " + lowerBound);
				System.out.println(" Upper Bound: " + upperBound);
				for (int i = 0; i < coeffs.length; i++) {
					System.out.println(" Coefficient: " + coeffs[i]);
				}
				System.out.println(" Percentage: " + epsilon);
				System.out.println("\n The area under the curve is: " + df.format(test.calculateSinArea(lowerBound, upperBound, coeffs, n)) + "\n");
			} catch (Exception e) {
				System.out.println("Test 5 Failed\n");
			}
			test.reset();

			System.out.println("\n End of Testing \n");
			System.out.println("*******************");
	} 



	/**
	* Main method to run program
	*/
	public static void main(String[] args) {
		SkateRampArea mySim = new SkateRampArea();
		mySim.validateArgsAndSetupIntegration(args);

		System.out.println("\n Welcome to the SkateRampArea Program!");
		switch(args[0]) {

			case "runTest": mySim.runMyTest();
							break;

			case "poly":System.out.println("\n Lower Bound: " + lowerBound);
						System.out.println(" Upper Bound: " + upperBound);
						for (int i = 0; i < coeffs.length; i++) {
							System.out.println(" Coefficient: " + coeffs[i]);
						}
						System.out.println(" Percetage: " + epsilon);
						System.out.println("\n The area under the curve is: " + df.format(mySim.calculatePolyArea(lowerBound, upperBound, coeffs, n)) + "\n");
							break;

			case "sin": System.out.println("\n Lower Bound: " + lowerBound);
						System.out.println(" Upper Bound: " + upperBound);
						for (int i = 0; i < coeffs.length; i++) {
							System.out.println(" Coefficient: " + coeffs[i]);
						}
						System.out.println(" Percetage: " + epsilon); 
						System.out.println("\n The area under the curve is: " + df.format(mySim.calculateSinArea(lowerBound, upperBound, coeffs, n)) + "\n");
							break;
		}
	}
}