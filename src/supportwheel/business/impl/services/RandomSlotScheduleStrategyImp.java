package supportwheel.business.impl.services;

import java.util.ArrayList;

import supportwheel.business.interfaces.EngineerPool;
import supportwheel.business.interfaces.RuleEvaluator;
import supportwheel.business.interfaces.ScheduleStrategy;
import supportwheel.common.models.EngineerDTO;
import supportwheel.common.models.Shift;


/** 
 Rather than trying to find the best candidate for a fixed slot, this algorithm
 picks a random engineer then walks through the slots that havn't been filled to look
 for a suitable one.
*/
public class RandomSlotScheduleStrategyImp implements ScheduleStrategy
{
	private RuleEvaluator _ruleEvaluator;

	public RandomSlotScheduleStrategyImp(RuleEvaluator ruleEvaluator)
	{
		_ruleEvaluator = ruleEvaluator;
	}

	public final ArrayList<Shift> generateSchedule(EngineerPool engineerPool, int shiftsPerPeriod)
	{
		// Populate the shift schedule without engineers
		ArrayList<Shift> shifts = new ArrayList<Shift>(shiftsPerPeriod);
		for (int i = 0; i < shiftsPerPeriod; i++)
		{
			shifts.add(new Shift(i));
		}

		// Find an engineer and then walk through the shifts to 
		// find the next valid one
		EngineerDTO candidate;
		while ((candidate = engineerPool.pullRandom()) != null)
		{
			for (int i = 0; i < shiftsPerPeriod; i++)
			{
				if (shifts.get(i).getEngineer() == null)
				{
					boolean foundSuitableSlot = _ruleEvaluator.isValid(i, candidate.getID(), shifts);
					if (foundSuitableSlot)
					{
						shifts.get(i).setEngineer( candidate);
						engineerPool.remove(candidate);
						break;
					}
				}
			}
		}

		return shifts;
	}
}