package me.mrCookieSlime.HotbarPets.pets;

import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.inventory.ItemStack;

import me.mrCookieSlime.HotbarPets.SimpleBasePet;

public class CreeperPet extends SimpleBasePet {

	public CreeperPet(ItemStack item, String name, ItemStack food, ItemStack[] recipe) {
		super(item, name, food, recipe);
	}

	@Override
	public void onUseItem(Player p) {
		TNTPrimed tnt = (TNTPrimed) p.getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT);
        tnt.setFuseTicks(0);
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1.0F, 2.0F);
	}
	
}
