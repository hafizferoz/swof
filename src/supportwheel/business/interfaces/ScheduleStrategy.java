package supportwheel.business.interfaces;

import java.util.ArrayList;

import supportwheel.common.models.Shift;


/** 
 Provides a strategy for schedule generation
*/
public interface ScheduleStrategy
{
	/** 
	 Generate the schedule using this strategy and given the specified parameters
	 
	 @param engineerPool The pool to select engineers from
	 @param shiftsPerPeriod The number of shifts to populate
	 @return Ordered list of shifts
	*/
	ArrayList<Shift> generateSchedule(EngineerPool engineerPool, int shiftsPerPeriod);
}