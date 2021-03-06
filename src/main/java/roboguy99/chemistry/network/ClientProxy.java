package roboguy99.chemistry.network;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import roboguy99.chemistry.api.Elements;
import roboguy99.chemistry.item.element.ItemElement;
import roboguy99.chemistry.item.element.render.ElementModelLoader;

public class ClientProxy extends CommonProxy
{	
	@Override
	public void registerProxies()
	{
		ModelLoaderRegistry.registerLoader(new ElementModelLoader());
		
		ModelResourceLocation heldModel = new ModelResourceLocation("chemistry:elementHeld", "inventory");
		for(ItemElement element : Elements.getElements())
		{
			ModelResourceLocation baseModel = new ModelResourceLocation("chemistry:" + element.getName(), "inventory");
			ModelResourceLocation elementModel = new ModelResourceLocation(("chemistry:" + element.getName()).replaceAll("_", "-"), "inventory");
			
			net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(element, 0, baseModel);
			ModelBakery.registerItemVariants(element, elementModel, heldModel);
		}
	}
}
