package roboguy99.chemistry.item.element.render;

import java.util.Collection;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.IModelState;
import net.minecraftforge.client.model.TRSRTransformation;
import roboguy99.chemistry.item.element.Element;

public class ModelElement implements IModel
{
	private String elementName;
	
	public ModelElement(String elementName)
	{
		this.elementName = elementName;
	}
	
	@Override
	public Collection<ResourceLocation> getDependencies()
	{
		return ImmutableList.of();
	}

	@Override
	public Collection<ResourceLocation> getTextures()
	{
		return ImmutableList.of();
	}

	@Override
	public IFlexibleBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter)
	{
		return new BakedModelElement(elementName);
	}

	@Override
	public IModelState getDefaultState()
	{
		return TRSRTransformation.identity();
	}
	
}
