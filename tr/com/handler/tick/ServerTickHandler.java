package tr.com.handler.tick;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler
{
    @Override
    public void tickStart(EnumSet tickType, Object ... args) 
    {
    	if (tickType.equals(EnumSet.of(TickType.PLAYER)))
        {
        	onPlayerTick(args);
        }
    }

    @Override
    public void tickEnd(EnumSet tickType, Object ... args)
    {
        if (tickType.equals(ticks()))
        {
            onTickInGame();
        }
    }

    @Override
    public EnumSet ticks()
    {
        return EnumSet.of(TickType.SERVER);
    }
    
    @Override
    public String getLabel()
    {
        return "Twin Realm Server Tick Handler";
    }

    public void onTickInGame()
    {
    	
    }

    public void onPlayerTick(Object ... args)
    {
    	EntityPlayer player = (EntityPlayer) args[0];
    }
}