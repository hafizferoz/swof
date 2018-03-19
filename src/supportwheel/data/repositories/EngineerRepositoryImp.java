package supportwheel.data.repositories;

import java.util.ArrayList;
import java.util.List;

import supportwheel.common.models.EngineerDTO;
import supportwheel.data.core.TestDataSource;
import supportwheel.data.interfaces.EngineerRepository;


public class EngineerRepositoryImp implements EngineerRepository
{
	private TestDataSource testData;

	public EngineerRepositoryImp(TestDataSource TestData)
	{
		this.testData = TestData;
	}

	public final List<EngineerDTO> readAll()
	{
		
		return  new ArrayList<EngineerDTO>(testData.testData.values());
	}

	public final void add(EngineerDTO engineer)
	{
		testData.testData.put(engineer.getID(), engineer);
	}

	public final void remove(int id)
	{
		testData.testData.remove(id);
	}

	public final EngineerDTO find(int id)
	{	
		return testData.testData.get(id);
	}
}