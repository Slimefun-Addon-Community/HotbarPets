package io.github.thebusybiscuit.hotbarpets.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.hotbarpets.HotbarPet;
import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;

public class FoodListener implements Listener {

    private final HotbarPets plugin;
    private final HotbarPet pig;
    private final HotbarPet zombie;

    public FoodListener(HotbarPets plugin) {
        this.plugin = plugin;

        pig = (HotbarPet) SlimefunItem.getById("HOTBAR_PET_PIG");
        zombie = (HotbarPet) SlimefunItem.getById("HOTBAR_PET_ZOMBIE");
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();

        for (int i = 0; i < 9; ++i) {
            ItemStack item = p.getInventory().getItem(i);

            if (pig != null && SlimefunUtils.isItemSimilar(item, pig.getItem(), true)) {

                if (!p.getInventory().containsAtLeast(pig.getFavouriteFood(), 1)) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "${hotbarpets.feedfood.message.03}"));
                    return;
                }

                plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                    p.getInventory().removeItem(pig.getFavouriteFood());
                    p.setSaturation(p.getSaturation() + 8.0F);
                    p.removePotionEffect(PotionEffectType.POISON);
                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PIG_AMBIENT, 1.0F, 2.0F);
                }, 2L);
            } else if (zombie != null && SlimefunUtils.isItemSimilar(e.getItem(), new ItemStack(Material.ROTTEN_FLESH), true) && SlimefunUtils.isItemSimilar(item, zombie.getItem(), true)) {
                plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> p.removePotionEffect(PotionEffectType.HUNGER), 2L);
            }
        }

    }

}
