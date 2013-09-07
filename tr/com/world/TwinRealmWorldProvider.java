package tr.com.world;

import holo.utils.world.BaseChunkManager;
import holo.utils.world.BaseChunkProvider;
import holo.utils.world.BaseWorldType;
import net.minecraft.block.Block;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TwinRealmWorldProvider extends WorldProvider
{
    public BaseWorldType type;
    /**
     * creates a new world chunk manager for WorldProvider
     */
    public void registerWorldChunkManager()
    {
        type = new BaseWorldType(0, "Twin Realm");
        for (BiomeGenBase biome : type.base12Biomes)
        {
            type.removeBiome(biome);
        }
        
        type.addNewBiome(BiomeGenBase.ocean);
        
        type.setWaterSnowHeight(63, 205);
        type.setBiomeSize(4);
        type.setFillBlock(Block.stone.blockID);
        
        type.setRiverBiome(BiomeGenBase.river);
        type.caveGen = null;
        type.ravineGen = null;
        this.worldChunkMgr = new BaseChunkManager(this.worldObj.getSeed(), type);
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * Returns a double value representing the Y value relative to the top of the map at which void fog is at its
     * maximum. The default factor of 0.03125 relative to 256, for example, means the void fog will be at its maximum at
     * (256*0.03125), or 8.
     */
    public double getVoidFogYFactor()
    {
        return 0.03125;
    }

    /**
     * Returns a new chunk provider which generates chunks for this world
     */
    public IChunkProvider createChunkGenerator()
    {
        return new BaseChunkProvider(this.worldObj, this.worldObj.getSeed(), false, type);
    }

    /**
     * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
     */
    public boolean isSurfaceWorld()
    {
        return true;
    }

    /**
     * Will check if the x, z position specified is alright to be set as the map spawn point
     */
    public boolean canCoordinateBeSpawn(int par1, int par2)
    {
        return false;
    }

    /**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
    public boolean canRespawnHere()
    {
        return false;
    }

    /**
     * Returns the dimension's name, e.g. "The End", "Nether", or "Overworld".
     */
    public String getDimensionName()
    {
        return "Twin Realm";
    }
    
    /**
     * Returns the sub-folder of the world folder that this WorldProvider saves to.
     * EXA: DIM1, DIM-1
     * @return The sub-folder name to save this world's chunks to.
     */
    public String getSaveFolder()
    {
        return getDimensionName();
    }
}
