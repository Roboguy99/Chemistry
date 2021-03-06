package roboguy99.chemistry.item.element.elements;

import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.element.elements.special.ElementRadioactive;

/**
 * The boiling point of Nobelium is unknown
 * @author Jake Stanger
 *
 */
public class Nobelium extends ElementRadioactive
{
	@Override
	public long giveHalfLife()
	{
		return 58 * 60;
	}

	@Override
	public String giveName()
	{
		return "nobelium";
	}

	@Override
	public String giveSymbol()
	{
		return "No";
	}

	@Override
	public Group giveGroup()
	{
		return Group.ACTINOIDS;
	}

	@Override
	public int giveAtomicNumber()
	{
		return 102;
	}

	@Override
	public int giveAtomicMass()
	{
		return 259;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 827;
	}

	@Override
	public int giveBoilingPoint()
	{
		return Integer.MAX_VALUE;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{2, 8, 18, 32, 32, 8, 2};
	}
}
