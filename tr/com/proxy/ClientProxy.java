package tr.com.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    
    @Override
    public void tickRegistry() {
        super.tickRegistry();
    }
    @Override
    public void renderRegistry() 
    {
    }
    
    @Override
    public int addArmor(String name)
    {
        return RenderingRegistry.addNewArmourRendererPrefix(name);
    }
}