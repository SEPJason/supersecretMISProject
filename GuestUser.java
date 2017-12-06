package c9MISProject;

/**
 * 
 * @author Jason Thomas, Ben Merz, Chris Pingel, Steve Weber
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class GuestUser {
	public static int num_Days;
	public static int room_Num;
	public static Double rte;
	public static int bed_Count;
	public static String has_Kitchen;
	public static String handicap_Access;
	public static String is_Booked;
	public static String occup;
	public static String needs_Upkeep;
	
	/* Method for setting reservations. Reads and edits text file based on user inputs*/
	
	public static void setReservation() throws FileNotFoundException{
		Scanner cmd = new Scanner(System.in);
		String inputFileName = "hotel.txt";
		File inputFile = new File(inputFileName);
		Scanner ins = new Scanner(inputFile);
		
	/* Unfortunately, in order for the guestUser class to work with the main,
	we had to redundantly write out the array lists for each method. We could not 
	figure out a way to make this class work without these redundancies without 
	completely restructuring the program. The portion of code starting here and ending 
	at the next section of notes will appear in every method.*/
		
		ArrayList<Integer> roomNum = new ArrayList<Integer>();
		ArrayList<Double> rate = new ArrayList<Double>();
		ArrayList<Integer> bedCount = new ArrayList<Integer>();
		ArrayList<String> hasKitchen = new ArrayList<String>();
		ArrayList<String> handicapAccess = new ArrayList<String>();
		ArrayList<String> isBooked = new ArrayList<String>(); 
		ArrayList<String> occupied = new ArrayList<String>();
		ArrayList<String> needsUpkeep = new ArrayList<String>(); 
		
		while (ins.hasNext()) {
			
			roomNum.add(ins.nextInt());
			rate.add(ins.nextDouble());
			bedCount.add(ins.nextInt());
			hasKitchen.add(ins.next());
			handicapAccess.add(ins.next());
			isBooked.add(ins.next());
			occupied.add(ins.next());
			needsUpkeep.add(ins.next());
			
		}ins.close();
		
		/* Asks user which room they would like to book. Rooms, rates, and room info is displayed
		and user enters number 1-10 for the room they would like to book. If room is already booked, an error message is displayed.*/
		
		System.out.println("Which room would you like to book?\nRoom# Rate Beds HasKitchen HandicapAccess IsBooked Occupied NeedsUpKeep");
		for(int i=0; i<10; i++){
			System.out.println(roomNum.get(i)+"\t"+rate.get(i)+"\t"+bedCount.get(i)+"\t"+hasKitchen.get(i)+"\t"+handicapAccess.get(i)+"\t"+isBooked.get(i)+"\t"+occupied.get(i)+"\t"+needsUpkeep.get(i));
		}
		int room = cmd.nextInt()-1;
		if(isBooked.get(room).equals("No")){
			System.out.println("How many days will you be staying?");
			num_Days = cmd.nextInt();
			isBooked.set(room,"Yes");
			System.out.println("Room successfully booked!");
			room_Num = room;
			rte = rate.get(room);
			bed_Count = bedCount.get(room);
			has_Kitchen = hasKitchen.get(room);
			handicap_Access = handicapAccess.get(room);
			is_Booked = isBooked.get(room);
			occup = occupied.get(room);
			needs_Upkeep = needsUpkeep.get(room);
			String n = "";
			for(int i=0; i<10; i++){
				n += roomNum.get(i)+"\t"+rate.get(i)+"\t"+bedCount.get(i)+"\t"+hasKitchen.get(i)+"\t"+handicapAccess.get(i)+"\t"+isBooked.get(i)+"\t"+occupied.get(i)+"\t"+needsUpkeep.get(i)+"\n";
			}
			try{
			    PrintWriter writer = new PrintWriter("hotel.txt", "UTF-8");
			    writer.print(n);
			    writer.close();
			} catch (IOException e) {}
		}else{
			System.out.println("Sorry, that room is already booked!");
			setReservation();
		}
		

	}
	
	/* Method for checking reservation. Similar to setReservation, however, this method merely checks the text file to see if a
	particular room is booked or not */
	
	public static void getReservation(){
		System.out.println((room_Num + 1) +" "+ rte +" "+ bed_Count +" "+ has_Kitchen +" "+ handicap_Access +" "+ is_Booked +" "+ occup +" "+ needs_Upkeep); 
	}
	
	public static void checkIn() throws FileNotFoundException{
		String inputFileName = "hotel.txt";
		File inputFile = new File(inputFileName);
		Scanner ins = new Scanner(inputFile);
		
		ArrayList<Integer> roomNum = new ArrayList<Integer>();
		ArrayList<Double> rate = new ArrayList<Double>();
		ArrayList<Integer> bedCount = new ArrayList<Integer>();
		ArrayList<String> hasKitchen = new ArrayList<String>();
		ArrayList<String> handicapAccess = new ArrayList<String>();
		ArrayList<String> isBooked = new ArrayList<String>(); // could this be boolean
		ArrayList<String> occupied = new ArrayList<String>();
		ArrayList<String> needsUpkeep = new ArrayList<String>(); // same with this, boolean
		
		while (ins.hasNext()) {
			
			roomNum.add(ins.nextInt());
			rate.add(ins.nextDouble());
			bedCount.add(ins.nextInt());
			hasKitchen.add(ins.next());
			handicapAccess.add(ins.next());
			isBooked.add(ins.next());
			occupied.add(ins.next());
			needsUpkeep.add(ins.next());
			
		}ins.close();
		occupied.set(room_Num,"Yes");
		System.out.println("Successfully checked in. Enjoy your stay!");
		String n = "";
		for(int i=0; i<10; i++){
			n += roomNum.get(i)+"\t"+rate.get(i)+"\t"+bedCount.get(i)+"\t"+hasKitchen.get(i)+"\t"+handicapAccess.get(i)+"\t"+isBooked.get(i)+"\t"+occupied.get(i)+"\t"+needsUpkeep.get(i)+"\n";
		}
		try{
		    PrintWriter writer = new PrintWriter("hotel.txt", "UTF-8");
		    writer.print(n);
		    writer.close();
		} catch (IOException e) {}
	}
	
	/* Method for checking out. Reads and edits text file for room that is being checked out. */
	
	public static void checkOut() throws FileNotFoundException{
		String inputFileName = "hotel.txt";
		File inputFile = new File(inputFileName);
		Scanner ins = new Scanner(inputFile);
		
		ArrayList<Integer> roomNum = new ArrayList<Integer>();
		ArrayList<Double> rate = new ArrayList<Double>();
		ArrayList<Integer> bedCount = new ArrayList<Integer>();
		ArrayList<String> hasKitchen = new ArrayList<String>();
		ArrayList<String> handicapAccess = new ArrayList<String>();
		ArrayList<String> isBooked = new ArrayList<String>(); 
		ArrayList<String> occupied = new ArrayList<String>();
		ArrayList<String> needsUpkeep = new ArrayList<String>(); 
		
		while (ins.hasNext()) {
			
			roomNum.add(ins.nextInt());
			rate.add(ins.nextDouble());
			bedCount.add(ins.nextInt());
			hasKitchen.add(ins.next());
			handicapAccess.add(ins.next());
			isBooked.add(ins.next());
			occupied.add(ins.next());
			needsUpkeep.add(ins.next());
			
		}ins.close();
		occupied.set(room_Num,"No");
		System.out.println("Check out process complete. Thank you, and come back soon!");
		String n = "";
		for(int i=0; i<10; i++){
			n += roomNum.get(i)+"\t"+rate.get(i)+"\t"+bedCount.get(i)+"\t"+hasKitchen.get(i)+"\t"+handicapAccess.get(i)+"\t"+isBooked.get(i)+"\t"+occupied.get(i)+"\t"+needsUpkeep.get(i)+"\n";
		}
		try{ 
		    PrintWriter writer = new PrintWriter("hotel.txt", "UTF-8");
		    writer.print(n);
		    writer.close();
		} catch (IOException e) {}
	}
	
	public static void printBill(){ // returns the total bill calculated by amount of days stayed and rate of the chosen room
		System.out.println("Your total comes to: $" + rte*num_Days);

	}
	
}
