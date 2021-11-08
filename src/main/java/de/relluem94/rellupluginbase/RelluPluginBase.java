package de.relluem94.rellupluginbase;

import java.util.Calendar;
import java.util.Objects;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.relluem94.rellupluginbase.commands.CommandBase;
import de.relluem94.rellupluginbase.events.EventBase;

import static de.relluem94.rellupluginbase.Strings.PLUGIN_SECONDARY_COLOR;

import static de.relluem94.minecraft.server.spigot.essentials.helpers.ChatHelper.consoleSendMessage;

import static de.relluem94.minecraft.server.spigot.essentials.Strings.PLUGIN_BORDER;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.PLUGIN_STARTTIME;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.PLUGIN_START_MESSAGE;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.PLUGIN_STOP_MESSAGE;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.LANG_COMMANDS_REGISTERED;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.LANG_EVENTS_REGISTERED;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.LANG_REGISTER_COMMANDS;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.LANG_REGISTER_EVENTS;
import static de.relluem94.rellupluginbase.Strings.PLUGIN_NAME_CONSOLE;

public class RelluPluginBase extends JavaPlugin {

    @Override
    public void onEnable() {
        long start = Calendar.getInstance().getTimeInMillis();
        consoleSendMessage(PLUGIN_SECONDARY_COLOR, PLUGIN_BORDER);
        consoleSendMessage(PLUGIN_NAME_CONSOLE, "");
        consoleSendMessage(PLUGIN_NAME_CONSOLE, "");
        consoleSendMessage(PLUGIN_NAME_CONSOLE, PLUGIN_SECONDARY_COLOR + PLUGIN_START_MESSAGE);
        consoleSendMessage(PLUGIN_NAME_CONSOLE, "");

        PluginManager pm = getServer().getPluginManager();
        consoleSendMessage(PLUGIN_NAME_CONSOLE, LANG_REGISTER_EVENTS);
        pm.registerEvents(new EventBase(), this);
        consoleSendMessage(PLUGIN_NAME_CONSOLE, LANG_EVENTS_REGISTERED);
        
        consoleSendMessage(PLUGIN_NAME_CONSOLE, LANG_REGISTER_COMMANDS);
        Objects.requireNonNull(this.getCommand("base")).setExecutor(new CommandBase());
        consoleSendMessage(PLUGIN_NAME_CONSOLE, LANG_COMMANDS_REGISTERED);

        consoleSendMessage(PLUGIN_NAME_CONSOLE, "");
        consoleSendMessage(PLUGIN_NAME_CONSOLE, PLUGIN_SECONDARY_COLOR + String.format(PLUGIN_STARTTIME, Calendar.getInstance().getTimeInMillis() - start));
        consoleSendMessage(PLUGIN_NAME_CONSOLE, "");
        consoleSendMessage(PLUGIN_SECONDARY_COLOR + PLUGIN_BORDER, "");
    }

    @Override
    public void onDisable() {
        consoleSendMessage(PLUGIN_NAME_CONSOLE, PLUGIN_SECONDARY_COLOR + PLUGIN_STOP_MESSAGE);
    }
}