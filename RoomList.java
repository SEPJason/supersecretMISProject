package c9MISProject;
import java.util.ArrayList;
/**
 * 
 * @author Jason Thomas
 *
 */

public class RoomList {
	ArrayList<String> r;
	//Creates a RoomList of i elements.
	public  RoomList(int i){
		r = new ArrayList<String>(i);
	}
	
	//reserves room i for a guest, making the room 
	public void reserve(int i){
		if(isBooked(i)){
		r.set(i, "booked");
		}
		if(!isBooked(i)){
		System.out.println("That room is already booked!");
		}
	}
	//displays that a guest has vacated their room, leaving it open
	public void vacate(int i){
		r.set(i, "open");
	}
	
	public boolean isBooked(int i){
		if(r.get(i).equals("booked")){
			return true;
		}
		else{
			return false;
		}
	}
	
}

