package supportwheel.impl.rules;

import java.util.ArrayList;

import supportwheel.business.interfaces.Rule;
import supportwheel.common.models.Shift;

public class ShiftsPerWeekRule implements Rule {

	int counter;
	@Override
	public boolean isValid(int shiftId, int candidateId, ArrayList<Shift> shifts) {
		
		counter =0; //by default zero
		
		// If there are currently no shifts then this proposal is valid
		if (shifts.size() == 0 || shiftId ==0)
		{
			return true;
		}
		 if (shiftId % 5 == 0)
		{
			//check if same engineer in last three days. Engineer should not repeat more than twice a week.
			if ((shifts.get(shiftId - 3).getEngineer() == null ? -1 : shifts.get(shiftId - 3).getEngineer().getID()) == candidateId 
					|| (shifts.get(shiftId - 2).getEngineer() == null ? -1 : shifts.get(shiftId - 2).getEngineer().getID()) == candidateId   )
			{
				return false;
			}
		}
		 
		if(shiftId >10){
			int week = shiftId / 10;
			shifts.subList(((week*10)-10), week*10).stream().forEach(x ->{
				if( (x.getEngineer() == null? -1: x.getEngineer().getID()) == candidateId){
					counter ++;
				}
			});
			if(counter>1)
				return false;
		}
			//Proposed shift is for nex consecutive days
			return true;
	}

}
