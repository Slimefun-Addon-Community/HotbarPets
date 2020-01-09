package io.github.thebusybiscuit.hotbarpets;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;

public class HotbarPetsRunnable implements Runnable {

	private final HotbarPet chicken; 
	private final HotbarPet mooshroom; 
	private final HotbarPet fish;
	private final HotbarPet goldenCow;

	public HotbarPetsRunnable() {
		chicken = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_CHICKEN");
		mooshroom = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_MOOSHROOM");
		fish = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_FISH");
		goldenCow = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_GOLDEN_COW");
	}

	@Override
	public void run() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			for (int i = 0; i < 9; ++i) {
				ItemStack item = p.getInventory().getItem(i);

				if (item == null || item.getType() == null || item.getType() == Material.AIR) continue;

				if (chicken != null && SlimefunManager.isItemSimilar(item, chicken.getItem(), true)) {
					if (chicken.tryToConsumeFood(p)) {
						p.getInventory().addItem(new ItemStack(Material.EGG));
						p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1.0F, 2.0F);
					}
				}
				else if (mooshroom != null && SlimefunManager.isItemSimilar(item, mooshroom.getItem(), true)) {
					if (mooshroom.tryToConsumeFood(p)) {
						p.getInventory().addItem(new ItemStack(Material.MUSHROOM_STEM));
						p.getWorld().playSound(p.getLocation(), Sound.ENTITY_COW_AMBIENT, 1.0F, 2.0F);
					}
				}
				else if (fish != null && SlimefunManager.isItemSimilar(item, fish.getItem(), true)) {
					if (fish.tryToConsumeFood(p)) {
						p.getInventory().addItem(new ItemStack(Material.COOKED_COD));
						p.getWorld().playSound(p.getLocation(), Sound.BLOCK_WATER_AMBIENT, 1.0F, 2.0F);
					}
				}
				else if (goldenCow != null && SlimefunManager.isItemSimilar(item, goldenCow.getItem(), true)) {
					if (goldenCow.tryToConsumeFood(p)) {
						p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT));
						p.getWorld().playSound(p.getLocation(), Sound.ENTITY_COW_AMBIENT, 0.8F, 2.0F);
					}
				}
			}
		}
	}

}
