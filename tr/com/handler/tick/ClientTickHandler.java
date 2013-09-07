package tr.com.handler.tick;

import java.security.acl.Group;
import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ClientTickHandler implements ITickHandler
{
    public static final Minecraft mc = Minecraft.getMinecraft();
    
    @Override
    public void tickStart(EnumSet tickType, Object ... args) 
    {
    	
    }

    @Override
    public void tickEnd(EnumSet tickType, Object ... args)
    {
    	if (tickType.equals(EnumSet.of(TickType.RENDER)))
        {
            onRenderTick();
        }
    }

    public void onRenderTick()
    {
    	
    }

    @Override
    public EnumSet ticks()
    {
        return EnumSet.of(TickType.CLIENT, TickType.RENDER);
    }

    @Override
    public String getLabel()
    {
        return "Twin Realm Client Tick Handler";
    }
}