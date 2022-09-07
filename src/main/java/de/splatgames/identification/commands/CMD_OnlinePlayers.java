package de.splatgames.identification.commands;

import de.splatgames.identification.identificationsystem.IdentificationSystem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.Map;

public class CMD_OnlinePlayers implements CommandExecutor {

    private IdentificationSystem main;

    public CMD_OnlinePlayers(IdentificationSystem main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (player != null) {
            if (player.hasPermission("identification.onlinePlayers") || player.hasPermission("identification.*")) {
                player.sendMessage("§e---- §6Alle Spieler §e-- §6Spieler §8┃ §c" + Bukkit.getServer().getOnlinePlayers().size() + " §e----");
                for (Map.Entry<Player, Integer> entry : main.getIdent().id.entrySet()) {
                    player.sendMessage("§8» §6" + entry.getKey().getName() + " §8┃ §7" + main.getIdent().getID(entry.getKey()));
                }
            } else {
                player.sendMessage(IdentificationSystem.NoPerms.replace("$permission", "identification.onlinePlayers"));
            }
        } else {
            Bukkit.getConsoleSender().sendMessage(IdentificationSystem.Console);
        }
        return false;
    }
}
