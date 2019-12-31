package io.github.thebusybiscuit.hotbarpets.pets;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.hotbarpets.SimpleBasePet;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class RabbitPet extends SimpleBasePet {

	public RabbitPet(Category category, SlimefunItemStack item, ItemStack food, ItemStack[] recipe) {
		super(category, item, food, recipe);
	}
	
	@Override
	public void onUseItem(Player p) {
        p.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 600, 1));
	}

}
