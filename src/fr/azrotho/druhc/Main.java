package fr.azrotho.druhc;

import fr.azrotho.druhc.Commands.StartCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class Main extends JavaPlugin {
    private static HashMap<UUID, String> roles;

    private static HashMap<String, UUID> rolesreverse;
    private static HashMap<UUID, String> camp;

    private static HashMap<String, UUID> campreverse;

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("start")).setExecutor(new StartCommand());
        roles = new HashMap<>();
        camp = new HashMap<>();
        rolesreverse = new HashMap<>();
        campreverse = new HashMap<>();
    }

    public static HashMap<UUID, String> getRoles() { return roles; }

    public static HashMap<UUID, String> getCamp() { return camp; }

    public static HashMap<String, UUID> getRolesreverse() { return rolesreverse; }

    public static HashMap<String, UUID> getCampreverse() { return campreverse; }

}
