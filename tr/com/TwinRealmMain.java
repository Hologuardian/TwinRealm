package tr.com;

import net.minecraft.command.CommandHandler;
import tr.com.proxy.CommonProxy;
import tr.com.util.Strings;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Strings.MAIN_MOD_ID, version = Strings.VERSION, name = Strings.MAIN_MOD_ID)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class TwinRealmMain
{   
    @Instance(Strings.MAIN_MOD_ID)
    public static TwinRealmMain instance;
    
    @SidedProxy
    (clientSide = Strings.clientProxy, 
        serverSide = Strings.commonProxy)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        instance = this;
        proxy.configRegistry(event);
        proxy.preInit(event);
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }
    
    @EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    {
        
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {       
        CommandHandler commandManager = (CommandHandler)event.getServer().getCommandManager();
    }
}