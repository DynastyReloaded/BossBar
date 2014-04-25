package me.UaVxChallenge.BarUpdate;

import java.util.logging.Logger;

import me.confuser.barapi.BarAPI;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class BarUpdate extends JavaPlugin {
		public final Logger logger = Logger.getLogger("Minecraft");
		public static BarUpdate plugin;
		
		@Override
		public void onDisable() {
			PluginDescriptionFile pdfFile = this.getDescription();
			this.logger.info(pdfFile.getName() + pdfFile.getVersion() + " Has been Disabled!");
		}
		
		@Override
		public void onEnable() {
			PluginDescriptionFile pdfFile = this.getDescription();
			this.logger.info(pdfFile.getName() + pdfFile.getVersion() + " Has been Enabled!");	
		}
	
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (label.equalsIgnoreCase("ShowBar")){
			BarAPI.setMessage((Player)sender,ChatColor.RED + "The bar is now visible", 100f);
		}
		if(label.equalsIgnoreCase("Hidebar")){
			if(BarAPI.hasBar((Player) sender)){
				BarAPI.removeBar((Player) sender);
			}
		}
		return false;
	}

}
