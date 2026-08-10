package de.relluem94.rellupluginbase;


import static de.relluem94.minecraft.server.spigot.essentials.constants.Constants.PLUGIN_FORMS_BORDER;
import static de.relluem94.minecraft.server.spigot.essentials.enums.MessageKey.PLUGIN_MANAGER_COMMANDS_REGISTERED;
import static de.relluem94.minecraft.server.spigot.essentials.enums.MessageKey.PLUGIN_MANAGER_EVENTS_REGISTERED;
import static de.relluem94.minecraft.server.spigot.essentials.enums.MessageKey.PLUGIN_MANAGER_REGISTER_COMMANDS;
import static de.relluem94.minecraft.server.spigot.essentials.enums.MessageKey.PLUGIN_MANAGER_REGISTER_EVENTS;
import static de.relluem94.minecraft.server.spigot.essentials.enums.MessageKey.PLUGIN_MANAGER_START_MESSAGE;
import static de.relluem94.minecraft.server.spigot.essentials.enums.MessageKey.PLUGIN_MANAGER_START_TIME_MESSAGE;
import static de.relluem94.minecraft.server.spigot.essentials.enums.MessageKey.PLUGIN_MANAGER_STOP_MESSAGE;
import static de.relluem94.minecraft.server.spigot.essentials.helpers.ChatHelper.consoleSendMessage;

import de.relluem94.minecraft.server.spigot.essentials.RelluEssentials;
import de.relluem94.minecraft.server.spigot.essentials.contexts.ServiceContext;
import de.relluem94.minecraft.server.spigot.essentials.services.TranslationService;
import de.relluem94.minecraft.server.spigot.essentials.wrappers.CommandWrapper;
import de.relluem94.minecraft.server.spigot.essentials.wrappers.ListenerWrapper;
import de.relluem94.rellupluginbase.commands.CommandBase;
import de.relluem94.rellupluginbase.events.EventBase;
import java.util.Calendar;
import java.util.List;
import org.bukkit.plugin.java.JavaPlugin;

public class RelluPluginBase extends JavaPlugin {

  public final static String PLUGIN_NAME = "RelluPluginBase";
  public final static String PLUGIN_PRIMARY_COLOR = "§5";
  public final static String PLUGIN_SECONDARY_COLOR = "§16";
  public final static String PLUGIN_NAME_CONSOLE =
      PLUGIN_SECONDARY_COLOR + "[" + PLUGIN_PRIMARY_COLOR + PLUGIN_NAME + PLUGIN_SECONDARY_COLOR
          + "]";
  public final static String PLUGIN_PREFIX = PLUGIN_PRIMARY_COLOR + PLUGIN_NAME;

  @Override
  public void onEnable() {
    long start = Calendar.getInstance().getTimeInMillis();
    RelluEssentials relluEssentials = RelluEssentials.getInstance();
    ServiceContext serviceContext = relluEssentials.getServiceContext();
    TranslationService translationService = serviceContext.getTranslationService();

    consoleSendMessage(PLUGIN_SECONDARY_COLOR, PLUGIN_FORMS_BORDER);
    consoleSendMessage(PLUGIN_NAME_CONSOLE, "");
    consoleSendMessage(PLUGIN_NAME_CONSOLE, "");
    consoleSendMessage(PLUGIN_NAME_CONSOLE,
        PLUGIN_SECONDARY_COLOR + translationService.get(PLUGIN_MANAGER_START_MESSAGE));
    consoleSendMessage(PLUGIN_NAME_CONSOLE, "");

    consoleSendMessage(PLUGIN_NAME_CONSOLE, translationService.get(PLUGIN_MANAGER_REGISTER_EVENTS));

    List<ListenerWrapper> listenerWrappers = List.of(new ListenerWrapper(new EventBase()));
    listenerWrappers.forEach(listenerWrapper -> listenerWrapper.init(this, serviceContext));

    consoleSendMessage(PLUGIN_NAME_CONSOLE,
        translationService.get(PLUGIN_MANAGER_EVENTS_REGISTERED));

    consoleSendMessage(PLUGIN_NAME_CONSOLE,
        translationService.get(PLUGIN_MANAGER_REGISTER_COMMANDS));

    List<CommandWrapper> wrappers = List.of(new CommandWrapper(new CommandBase()));
    wrappers.forEach(commandWrapper -> commandWrapper.init(this, serviceContext));
    consoleSendMessage(PLUGIN_NAME_CONSOLE,
        translationService.get(PLUGIN_MANAGER_COMMANDS_REGISTERED));

    consoleSendMessage(PLUGIN_NAME_CONSOLE, "");
    consoleSendMessage(PLUGIN_NAME_CONSOLE,
        PLUGIN_SECONDARY_COLOR + translationService.get(PLUGIN_MANAGER_START_TIME_MESSAGE,
            Calendar.getInstance().getTimeInMillis() - start));
    consoleSendMessage(PLUGIN_NAME_CONSOLE, "");
    consoleSendMessage(PLUGIN_SECONDARY_COLOR + PLUGIN_FORMS_BORDER, "");
  }

  @Override
  public void onDisable() {
    consoleSendMessage(PLUGIN_NAME_CONSOLE, PLUGIN_SECONDARY_COLOR + PLUGIN_MANAGER_STOP_MESSAGE);
  }
}