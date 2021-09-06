package io.github.thebusybiscuit.hotbarpets;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;

public class HotbarPetsRunnable implements Runnable {

    private final HotbarPet chicken;
    private final HotbarPet mooshroom;
    private final HotbarPet fish;
    private final HotbarPet goldenCow;

    protected HotbarPetsRunnable() {
        chicken = (HotbarPet) SlimefunItem.getById("HOTBAR_PET_CHICKEN");
        mooshroom = (HotbarPet) SlimefunItem.getById("HOTBAR_PET_MOOSHROOM");
        fish = (HotbarPet) SlimefunItem.getById("HOTBAR_PET_FISH");
        goldenCow = (HotbarPet) SlimefunItem.getById("HOTBAR_PET_GOLDEN_COW");
    }

    @Override
    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            for (int i = 0; i < 9; ++i) {
                ItemStack item = p.getInventory().getItem(i);

                if (item == null || item.getType() == Material.AIR) {
                    continue;
                }

                if (isPet(item, chicken)) {
                    if (chicken.checkAndConsumeFood(p)) {
                        p.getInventory().addItem(new ItemStack(Material.EGG));
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1.0F, 2.0F);
                    }
                } else if (isPet(item, mooshroom)) {
                    if (mooshroom.checkAndConsumeFood(p)) {
                        p.getInventory().addItem(new ItemStack(Material.MUSHROOM_STEW));
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_COW_AMBIENT, 1.0F, 2.0F);
                    }
                } else if (isPet(item, fish)) {
                    if (fish.checkAndConsumeFood(p)) {
                        p.getInventory().addItem(new ItemStack(Material.COOKED_COD));
                        p.getWorld().playSound(p.getLocation(), Sound.BLOCK_WATER_AMBIENT, 1.0F, 2.0F);
                    }
                } else if (isPet(item, goldenCow)) {
                    if (goldenCow.checkAndConsumeFood(p)) {
                        p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT));
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_COW_AMBIENT, 0.8F, 2.0F);
                    }
                }
            }
        }
    }

    private boolean isPet(ItemStack item, HotbarPet pet) {
        return pet != null && SlimefunUtils.isItemSimilar(item, pet.getItem(), true);
    }
}
