package com.github.normalpvp.tools;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
/*
* 计时工具类
* */
public class TimerTool {
    private final Plugin plugin;
    private BukkitRunnable task;

    public TimerTool(Plugin plugin) {
        this.plugin = plugin;
    }

    public void startEverySecond(Runnable runnable) {
        task = new BukkitRunnable() {
            @Override
            public void run() {
                runnable.run();
            }
        };
        task.runTaskTimerAsynchronously(plugin, 0L, 20L);
    }

    public void stop() {
        if (task != null) {
            task.cancel();
        }
    }
}