package supportwheel.impl.factories;

import java.util.ArrayList;

import supportwheel.business.impl.services.EngineerPoolImp;
import supportwheel.business.interfaces.EngineerPool;
import supportwheel.business.interfaces.EngineerPoolFactory;
import supportwheel.business.interfaces.RandomAdapter;
import supportwheel.common.models.EngineerDTO;
import supportwheel.data.interfaces.EngineerRepository;



public class EngineerPoolFactoryImp implements EngineerPoolFactory
{
	private EngineerRepository _engineerRepository;
	private RandomAdapter _randomAdapter;

	public EngineerPoolFactoryImp(EngineerRepository engineerRepository, RandomAdapter randomAdapter)
	{
		_randomAdapter = randomAdapter;
		_engineerRepository = engineerRepository;
	}

	/** 
	 Creates a pool, populated with the engineers names.
	 If each engineer needs to perform 2 shifts per period, then their
	 names need to go into the hat 2 times each.
	 
	 @param shiftsPerEngineerPerPeriod Number of shifts per engineer in a period
	 @return The created engineer pool
	*/
	public final EngineerPool create(int shiftsPerEngineerPerPeriod)
	{
		EngineerPoolImp pool = new EngineerPoolImp(_randomAdapter);
		ArrayList<EngineerDTO> engineers = (ArrayList<EngineerDTO>) _engineerRepository.readAll();
		for (int i = 0; i < shiftsPerEngineerPerPeriod; i++)
		{
			pool.add(engineers);
		}
		return pool;
	}
}