package supportwheel.business.interfaces;

import java.util.ArrayList;

import supportwheel.common.models.Shift;

/** 
 Provides a mechanism for rule validation
*/
public interface Rule
{
	/** 
	 Determines if the rule is valid given the passed parameters
	 
	 @param shiftId Identifier of the proposed shift
	 @param candidateId Identifier of the proposed candiate
	 @param shifts Curent schedule to shifts
	 @return True if rule passed against passed criteria
	*/
	boolean isValid(int shiftId, int candidateId, ArrayList<Shift> shifts);
}