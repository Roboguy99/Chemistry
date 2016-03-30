package roboguy99.chemistry.item.element;

public enum Group
{
	ALKALI_METALS("alkaliMetals"),
	ALKALINE_EARTH_METALS("alkalineEarthMetals"),
	TRANSITION_METALS("transitionMetals"),
	OTHER_METALS("otherMetals"),
	NON_METALS("nonMetals"),
	NOBLE_GASSES("nobleGasses"),
	SPECIAL("special");
	
	public static Group[] GROUPS = new Group[]{ALKALI_METALS, ALKALINE_EARTH_METALS, TRANSITION_METALS, OTHER_METALS, NON_METALS, NOBLE_GASSES, SPECIAL};
	
	public final String groupName;
	
	private Group(String groupName)
	{
		this.groupName = groupName;
	}
}