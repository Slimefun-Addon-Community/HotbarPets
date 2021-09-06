package io.github.thebusybiscuit.hotbarpets.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Phantom;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

import io.github.thebusybiscuit.hotbarpets.HotbarPet;
import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;

public class PhantomListener implements Listener {

    private final HotbarPet panda;

    public PhantomListener(HotbarPets plugin) {
        panda = (HotbarPet) SlimefunItem.getById("HOTBAR_PET_PANDA");

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPhantomSpawn(EntityTargetLivingEntityEvent e) {
        if (e.getEntityType() == EntityType.PHANTOM && ((Phantom) e.getEntity()).getTarget() instanceof Player) {
            Player p = (Player) ((Phantom) e.getEntity()).getTarget();

            if (!hasPandaPet(p) || !panda.checkAndConsumeFood(p)) {
                return;
            }

            e.getEntity().remove();
            e.setCancelled(true);
        }
    }

    private boolean hasPandaPet(Player player) {
        for (int i = 0; i < 9; i++) {
            if (panda.isItem(player.getInventory().getItem(i))) {
                return true;
            }
        }

        return false;
    }

}
