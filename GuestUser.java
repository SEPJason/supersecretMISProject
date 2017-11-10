package c9MISProject;

/**
 * 
 * @author Jason Thomas
 *
 */

public class GuestUser {

	boolean in = false;
	public static void setReservation(){
		// #TODO

	}
	
	public String getReservation(){
		//does this need to be something other than String type?
		// what are we storing reservations as?
		return null;
	}
	
	public static void checkIn(){
		in = true;
	}
	
	public static void checkOut(){
		in = false
	}
	
	public static void printBill(){
		

	}
	
	public static void payBill(){
		//this wasn't in the spec but I wasn't sure if we should include this?
	}
}
