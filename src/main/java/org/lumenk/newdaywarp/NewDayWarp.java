package org.lumenk.newdaywarp;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.lumenk.newdaywarp.commands.DataCommand;
import org.lumenk.newdaywarp.listeners.RegionEnterListener;
import org.lumenk.newdaywarp.listeners.RegionLeftListener;
import org.lumenk.newdaywarp.repositories.WarpRepository;
import org.lumenk.newdaywarp.tabcompleters.DataCommandCompleter;

import java.util.Objects;

public final class NewDayWarp extends JavaPlugin {

    @Getter
    private static NewDayWarp instance;

    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this;

        final PluginManager pm = Bukkit.getPluginManager();

        WarpRepository.load();
        Objects.requireNonNull(getCommand("warpdata")).setExecutor(new DataCommand());
        Objects.requireNonNull(getCommand("warpdata")).setTabCompleter(new DataCommandCompleter());

        pm.registerEvents(new RegionEnterListener(), this);
        pm.registerEvents(new RegionLeftListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        WarpRepository.save();
    }
}
