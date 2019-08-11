package uk.org.cloudcraftmc.RetailSimulator;

import org.bukkit.Bukkit;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import uk.org.cloudcraftmc.RetailSimulator.generators.TycoonGenerator;
import uk.org.cloudcraftmc.RetailSimulator.utils.Configuration;

import java.util.logging.Logger;

public class RetailSimulator extends JavaPlugin {

    private java.lang.Object Object;

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

    public ChunkGenerator getWorldGenerator(String worldName, String id) {

        return new TycoonGenerator();

    }

    public static RetailSimulator getInstance() {

        return instance;

    }

    public static Logger getMinecraftLogger() {

        return logger;

    }

}
