package fr.azrotho.druhc.listeners;

import fr.azrotho.druhc.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class onDeath implements Listener {

    @EventHandler
    public void OnDeath(PlayerDeathEvent e){
        Player p = e.getEntity().getPlayer();
        if(Objects.equals(Main.getRoles().get(p.getUniqueId()), "Monokuma")){
            // Do Something
        }
        if(Objects.equals(Main.getRoles().get(p.getUniqueId()), "Junko")){
            // Do Stg
        }
    }
}
