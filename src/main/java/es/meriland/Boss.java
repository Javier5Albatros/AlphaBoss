package es.meriland;

import es.meriland.utils.Methods;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;

import java.util.Set;

@Getter
@Setter
public class Boss {

    private LivingEntity entity;
    private BossAttribs attribs;

    public Boss(LivingEntity type) {
        this.entity = type;
    }


    public void update() {
        for(BossAttribs attrib : attribs.values()) {
            String update = attrib.update(entity);
            if(update != null) {
                Set<String> tags = entity.getScoreboardTags();
                for(String tag : tags) {
                    Methods.consoleCommand("data merge entity @e[type=" + entity.getType().toString().toLowerCase() + ",limit=1,tag=" + tag + "] " + update);
                    Bukkit.broadcastMessage(ChatColor.AQUA+ "data merge entity @e[type=" + entity.getType().toString().toLowerCase() + ",limit=1,tag=" + tag + "] " + update);
                }
            }
        }
    }

    public void showAttribs() {
        for(BossAttribs attrib : attribs.values()) {
            Bukkit.broadcastMessage(attrib.toString() + ": "+ String.valueOf(attrib.getValue()));
        }
    }

    public double getDifficulty() {
        return attribs.DIFFICULTY.getValue();
    }

}
