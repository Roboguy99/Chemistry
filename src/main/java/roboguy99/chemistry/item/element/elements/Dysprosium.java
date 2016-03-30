package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Dysprosium extends Element
{
	@Override
	public String giveName()
	{
		return "dysprosium";
	}

	@Override
	public String giveSymbol()
	{
		return "Dy";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 66;
	}

	@Override
	public int giveAtomicMass()
	{
		return 163;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1412;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2567;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 28, 8, 2};
	}
	
}