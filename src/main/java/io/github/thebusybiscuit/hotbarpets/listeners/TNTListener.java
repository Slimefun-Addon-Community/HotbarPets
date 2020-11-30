package io.github.thebusybiscuit.hotbarpets.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import me.mrCookieSlime.Slimefun.cscorelib2.protection.ProtectableAction;

public class TNTListener implements Listener {

    private static final String METADATA_KEY = "hotbarpets_player";

    private final HotbarPets plugin;

    public TNTListener(HotbarPets plugin) {
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onTNT(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof TNTPrimed && e.getDamager().hasMetadata(METADATA_KEY)) {
            Player attacker = (Player) e.getDamager().getMetadata(METADATA_KEY).get(0).value();

            e.getDamager().removeMetadata(METADATA_KEY, plugin);

            if (!SlimefunPlugin.getProtectionManager().hasPermission(attacker, e.getEntity().getLocation(), ProtectableAction.PVP)) {
                e.setCancelled(true);
                attacker.sendMessage(ChatColor.DARK_RED + "You cannot harm Players in here!");
            }
        }
    }

}
