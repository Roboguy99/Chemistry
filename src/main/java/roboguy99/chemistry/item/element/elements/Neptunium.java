package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

public class Neptunium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 1124784000000L * 60;
	}

	@Override
	public String giveName()
	{
		return "neptunium";
	}

	@Override
	public String giveSymbol()
	{
		return "Np";
	}

	@Override
	public Group giveGroup()
	{
		return Group.ACTINOIDS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 93;
	}

	@Override
	public int giveAtomicMass()
	{
		return 237;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 639;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 3902;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 22, 9, 2};
	}
}
