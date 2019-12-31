package io.github.thebusybiscuit.hotbarpets.pets;

import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.hotbarpets.SimpleBasePet;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class GhastPet extends SimpleBasePet {

	public GhastPet(Category category, SlimefunItemStack item, ItemStack food, ItemStack[] recipe) {
		super(category, item, food, recipe);
	}
	
	@Override
	public void onUseItem(Player p) {
		p.launchProjectile(Fireball.class);
        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 500, 1));
	}

}
