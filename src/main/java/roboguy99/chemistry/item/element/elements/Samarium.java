package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Samarium extends Element
{
	@Override
	public String giveName()
	{
		return "samarium";
	}

	@Override
	public String giveSymbol()
	{
		return "Sm";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 62;
	}

	@Override
	public int giveAtomicMass()
	{
		return 150;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1074;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 1794;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 24, 8, 2};
	}
	
}