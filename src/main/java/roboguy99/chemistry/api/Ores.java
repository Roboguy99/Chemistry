package roboguy99.chemistry.api;

import com.google.gson.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.commons.io.FileUtils;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.block.BlockOre;
import roboguy99.chemistry.item.element.ItemElement;
import roboguy99.chemistry.wrapper.MinMax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * Handles creation of ore blocks when the game loads.
 * Reads ores from JSON file.
 * Also contains list of all ores.
 * @author Jake Stanger
 *
 */
public class Ores 
{
	private HashMap<String, HashMap<ItemElement, MinMax>> oreRegistrants = new HashMap<>(); //Ores to register
	private HashMap<String, ModelResourceLocation> models = new HashMap<>(); //Ores and models
	
	private List<BlockOre> oreList = new ArrayList<>(); //List of all ores (for public access)
	
	public static Ores INSTANCE;
	
	public Ores(FMLPreInitializationEvent event)
	{
		INSTANCE = this;
		getOresFromJSON();
		registerOres();
	}
	
	/**
	 * Reads the ores to add to game from the ores.json file.
	 * Who's Jason and why does he have the ores?
	 */
	private void getOresFromJSON()
	{
		JsonParser parser = new JsonParser();
		try
		{	
			JsonElement element = parser.parse(new FileReader(Chemistry.CONFIG_DIR + "ores.json"));
			JsonArray arr = element.getAsJsonArray();
			
			for(JsonElement ele : arr)
			{
				JsonObject oreData = ele.getAsJsonObject();
				
				String name = oreData.get("name").getAsString();
				String model = oreData.get("model").getAsString();
				
				//Avoids another wrapper class
				this.models.put(name, new ModelResourceLocation(model));
				
				JsonObject processObj = oreData.get("processMap").getAsJsonObject();
				HashMap<ItemElement, MinMax> processMap = new HashMap<>();
				
				for(Entry<String, JsonElement> processData : processObj.entrySet())
				{
					//Get element and min/max processing values
					ItemElement itemElement = Elements.getElement(processData.getKey());
					
					JsonArray minMaxArr = processData.getValue().getAsJsonArray();
					MinMax minMax = new MinMax(minMaxArr.get(0).getAsInt(), minMaxArr.get(1).getAsInt());
					
					processMap.put(itemElement, minMax);
				}
				
				this.oreRegistrants.put(name, processMap);
			}
		}
		catch (JsonIOException | JsonSyntaxException e)
		{
			e.printStackTrace();
		}
		catch(FileNotFoundException e)
		{
			try
			{
				this.copyDefaultJSONFromJar();
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	/**
	 * In the case the ores config does not exist
	 * (such as when the mod is first loaded),
	 * copy the default config from inside the JAR
	 * to the Forge config folder.
	 * @throws IOException
	 */
	private void copyDefaultJSONFromJar() throws IOException
	{
		Chemistry.logger.info("Copying default ores config");
		URL inputUrl = getClass().getResource("/assets/chemistry/config/ores.json");
		File dest = new File(Chemistry.CONFIG_DIR + "ores.json");
		FileUtils.copyURLToFile(inputUrl, dest);
		this.getOresFromJSON();
	}
	
	/**
	 * Add an ore to the ores list, ready to be registered.
	 * 
	 * @param name The unlocalised name of the ore. 
	 * There is no need to include "ore" in the name as this is automatically appended.
	 * @param processContents The minimum and maximum. 
	 * @param model The model to associate to the ore.
	 */
	private void addOre(String name, HashMap<ItemElement, MinMax> processContents, ModelResourceLocation model)
	{
		oreRegistrants.put(name, processContents);
		models.put(name, model);
	}
	
	/**
	 * Actually instance each block and register it in the game
	 */
	private void registerOres()
	{
		for(String name : oreRegistrants.keySet())
		{
			BlockOre ore = new BlockOre(name, models.get(name), oreRegistrants.get(name));
			this.oreList.add(ore);
		}
	}
	
	/**
	 * Get a list of all registered ores.
	 * @return A list of all the registered ores.
	 */
	public List<BlockOre> getOres()
	{
		return this.oreList;
	}
}
