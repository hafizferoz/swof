package supportwheel.api.models.schedule;

import java.util.ArrayList;



public class ScheduleViewModel
{
	private ArrayList<DayViewModel> Days;
	public final ArrayList<DayViewModel> getDays()
	{
		return Days;
	}
	public final void setDays(ArrayList<DayViewModel> value)
	{
		Days = value;
	}
}