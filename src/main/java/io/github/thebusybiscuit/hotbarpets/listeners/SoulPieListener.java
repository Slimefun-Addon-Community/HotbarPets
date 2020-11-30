package io.github.thebusybiscuit.hotbarpets.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.hotbarpets.HotbarPet;
import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

public class SoulPieListener implements Listener {

    private final HotbarPet eyamaz;

    public SoulPieListener(HotbarPets plugin) {
        eyamaz = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_EYAMAZ");

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onSoulHarvest(EntityDeathEvent e) {
        if (e.getEntity().getKiller() != null) {
            Player p = e.getEntity().getKiller();

            for (int i = 0; i < 9; ++i) {
                ItemStack item = p.getInventory().getItem(i);

                if (eyamaz != null && SlimefunUtils.isItemSimilar(item, eyamaz.getItem(), true)) {
                    e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), new CustomItem(new ItemStack(Material.PUMPKIN_PIE), "&b靈魂派"));
                }
            }
        }

    }

}
