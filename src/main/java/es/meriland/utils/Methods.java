package es.meriland.utils;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Methods {


    public static int getScore(Scoreboard scoreboard, String objective, String score) {
        Objective obj = scoreboard.getObjective(objective);
        return obj.getScore(score).getScore();
    }

    public static void setScore(Scoreboard scoreboard, String objective, String score, int value) {
        Objective obj = scoreboard.getObjective(objective);
        obj.getScore(score).setScore(value);
    }

    public static void consoleCommand(String cmd) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
    }
}
