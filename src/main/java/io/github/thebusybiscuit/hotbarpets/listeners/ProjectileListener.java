package io.github.thebusybiscuit.hotbarpets.listeners;

import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import io.github.thebusybiscuit.hotbarpets.HotbarPets;

public class ProjectileListener implements Listener {

    private final HotbarPets plugin;

    public ProjectileListener(HotbarPets plugin) {
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onTippedArrowHit(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Arrow && e.getEntity().hasMetadata("hotbarpets_projectile")) {
            e.getEntity().removeMetadata("hotbarpets_projectile", plugin);
            e.getEntity().remove();
        }
    }

}
