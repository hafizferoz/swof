package supportwheel.business.impl.services;

import java.util.Random;

import supportwheel.business.interfaces.RandomAdapter;



public class RandomAdapterImp implements RandomAdapter
{
	private Random _random;

	public RandomAdapterImp(Random random)
	{
		_random = random;
	}

	public final int next(int max)
	{
		return _random.nextInt(max);
	}
}