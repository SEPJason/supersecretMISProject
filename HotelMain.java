package c9MISProject;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Jason Thomas, Ben Merz, Chris Pingel, Steve Weber
 *
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
		ArrayList<String> isBooked = new ArrayList<String>(); 
		ArrayList<String> occupied = new ArrayList<String>();
		ArrayList<String> needsUpkeep = new ArrayList<String>(); 

		// Part 1: adding to ArrayList

		String inputFileName = "hotel.txt"; // our base text file we're working off
		File inputFile = new File(inputFileName);
		Scanner ins = new Scanner(inputFile);

		while (ins.hasNext()) { // populates arraylists
		
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

			//Part 2: taking input from user and UI
			Scanner in = new Scanner(System.in);

			int occCount = 0; //variable that stores number of currently occupied rooms
			
			while(true){
				System.out.println("Login Menu:");
				System.out.println("Are you a Guest or Manager user?");
				String cmd = in.nextLine();
			
				if (cmd.equalsIgnoreCase("Guest")) { // guest user interface
					while(true){
						System.out.println("Main Menu:");
						System.out.println("Would you like to B)ook a reservation, V)iew your current reservation, C)heck in, check O)ut, P)rint bill, or Q)uit?");
						cmd = in.nextLine();
						if (cmd.equalsIgnoreCase("B")) { //case for booking reservations
							GuestUser.setReservation();	
						} else if (cmd.equalsIgnoreCase("V")) { //case for viewing current reservations
							GuestUser.getReservation();
						} else if (cmd.equalsIgnoreCase("C")) { //case for checking in
							GuestUser.checkIn();
						} else if (cmd.equalsIgnoreCase("O")) { // case for checking out
							GuestUser.checkOut();
						} else if (cmd.equalsIgnoreCase("P")){ // check prospective bill for room based on rate and nights stayed.
							GuestUser.printBill();
						}
						else if (cmd.equalsIgnoreCase("Q")) { // case to exit program
							System.out.print("Thank you for using our hotel service application. Goodbye!\n");
							break;
						}
					}
				} 
				else if (cmd.equalsIgnoreCase("Manager")) { // manager user interface
					while(true){
						System.out.println("Main Menu:");
						System.out.println("Would you like to check O)ccupany, view G)uest count, check what room needs U)pkeep, or Q)uit?");
						cmd = in.nextLine();
						
						if (cmd.equalsIgnoreCase("O")) { // case for checking how many rooms are occupied
							for (int i = 0; i < occupied.size(); i++){
								if(occupied.get(i).equals("Yes")){
									occCount++;
								}
							}
							System.out.println("There are " + occCount + " rooms currently occupied.");								
							System.out.println("Press ENTER to return to main menu.");
							cmd = in.nextLine();
	
						} else if (cmd.equalsIgnoreCase("G")) { // case for counting guests
							for (int i = 0; i < roomNum.size(); i++){
								if(occupied.get(i).equals("Yes")){ // check if rooms are occupied and displays how many guests are roughly staying in each room.
									System.out.println("There is " + bedCount.get(i) + " guest(s) in room " + roomNum.get(i) + ".");
								}
							}
							System.out.println("Press ENTER to return to main menu.");
							cmd = in.nextLine();
						} else if (cmd.equalsIgnoreCase("U")) { // case for checking upkeep status
							
							for (int i = 0; i < needsUpkeep.size(); i++){
								if (needsUpkeep.get(i).equals("Yes")){ // if room is flagged for upkeeping
									System.out.println("Room " + roomNum.get(i) + " needs upkeeping.");
								} else {
									System.out.println("Room " + roomNum.get(i) + " is in good condition.");
								}
							}
							System.out.println("Press ENTER to return to main menu.");
							cmd = in.nextLine();
						} else if (cmd.equalsIgnoreCase("Q")) { //case for quitting the program
							System.out.print("Thank you for using our hotel service. Goodbye!\n");
							break;
						}
					}
				}
			}
		}
	}	