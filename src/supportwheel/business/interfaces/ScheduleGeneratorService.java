package supportwheel.business.interfaces;

import java.util.ArrayList;

import supportwheel.common.models.Shift;


/** 
 Provides a mechanism for creation of a schedule
*/
public interface ScheduleGeneratorService
{
	/** 
	 Generates a new schedule with the specificed parameters
	 
	 @param shiftsPerPeriod The number of shifts per period
	 @param shiftsPerEngineerPerPeriod The number of shifts per engineer per period
	 @return Ordered list of shifts
	*/
	ArrayList<Shift> generate(int shiftsPerPeriod, int shiftsPerEngineerPerPeriod);
}