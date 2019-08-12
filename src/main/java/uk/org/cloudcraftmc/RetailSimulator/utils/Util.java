package uk.org.cloudcraftmc.RetailSimulator.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import uk.org.cloudcraftmc.RetailSimulator.RetailSimulator;

import java.io.File;
import java.io.IOException;

public class Util {

    /*public static void loadSchematic(Location location, String fileName) {
        WorldEditPlugin worldEditPlugin = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
        EditSession session = worldEditPlugin.getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(location.getWorld()), 10000);
        File schematic = new File(RetailSimulator.getInstance().getDataFolder() + File.separator + "/schematics/" + fileName + ".schematic");
        try {
            CuboidClipboard clipboard = MCEditSchematicFormat.getFormat(schematic).load(schematic);
            clipboard.rotate2D(0);
            clipboard.paste(session, new Vector(location.getX(), location.getY(), location.getZ()), true);
        } catch (MaxChangedBlocksException | DataException | IOException e) {
            e.printStackTrace();
        }
    }*/

}
