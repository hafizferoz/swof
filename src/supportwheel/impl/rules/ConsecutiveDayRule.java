package supportwheel.impl.rules;

import java.util.ArrayList;

import supportwheel.business.interfaces.Rule;
import supportwheel.common.models.Shift;

/** 
 An engineer cannot have half day shifts on consecutive days
*/
public class ConsecutiveDayRule implements Rule
{
	public final boolean isValid(int shiftId, int candidateId, ArrayList<Shift> shifts)
	{
		// If shiftId is the first day then allocation must be valid
		if (shiftId < 2)
		{
			return true;
		}
		else
		{
			boolean isMorning = shiftId == 0 || shiftId % 2 == 0;
			if (isMorning)
			{
				//Proposed shift is for a morning - check the last 2 shifts are not for the same enginner
				if ((shifts.get(shiftId - 1).getEngineer() == null ? -1 : shifts.get(shiftId - 1).getEngineer().getID()) == candidateId || (shifts.get(shiftId - 2).getEngineer() == null ? -1 : shifts.get(shiftId - 2).getEngineer().getID()) == candidateId)
				{
					return false;
				}
			}
			else
			{
				//Proposd shift is for an afternoon - check the previous days shifts
				if ((shifts.get(shiftId - 2).getEngineer() == null ? -1 : shifts.get(shiftId - 2).getEngineer().getID()) == candidateId || (shifts.get(shiftId - 3).getEngineer() == null ? -1 : shifts.get(shiftId - 3).getEngineer().getID()) == candidateId)
				{
					return false;
				}
			}

			// The same enginner is not defined for the previous day, so the proposal is valid
			return true;
		}
	}
}