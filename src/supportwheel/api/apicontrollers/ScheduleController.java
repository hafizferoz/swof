package supportwheel.api.apicontrollers;

import java.util.List;

import supportwheel.api.options.ScheduleOptions;
import supportwheel.business.interfaces.ScheduleGeneratorService;
import supportwheel.common.models.Shift;


public class ScheduleController
{
	private ScheduleGeneratorService _scheduleGeneratorService;
	private ScheduleOptions _optionsAccessor;

	public ScheduleController(ScheduleGeneratorService scheduleGeneratorService, ScheduleOptions optionsAccessor)
	{
		_scheduleGeneratorService = scheduleGeneratorService;
		_optionsAccessor = optionsAccessor;
	}

	/** 
	 Generate a new schedule
	 
	 @return List of shifts for the new schedule
	*/
	public final List<Shift> get()
	{
		return _scheduleGeneratorService.generate(_optionsAccessor.getShiftsPerPeriod(), _optionsAccessor.getShiftsPerEngineerPerPeriod());
	}
}