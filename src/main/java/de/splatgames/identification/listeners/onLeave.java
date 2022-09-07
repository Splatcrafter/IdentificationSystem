package de.splatgames.identification.listeners;

import de.splatgames.identification.identificationsystem.IdentificationSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class onLeave implements Listener {

    private IdentificationSystem main;

    public onLeave(IdentificationSystem main){
        this.main = main;
    }

    @EventHandler
    public void onLeaveEvent(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        main.getIdent().removeID(player);
    }

    @EventHandler
    public void onKickEvent(PlayerKickEvent event) {
        Player player = event.getPlayer();
        main.getIdent().removeID(player);
    }
}
