package com.glenjendary.clearchat;

/* ClearChat Created by Glenjendary on 6/07/2017. */

import com.glenjendary.clearchat.commands.ClearChat;
import com.glenjendary.clearchat.events.ChatToggle;
import com.glenjendary.clearchat.events.AuthorJoin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    public void onEnable() {

        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();

        registerCommands();
        registerEvents();

        logger.info(pdfFile.getName() + " has been enabled with version "
                + pdfFile.getVersion());

    }

    public void registerCommands() {

        getCommand("clearchat").setExecutor(new ClearChat(this));

    }

    public void registerEvents() {

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ChatToggle(this), this);
        pm.registerEvents(new AuthorJoin(this), this);

    }

    public void onDisable() {

        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();

        logger.info(pdfFile.getName() + " has been disabled with version "
                + pdfFile.getVersion());
    }

}
