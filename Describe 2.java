import java.util.*;

public class Describe extends Game{
	
	Visits one = new Visits();
	
	public void describe(Location room) {
	
		room.nameDisplay();
		System.out.println();
		String wanted = room.getName();
		int i;
		    
			if (room == map.get(3)) {
				room.descriptionDisplay();
				room = map.get(4);
			}
			else{
				room.descriptionDisplay();
				i = getRoomIndex(wanted);
				//System.out.println(i);
				System.out.println(one.secondVisit.get(i));
				String visit = one.secondVisit.get(i);
				map.get(i).setDescription(visit);
				room.descriptionDisplay();
				System.out.println(visit);
				System.out.println(map.get(i).getDescription());
			}
	}
	
}