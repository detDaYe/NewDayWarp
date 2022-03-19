package org.lumenk.newdaywarp.listeners;

import net.raidstone.wgevents.events.RegionEnteredEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Objects;

public class RegionEnterListener implements Listener {

    @EventHandler
    public void onRegionEnter(RegionEnteredEvent event){
        final Player player = event.getPlayer();
        final String name = event.getRegionName();

        Objects.requireNonNull(player).sendMessage("you enter " + name);
    }
}
