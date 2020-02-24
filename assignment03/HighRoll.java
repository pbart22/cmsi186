public class HighRoll {

	public static void main (String args[]) {
		System.out.println();
		System.out.println("\n                      Welcome to HighRoll!\n");
		System.out.println("             *************************************");
		System.out.println("\nRoll the dice and try to get the highest summed value possible.\n");
	
		int count = 0;
		int sides = 0;

		if (args.length < 2 || args.length > 2) {
			System.out.println("Program only takes two arguments: Number of dice, and number of sides on each die");
			System.exit(0);
		}

		try {
		count = Integer.parseInt(args[0]);
		sides = Integer.parseInt(args[1]);
		} catch (NumberFormatException nfe) {
			System.out.println("Please only enter the number of die and the number of sides you want!");
			System.out.println("                ************************************");
			System.out.println();
			}

		int highScore = 0;
		int sumOfDice = 0;
		DiceSet userDice = new DiceSet(count, sides);
		var console = System.console();

		System.out.println("\nYour current set of die is: " + userDice.toString());
		HighRoll.mainMenu();


		while (true){
			System.out.print("\n>>");

			try{
				String commandLine = console.readLine("Choose an option from the menu! ").trim();
				System.out.println();

				if('m' == commandLine.charAt(0)) {
					HighRoll.mainMenu();
				}
				else if ('r' == commandLine.charAt(0)) {
					userDice.roll();
					System.out.print("\nDice values after roll is: " + userDice.toString());
					System.out.println();
				}
				else if ('d' == commandLine.charAt(0)){
					String selectDie = console.readLine("Select a die to roll from your set ").trim();
					int selectedDieIndex = Integer.parseInt(selectDie) - 1;
					System.out.println("\nYou rolled a: " + userDice.rollIndividual(selectedDieIndex));
					System.out.println("\nYour current set is now: " + userDice.toString());
					System.out.println(); 
				}
				else if ('c' == commandLine.charAt(0)) {
					sumOfDice = userDice.sum();
					System.out.println("\nThe sum of all the die in your set is: " + sumOfDice);
					System.out.println("\nYour current set is: " + userDice.toString());
				}
				else if ('s' == commandLine.charAt(0)) {
					highScore = sumOfDice;
					System.out.println("\nYour high score of " + highScore + " has been saved");
					System.out.println("\nYour current set is: " + userDice.toString());
				}
				else if ('y' == commandLine.charAt(0)) {
					System.out.println("\nYour high score is: " + highScore);
					System.out.println("\nYour current set is: " + userDice.toString());
					System.out.println();
				}
				else if ('q' == commandLine.charAt(0)) {
					System.out.println("\nThank you for playing!\n");
					break;
				} 
				else {
					System.out.println("Option is not in the main menu, please try again!");
				}
				} catch(Exception e) {
				System.out.println("Please make sure your input is valid.");
				}
			}
		}
	

	public static void mainMenu() {
		System.out.println("\nBelow is the main Menu:");
		System.out.println();
		System.out.println();
		System.out.println("Press the [r] key to roll of the dice in set.");
		System.out.println("Press the [d] key to roll an individual die in the set");
		System.out.println("Press the [c] key to calculate your current score");
		System.out.println("Press the [s] key to save your score");
		System.out.println("Press the [y] key to display your high score");
		System.out.println("press the [q] key to quit the program");
		System.out.println("press the [m] key to display the main menu again");
		System.out.println();
		}
}


