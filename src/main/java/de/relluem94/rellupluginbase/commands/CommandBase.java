package de.relluem94.rellupluginbase.commands;

import static de.relluem94.minecraft.server.spigot.essentials.helpers.ChatHelper.sendMessage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.relluem94.minecraft.server.spigot.essentials.permissions.Groups;
import de.relluem94.minecraft.server.spigot.essentials.permissions.Permission;
import org.jetbrains.annotations.NotNull;

public class CommandBase implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String cmdLabel, String[] args) {
        if(cmd.getName().equalsIgnoreCase("base")){
            if(Permission.isAuthorized(sender, Groups.getGroup("user").getId())){
                sendMessage(sender, "Drop the (Data)Base!");
                return true;
            }
        }
        return false;
    }
}