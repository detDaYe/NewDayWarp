package org.lumenk.newdaywarp.tabcompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataCommandCompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        ArrayList<String> result = new ArrayList<>(List.of("load", "save"));
        result.removeIf(s ->  !s.toLowerCase().startsWith(args[args.length - 1].toLowerCase()));
        return result;
    }
}
