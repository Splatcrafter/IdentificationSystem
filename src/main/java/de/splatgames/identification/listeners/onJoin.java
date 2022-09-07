package de.splatgames.identification.listeners;

import de.splatgames.identification.identificationsystem.IdentificationSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {

    private IdentificationSystem main;

    public onJoin(IdentificationSystem main){
        this.main = main;
    }

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        main.getIdent().addID(player);
    }
}
