package fr.azrotho.druhc.Commands;

import fr.azrotho.druhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

public class StartCommand implements CommandExecutor {

    private Main main;
    public StartCommand(Main main) { this.main = main; }
    
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player)){




            int id = 0;
            for(Player p : Bukkit.getOnlinePlayers()){
                TPRandom(p);
                DefRoles(p, id);

                id++;
            }
            return true;
        }else{
            Player player = (Player) commandSender;
            player.sendMessage("§c§lSeul la console peut démarrer la partie");
            return true;
        }


    }

    public void TPRandom(Player p){
        Location location = new Location(p.getWorld(), 0, 0, 0);

        location.setX(Math.random() * 1000 * 2 - 1000);
        location.setZ(Math.random() * 1000 * 2 - 1000);
        location.setY(p.getWorld().getHighestBlockAt(location.getBlockX(), location.getBlockZ()).getY());
    }

    public static void DefRoles(Player p, int id){
        UUID uuid = p.getUniqueId();
        switch (id){
            case 0:
                Main.getRoles().put(uuid, "Makoto");
                Main.getRolesreverse().put("Makoto", uuid);
                Main.getCamp().put(uuid, "Gentil");
                break;
            case 1:
                Main.getRoles().put(uuid, "Monokuma");
                Main.getRolesreverse().put("Monokuma", uuid);
                Main.getCamp().put(uuid, "Mechant");
                break;
            case 2:
                Main.getRoles().put(uuid, "Chihiro");
                Main.getRolesreverse().put("Chihiro", uuid);
                Main.getCamp().put(uuid, "Gentil");
                break;
            case 3:
                Main.getRoles().put(uuid, "Byakuya");
                Main.getRolesreverse().put("Byakuya", uuid);
                Main.getCamp().put(uuid, "Gentil");
                break;
            case 4:
                Main.getRoles().put(uuid, "Junko");
                Main.getRolesreverse().put("Junko", uuid);
                Main.getCamp().put(uuid, "Mechant");
                break;
            case 5:
                Main.getRoles().put(uuid, "Toko");
                Main.getRolesreverse().put("Toko", uuid);
                Main.getCamp().put(uuid, "Gentil");
                break;
            case 6:
                Main.getRoles().put(uuid, "Mondo");
                Main.getRolesreverse().put("Mondo", uuid);
                Main.getCamp().put(uuid, "Gentil");
                break;
            case 7:
                Main.getRoles().put(uuid, "Sakura");
                Main.getRolesreverse().put("Sakura", uuid);
                Main.getCamp().put(uuid, "Gentil");
                break;
            case 8:
                Main.getRoles().put(uuid, "Aoi");
                Main.getRolesreverse().put("Aoi", uuid);
                Main.getCamp().put(uuid, "Gentil");
                break;
            case 9:
                Main.getRoles().put(uuid, "Hifumi");
                Main.getRolesreverse().put("Hifumi", uuid);
                Main.getCamp().put(uuid, "Gentil");
                break;
            case 10:
                Main.getRoles().put(uuid, "Sayaka");
                Main.getRolesreverse().put("Sayaka", uuid);
                Main.getCamp().put(uuid, "Gentil");
                break;
            case 11:
                Main.getRoles().put(uuid, "Kyoko");
                Main.getRolesreverse().put("Kyoko", uuid);
                Main.getCamp().put(uuid, "Gentil");
                break;
            case 12:
                Main.getRoles().put(uuid, "Celestia");
                Main.getRolesreverse().put("Celestia", uuid);
                Main.getCamp().put(uuid, "Gentil");
                break;
            case 13:
                Main.getRoles().put(uuid, "Mukuro");
                Main.getRolesreverse().put("Mukoro", uuid);
                Main.getCamp().put(uuid, "Solo");
                break;
            case 14:
                Main.getRoles().put(uuid, "Ishimaru");
                Main.getRolesreverse().put("Ishimaru", uuid);
                Main.getCamp().put(uuid, "Gentil");
                break;
            case 15:
                Main.getRoles().put(uuid, "Yasuhiro");
                Main.getRolesreverse().put("Yasuhiro", uuid);
                Main.getCamp().put(uuid, "Gentil");
                break;
            case 16:
                Main.getRoles().put(uuid, "Leon");
                Main.getRolesreverse().put("Leon", uuid);
                Main.getCamp().put(uuid, "Gentil");
                break;
        }
    }

    public static void SetRoles(Player p) {
        String role = Main.getRoles().get(p.getUniqueId());
        switch (role) {
            case "Makoto":
                p.sendMessage("§b§lVous êtes Makoto Naegi, Ultime Chanceux, Vous devez éliminer Monokuma, Vous êtes connu de tous, Vous incarnez l'espoir au sein de Kibogamine, Vous devez gagner avec les autres étudients!");
                Bukkit.broadcastMessage("§c§lL'espoir au sein de cet école, aka Makoto Naegi est: §f§l" + p.getDisplayName());
                break;
            case "Monokuma":
                p.sendMessage("§c§lVous êtes Monokuma, upupupu, Vous avez comme but d'exterminer les vilains élèves de Kibogamine, Si vous mourrez vous réapparaissez avec un coeur en Moins, Mais si Junko meurt, vous mourrez, à savoir que vous pouvez infecter un Joueur avec §6§l/dr infect <pseudo>");
                break;
            case "Chihiro":
                p.sendMessage("§b§lVous êtes Chihiro, Ultime Programmeur une frêle fille, Vous devez éliminer Monokuma, mais vous êtes invisible durant les phases de nuit.");
                break;
            case "Byakuya":
                p.sendMessage("§b§lVous êtes Byakuya, Ultime Héritier, Vous devez éliminer Monokuma, vous possédez Speed II et vous avez l'information quand §bToko §b§l se transforme en §5Genocider Sho");
                break;
            case "Junko":
                p.sendMessage("§c§lVous êtes Junko, Ultime Fashionsta, Vous devez tuer les étudients, vous possédez Force I, et si vous mourrez Monokuma meurt avec vous.");
                UUID MonoUUID = Main.getRolesreverse().get("Monokuma");
                Player Monokuma = Bukkit.getPlayer(MonoUUID);
                p.sendMessage("§a§lPseudo de Monokuma: §f" + Monokuma.getDisplayName());
                break;
            case "Toko":
                p.sendMessage("§b§lVous êtes Toko, Ultime Romancière, Vous devez éliminer Monokuma, Vous n'avez aucun spécial dans la partie, sauf que si vous mourrez vous devenez §5Genocider Sho");
                UUID ByakuUUID = Main.getRolesreverse().get("Byakuya");
                Player Byakuya = Bukkit.getPlayer(ByakuUUID);
                p.sendMessage("§a§lPseudo de Byakuya: §f" + Byakuya.getDisplayName());
                break;
            case "Mondo":
                p.sendMessage("§b§lVous êtes Mondo, Ultime Chef de Gang, Vous devez éliminer Monokuma, Vous disposez de l'effet Force.");
                break;
            case "Sakura":
                p.sendMessage("§b§lVous êtes Sakura, Ultime Combattante, Vous devez éliminer Monokuma, Vous disposez de l'effet Force et vous connaissez Aoi");
                UUID AoUUID = Main.getRolesreverse().get("Aoi");
                Player Aoi = Bukkit.getPlayer(AoUUID);
                p.sendMessage("§a§lPseudo de Aoi: §f" + Aoi.getDisplayName());
                break;
            case "Aoi":
                p.sendMessage("§b§lVous êtes Aoi, Ultime Nageuse, Vous devez éliminer Monokuma, Vous disposez de l'effet Speed I et un Livre Depth Strider 3, Vous connaissez Sakura");
                UUID SakuUUID = Main.getRolesreverse().get("Sakura");
                Player Sakura = Bukkit.getPlayer(SakuUUID);
                p.sendMessage("§a§lPseudo de Sakura: §f" + Sakura.getDisplayName());
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " minecraft:enchanted_book 1 0 {ench:[{id:8,lvl:3}]}");
                break;
            case "Hifumi":
                p.sendMessage("§b§lVous êtes Hifumi, Ultime Auteur de Fanzine (vive la 2d), Vous devez éliminer Monokuma, Vous disposez de l'effet Résistance");
                break;
            case "Sayaka":
                p.sendMessage("§b§lVous êtes Sayaka, Ultime Idol, Vous devez éliminer Monokuma, Vous disposez de l'effet Speed I et d'une Épée Knockback 2");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " minecraft:iron_sword 1 0 {ench:[{id:19,lvl:2}]}");
                break;
            case "Kyoko":
                p.sendMessage("§b§lVous êtes Kyoko, Ultime ???, Vous devez éliminer Monokuma, Vous savez quand un Joueur a été infecté");
                break;
            case "Celestia":
                p.sendMessage("§b§lVous êtes Celestia, Ultime Parieuse, Vous devez éliminer Monokuma, Vous avez 15 Coeurs.");
                p.setMaxHealth(30);
                break;
            case "Mukuro":
                p.sendMessage("§5§lVous êtes Mukuro, Vous devez gagner seul, Vous avez un Arc Power III et Punch II, Force I et 15 Coeurs");
                p.setMaxHealth(30);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " minecraft:bow 1 0 {ench:[{id:48,lvl:3},{id:49,lvl:2}]}");
                break;
            case "Ishimaru":
                p.sendMessage("§b§lVous êtes Ishimaru, Vous devez éliminer Monokuma, Vous disposez de l'effet Speed II");
                break;
            case "Yasuhiro":
                p.sendMessage("§b§lVous êtes Yasuhiro, Ultime Voyant, Vous devez éliminer Monokuma, Avec §6§l/dr check <pseudo1> <pseudo2> <pseudo3>§b§l, Si les joueurs sont dans le même camp");
                break;
            case "Leon":
                p.sendMessage("Vous êtes Leon, Vous devez éliminer Monokuma, Et vous avez un Arc Punch II");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " minecraft:bow 1 0 {ench:[{id:49,lvl:2}]}");
                break;
        }

    }






    }
