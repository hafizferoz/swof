package supportwheel.common.models;

public class Shift
{
	private int _id;

	public Shift(int id)
	{
		_id = id;
	}

	public final int getId()
	{
		return _id;
	}

	private EngineerDTO Engineer;
	public final EngineerDTO getEngineer()
	{
		return Engineer;
	}
	public final void setEngineer(EngineerDTO value)
	{
		Engineer = value;
	}
}