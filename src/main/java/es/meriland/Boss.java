package es.meriland;

import es.meriland.utils.Methods;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;

@Getter
@Setter
public class Boss {

    private String tag;
    private EntityType type;
    private BossAttribs attribs;

    public Boss(String tag, EntityType type) {
        this.tag = tag;
        this.type = type;
    }


    public void update() {
        for(BossAttribs attrib : attribs.values()) {
            attrib.update();
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
