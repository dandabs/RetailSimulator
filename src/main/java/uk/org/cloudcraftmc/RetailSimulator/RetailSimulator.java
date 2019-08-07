package uk.org.cloudcraftmc.RetailSimulator;

import org.bukkit.plugin.java.JavaPlugin;
import uk.org.cloudcraftmc.RetailSimulator.utils.Configuration;

public class RetailSimulator extends JavaPlugin {

    public RetailSimulator() {}
    private static RetailSimulator instance;

    @Override
    public void onEnable() {

        instance = this;
        new Configuration().loadConfiguration();

    }

    @Override
    public void onDisable() {



    }

    public static RetailSimulator getInstance() {

        return instance;

    }

}
