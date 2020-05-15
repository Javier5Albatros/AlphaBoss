package es.meriland;


import es.meriland.utils.Methods;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;


@Getter
enum BossAttribs {

    DIFFICULTY(1) {
        @Override
        public String update(LivingEntity entity) {
            DIFFICULTY.value = Methods.getScore(Bukkit.getScoreboardManager().getMainScoreboard(), "Tabla", "Dificultad");
            if(DIFFICULTY.value > 96) DIFFICULTY.value = 96;
            return null;
        }
    },
    KNOCBACK_RESISTANCE(0.5) {
        @Override
        public String update(LivingEntity entity) {
            KNOCBACK_RESISTANCE.value = .5 + (.005 * DIFFICULTY.getValue());
            entity.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(KNOCBACK_RESISTANCE.value);
            return null;
        }
    },
    ABSORPTION_AMOUNT(0) { //TODO DAMAGEABLE
        @Override
        public String update(LivingEntity entity) {
            entity.setAbsorptionAmount(1);
            return null;
        }
    },
    MAX_HEALTH(400) { //TODO DAMAGEABLE
        @Override
        public String update(LivingEntity entity) {
            double health = MAX_HEALTH.value;
            MAX_HEALTH.value = 400 + 39 * DIFFICULTY.getValue();
            entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(MAX_HEALTH.value);
            if(health < MAX_HEALTH.value) {
                health = MAX_HEALTH.value - health;
                entity.setHealth(entity.getHealth() + health);
            }
            return null;
        }
    },
    ATTACK_DAMAGE(12) {
        @Override
        public String update(LivingEntity entity) {
            ATTACK_DAMAGE.value = 12 + (.2 * DIFFICULTY.getValue());
            entity.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(ATTACK_DAMAGE.value);
            return null;
        }
    },
    ATTACK_KNOCBACK(10) {
        @Override
        public String update(LivingEntity entity) {
            ATTACK_KNOCBACK.value = 10 +  DIFFICULTY.getValue();
            return "{Attributes:[{Name:generic.attackKnockback,Base:" + ATTACK_KNOCBACK.getValue() + "}]}";
        }
    },
    ARMOR_PROTECTION(0) {
        @Override
        public String update(LivingEntity entity) {
            if(DIFFICULTY.getValue() > 49) {
                ARMOR_PROTECTION.value = 5;
            } else {
                ARMOR_PROTECTION.value = DIFFICULTY.getValue()/10;
            }
            ItemStack[] armor = entity.getEquipment().getArmorContents();
            for(ItemStack piece : armor) {
                if(DIFFICULTY.value > 0) {
                    piece.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)ARMOR_PROTECTION.value);
                } else {
                    piece.removeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL);
                }
            }
            Bukkit.broadcastMessage(ChatColor.GOLD + entity.getScoreboardTags().toString());
            /*return "{ArmorItems:[{id:\"minecraft:diamond_boots\",Count:1b,tag:{Enchantments:[{id:\"minecraft:protection\",lvl:" + (int)ARMOR_PROTECTION.getValue() +
                    "s}]}},{id:\"minecraft:diamond_leggings\",Count:1b,tag:{Enchantments:[{id:\"minecraft:protection\",lvl:" + (int)ARMOR_PROTECTION.getValue() +
                    "s}]}},{id:\"minecraft:diamond_chestplate\",Count:1b,tag:{Enchantments:[{id:\"minecraft:protection\",lvl:" + (int)ARMOR_PROTECTION.getValue()+
                    "s}]}},{id:\"minecraft:diamond_helmet\",Count:1b,tag:{Unbreakable:1b,Enchantments:[{id:\"minecraft:protection\",lvl:" + (int)ARMOR_PROTECTION.getValue() + "s}]}}]}";*/
            return null;
        }
    };

    private double value;

    BossAttribs(double value) {
        this.value = value;
    }

    public abstract String update(LivingEntity entity);

    //data merge entity @e[type=wither_skeleton,limit=1,tag=endboss] {Health:1f,Attributes:[{Name:generic.maxHealth,Base:1}]}

}