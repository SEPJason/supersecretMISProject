package c9MISProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Jason Thomas
 * @author Chris Pingel
 */

public class HotelMain {
	
	public static void main(String[] args) throws FileNotFoundException {
		// Scanner to read through text file line by line
		// prompt user for guest or manager through system.in
		// ask user for task to perform through system.in
		// ask how many rooms user wants? handicap accessible? Kitchen Y/n, etc.
		// and book room based on
		ArrayList<Integer> roomNum = new ArrayList<Integer>();
		ArrayList<Double> rate = new ArrayList<Double>();
		ArrayList<Integer> bedCount = new ArrayList<Integer>();
		ArrayList<String> hasKitchen = new ArrayList<String>();
		ArrayList<String> handicapAccess = new ArrayList<String>();
		ArrayList<String> isBooked = new ArrayList<String>(); // could this be boolean
		ArrayList<String> occupied = new ArrayList<String>();
		ArrayList<String> needsUpkeep = new ArrayList<String>(); // same with this, boolean

		// Part 1: adding to ArrayList

		String inputFileName = "hotel.txt";
		File inputFile = new File(inputFileName);
		Scanner ins = new Scanner(inputFile);

		while (ins.hasNext()) {
		
			roomNum.add(ins.nextInt());
			rate.add(ins.nextDouble());
			bedCount.add(ins.nextInt());
			hasKitchen.add(ins.next());
			handicapAccess.add(ins.next());
			isBooked.add(ins.next());
			occupied.add(ins.next());
			needsUpkeep.add(ins.next());
			
		}
		ins.close();

			//Part 2: taking input from user
			Scanner in = new Scanner(System.in);

			boolean more = true;
			int occCount = 0;
			int guestCount = 0;
				System.out.println("Login Menu:");
				System.out.println("Are you a Guest or Manager user?");
				String cmd = in.nextLine();
				while (more) {
				if (cmd.equalsIgnoreCase("Guest")) {
					System.out.println("Main Menu:");
					System.out.println("Would you like to B)ook a reservation, V)iew your current reservation, C)heck in, check O)ut, or Q)uit?");
					cmd = in.nextLine();
					if (cmd.equalsIgnoreCase("B")) {
						GuestUser.setReservation();
						System.out.println("Main Menu:");
						System.out.println("Would you like to check O)ccupany, view G)uest count, check what room needs U)pkeep, or Q)uit?");
						cmd = in.nextLine();
						
						//For Testing Purposes
						// Remember that arrays start at zero, so if we want to check rates for room 1 we have to input it as "roomNum.get(1-1);," room 2 would be "roomNum.get(2-1);."
						//for(int i = 0; i<rate.size(); i++){
						//	System.out.println(roomNum.get(i));
						//	System.out.println(rate.get(i));
						//	System.out.println(bedCount.get(i));
						//	System.out.println(hasKitchen.get(i));
						//	System.out.println(isBooked.get(i));
						//}
						
					} else if (cmd.equalsIgnoreCase("V")) {
						GuestUser.getReservation();
						System.out.println("Main Menu:");
						System.out.println("Would you like to check O)ccupany, view G)uest count, check what room needs U)pkeep, or Q)uit?");
						cmd = in.nextLine();
					} else if (cmd.equalsIgnoreCase("C")) {
						GuestUser.checkIn();
						System.out.println("Main Menu:");
						System.out.println("Would you like to check O)ccupany, view G)uest count, check what room needs U)pkeep, or Q)uit?");
						cmd = in.nextLine();
					} else if (cmd.equalsIgnoreCase("O")) {
						GuestUser.checkOut();
						System.out.println("Main Menu:");
						System.out.println("Would you like to check O)ccupany, view G)uest count, check what room needs U)pkeep, or Q)uit?");
						cmd = in.nextLine();
					} else if (cmd.equalsIgnoreCase("Q")) {
						System.out.print("Thank you for using our hotel service. Goodbye!");
						in.close();
						System.exit(0);

					}
				} 
				else if (cmd.equalsIgnoreCase("Manager")) {
					System.out.println("Main Menu:");
					System.out.println("Would you like to check O)ccupany, view G)uest count, check what room needs U)pkeep, or Q)uit?");
					cmd = in.nextLine();
					
					if (cmd.equalsIgnoreCase("O")) {
						for (int i = 0; i < occupied.size(); i++){
							if(occupied.get(i) == "Yes"){
								occCount++;
							}
						}
						System.out.println("Current occupancy is: " + occCount + " guests.");
						System.out.println("Main Menu:");
						System.out.println("Would you like to check O)ccupany, view G)uest count, check what room needs U)pkeep, or Q)uit?");
						cmd = in.nextLine();

					} else if (cmd.equalsIgnoreCase("G")) {
						for (int i = 0; i < roomNum.size(); i++){
							if(occupied.get(i) == "Yes"){
								guestCount = guestCount + bedCount.get(i);
							}
						}
						System.out.println("There are roughly " + guestCount + " guests currently checked in.");
						System.out.println("Main Menu:");
						System.out.println("Would you like to check O)ccupany, view G)uest count, check what room needs U)pkeep, or Q)uit?");
						cmd = in.nextLine();
					} else if (cmd.equalsIgnoreCase("U")) {
						
						for (int i = 0; i < needsUpkeep.size(); i++){
							if (needsUpkeep.get(i) == "Yes"){
								System.out.println("Room " + roomNum.get(i) + " needs upkeeping.");
							} else if (needsUpkeep.get(i) != "Yes"){
								System.out.println("Room " + roomNum.get(i) + " is in good condition.");
							}
						}
						System.out.println("Main Menu:");
						System.out.println("Would you like to check O)ccupany, view G)uest count, check what room needs U)pkeep, or Q)uit?");
						cmd = in.nextLine();
					} else if (cmd.equalsIgnoreCase("Q")) {
						System.out.print("Thank you for using our hotel service. Goodbye!");
						in.close();
						System.exit(0);
					}
				}
			}

		}
	}
