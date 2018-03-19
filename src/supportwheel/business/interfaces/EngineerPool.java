package supportwheel.business.interfaces;

import java.util.ArrayList;

import supportwheel.common.models.EngineerDTO;



/** 
 Provides methods to manipulate a pool of Engineers
*/
public interface EngineerPool
{
	/** 
	 Adds a list of engineers to the pool
	 
	 @param engineers
	*/
	void add(ArrayList<EngineerDTO> engineers);

	/** 
	 Retrieves an engineer from pool at random
	 
	 @return 
	*/
	EngineerDTO pullRandom();

	/** 
	 Removes the specified engineer from the pool
	 
	 @param engineer The engineer to be removed from the pool
	*/
	void remove(EngineerDTO engineer);

	/** 
	 Resets the list of engineers that can be pulled to the available list of engineers
	*/
	void resetPullables();

	/** 
	 Gets the number of engineers available
	*/
	int getAvailable();

	/** 
	 Gets the number of engineers that have not yet been pulled
	*/
	int getPullable();
}