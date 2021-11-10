package de.relluem94.rellupluginbase.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class EventBase implements Listener {

    @EventHandler
    public void playerDeath(PlayerDeathEvent e) {
        e.setDeathMessage("§c" + e.getDeathMessage());
    }
}