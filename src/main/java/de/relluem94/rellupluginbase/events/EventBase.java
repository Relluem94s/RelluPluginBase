package de.relluem94.rellupluginbase.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.jetbrains.annotations.NotNull;

public class EventBase implements Listener {

    @EventHandler
    public void playerDeath(@NotNull PlayerDeathEvent event) {
        event.setDeathMessage("§c" + event.getDeathMessage());
    }
}