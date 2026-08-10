package de.relluem94.rellupluginbase.commands;

import static de.relluem94.rellupluginbase.RelluPluginBase.PLUGIN_PREFIX;

import de.relluem94.minecraft.server.spigot.essentials.annotations.CommandName;
import de.relluem94.minecraft.server.spigot.essentials.contexts.ServiceContext;
import de.relluem94.minecraft.server.spigot.essentials.interfaces.CommandConstruct;
import de.relluem94.minecraft.server.spigot.essentials.interfaces.CommandsEnum;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

@CommandName("base")
public class CommandBase implements CommandConstruct {

    private ServiceContext serviceContext;

    @Override
    public void injectContext(ServiceContext context) {
        this.serviceContext = context;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String cmdLabel, String[] args) {
        if(serviceContext.getGroupService().isSenderAuthorized(sender, "user")){
            sender.sendMessage(PLUGIN_PREFIX + "Drop the (Data)Base!");
        }
        return true;
    }

    @Override
    public CommandsEnum[] getCommands() {
        return new CommandsEnum[0];
    }

    @Override
    public @Nullable List<String> onTabComplete(@NonNull CommandSender sender,
        @NonNull Command command, @NonNull String label, @NonNull String[] args) {
        return List.of();
    }
}