package es.meriland;


import es.meriland.utils.Methods;
import org.bukkit.Bukkit;

enum BossAttribs {
    DIFFICULTY(1) {
        @Override
        public void update() {
            DIFFICULTY.value = Methods.getScore(Bukkit.getScoreboardManager().getMainScoreboard(), "Tabla", "Dificultad");
            if(DIFFICULTY.value > 96) DIFFICULTY.value = 96;
        }
    },
    KNOCBACK_RESISTANCE(0.5) {
        @Override
        public void update() {
            KNOCBACK_RESISTANCE.value = .5 + (.005 * DIFFICULTY.getValue());
        }
    },
    ABSORPTION_AMOUNT(0) {
        @Override
        public void update() {

        }
    },
    MAX_HEALTH(400) {
        @Override
        public void update() {

        }
    },
    HEALTH(400) {
        @Override
        public void update() {

        }
    },
    ATTACK_DAMAGE(12) {
        @Override
        public void update() {
            ATTACK_DAMAGE.value = 12 + (.2 * DIFFICULTY.getValue());
        }
    },
    ATTACK_KNOCBACK(10) {
        @Override
        public void update() {
            ATTACK_KNOCBACK.value = 10 +  DIFFICULTY.getValue();
        }
    },
    ARMOR_PROTECTION(0) {
        @Override
        public void update() {
            if(DIFFICULTY.getValue() > 49) {
                ARMOR_PROTECTION.value = 5;
            } else {
                ARMOR_PROTECTION.value = DIFFICULTY.getValue()/10;
            }
        }
    };

    private double value;
    private Object type;

    BossAttribs(double value) {
        this.value = value;
        this.type = type;
    }

    public double getValue() { return this.value; }

    public abstract void update();

}