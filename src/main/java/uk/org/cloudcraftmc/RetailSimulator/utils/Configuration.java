package uk.org.cloudcraftmc.RetailSimulator.utils;

import org.bukkit.configuration.file.FileConfiguration;
import uk.org.cloudcraftmc.RetailSimulator.RetailSimulator;

public class Configuration {

    private FileConfiguration config = RetailSimulator.getInstance().getConfig();
    private void saveConfig() { RetailSimulator.getInstance().saveConfig(); }

    public void loadConfiguration() {

        //See "Creating you're defaults"
        config.options().copyDefaults(true); // NOTE: You do not have to use "plugin." if the class extends the java plugin

        //Save the config whenever you manipulate it
        saveConfig();

        config.addDefault("lang.reload", "&b[CC] &6Plugin reloaded.");
        config.addDefault("lang.reload", "&b[CC] &6Plugin reloaded.");

        config.options().copyDefaults(true);
        saveConfig();

    }

}
