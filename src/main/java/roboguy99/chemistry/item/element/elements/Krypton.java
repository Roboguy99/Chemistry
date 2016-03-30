package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Group;

public class Krypton extends Element
{
	@Override
	public String giveName()
	{
		return "krypton";
	}

	@Override
	public String giveSymbol()
	{
		return "Kr";
	}

	@Override
	public Group giveGroup()
	{
		return Group.NOBLE_GASSES;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 36;
	}

	@Override
	public int giveAtomicMass()
	{
		return 84;
	}

	@Override
	public int giveMeltingPoint()
	{
		return -157;
	}

	@Override
	public int giveBoilingPoint()
	{
		return -153;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,8};
	}
	
}