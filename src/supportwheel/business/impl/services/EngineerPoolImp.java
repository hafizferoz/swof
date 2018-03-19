package supportwheel.business.impl.services;

import java.util.ArrayList;

import supportwheel.business.interfaces.EngineerPool;
import supportwheel.business.interfaces.RandomAdapter;
import supportwheel.common.models.EngineerDTO;



public class EngineerPoolImp implements EngineerPool
{
	private RandomAdapter _randomAdapter;

	private ArrayList<EngineerDTO> _engineersAvailable;
	private ArrayList<EngineerDTO> _engineersPullable;

	public EngineerPoolImp(RandomAdapter randomAdapter)
	{
		_engineersAvailable = new ArrayList<EngineerDTO>();
		_engineersPullable = new ArrayList<EngineerDTO>();
		_randomAdapter = randomAdapter;
	}

	public final int getAvailable()
	{
		return _engineersAvailable.size();
	}

	public final int getPullable()
	{
		return _engineersPullable.size();
	}

	public final void add(ArrayList<EngineerDTO> engineers)
	{
		_engineersAvailable.addAll(engineers);
		_engineersPullable.addAll(engineers);
	}

	public final EngineerDTO pullRandom()
	{
		if (_engineersPullable.stream().findAny().isPresent())
		{
			 EngineerDTO candidate = _engineersPullable.get(_randomAdapter.next(_engineersPullable.size()));
			_engineersPullable.remove(candidate);
			return candidate;
		}
		else
		{
			return null;
		}
	}

	public final void remove(EngineerDTO engineer)
	{
		_engineersAvailable.remove(engineer);
	}

	public final void resetPullables()
	{
		_engineersPullable.clear();
		_engineersPullable.addAll(_engineersAvailable);
	}
}