/**
 * By Ray Toal
 */

public class PiEstimator {
    
    public static void main(String[] args) {
        
        int defaultDarts = 10000;

        if (args.length != 1) {
            System.out.println("Invalid input: At least one integer argument needed, defaulting to 10,000");
        } else {
        try {
            defaultDarts = Integer.parseInt(args[0]);
        
         } catch (NumberFormatException nfe) {
            System.out.print("Invalid input: The argument must be an integer, Please try Again!");
            System.exit(0);
        }
    }

    System.out.println("Estimate of pi: " + estimate(defaultDarts));

        }
    


    public static double estimate(int darts) {
        int circleRadius = 1;
        double totalDartHits = 0;

         for (double i = 1; i < darts; i++) {   

            double positionX = (Math.random() * 2);
            double positionY = (Math.random() * 2);

            double dartsInsideCircle = Math.sqrt(Math.pow(positionX - circleRadius, 2) + Math.pow(positionY-circleRadius, 2));
        
            if (dartsInsideCircle <= circleRadius) {
                totalDartHits++;

            }

        }

    double piEstimate = 4 * (totalDartHits/darts);

    return piEstimate;

    }

    //
    // Don't be afraid to put in some private "helper" methods. You don't have to, of
    // course, but they could be useful and keep your code modular.
    //
}
