package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Copper extends ItemElement
{
	@Override
	public String giveName()
	{
		return "copper";
	}

	@Override
	public String giveSymbol()
	{
		return "Cu";
	}

	@Override
	public Group giveGroup()
	{
		return Group.TRANSITION_METALS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 29;
	}

	@Override
	public int giveAtomicMass()
	{
		return 64;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 1085;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 2562;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,1};
	}
	
}
