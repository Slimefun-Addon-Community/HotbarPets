package io.github.thebusybiscuit.hotbarpets.pets;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.hotbarpets.SimpleBasePet;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class PhantomPet extends SimpleBasePet {

	public PhantomPet(Category category, SlimefunItemStack item, ItemStack food, ItemStack[] recipe) {
		super(category, item, food, recipe);
	}
	
	@Override
	public void onUseItem(Player p) {
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 250, 0));
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PHANTOM_AMBIENT, 1.0F, 2.0F);
	}

}
