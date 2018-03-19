package supportwheel.impl.rules;

import java.util.ArrayList;

import supportwheel.business.interfaces.Rule;
import supportwheel.common.models.Shift;

/** 
 An engineer can do at most one half day shift in a day
*/
public class ShiftsPerDayRule implements Rule
{
	public final boolean isValid(int shiftId, int candidateId, ArrayList<Shift> shifts)
	{
		// If there are currently no shifts then this proposal is valid
		if (shifts.size() == 0)
		{
			return true;
		}
		else if (shiftId % 2 == 1)
		{
			//Its an afternoon shift, so check the morning is not the same enginner
			if ((shifts.get(shiftId - 1).getEngineer() == null ? -1 : shifts.get(shiftId - 1).getEngineer().getID()) == candidateId)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else
		{
			//Proposed shift is for a morning, we only check when populating the afternoon shift
			return true;
		}
	}
}