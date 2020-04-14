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
	// n represents the rectanges (int n) from the calculatePolyArea and calculateSinArea method arguments
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
		if (args[0].equals("runTest")) {
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
					currentArea += yCoord *xCoord;
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
	* Method that runs a test for poly arguments
	*/
	private void runMyTestPoly() {
		System.out.println("\n Testing Poly Arguments \n");

		SkateRampArea polyTest = new SkateRampArea();
		System.out.println("Test Arguments: {poly, 1.0, -2.1, 3.2, -10.0, +5.0} ");
		System.out.println("Expected Result: parse through arguments and calulate area using DEFAULT_PERCENT");
		try { 
			String[] test = {"poly", "1.0", "-2.1", "3.2", "-10.0", "+5.0"};
			polyTest.validateArgsAndSetupIntegration(test);
			System.out.println(" Lower Bound: " + lowerBound);
			System.out.println(" Upper Bound: " + upperBound);
			for (int i = 0; i < coeffs.length; i++) {
				System.out.println(" Coefficient: " + coeffs[i]);
			}
			System.out.println(" Percetage: " + epsilon);
			System.out.println("\n The area under the curve is: " + df.format(polyTest.calculatePolyArea(lowerBound, upperBound, coeffs, n)) + "\n");
		} catch (Exception e) {
			System.out.println("Test Failed");
		}
	} 


	/**
	* Method that runs a test for sin arguments
	*/
	private void runMyTestSin() {
		System.out.println("\n Testing Sin Arguments \n");

		SkateRampArea sinTest = new SkateRampArea();
		System.out.println("Test Arguments: {sin, -0.27, +3.55}");
		System.out.println("Expected Result: parse through arguments and calulate area using DEFAULT_PERCENT and no coefficients");
		try {
			String[] test = {"sin", "-0.27", "+3.55"};
			sinTest.validateArgsAndSetupIntegration(test);
			System.out.println(" Lower Bound: " + lowerBound);
			System.out.println(" Upper Bound: " + upperBound);
			for (int i = 0; i < coeffs.length; i++) {
				System.out.println(" Coefficient: " + coeffs[i]);
			}
			System.out.println(" Percetage: " + epsilon);
			System.out.println("\n The area under the curve is: " + df.format(sinTest.calculateSinArea(lowerBound, upperBound, coeffs, n)) + "\n");
		} catch (Exception e) {
			System.out.println("Test Failed");
		}
	}

	/**
	* Main method to run program
	*/
	public static void main(String[] args) {
		SkateRampArea mySim = new SkateRampArea();
		mySim.validateArgsAndSetupIntegration(args);

		System.out.println("\n Welcome to the SkateRampArea Program!");
		switch(args[0]) {

			case "runTest": mySim.runMyTestPoly();
							mySim.runMyTestSin();
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