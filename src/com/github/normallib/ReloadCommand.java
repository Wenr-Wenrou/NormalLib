package com.github.normallib;

import com.github.normallib.command.SubCommand;
import com.github.normallib.utils.ColorUtil;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends SubCommand {
    public ReloadCommand(String permission) {
        super(permission);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Demo.messageConfig.reloadConfig();
        sender.sendMessage(ColorUtil.changeColorChar(Demo.messageConfig.getString("ReloadMessage")));
    }
}
