package com.glenjendary.clearchat.commands;

import com.glenjendary.clearchat.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* ClearChat Created by Glenjendary on 6/07/2017. */

public class ClearChat implements CommandExecutor {

    private Main plugin;
    public ClearChat(Main plugin) {
        this.plugin = plugin;
    }

    public static boolean timer = false;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("clearchat") && player.hasPermission("clearchat.clear")) {
            //Loop through all players
            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                //Check which has permission to bypass clearchat
                if (all.hasPermission("clearchat.clear")) {
                    //Tell them Chat has been cleared
                    all.sendMessage(ChatColor.BLUE + "[SC] " + player + " has cleared the chat!");
                    all.sendMessage(ChatColor.BLUE + "[SC] Chat will resume in 5 SECONDS!");
                    //Return if they do (don't clear chat for them)
                    return false;
                } else {
                    //Send a blank message 54 times
                    for (int i=0; i<54; i++) {
                        all.sendMessage(" ");
                    }
                    timer = true;
                    all.sendMessage(ChatColor.RED + "Chat has been cleared by " + player + "!");

                    Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable(){
                        public void run(){
                            timer = false;
                        }
                    },100);
                }
                }
            }


        return false;
    }
}
