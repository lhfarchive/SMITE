/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.Icelaunche.SMITE;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.*;


public class Smite extends JavaPlugin {

    public static Smite plugin;
    private final Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onDisable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        this.log.info("[Smite]Version "+ pdfFile.getVersion() +" By Icelaunche DISABLED");
    }

    @Override
    public void onEnable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        log.info("[Smite]Version "+ pdfFile.getVersion() +" By Icelaunche ENABLED");

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(sender instanceof Player){
        Player player = (Player) sender;
        World world = player.getWorld();
        if (commandLabel.equalsIgnoreCase("smite")) {
            if (player.hasPermission("cake.moo")) // I dont think that works
            if (args.length == 0) {
                Block targetblock = player.getTargetBlock(null, 50);
                Location location = targetblock.getLocation();
                world.strikeLightning(location);
                world.createExplosion(location, 3);
            } else if (args.length == 1) {
                if (player.getServer().getPlayer(args[0]) != null) {
                    Player targetplayer = player.getServer().getPlayer(args[0]);
                    Location location = targetplayer.getLocation();
                    world.strikeLightning(location);
                    player.sendMessage(ChatColor.GRAY + "Smiting " + targetplayer.getDisplayName() + "!");
                } else {
                    player.sendMessage(ChatColor.DARK_RED + "ERROR: The player is offline!");
                }
            } else if (args.length > 1) {
                player.sendRawMessage(ChatColor.DARK_RED + "ERROR: Too many arguments");
            }else{
                player.sendMessage(ChatColor.DARK_RED + "Noob"); // IDK what that does
            }
        }
        return false;
            
        }
        return true;
  

    }
}

