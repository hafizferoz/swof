package supportwheel.common.util;

public enum DaysOfWeek {
	MONDAY("Monday"), TUESDAY("Tuesday"), WEDNESDAY("Wednesday"), THURSDAY("Thursday"), FRIDAY("Friday");

	private String day;
	
	private DaysOfWeek(String day){
		this.day = day;
	}
	public String getValue() {
	    return day;
	  }
}

