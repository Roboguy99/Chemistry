package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Ytterbium extends ItemElement
{
	@Override
	public String giveName()
	{
		return "ytterbium";
	}

	@Override
	public String giveSymbol()
	{
		return "Yb";
	}

	@Override
	public Group giveGroup()
	{
		return Group.LANTHANOIDS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 70;
	}

	@Override
	public int giveAtomicMass()
	{
		return 173;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 819;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 1196;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 8, 2};
	}
	
}
