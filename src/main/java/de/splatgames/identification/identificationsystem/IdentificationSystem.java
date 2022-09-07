package de.splatgames.identification.identificationsystem;

import de.splatgames.identification.api.Identification;
import de.splatgames.identification.commands.CMD_ID;
import de.splatgames.identification.commands.CMD_OnlinePlayers;
import de.splatgames.identification.listeners.onJoin;
import de.splatgames.identification.listeners.onLeave;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class IdentificationSystem extends JavaPlugin {

    private static IdentificationSystem plugin;
    private static Identification ident;
    public static String NoPerms = "§8» §6Splatgames.de §8┃ §cDu hast leider keine Rechte für diesen Befehl! Benötigte Berechtigung: $permission";
    public static String Prefix = "§8» §6Splatgames.de §8┃ §r";
    public static String Console = "§8» §6Splatgames.de §8┃ §cDie Konsole kann diesen Command nicht ausführen!";
    public static String Debug = "§8» §6Splatgames.de - Debugger §8┃ §c";

    @Override
    public void onEnable() {
        plugin = this;
        ident = new Identification();
        msg();

        registerCommand(
                new CMD_ID(this),
                new CMD_OnlinePlayers(this)
        );

        registerListener(
                new onJoin(this),
                new onLeave(this)
        );

        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            getIdent().addID(player);
        }
    }

    @Override
    public void onDisable() {

    }

    public void msg() {
        String developer = null;
        Bukkit.getConsoleSender().sendMessage("§aDas " + this.getDescription().getName() + " v" + this.getDescription().getVersion() + " wurde erfolgreich gestartet!");
        if (this.getDescription().getAuthors().size() < 1) {
            Bukkit.getConsoleSender().sendMessage("§1Plugin by: §4Nicht Angegeben");
        } else {
            for (String author : this.getDescription().getAuthors()) {
                if (developer == null) {
                    developer = author;
                } else {
                    developer = developer + ", " + author;
                }
            }
            Bukkit.getConsoleSender().sendMessage("§1Plugin by: §4" + developer);
        }
        if (this.getDescription().getCommands() != null) {
            Bukkit.getConsoleSender().sendMessage("§cCommandLoader " + this.getDescription().getName() + ":");
            for (String command : this.getDescription().getCommands().keySet()) {
                Bukkit.getConsoleSender().sendMessage("§8[§a+§8] §1" + command);
            }
        }
    }

    public void registerListener(Listener... listeners) {
        Arrays.stream(listeners).forEach(listener -> {
            Bukkit.getPluginManager().registerEvents(listener, this);
        });
    }

    public void registerCommand(CommandExecutor... commands) {
        Arrays.stream(commands).forEach(command -> {
            String name = command.getClass().getSimpleName().replace("CMD_", "");
            getCommand(name).setExecutor(command);
        });
    }

    public static IdentificationSystem getInstance() {
        return plugin;
    }

    public Identification getIdent(){
        return ident;
    }
}
