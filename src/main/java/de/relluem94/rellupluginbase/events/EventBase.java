package de.relluem94.rellupluginbase.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.jetbrains.annotations.NotNull;

import static de.relluem94.rellupluginbase.RelluPluginBase.PLUGIN_PREFIX;

public class EventBase implements Listener {

    @EventHandler
    public void playerDeath(@NotNull PlayerDeathEvent event) {
        event.setDeathMessage(PLUGIN_PREFIX + "§c" + event.getDeathMessage());
    }
}