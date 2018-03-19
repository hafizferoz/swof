package supportwheel.data.models;



public class Engineer
{
	private int ID;
	public final int getID()
	{
		return ID;
	}
	public final void setID(int value)
	{
		ID = value;
	}
	private String name;
	public final String getName()
	{
		return name;
	}
	public final void setName(String value)
	{
		name = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null & this.getID() == ((Engineer) obj).getID())
			return true;
		return false;
	}
	@Override
	public int hashCode() {
		return ID;
	}
}