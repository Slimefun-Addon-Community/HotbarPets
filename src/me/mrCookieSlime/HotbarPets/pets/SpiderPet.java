package me.mrCookieSlime.HotbarPets.pets;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.mrCookieSlime.HotbarPets.SimpleBasePet;

public class SpiderPet extends SimpleBasePet {

	public SpiderPet(ItemStack item, String name, ItemStack food, ItemStack[] recipe) {
		super(item, name, food, recipe);
	}
	
	@Override
	public void onUseItem(Player p) {
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200, 3));
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SPIDER_AMBIENT, 1.0F, 2.0F);
	}

}
