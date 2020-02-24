/**
 * By Ray Toal
 */



public class SharedBirthday {

    public static void main(String[] args) {
        try {
            if (args.length != 3) {
                throw new IllegalArgumentException("Exactly three arguments required");
            }
            int people = Integer.parseInt(args[0]);
            int days = Integer.parseInt(args[1]);
            int trials = Integer.parseInt(args[2]);
            System.out.println(probabilityEstimate(people, days, trials));
        } catch (NumberFormatException e) {
            System.err.println("Arguments must all be integers");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static double probabilityEstimate(int people, int days, int trials) {
        if (people < 2) {
            throw new IllegalArgumentException("Minimum of two people are required");
        }

        if (days < 1) {
            throw new IllegalArgumentException("Minimum of one day is required");
        }

        if (trials < 1) {
            throw new IllegalArgumentException("Minimum of one trial is required");
        }

    	int[] calenderDays = new int[days];
        int daysOver1Bday = 0; 

    	for (int t = 0; t < trials; t++){
            int sharedBdayCount = 0;
    		for (int i = 0; i < calenderDays.length; i++) {
    			calenderDays[i] = 0;
    		}

    	   for (int p = 0; p < people; p++) {
    		  int randomBirthday = (int) Math.floor(Math.random()*days);
                calenderDays[randomBirthday]++;
            }
    	
            // AV: This for loop should close before you check to see if sharedBdayCount >0
            for (int d = 0; d < days; d++) {
                if (calenderDays[d] > 1) {
                    sharedBdayCount++;
                }
            // close for loop here    
            
            // AV: check if sharedBdayCOunt > 0
    	   if (sharedBdayCount > 1) {
    		  daysOver1Bday++;
    	   }
    } // remove this closing curly bracket
}

        double bdayEstimate = (double) daysOver1Bday/trials;
        return bdayEstimate;

}
}
