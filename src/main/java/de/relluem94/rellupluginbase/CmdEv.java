package de.relluem94.rellupluginbase;

import de.relluem94.rellupluginbase.commands.CommandBase;
import java.util.Objects;

import org.bukkit.plugin.PluginManager;

import de.relluem94.rellupluginbase.events.EventBase;

import static de.relluem94.rellupluginbase.Strings.*;

import static de.relluem94.minecraft.server.spigot.essentials.Strings.LANG_COMMANDS_REGISTERED;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.LANG_EVENTS_REGISTERED;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.LANG_REGISTER_COMMANDS;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.LANG_REGISTER_EVENTS;
import static de.relluem94.minecraft.server.spigot.essentials.helpers.ChatHelper.consoleSendMessage;

public class CmdEv {

    de.relluem94.rellupluginbase.RelluPluginBase main;

    public CmdEv(de.relluem94.rellupluginbase.RelluPluginBase instance) {
        main = instance;
    }

    public void registerCommands() {
        consoleSendMessage(PLUGIN_NAME_CONSOLE, LANG_REGISTER_COMMANDS);
        Objects.requireNonNull(main.getCommand("base")).setExecutor(new CommandBase());
        consoleSendMessage(PLUGIN_NAME_CONSOLE, LANG_COMMANDS_REGISTERED);
    }

    public void registerEvents() {
        PluginManager pm = main.getServer().getPluginManager();
        consoleSendMessage(PLUGIN_NAME_CONSOLE, LANG_REGISTER_EVENTS);


        pm.registerEvents(new EventBase(), main);

        consoleSendMessage(PLUGIN_NAME_CONSOLE, LANG_EVENTS_REGISTERED);
    }
}