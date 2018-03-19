package supportwheel.business.interfaces;

import java.util.ArrayList;

import supportwheel.common.models.Shift;


/** 
 Provides a mechanism for checking if multiple rules are valid
 TODO: replace with decorator?
*/
public interface RuleEvaluator
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