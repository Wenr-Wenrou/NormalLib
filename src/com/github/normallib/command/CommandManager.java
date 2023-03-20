package com.github.normallib.command;

import java.util.HashMap;
import java.util.Map;

import com.github.normallib.Demo;
import com.github.normallib.utils.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
public class CommandManager implements CommandExecutor {

    /*
    * example
    *
    *     CommandManager cmdManager = new CommandManager();
    *     cmdManager.registerCommand("subcmd1", new SubCommand1());
    *     cmdManager.registerCommand("subcmd2", new SubCommand2());
    *     getCommand("command").setExecutor(cmdManager);
    *
    * */

    private Map<String, SubCommand> commands = new HashMap<String, SubCommand>();

    public void registerCommand(String name, SubCommand cmd) {
        commands.put(name, cmd);
    }

    public boolean hasPermission(CommandSender sender, String permission) {
        if (sender.hasPermission(permission) || permission == null) {
            return true;
        } else {
            sender.sendMessage(ColorUtil.changeColorChar(Demo.messageConfig.getString("NoPermission")));
            return false;
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length > 0) {
            SubCommand subCmd = commands.get(args[0]);
            if (subCmd != null) {
                if (hasPermission(sender, subCmd.getPermission())) {
                    subCmd.execute(sender, args);
                }
            } else {
                sender.sendMessage(ColorUtil.changeColorChar(Demo.messageConfig.getString("UnKnow")));
            }
        }
        return true;
    }

}
