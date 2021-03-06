package roboguy99.chemistry.gui.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import roboguy99.chemistry.item.element.ItemElement;

/**
 * A container slot which only allows elements to be placed in it.
 * @author Jake Stanger
 *
 */
public class SlotElement extends Slot
{
	public SlotElement(IInventory inventoryIn, int index, int xPosition, int yPosition)
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack itemStack)
	{
		return itemStack.getItem() instanceof ItemElement;
	}
}
