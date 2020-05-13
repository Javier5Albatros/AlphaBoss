package es.meriland.cmd;

import es.meriland.Boss;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.org.apache.commons.lang3.EnumUtils;
import org.bukkit.entity.EntityType;

public class UpdateBossCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 2) {

                if(EnumUtils.isValidEnum(EntityType.class, args[1].toUpperCase())) {
                    Boss gfe = new Boss(args[0], EntityType.valueOf(args[1].toUpperCase()));
                    gfe.update();

                    Bukkit.broadcastMessage("Dif: " + String.valueOf(gfe.getDifficulty()));
                    gfe.showAttribs();
                } else {
                    sender.sendMessage("entidad");
                }


        }



        return true;
    }
}
