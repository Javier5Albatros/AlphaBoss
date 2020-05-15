package es.meriland.cmd;

import es.meriland.Boss;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.*;
import org.bukkit.craftbukkit.libs.org.apache.commons.lang3.EnumUtils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.List;

public class UpdateBossCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        List<Entity> entitis = Bukkit.getServer().selectEntities(sender, args[0]);

        for(Entity ent : entitis) {
            ent.setCustomNameVisible(true);
            ent.setCustomName(args[1]);
        }



        /*
        if(args.length == 2) {

                if(EnumUtils.isValidEnum(EntityType.class, args[1].toUpperCase())) {
                    Boss gfe = new Boss(args[0], EntityType.valueOf(args[1].toUpperCase()));
                    gfe.update();

                    Bukkit.broadcastMessage("Dif: " + String.valueOf(gfe.getDifficulty()));
                    gfe.showAttribs();
                } else {
                    sender.sendMessage("entidad");
                }



        }*/



        return true;
    }
}
