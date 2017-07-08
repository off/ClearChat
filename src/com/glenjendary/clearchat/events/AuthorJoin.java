package com.glenjendary.clearchat.events;

import com.glenjendary.clearchat.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/* ClearChat Created by Glenjendary on 8/07/2017. */

public class AuthorJoin implements Listener {

    private Main plugin;
    public AuthorJoin(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if (player.getUniqueId().toString().replace("-", "") == "e06c919d712b408a8fff3bd16512ee12") {
            player.sendMessage(ChatColor.RED + "Server is running your ChatClear plugin!");
        }

    }
}
