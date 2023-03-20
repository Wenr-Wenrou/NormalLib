package com.github.normallib.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public abstract class SubCommand {
    private String permission;
    public SubCommand(){}

    public SubCommand(String permission) {
        this.permission = permission;
    }
    public String getPermission() {
        return permission;
    }
    public abstract void execute(CommandSender sender, String[] args);
}
