package io.github.thebusybiscuit.hotbarpets.listeners;

import java.util.Iterator;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;

public class TNTListener implements Listener {

    private static final String METADATA_KEY = "hotbarpets_player";

    private final HotbarPets plugin;

    public TNTListener(HotbarPets plugin) {
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onTNTDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof TNTPrimed && e.getDamager().hasMetadata(METADATA_KEY)) {
            Player attacker = Bukkit.getPlayer((UUID) e.getDamager().getMetadata(METADATA_KEY).get(0).value());

            if (attacker == null) {
                e.setCancelled(true);
            } else if (!Slimefun.getProtectionManager().hasPermission(attacker, e.getEntity().getLocation(), Interaction.ATTACK_PLAYER)) {
                e.setCancelled(true);
                attacker.sendMessage(ChatColor.DARK_RED + "${hotbarpets.hotbarpets_player.message}");
            }
        }
    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onTNTExplode(EntityExplodeEvent e) {
        if (e.getEntityType() == EntityType.PRIMED_TNT && e.getEntity().hasMetadata(METADATA_KEY)) {
            OfflinePlayer player = Bukkit.getOfflinePlayer((UUID) e.getEntity().getMetadata(METADATA_KEY).get(0).value());

            plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> e.getEntity().removeMetadata(METADATA_KEY, plugin), 4);

            Iterator<Block> blocks = e.blockList().iterator();

            while (blocks.hasNext()) {
                Block b = blocks.next();

                if (!Slimefun.getProtectionManager().hasPermission(player, b, Interaction.BREAK_BLOCK)) {
                    blocks.remove();
                }
            }

            // This is pretty much cancelled if all blocks were protected
            if (e.blockList().isEmpty()) {
                e.setCancelled(true);
            }
        }
    }

}
