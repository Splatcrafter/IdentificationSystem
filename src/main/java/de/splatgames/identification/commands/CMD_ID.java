package de.splatgames.identification.commands;

import de.splatgames.identification.identificationsystem.IdentificationSystem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_ID implements CommandExecutor {

    private IdentificationSystem main;

    public CMD_ID(IdentificationSystem main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (player != null) {
            player.sendMessage(IdentificationSystem.Prefix + "§6Deine Server ID: §7" + main.getIdent().getID(player));
        } else {
            Bukkit.getConsoleSender().sendMessage(IdentificationSystem.Console);
        }
        return false;
    }
}
