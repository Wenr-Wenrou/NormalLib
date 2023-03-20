package com.github.normallib.event;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Consumer;

public class EventManager {
    private final Plugin plugin;

    public EventManager(Plugin plugin) {
        this.plugin = plugin;
    }

    public <T extends Event> void registerEvent(Class<T> eventClass, Consumer<T> consumer) {
        Bukkit.getPluginManager().registerEvent(eventClass, new Listener() {},
                EventPriority.NORMAL, (listener, event) -> consumer.accept((T) event), plugin);
    }

    public <T extends Event> void registerEvent(Class<T> eventClass, EventPriority priority, Consumer<T> consumer) {
        Bukkit.getPluginManager().registerEvent(eventClass, new Listener() {},
                priority, (listener, event) -> consumer.accept((T) event), plugin);
    }
}
