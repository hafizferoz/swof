package supportwheel.business.impl.services;

import java.util.ArrayList;
import java.util.List;

import supportwheel.business.interfaces.Rule;
import supportwheel.business.interfaces.RuleEvaluator;
import supportwheel.common.models.Shift;



/** 
 TODO could replace this with a Decorator class for Rule
*/
public class RuleEvaluatorImp implements RuleEvaluator
{
	private List<Rule> _rules;

	public RuleEvaluatorImp(List<Rule> rules)
	{
		_rules = rules;
	}

	public final boolean isValid(int shiftId, int candidateId, ArrayList<Shift> shifts)
	{
		boolean valid = true;
		// Check if all the rules pass
		for (Rule rule : _rules)
		{
			valid &= rule.isValid(shiftId, candidateId, shifts);
		}

		return valid;
	}
}