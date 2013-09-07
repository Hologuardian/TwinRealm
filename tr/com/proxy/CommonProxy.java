package tr.com.proxy;

import java.io.File;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import tr.com.config.TRConfig;
import tr.com.helper.TRBlockRegistry;
import tr.com.helper.TRDimensionRegistry;
import tr.com.helper.TRItemRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy 
{
	public void preInit(FMLPreInitializationEvent event)
	{
//      entityRegistry();
        TRItemRegistry.initItems();
        TRBlockRegistry.initBlocks();
        TRDimensionRegistry.initWorld();
//      TRRecipes.initRecipes();
//      TRNames.initNames();
//      renderRegistry();
	}
	
	
    public void init(FMLInitializationEvent event) 
    {
          tickRegistry();
          eventRegistry();
    }
    
    public void tickRegistry() 
    {
    }
    
    public void configRegistry(FMLPreInitializationEvent event) 
    {
        File file = new File(event.getModConfigurationDirectory(), "Sojourn.cfg");
        Configuration config = new Configuration(file);
        config.load();
        TRConfig.initTRConfig(event, config);
        config.save();
    }
    
    public void renderRegistry() 
    {
        
    }
    
    public void eventRegistry() 
    {
    }
    
    public void entityRegistry() 
    {
    }
    
    public int addArmor(String name)
    {
        return 0;
    }
}