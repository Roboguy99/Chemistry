package roboguy99.chemistry.item.element.elements.special;

import roboguy99.chemistry.api.Group;

/**
 * A special element with no mass used for marking the beginning/end of a molecule
 * @author Jake Stanger
 *
 */
public class MoleculeMarker extends ElementSpecial
{
	@Override
	public String giveName()
	{
		return "marker.molecule";
	}

	@Override
	public String giveSymbol()
	{
		return "|";
	}

	@Override
	public int giveAtomicNumber()
	{
		return 119;
	}

	@Override
	public int giveAtomicMass()
	{
		return 0;
	}

	@Override
	public int giveMeltingPoint()
	{
		return 0;
	}

	@Override
	public int giveBoilingPoint()
	{
		return 0;
	}

	@Override
	public int[] giveElectronConfiguration()
	{
		return new int[]{0};
	}

	@Override
	public Group giveGroup()
	{
		return Group.SPECIAL;
	}
}
