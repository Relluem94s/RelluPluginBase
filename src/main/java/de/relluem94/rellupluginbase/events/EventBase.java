package de.relluem94.rellupluginbase.events;

import de.relluem94.minecraft.server.spigot.essentials.contexts.ServiceContext;
import de.relluem94.minecraft.server.spigot.essentials.interfaces.ListenerConstruct;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.jetbrains.annotations.NotNull;

import static de.relluem94.rellupluginbase.RelluPluginBase.PLUGIN_PREFIX;
public class EventBase implements ListenerConstruct {

    private ServiceContext serviceContext;

    @Override
    public void injectContext(ServiceContext context) {
        this.serviceContext = context;
    }

    @EventHandler
    public void playerDeath(@NotNull PlayerDeathEvent event) {
        event.setDeathMessage(PLUGIN_PREFIX + "§c" + event.getDeathMessage());
        serviceContext.getPlayerService().setAFK(event.getEntity(), false);
    }
}