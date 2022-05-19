package fr.azrotho.druhc.utils;

import fr.azrotho.druhc.Commands.StartCommand;
import fr.azrotho.druhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

public class Timer extends BukkitRunnable {

    public int timer = 0;
    Boolean nuit;

    @Override
    public void run() {
        timer++;
        for(Player p : Bukkit.getServer().getOnlinePlayers()){

            final ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
            final Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
            final Objective objective = scoreboard.registerNewObjective("general", "dummy");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            objective.setDisplayName("§c§lDanganronpa UHC");
            final Score Episode = objective.getScore("§c§lÉpisode: §f" + (int) (timer / 1200));
            final Score Timer = objective.getScore("§f" + ((timer - (1200 * (timer / 1200))) / 60 + " §c§lmin§f " + timer % 60));
            final Score Air = objective.getScore("");
            final Score Role = objective.getScore("§c§lRôle: §f20 min");
            Episode.setScore(8);
            Timer.setScore(7);
            Air.setScore(6);
            Role.setScore(5);
            p.setScoreboard(scoreboard);
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20 * 99999, 1, true));


            if(timer == 1200){
                StartCommand.SetRoles(p);
            }
            if(timer % 600 == 300){
                nuit = true;
                p.getLocation().getWorld().setTime(17000);
            }
            if(timer % 600 == 0){
                nuit = false;
                p.getLocation().getWorld().setTime(1000);
            }

            if(Main.getRoles().get(p.getUniqueId()) != null) {
                String role = Main.getRoles().get(p.getUniqueId());

                switch (role) {
                    case "Sakura":
                        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 99999, 0, false));
                    case "Monokuma":
                        p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20 * 99999, 0, false));
                    case "Mondo":
                        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 99999, 0, false));
                    case "Junko":
                        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 99999, 0, false));
                    case "Hifumi":
                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 99999, 0, false));
                    case "Byakuya":
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 99999, 1, false));
                    case "Genocider":
                        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 99999, 0, false));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 99999, 0, false));
                    case "Aoi":
                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 99999, 0, false));
                    case "Ishmaru":
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 99999, 1, false));
                    case "Mokuro":
                        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 99999, 0, false));
                }


               if(timer >= 1200) {

                   if (nuit) {
                       if (role.equals("Chihiro")) {
                           p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20 * 99999, 0, false));
                       }else{
                           p.removePotionEffect(PotionEffectType.INVISIBILITY);
                       }
                   }

               }

            }
        }
    }
}
