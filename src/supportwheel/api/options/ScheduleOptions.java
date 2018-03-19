package supportwheel.api.options;

public class ScheduleOptions {
	private int shiftsPerPeriod;

	public final int getShiftsPerPeriod() {
		return shiftsPerPeriod;
	}

	public final void setShiftsPerPeriod(int value) {
		shiftsPerPeriod = value;
	}

	private int shiftDays;

	public final int getShiftDays() {
		return shiftDays;
	}

	public final void setShiftDays(int value) {
		shiftDays = value;
	}

	private int shiftsPerEngineerPerPeriod;

	public final int getShiftsPerEngineerPerPeriod() {
		return shiftsPerEngineerPerPeriod;
	}

	public final void setShiftsPerEngineerPerPeriod(int value) {
		shiftsPerEngineerPerPeriod = value;
	}

	private int shiftsPerDay;

	public int getShiftsPerDay() {
		return shiftsPerDay;
	}

	public void setShiftsPerDay(int value) {
		shiftsPerDay = value;
	}
}