package org.lumenk.newdaywarp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class DataCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length != 1)return false;

        switch (args[0]){
            case "save" -> {

            }
            case "load" -> {

            }
            default -> {
                sender.sendMessage("/warpdata load");
                sender.sendMessage("/warpdata save");
            }
        }
        return true;
    }
}
