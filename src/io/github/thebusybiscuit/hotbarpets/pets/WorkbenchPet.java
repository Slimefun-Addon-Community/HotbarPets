package io.github.thebusybiscuit.hotbarpets.pets;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.hotbarpets.SimpleBasePet;

public class WorkbenchPet extends SimpleBasePet {

	public WorkbenchPet(ItemStack item, String name, ItemStack food, ItemStack[] recipe) {
		super(item, name, food, recipe);
	}

	@Override
	public void onUseItem(Player p) {
		 p.openWorkbench(p.getLocation(), true);
         p.getWorld().playSound(p.getLocation(), Sound.BLOCK_WOODEN_BUTTON_CLICK_ON, 1.0F, 2.0F);
	}
	
}
