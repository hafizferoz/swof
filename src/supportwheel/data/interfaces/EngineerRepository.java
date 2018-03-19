package supportwheel.data.interfaces;

import java.util.List;

import supportwheel.common.models.EngineerDTO;



/** 
 Provides a repository of Engineers
*/
public interface EngineerRepository
{
	/** 
	 Reads all the engineers from the repository
	 
	 @return List of engineers
	*/
	List<EngineerDTO> readAll();

	/** 
	 Adds a new engineer to the repository
	 
	 @param engineer The engineer to add
	*/
	void add(EngineerDTO engineer);

	/** 
	 Removes a specific engineer from the repository
	 
	 @param id Id of the engineer to remove
	*/
	void remove(int id);

	/** 
	 Retrieves an engineer from the repository
	 
	 @param id Id of the engineer to retreive
	 @return 
	*/
	EngineerDTO find(int id);
}