package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.ItemElement;

public class Iodine extends ItemElement
{
	@Override
	public String giveName()
	{
		return "iodine";
	}

	@Override
	public String giveSymbol()
	{
		return "I";
	}

	@Override
	public Group giveGroup()
	{
		return Group.HALOGENS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 53;
	}

	@Override
	public int giveAtomicMass()
	{
		return 127;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 114;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 184;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2,8,18,18,7};
	}
	
}
