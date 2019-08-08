package uk.org.cloudcraftmc.RetailSimulator.generators;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import uk.org.cloudcraftmc.RetailSimulator.RetailSimulator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class SchematicPopulator extends BlockPopulator {

    File shop = new File(RetailSimulator.getInstance().getDataFolder().getAbsolutePath() + "/DefaultShop.schem");

    @Override
    public void populate(World world, Random random, Chunk chunk) {

        ClipboardFormat format = ClipboardFormats.findByFile(shop);
        Clipboard clipboard = null;
        try (ClipboardReader reader = format.getReader(new FileInputStream(shop))) {
            clipboard = reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (random.nextBoolean()) {
            int amount = random.nextInt(4)+1;  // Amount of trees
            for (int i = 1; i < amount; i++) {
                int X = random.nextInt(15);
                int Z = random.nextInt(15);
                int Y;
                for (Y = world.getMaxHeight()-1; chunk.getBlock(X, Y, Z).getType() == Material.AIR; Y--); // Find the highest block of the (X,Z) coordinate chosen.
                world.generateTree(chunk.getBlock(X, Y, Z).getLocation(), TreeType.MEGA_REDWOOD); // The tree type can be changed if you want.

                try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession((com.sk89q.worldedit.world.World) world, -1)) {
                    Operation operation = new ClipboardHolder(clipboard)
                            .createPaste(editSession)
                            .to(BlockVector3.at(X, Y, Z))
                            .ignoreAirBlocks(false)
                            .build();
                    Operations.complete(operation);
                } catch (WorldEditException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}
