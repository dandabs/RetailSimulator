package uk.org.cloudcraftmc.RetailSimulator.generators;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;
import uk.org.cloudcraftmc.RetailSimulator.populators.BaseStorePopulator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TycoonGenerator extends ChunkGenerator {

    int currentHeight = 50;

    @Override
    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
        SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);
        ChunkData chunk = createChunkData(world);
        generator.setScale(0.005D);

        for (int X = 0; X < 16; X++)
            for (int Z = 0; Z < 16; Z++) {
                currentHeight = (int) (generator.noise(chunkX*16+X, chunkZ*16+Z, 0.5D, 0.5D)*15D+50D);
                chunk.setBlock(X, 50, Z, Material.GRASS);
                chunk.setBlock(X, 49, Z, Material.OBSIDIAN);
            }
        return chunk;
    }

    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {
        return Arrays.asList((BlockPopulator)new BaseStorePopulator());
    }

}
