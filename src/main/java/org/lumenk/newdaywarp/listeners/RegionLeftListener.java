package org.lumenk.newdaywarp.listeners;

import net.raidstone.wgevents.events.RegionLeftEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Objects;

public class RegionLeftListener implements Listener {

    @EventHandler
    public void onRegionLeft(RegionLeftEvent event){
        final Player player = event.getPlayer();
        final String name = event.getRegionName();

        Objects.requireNonNull(player).sendMessage("you left " + name);
    }
}
