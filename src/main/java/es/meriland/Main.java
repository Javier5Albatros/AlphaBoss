package es.meriland;

import es.meriland.cmd.UpdateBossCMD;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
public class Main extends JavaPlugin {

    public void onEnable() {
        Bukkit.getPluginCommand("updateboss").setExecutor(new UpdateBossCMD());
    }

    public void onDisable() {

    }
}
