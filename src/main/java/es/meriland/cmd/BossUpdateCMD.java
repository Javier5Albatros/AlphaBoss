package es.meriland.cmd;

import es.meriland.Boss;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class BossUpdateCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        List<Entity> ents = Bukkit.getServer().selectEntities(sender, args[0]);

        for(Entity ent: ents) {
            Boss boss = new Boss((LivingEntity)ent);
            boss.update();
            boss.showAttribs();
        }
        return true;
    }
}
