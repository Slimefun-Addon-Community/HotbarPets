package io.github.thebusybiscuit.hotbarpets.pets;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.hotbarpets.SimpleBasePet;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class CowPet extends SimpleBasePet {

	public CowPet(Category category, SlimefunItemStack item, ItemStack food, ItemStack[] recipe) {
		super(category, item, food, recipe);
	}

	@Override
	public void onUseItem(Player p) {
		p.removePotionEffect(PotionEffectType.BLINDNESS);
        p.removePotionEffect(PotionEffectType.CONFUSION);
        p.removePotionEffect(PotionEffectType.HUNGER);
        p.removePotionEffect(PotionEffectType.POISON);
        p.removePotionEffect(PotionEffectType.SLOW);
        p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
        p.removePotionEffect(PotionEffectType.WEAKNESS);
        p.removePotionEffect(PotionEffectType.WITHER);
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_COW_AMBIENT, 1.0F, 2.0F);
	}
	
}
