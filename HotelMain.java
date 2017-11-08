package c9MISProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Jason Thomas
 *
 */

public class HotelMain {
	
	public static void main(String[] args) throws FileNotFoundException {
		// Scanner to read through text file line by line
		// prompt user for guest or manager through system.in
		// ask user for task to perform through system.in
		// ask how many rooms user wants? handicap accessible? Kitchen Y/n, etc.
		// and book room based on
		ArrayList<Double> rate = new ArrayList<Double>();
		ArrayList<Integer> bedCount = new ArrayList<Integer>();
		ArrayList<String> hasKitchen = new ArrayList<String>();
		ArrayList<String> handicapAccess = new ArrayList<String>();
		ArrayList<String> isBooked = new ArrayList<String>(); // could this be boolean
		ArrayList<String> needsUpkeep = new ArrayList<String>(); // same with this, boolean

		// Part 1: adding to ArrayList

		String inputFileName = "hotel.txt";
		File inputFile = new File(inputFileName);
		Scanner ins = new Scanner(inputFile);

		while (ins.hasNextLine()) {
			Double roomCost = ins.nextDouble();
			Integer beds = ins.nextInt();
			String kitchen = ins.next();
			String handicap = ins.next();
			String booked = ins.next();
			String upkeep = ins.next();

			rate.add(roomCost);
			bedCount.add(beds);
			hasKitchen.add(kitchen);
			handicapAccess.add(handicap);
			isBooked.add(booked);
			needsUpkeep.add(upkeep);

			//Part 2: taking input from user
			Scanner in = new Scanner(System.in);

			boolean more = true;
			while (more) {
				System.out.println("Are you a G)uest or M)anager user? (G/M)");
				String cmd = in.nextLine();

				if (cmd.equalsIgnoreCase("G")) {
					System.out.println("Would you like to B)ook a reservation, V)iew your current reservation, C)heck in, check O)ut, or Q)uit?");
					cmd = in.nextLine();
					if (cmd.equalsIgnoreCase("B")) {

					} else if (cmd.equalsIgnoreCase("V")) {

					} else if (cmd.equalsIgnoreCase("C")) {

					} else if (cmd.equalsIgnoreCase("O")) {

					} else if (cmd.equalsIgnoreCase("Q")) {
						in.close();
						System.exit(0);

					}
				} else if (cmd.equalsIgnoreCase("M")) {
					System.out.println("Would you like to check O)ccupany, view G)uest count, check what room needs U)pkeep, or Q)uit?");
					cmd = in.nextLine();
					if (cmd.equalsIgnoreCase("O")) {

					} else if (cmd.equalsIgnoreCase("G")) {

					} else if (cmd.equalsIgnoreCase("U")) {

					} else if (cmd.equalsIgnoreCase("Q")) {
						in.close();
						System.exit(0);
					}
				}
			}

		}
	}}
