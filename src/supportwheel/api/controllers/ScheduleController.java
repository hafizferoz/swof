package supportwheel.api.controllers;

import java.util.ArrayList;

import supportwheel.api.models.schedule.DayViewModel;
import supportwheel.api.models.schedule.ScheduleViewModel;
import supportwheel.api.options.ScheduleOptions;
import supportwheel.business.interfaces.ScheduleGeneratorService;
import supportwheel.common.models.Shift;
import supportwheel.common.util.DaysOfWeek;




public class ScheduleController 
{

	private ScheduleGeneratorService _scheduleGeneratorService;
	private ScheduleOptions _optionsAccessor;

	public ScheduleController(ScheduleGeneratorService scheduleGeneratorService, ScheduleOptions optionsAccessor)
	{
		_scheduleGeneratorService = scheduleGeneratorService;
		_optionsAccessor = optionsAccessor;
	}

	public final ScheduleViewModel generate()
	{
		 ArrayList<Shift> shifts = _scheduleGeneratorService.generate(_optionsAccessor.getShiftsPerPeriod(), _optionsAccessor.getShiftsPerEngineerPerPeriod());

		 int shiftsPerDay = _optionsAccessor.getShiftsPerDay() ;// _optionsAccessor.getShiftsPerPeriod() / _optionsAccessor.getShiftDays();
		 int shiftCounter = 0;
		 int weekday=0;
		ArrayList<DayViewModel> days = new ArrayList<DayViewModel>();
		for (int i = 0; i < _optionsAccessor.getShiftDays(); i++)
		{
			DayViewModel tempVar = new DayViewModel();
			tempVar.setName(DaysOfWeek.values()[i % 5].getValue());
			tempVar.setShifts(shifts.subList(i * shiftsPerDay, shiftCounter+=shiftsPerDay));
			tempVar.setWeekNumber(weekday);
			if(i%5==0)
			tempVar.setWeekNumber(++weekday);
			days.add(tempVar);
		}

		ScheduleViewModel tempVar2 = new ScheduleViewModel();
		tempVar2.setDays(days);
		return  tempVar2;
	}
}