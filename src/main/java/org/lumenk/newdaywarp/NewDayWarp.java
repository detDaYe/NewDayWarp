package org.lumenk.newdaywarp;

import org.bukkit.plugin.java.JavaPlugin;
import org.lumenk.newdaywarp.repositories.WarpRepository;

public final class NewDayWarp extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        WarpRepository.load();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        WarpRepository.save();
    }
}
