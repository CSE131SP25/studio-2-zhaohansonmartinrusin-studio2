package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Starting amount?");
		double startAmount = in.nextDouble();

		System.out.println("Win chance (between 0 and 100?");
		double winChance = in.nextDouble();
		

		System.out.println("Win limit?");
		double winLimit = in.nextDouble();
		
		System.out.println("How many days do you want to play?");
		double totalSimulations = in.nextDouble();
		
		double ruinCount = 0;
		int losses = 0; 

		for (int count = 1; count <= totalSimulations; count++) {
			System.out.println("Simulation " + count);
			double startAmount2 = startAmount;
			while (startAmount2 > 0 && startAmount2 < winLimit) {
				int outcome = (int) (Math.random() * 100) + 1;
				if (winChance > outcome) {
				startAmount2++;
				}
				else {
					startAmount2--;
				}
			
			}
			if (startAmount2 > 0) {
				System.out.println("win");
			}
			else {
				System.out.println("lose");
				ruinCount++;
				losses++;
		}
		}
		System.out.println("Losses: " + losses);
		System.out.println("Ruin Rate: " + ruinCount/totalSimulations);
		double a = (1 - winChance) / winChance;
		if (winChance == 50) {
			double expectedRuin = 1-(startAmount/winLimit);
			System.out.println(expectedRuin);
		}
		else {
			double expectedRuin = ((Math.pow(a, startAmount)) - (Math.pow(a, winLimit))) / (1 - Math.pow(a, winLimit));
			System.out.println(expectedRuin);

		}
		

	}

}
