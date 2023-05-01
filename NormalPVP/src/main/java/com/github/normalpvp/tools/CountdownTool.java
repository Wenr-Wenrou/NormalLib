package com.github.normalpvp.tools;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

/*
* 倒计时工具类
* */
public class CountdownTool {
    private final Plugin plugin;
    private BukkitRunnable task;
    private int remainingTime;
    private Runnable onStart;
    private Runnable onTick;
    private Runnable onFinish;

    public CountdownTool(Plugin plugin) {
        this.plugin = plugin;
    }

    public void start(int totalTime, Runnable onStart, Runnable onTick, Runnable onFinish) {
        this.onStart = onStart;
        this.onTick = onTick;
        this.onFinish = onFinish;
        this.remainingTime = totalTime;

        task = new BukkitRunnable() {
            @Override
            public void run() {
                if (remainingTime > 0) {
                    if (onStart != null && remainingTime == totalTime) {
                        plugin.getServer().getScheduler().runTask(plugin, onStart);
                    }
                    if (onTick != null) {
                        plugin.getServer().getScheduler().runTask(plugin, onTick);
                    }
                    remainingTime--;
                } else {
                    if (onFinish != null) {
                        plugin.getServer().getScheduler().runTask(plugin, onFinish);
                    }
                    cancel();
                }
            }
        };
        task.runTaskTimerAsynchronously(plugin, 0L, 20L);
    }

    public void stop() {
        if (task != null) {
            task.cancel();
        }
    }

    public int getRemainingTime() {
        return remainingTime;
    }
}