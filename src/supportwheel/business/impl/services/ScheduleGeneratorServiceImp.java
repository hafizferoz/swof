package supportwheel.business.impl.services;

import java.util.ArrayList;

import supportwheel.business.interfaces.EngineerPool;
import supportwheel.business.interfaces.EngineerPoolFactory;
import supportwheel.business.interfaces.ScheduleGeneratorService;
import supportwheel.business.interfaces.ScheduleStrategy;
import supportwheel.common.models.Shift;



public class ScheduleGeneratorServiceImp implements ScheduleGeneratorService
{
	private EngineerPoolFactory _engineerPoolFactory;
	private ScheduleStrategy _scheduleStrategy;

	public ScheduleGeneratorServiceImp(EngineerPoolFactory engineerPoolFactory, ScheduleStrategy scheduleStrategy)
	{
		_engineerPoolFactory = engineerPoolFactory;
		_scheduleStrategy = scheduleStrategy;
	}

	/** 
	 Generates a schedule. Due to nature of the Random engineer picking, it sometimes
	 picks the engineers in such a way that there is no valid way to populate all the shifts
	 In this case we just have another go with a new Random object.
	 For example, an engineer may not get picked until the 19th slot which is valid, but then
	 the same engineer cannot be used in the remaining slot.
	 
	 @param shiftsPerPeriod Number of shifts per period
	 @param shiftsPerEngineerPerPeriod Number of shifts per engineer per period
	 @return Ordered list of shifts with allocated engineer
	*/
	public final ArrayList<Shift> generate(int shiftsPerPeriod, int shiftsPerEngineerPerPeriod)
	{
		ArrayList<Shift> shifts = new ArrayList<Shift>();
		while (shifts.size() != shiftsPerPeriod /*&& shifts.stream().filter(x -> x.getEngineer() ==null).count() ==0  */)
		{
			//System.out.println(shifts.stream().filter(x -> x.getEngineer() ==null).count());
			// Create a pool of engineers to use for scheduling
			 EngineerPool engineerPool = _engineerPoolFactory.create(shiftsPerEngineerPerPeriod);

			// Generate the shift pattern using the provided strategy
			shifts = _scheduleStrategy.generateSchedule(engineerPool, shiftsPerPeriod);
		}
		return shifts;
	}
}