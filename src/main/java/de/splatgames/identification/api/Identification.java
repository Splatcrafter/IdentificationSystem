package de.splatgames.identification.api;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Identification {

    public int value;
    public HashMap<Player, Integer> id = new HashMap<>();

    public void addID(Player player) {
        value++;
        this.id.put(player, value);
    }

    public void removeID(Player player) {
        id.remove(player);
    }

    public int getID(Player player) {
        return this.id.get(player);
    }

    public Player getByID(int value) {
        for (Map.Entry<Player, Integer> entry : id.entrySet()) {
            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return null;
    }
}
