package supportwheel.api.apicontrollers;

import java.util.List;

import supportwheel.common.models.EngineerDTO;
import supportwheel.data.interfaces.EngineerRepository;

public class EngineerController 	
{
	private EngineerRepository _engineerRepository;

	public EngineerController(EngineerRepository engineerRepository)
	{
		_engineerRepository = engineerRepository;
	}

	/** 
	 Retrieves all Engineers
	 
	 @return List of engineers
	*/
	public final List<EngineerDTO> get()
	{
		return _engineerRepository.readAll();
	}

	/** 
	 Gets a single engineer with the matching id
	 
	 @param id Identifier of the engineer to return
	 @return The engineer with the specified Id
	*/
	public final EngineerDTO get(int id)
	{
		 EngineerDTO engineer = _engineerRepository.find(id);
		if (engineer == null)
		{
			return null	;
		}

		return  engineer;
	}

	/** 
	 Adds a new engineer with the given name
	 
	 @param name Name of the engineer.
	 @return Id of the new engineer
	*/
	public final int save(String name)
	{
		EngineerDTO engineer = new EngineerDTO();
		engineer.setName(name);
		_engineerRepository.add(engineer);
		return engineer.getID();
	}

	/** 
	 Removes the engineer with the given identifier from the repository
	 
	 @param id Identifier of the engineer to delete
	 @return OK if deleted
	*/
	public final void delete(int id)
	{
		_engineerRepository.remove(id);
		
	}
}