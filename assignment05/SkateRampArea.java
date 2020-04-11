import java.text.DecimalFormat;

public class SkateRampArea {

	// constants
	private static final int MINIMUM_ARG_COUNT = 3;
	private static final double DEFAULT_PERCENT = 0.01;
	private static final int MINIMUM_POLY_ARG_COUNT = 5;

	// private instance variables
	private double[] coeffs = null;
	private String function = "";
	private double currentArea = 0.0;
	private double previousArea = 0.0;
	private double epsilon = DEFAULT_PERCENT;
	private double lastArea = 0.0;
	private double percentChange = 100.0;
	private double lowerBound = 0.0;
	private double upperBound = 0.0;
	private DecimalFormat df = new DecimalFormat("#00.0000");

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
		if (args.length < MINIMUM_ARG_COUNT) {
			throw new IllegalArgumentException ("\nPlease enter a minimum of 3 arguments\n Proper Format Ex: <function name> <coefficients> <lowerBound> <upperBound> <(optional) percentage>");
		} else if (function.contains(functions[0]) && args.length < MINIMUM_POLY_ARG_COUNT) {
			throw new IllegalArgumentException ("\nIf function is poly, enter a minimum of 5 arguments\n Proper Format Ex: <function name (poly)> <coefficient> <coefficient> <lowerBound> <upperBound> <(optional) percentage>");
		} else if (function.contains(functions[1]) && args.length < MINIMUM_ARG_COUNT) {
			throw new IllegalArgumentException ("\nIf function is sin, enter a minimum of 3 arguments\n Proper Format Ex: <function name (sin)> <coefficient> <lowerBound> <upperBound> <(optional) percentage>");
		} else if (!function.contains(functions[0]) || !function.contains(functions[1])) {
			throw new IllegalArgumentException ("\n Make sure to enter the function name, either poly or sin");
		}

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

		if (function.contains(functions[0]) && args[args.length - 1].contains("%")) {
			try {
				int numCoeff = args.length - 3;
				coeffs = new double [numCoeff];
				for (int i = 0; i < numCoeff; i++) {
					coeffs[i] = Double.parseDouble(args[i + 1]);
				}
			} catch (IllegalArgumentException iae) {
				System.out.println("Could not find number of coefficients with the optional percent argument please only enter integers.");
			}
		} else {
			try {
				int numCoeff = args.length - 2;
				coeffs = new double [numCoeff];
				for (int i = 0; i < numCoeff; i++) {
					coeffs[i] = Double.parseDouble(args[i + 1]);
				}
			} catch(IllegalArgumentException iae) {
				System.out.println("Could not find number of coefficients please only enter integers.");
			}
		}
	}


	/**
	* Method to calculate the area under a poly curve using the lower bound, upper bound, coefficients, and number of rectangles
	* @param lb double the lower bound
	* @param ub double the upper bound
	* @param coefficients array that contains command line arguments
	* @param n integer that represents number of rectangles needed in simulation
	* @return the calulated area
	*/
	public double calculatePolyArea(double lb, double ub, double[] coefficients, int n) {
		double sum = 0.0;
		double yCoord = 0.0;
		double xCoord = ((ub - lb) / n);
		double startPoint = lb + (((ub - lb) / (n)) / 2);
		double midPoint = 0.0;

		for (int i = n; i > 0; i--) {
			yCoord = 0.0;
			midPoint = startPoint + ((n - i) * xCoord);

			for (int j = 0; j < coefficients.length; j++) {
				yCoord += (coefficients[i] * Math.pow(midPoint, i));
			}
			sum += yCoord * xCoord;
		}
		n++;
		return sum; 
	}
}