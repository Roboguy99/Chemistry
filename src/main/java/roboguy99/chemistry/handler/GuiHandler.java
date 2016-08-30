package roboguy99.chemistry.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import roboguy99.chemistry.gui.GuiBlockCompoundCreator;
import roboguy99.chemistry.gui.GuiBlockOreProcessor;
import roboguy99.chemistry.gui.container.ContainerBlockCompoundCreator;
import roboguy99.chemistry.gui.container.ContainerBlockOreProcessor;
import roboguy99.chemistry.tile.TileCompoundCreator;
import roboguy99.chemistry.tile.TileOreProcessor;

public class GuiHandler implements IGuiHandler
{
	//private static int guiId = 0;
	public static final int GUI_BLOCK_COMPOUND_CREATOR = 0; //TODO Move to enum
	public static final int GUI_BLOCK_ORE_PROCESSOR = 1;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		switch(ID)
		{
			case GUI_BLOCK_COMPOUND_CREATOR:
				return new ContainerBlockCompoundCreator(player.inventory, (TileCompoundCreator) world.getTileEntity(new BlockPos(x, y, z)));
			case GUI_BLOCK_ORE_PROCESSOR:
				return new ContainerBlockOreProcessor(player.inventory, (TileOreProcessor) world.getTileEntity(new BlockPos(x, y, z)));
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
		
		switch(ID)
		{
			case GUI_BLOCK_COMPOUND_CREATOR:
				return new GuiBlockCompoundCreator(new ContainerBlockCompoundCreator(player.inventory, (TileCompoundCreator) tile), (TileCompoundCreator) tile);
			case GUI_BLOCK_ORE_PROCESSOR:
				return new GuiBlockOreProcessor(new ContainerBlockOreProcessor(player.inventory, (TileOreProcessor) tile), (TileOreProcessor) tile);
			default:
				return null;
		}
	}
}
