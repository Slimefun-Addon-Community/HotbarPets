package io.github.thebusybiscuit.hotbarpets;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;

public class HotbarPetsRunnable implements Runnable {
	
	private HotbarPet chicken, mooshroom, fish;
	
	public HotbarPetsRunnable() {
		chicken = (HotbarPet) SlimefunItem.getByID("");
	}

	@Override
	public void run() {
		for (Player p : Bukkit.getOnlinePlayers()) {
            for (int i = 0; i < 9; ++i) {
                ItemStack item = p.getInventory().getItem(i);

                if (item == null || item.getType() == null || item.getType().equals(Material.AIR)) continue;
                
                if (chicken != null && SlimefunManager.isItemSimiliar(item, chicken.getItem(), true)) {
                    if (!p.getInventory().containsAtLeast(chicken.getFavouriteFood(), 1)) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &rChicken Pet &9would have helped you if you did not neglect it by not feeding it :("));
                    } 
                    else {
                        p.getInventory().removeItem(chicken.getFavouriteFood());
                        p.getInventory().addItem(new ItemStack(Material.EGG));
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1.0F, 2.0F);
                    }
                }
                
                if (mooshroom != null && SlimefunManager.isItemSimiliar(item, mooshroom.getItem(), true)) {
                    if (!p.getInventory().containsAtLeast(mooshroom.getFavouriteFood(), 1)) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &dMooshroom Pet &9would have helped you if you did not neglect it by not feeding it :("));
                    } 
                    else {
                        p.getInventory().removeItem(mooshroom.getFavouriteFood());
                        p.getInventory().addItem(new ItemStack(Material.BEETROOT_SOUP));
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_COW_AMBIENT, 1.0F, 2.0F);
                    }
                }
                
                if (fish != null && SlimefunManager.isItemSimiliar(item, fish.getItem(), true)) {
                    if (!p.getInventory().containsAtLeast(fish.getFavouriteFood(), 1)) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &3Fish Pet &9would have helped you if you did not neglect it by not feeding it :("));
                    } 
                    else {
                        p.getInventory().removeItem(fish.getFavouriteFood());
                        p.getInventory().addItem(new ItemStack(Material.COOKED_COD));
                        p.getWorld().playSound(p.getLocation(), Sound.BLOCK_WATER_AMBIENT, 1.0F, 2.0F);
                    }
                }
            }
        }
	}

}
