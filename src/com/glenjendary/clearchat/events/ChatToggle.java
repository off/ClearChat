package com.glenjendary.clearchat.events;

import com.glenjendary.clearchat.Main;
import com.glenjendary.clearchat.commands.ClearChat;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/* ClearChat Created by Glenjendary on 6/07/2017. */
public class ChatToggle implements Listener {

    private Main plugin;
    public ChatToggle(Main plugin) {
        this.plugin = plugin;
    }

    public void onPlayerChat (AsyncPlayerChatEvent event) {

        if (!(event.getPlayer() instanceof Player)) {
            return;
        }

        Player player = event.getPlayer();

        if (!ClearChat.timer) {
            event.setCancelled(false);
        } else if (ClearChat.timer && !(player.hasPermission("chatclear.clear"))) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "Chat will be enabled soon!");
        }
    }
}
