package roboguy99.chemistry;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import roboguy99.chemistry.api.CompoundNamer;
import roboguy99.chemistry.api.Elements;
import roboguy99.chemistry.api.Elements.EnumElement;
import roboguy99.chemistry.block.BlockCompoundCreator;
import roboguy99.chemistry.handler.GuiHandler;
import roboguy99.chemistry.item.compound.Compound;
import roboguy99.chemistry.network.CommonProxy;
import roboguy99.chemistry.network.packet.CompoundCreate;
import roboguy99.chemistry.network.packet.CompoundCreate.CompoundCreateHandle;
import roboguy99.chemistry.network.packet.ItemDelete;
import roboguy99.chemistry.network.packet.ItemDelete.ItemDeleteHandle;
import roboguy99.chemistry.tile.TileEntities;

/**
 * Main class. Handles mod initialisation.
 * 
 * @author Roboguy99
 * 
 */
@Mod(modid = Chemistry.modID, version = Chemistry.modVersion, name = Chemistry.name)
public class Chemistry 
{
	// Mod data. Fallback if mc-mod.info fails to load.
	public static final String modID = "chemistry";
	public static final String modVersion = "0.0.0";
	public static final String name = "Chemistry";

	public static final Logger logger = LogManager.getLogger("Chemistry");
	
	public static String CONFIG_DIR;

	@SidedProxy(clientSide = "roboguy99.chemistry.network.ClientProxy", serverSide = "roboguy99.chemistry.network.CommonProxy")
	protected static CommonProxy proxy;
	private static SimpleNetworkWrapper networkWrapper;

	public static Chemistry INSTANCE;
	
	private static BlockCompoundCreator blockCompoundCreator; //TODO Give this a proper home
	private static Compound compound;
	
	@EventHandler
	private void preInit(FMLPreInitializationEvent event) // Pre-initialisation loading
	{
		logger.info("Pre-initialising");
		this.INSTANCE = this;
		
		this.CONFIG_DIR = event.getModConfigurationDirectory() + "/Chemistry";
		
		new Elements();
		this.compound = new Compound();
		this.blockCompoundCreator = new BlockCompoundCreator();
		
		proxy.registerProxies();
		
		this.networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel("chemisty");
		this.getNetworkWrapper().registerMessage(CompoundCreateHandle.class, CompoundCreate.class, 0, Side.SERVER);
		this.getNetworkWrapper().registerMessage(ItemDeleteHandle.class, ItemDelete.class, 1, Side.SERVER);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	}

	@EventHandler
	private void init(FMLInitializationEvent event) // Initialisation loading
	{
		logger.info("Initialising");
		new CompoundNamer();
		
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		
	    mesher.register(Chemistry.compound, 0, new ModelResourceLocation("chemistry:compound", "inventory"));
	
		new TileEntities();
	}

	@EventHandler
	private void postInit(FMLPostInitializationEvent event) 
	{			
	}
	
	/**
	 * Get the configuration file for the mod.
	 * This will be placed in /config/Chemistry/modid.cfg
	 * @param modId The name of the configuration file to generate
	 * @return The configuration for the given modid
	 */
	public static Configuration getConfig(String modId)
	{
		return new Configuration(new File(Chemistry.CONFIG_DIR + modId + ".cfg"));
	}
	
	/**
	 * Get the network wrapper. This is used for sending/receiving packets.
	 * @return the networkWrapper
	 */
	public SimpleNetworkWrapper getNetworkWrapper()
	{
		return networkWrapper;
	}
	
	public static Compound getCompound()
	{
		return Chemistry.compound;
	}

	/**
	 * The creative tab in which all of the elements are shown
	 */
	public static CreativeTabs tabElements = new CreativeTabs("tabElements") 
	{
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
	    {
	        return EnumElement.CARBON.getElement();
	    }
	};
	/**
	 * The creative tab in which any machines are shown
	 */
	public static CreativeTabs tabMachines = new CreativeTabs("tabMachines") 
	{
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
	    {
	        return Item.getItemFromBlock(Chemistry.blockCompoundCreator);
	    }
	};
}	