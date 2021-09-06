package io.github.thebusybiscuit.hotbarpets.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerQuitEvent;

import io.github.thebusybiscuit.hotbarpets.HotbarPet;
import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;

public class GeneralListener implements Listener {

    public GeneralListener(HotbarPets plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onPlace(BlockPlaceEvent e) {
        if (SlimefunItem.getByItem(e.getItemInHand()) instanceof HotbarPet) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onEquip(InventoryClickEvent e) {
        if (e.getSlotType() == SlotType.ARMOR && SlimefunItem.getByItem(e.getCursor()) instanceof HotbarPet) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        HotbarPet.getMessageDelay().remove(e.getPlayer().getUniqueId());
    }

}
