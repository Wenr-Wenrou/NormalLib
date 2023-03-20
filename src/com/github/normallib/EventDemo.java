package com.github.normallib;

import com.github.normallib.event.EventManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class EventDemo{
    private Plugin plugin;

    public EventDemo() {
        plugin = Bukkit.getPluginManager().getPlugin("NormalLib");
        onPlayerJoin();
    }

    public void onPlayerJoin() {
        EventManager eventManager = new EventManager(plugin);
        eventManager.registerEvent(PlayerJoinEvent.class, EventPriority.NORMAL , (event) -> {
            Player player = event.getPlayer();
            player.sendMessage("欢迎玩家" + player.getName() + "进入服务器");
        });
    }
}
