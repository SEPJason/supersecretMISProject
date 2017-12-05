import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Jason Thomas
 *
 */

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
	
	public static void setReservation() throws FileNotFoundException{
		Scanner cmd = new Scanner(System.in);
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
		
		System.out.println("Which room would you like to book?\nRoom# Rate Beds HasKitchen HandicapAccess IsBooked Occupied NeedsUpKeep");
		for(int i=0; i<10; i++){
			System.out.println(roomNum.get(i)+"\t"+rate.get(i)+"\t"+bedCount.get(i)+"\t"+hasKitchen.get(i)+"\t"+handicapAccess.get(i)+"\t"+isBooked.get(i)+"\t"+occupied.get(i)+"\t"+needsUpkeep.get(i));
		}
		int room = cmd.nextInt()-1;
		if(isBooked.get(room).equals("No")){
			System.out.println("How many days will you be staying?");
			num_Days = cmd.nextInt();
			isBooked.set(room,"Yes");
			
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
	
	public static void getReservation(){
		System.out.println(room_Num +" "+ rte +" "+ bed_Count +" "+ has_Kitchen +" "+ handicap_Access +" "+ is_Booked +" "+ occup +" "+ needs_Upkeep); 
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
	
	public static void checkOut() throws FileNotFoundException{
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
		occupied.set(room_Num,"No");
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
	
	public static void printBill(){
		System.out.println(rte*num_Days);

	}
	
}
