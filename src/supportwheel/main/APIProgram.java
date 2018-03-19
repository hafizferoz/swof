package supportwheel.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import supportwheel.api.controllers.ScheduleController;
import supportwheel.api.models.schedule.DayViewModel;
import supportwheel.api.models.schedule.ScheduleViewModel;
import supportwheel.api.options.ScheduleOptions;
import supportwheel.business.impl.services.RandomAdapterImp;
import supportwheel.business.impl.services.RandomSlotScheduleStrategyImp;
import supportwheel.business.impl.services.RuleEvaluatorImp;
import supportwheel.business.impl.services.ScheduleGeneratorServiceImp;
import supportwheel.business.interfaces.EngineerPoolFactory;
import supportwheel.business.interfaces.RandomAdapter;
import supportwheel.business.interfaces.Rule;
import supportwheel.business.interfaces.RuleEvaluator;
import supportwheel.business.interfaces.ScheduleGeneratorService;
import supportwheel.business.interfaces.ScheduleStrategy;
import supportwheel.common.models.EngineerDTO;
import supportwheel.common.models.Shift;
import supportwheel.data.core.TestDataSource;
import supportwheel.data.interfaces.EngineerRepository;
import supportwheel.data.repositories.EngineerRepositoryImp;
import supportwheel.impl.factories.EngineerPoolFactoryImp;
import supportwheel.impl.rules.ConsecutiveDayRule;
import supportwheel.impl.rules.ShiftsPerDayRule;
import supportwheel.impl.rules.ShiftsPerWeekRule;

public class APIProgram
{
	private ScheduleOptions _mockOptions;
	private ScheduleGeneratorService _mockScheduleGeneratorService;
	private ScheduleController _controller;
	private int totalNumberOfDays;
	private int numberOfEngineersPerShift;
	
	public APIProgram(int totalNumberOfDays, int numberOfEngineersPerShift ){
		this.totalNumberOfDays=totalNumberOfDays;
		this.numberOfEngineersPerShift=numberOfEngineersPerShift;
		testIntialize();
	}
	
	public static void main(String[] args)
	{
		APIProgram program = new APIProgram(10,2);
		program.generateSchedule();
	}
	
	public final void testIntialize()
	{
		EngineerRepository engineerRepository = new EngineerRepositoryImp(new TestDataSource());
		Random random = new Random();
		RandomAdapter randomAdapter = new RandomAdapterImp(random);
		EngineerPoolFactory engineerPoolFactory = new EngineerPoolFactoryImp(engineerRepository, randomAdapter);
		List<Rule> rules = new ArrayList<Rule>();
		rules.add(new ConsecutiveDayRule());
		rules.add(new ShiftsPerDayRule());
		rules.add(new ShiftsPerWeekRule());
		RuleEvaluator ruleEvaluator = new RuleEvaluatorImp(rules);
		ScheduleStrategy scheduleStrategy = new RandomSlotScheduleStrategyImp(ruleEvaluator);
		_mockScheduleGeneratorService = new ScheduleGeneratorServiceImp(engineerPoolFactory, scheduleStrategy);
		_mockOptions = new ScheduleOptions();
		//int numberOfEngineersPerShift = 2; //engineers per shift
		//int totalNumberOfDays = 15; // total number schedule roaster
		int totalEngineersPerPeriod=totalNumberOfDays/5;  // total number of days /5 days a week
		_mockOptions.setShiftDays(totalNumberOfDays);
		_mockOptions.setShiftsPerEngineerPerPeriod(totalEngineersPerPeriod); 
		_mockOptions.setShiftsPerPeriod(totalNumberOfDays*numberOfEngineersPerShift); // total shifts period
		_mockOptions.setShiftsPerDay(numberOfEngineersPerShift);
		_controller = new ScheduleController(_mockScheduleGeneratorService, _mockOptions);
	}

	public final String generateSchedule()
	{
		String result = "";
		try {
			ScheduleViewModel model = _controller.generate();
			int days = model.getDays().size();
			for (int i = 0; i < days; i++) {

				DayViewModel day = model.getDays().get(i);
				int dayOfWeek = day.getWeekNumber();
				String dayName = day.getName();
				int shifts = day.getShifts().size();
				result += "Week:" + dayOfWeek + " : " + dayName + "\n";
				System.out.println("Week:" + dayOfWeek + " : " + dayName);
				for (int j = 0; j < shifts; j++) {
					Shift shift = day.getShifts().get(j);
					int shiftId = shift.getId();
					EngineerDTO engineer = shift.getEngineer();
					String name = engineer.getName();
					result += " Shift Engineer ID: ";
					System.out.print("Shift Engineer ID: ");
					int engineerId = engineer.getID();
					result += engineerId + ": Name:" + name;
					System.out.print(engineerId + ": Name:" + name);
					result += "\n";
					System.out.println();
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
			result += "Error Retry";

		}
		return result;
	}


}