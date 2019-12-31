package io.github.thebusybiscuit.hotbarpets.pets;

import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.hotbarpets.SimpleBasePet;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class CreeperPet extends SimpleBasePet {
	
	private final HotbarPets plugin;

	public CreeperPet(HotbarPets plugin, SlimefunItemStack item, ItemStack food, ItemStack[] recipe) {
		super(plugin.getCategory(), item, food, recipe);
		
		this.plugin = plugin;
	}

	@Override
	public void onUseItem(Player p) {
		TNTPrimed tnt = (TNTPrimed) p.getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT);
		tnt.setFuseTicks(0);
		tnt.setMetadata("hotbarpets_player", new FixedMetadataValue(plugin, p));
		
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1.0F, 2.0F);
	}
	
}
