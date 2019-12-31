package io.github.thebusybiscuit.hotbarpets.pets.special;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.hotbarpets.SimpleBasePet;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class CookieSlimePet extends SimpleBasePet {

	public CookieSlimePet(Category category, SlimefunItemStack item, ItemStack food, ItemStack[] recipe) {
		super(category, item, food, recipe);
	}

	@Override
	public void onUseItem(Player p) {
		p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 160, 2));
        p.getWorld().playSound(p.getLocation(), Sound.BLOCK_SLIME_BLOCK_STEP, 1.0F, 2.0F);
	}
	
}
