package tr.com.util;

import net.minecraft.util.ResourceLocation;

public class Textures 
{
	public static final String texLoc = "textures/";
	
    
    
    public static ResourceLocation getResource(String path)
    {
    	return new ResourceLocation(Strings.MAIN_MOD_ID.toLowerCase(), path);
    }
}
