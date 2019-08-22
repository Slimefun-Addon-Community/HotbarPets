package io.github.thebusybiscuit.hotbarpets.pets;

import org.bukkit.Sound;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.hotbarpets.SimpleBasePet;

public class EndermanPet extends SimpleBasePet {

	public EndermanPet(ItemStack item, String name, ItemStack food, ItemStack[] recipe) {
		super(item, name, food, recipe);
	}
	
	@Override
	public void onUseItem(Player p) {
		p.launchProjectile(EnderPearl.class);
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_AMBIENT, 1.0F, 2.0F);
	}

}
