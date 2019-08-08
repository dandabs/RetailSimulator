package uk.org.cloudcraftmc.RetailSimulator;

import com.sk89q.worldedit.world.DataException;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import uk.org.cloudcraftmc.RetailSimulator.generators.PlotGenerator;
import uk.org.cloudcraftmc.RetailSimulator.utils.Configuration;

import java.io.IOException;
import java.util.logging.Logger;

public class RetailSimulator extends JavaPlugin {

    public RetailSimulator() {}
    private static RetailSimulator instance;

    private static Logger logger = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {

        instance = this;
        new Configuration().loadConfiguration();

    }

    @Override
    public void onDisable() {



    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {

            return new PlotGenerator();

    }

    public static RetailSimulator getInstance() {

        return instance;

    }

    public static Logger getMinecraftLogger() {

        return logger;

    }

}
