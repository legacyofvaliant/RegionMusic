package com.github.e2318501.regionmusic.listener;

import lombok.RequiredArgsConstructor;
import com.github.e2318501.regionmusic.RegionMusic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

@RequiredArgsConstructor
public class PlayerListener implements Listener {
    private final RegionMusic plugin;

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        plugin.getMusicManager().clearPlayer(event.getPlayer());
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        plugin.getMusicManager().clearPlayer(event.getEntity().getPlayer());
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        plugin.getMusicManager().updateMusic(event.getPlayer());
    }
}
