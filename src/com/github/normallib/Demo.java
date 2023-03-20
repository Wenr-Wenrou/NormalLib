package com.github.normallib;

import com.github.normallib.command.CommandManager;
import com.github.normallib.config.ConfigManager;
import com.github.normallib.event.EventManager;
import com.github.normallib.inventory.InventoryBuilder;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Demo extends JavaPlugin {
    private File messageFile;

    public static ConfigManager messageConfig;
    public static InventoryBuilder inventoryBuilder;
    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        // new EventDemo();
        inventoryBuilder = new InventoryBuilder();
        getServer().getPluginManager().registerEvents(inventoryBuilder, this);
        try {
            messageFile = ConfigManager.generate(this.getDataFolder().getPath(), "Message", "yml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        messageConfig = new ConfigManager(this, "message.yml");
        if (messageConfig.getString("Unknow") == null) {
            messageConfig.set("UnKnow", "&f[NormalPlugin] &a未知指令.");
        }

        if (messageConfig.getString("ReloadMessage") == null) {
            messageConfig.set("ReloadMessage", "&f[NormalPlugin] &a重载完成");
        }
        if (messageConfig.getString("NoPermission") == null) {
            messageConfig.set("NoPermission", "&f[NormalPlugin] &c你没有权限执行此操作");
        }
        messageConfig.saveConfig();
        messageConfig.reloadConfig();
        CommandManager commandManager = new CommandManager();
        commandManager.registerCommand("help", new HelpCommand("normallib.help"));
        commandManager.registerCommand("reload", new ReloadCommand("normallib.reload"));
        getServer().getPluginCommand("normallib").setExecutor(commandManager);
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }
}
