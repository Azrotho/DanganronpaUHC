package fr.azrotho.druhc.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class drCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        switch (strings[0]) {
            case "help":
                // do something
            case "spec":
                // do something
            case "infect":
                // do something

            default:
                player.sendMessage("§c§lFaites /dr help pour avoir des Informations");



        }
        return true;
    }
}
