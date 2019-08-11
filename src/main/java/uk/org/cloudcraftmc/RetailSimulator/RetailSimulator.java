package uk.org.cloudcraftmc.RetailSimulator;

import com.github.intellectualsites.plotsquared.api.PlotAPI;
import com.github.intellectualsites.plotsquared.plot.generator.HybridGen;
import com.github.intellectualsites.plotsquared.plot.generator.PlotGenerator;
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
    public PlotAPI api;

    @Override
    public void onEnable() {

        instance = this;
        new Configuration().loadConfiguration();

        PluginManager manager = Bukkit.getServer().getPluginManager();
        final Plugin plotsquared = manager.getPlugin("PlotSquared");

        // Disable the plugin if PlotSquared is not installed

        // If you move any PlotSquared related tasks to en external class you
        // wouldn't have to disable the plugin if PlotSquared wasn't installed

        if(plotsquared != null && !plotsquared.isEnabled()) {
            logger.log(null, "&c[RetailSimulator] Could not find PlotSquared Dependency! Disabling plugin...");
            manager.disablePlugin(this);
            return;
        }

        // Do PlotSquared related stuff
        api = new PlotAPI();

        // You can now use this api object to do powerful things.

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

    public PlotAPI getPlotAPI() {

        return api;

    }

    public static Logger getMinecraftLogger() {

        return logger;

    }

}
