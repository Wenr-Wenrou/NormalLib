package com.github.normallib;

import com.github.normallib.command.SubCommand;
import com.github.normallib.utils.ColorUtil;
import org.bukkit.command.CommandSender;

public class HelpCommand extends SubCommand {
    public HelpCommand(String permission) {
        super(permission);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(ColorUtil.changeColorChar("&a帮助如下:"));
        sender.sendMessage(ColorUtil.changeColorChar("  &f/normallib reload   ->   重载插件"));
    }
}
