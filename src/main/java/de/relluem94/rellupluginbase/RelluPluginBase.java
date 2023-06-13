package de.relluem94.rellupluginbase;

import static de.relluem94.minecraft.server.spigot.essentials.Strings.PLUGIN_FORMS_BORDER;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.PLUGIN_MANAGER_COMMANDS_REGISTERED;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.PLUGIN_MANAGER_EVENTS_REGISTERED;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.PLUGIN_MANAGER_REGISTER_COMMANDS;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.PLUGIN_MANAGER_REGISTER_EVENTS;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.PLUGIN_MANAGER_STARTTIME_MESSAGE;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.PLUGIN_MANAGER_START_MESSAGE;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.PLUGIN_MANAGER_STOP_MESSAGE;
import static de.relluem94.minecraft.server.spigot.essentials.helpers.ChatHelper.consoleSendMessage;

import java.util.Calendar;
import java.util.Objects;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.relluem94.rellupluginbase.commands.CommandBase;
import de.relluem94.rellupluginbase.events.EventBase;
public class RelluPluginBase extends JavaPlugin {
    
    public final static String PLUGIN_NAME = "RelluPluginBase";
    public final static String PLUGIN_PRIMARY_COLOR = "§5";
    public final static String PLUGIN_SECONDARY_COLOR = "§16";
    public final static String PLUGIN_NAME_CONSOLE = PLUGIN_SECONDARY_COLOR + "[" + PLUGIN_PRIMARY_COLOR + PLUGIN_NAME + PLUGIN_SECONDARY_COLOR + "]";
    public final static String PLUGIN_PREFIX = PLUGIN_PRIMARY_COLOR + PLUGIN_NAME;

    @Override
    public void onEnable() {
        long start = Calendar.getInstance().getTimeInMillis();
        consoleSendMessage(PLUGIN_SECONDARY_COLOR, PLUGIN_FORMS_BORDER);
        consoleSendMessage(PLUGIN_NAME_CONSOLE, "");
        consoleSendMessage(PLUGIN_NAME_CONSOLE, "");
        consoleSendMessage(PLUGIN_NAME_CONSOLE, PLUGIN_SECONDARY_COLOR + PLUGIN_MANAGER_START_MESSAGE);
        consoleSendMessage(PLUGIN_NAME_CONSOLE, "");

        PluginManager pm = getServer().getPluginManager();
        consoleSendMessage(PLUGIN_NAME_CONSOLE, PLUGIN_MANAGER_REGISTER_EVENTS);
        pm.registerEvents(new EventBase(), this);
        consoleSendMessage(PLUGIN_NAME_CONSOLE, PLUGIN_MANAGER_EVENTS_REGISTERED);
        
        consoleSendMessage(PLUGIN_NAME_CONSOLE, PLUGIN_MANAGER_REGISTER_COMMANDS);
        Objects.requireNonNull(this.getCommand("base")).setExecutor(new CommandBase());
        consoleSendMessage(PLUGIN_NAME_CONSOLE, PLUGIN_MANAGER_COMMANDS_REGISTERED);

        consoleSendMessage(PLUGIN_NAME_CONSOLE, "");
        consoleSendMessage(PLUGIN_NAME_CONSOLE, PLUGIN_SECONDARY_COLOR + String.format(PLUGIN_MANAGER_STARTTIME_MESSAGE, Calendar.getInstance().getTimeInMillis() - start));
        consoleSendMessage(PLUGIN_NAME_CONSOLE, "");
        consoleSendMessage(PLUGIN_SECONDARY_COLOR + PLUGIN_FORMS_BORDER, "");
    }

    @Override
    public void onDisable() {
        consoleSendMessage(PLUGIN_NAME_CONSOLE, PLUGIN_SECONDARY_COLOR + PLUGIN_MANAGER_STOP_MESSAGE);
    }
}