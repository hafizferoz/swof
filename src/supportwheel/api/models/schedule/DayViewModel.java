package supportwheel.api.models.schedule;

import java.util.List;

import supportwheel.common.models.Shift;



public class DayViewModel
{
	private String Name;
	public final String getName()
	{
		return Name;
	}
	public final void setName(String value)
	{
		Name = value;
	}

	private List<Shift> Shifts;
	public final List<Shift> getShifts()
	{
		return Shifts;
	}
	public final void setShifts(List<Shift> value)
	{
		Shifts = value;
	}

	private int WeekNumber;
	public final int getWeekNumber()
	{
		return WeekNumber;
	}
	public final void setWeekNumber(int value)
	{
		WeekNumber = value;
	}
}