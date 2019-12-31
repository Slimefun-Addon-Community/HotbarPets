package io.github.thebusybiscuit.hotbarpets.groups;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.hotbarpets.HotbarPet;
import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.hotbarpets.PetGroup;
import io.github.thebusybiscuit.hotbarpets.pets.IronGolemPet;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public final class PassiveMobs implements PetGroup {

	public PassiveMobs(HotbarPets plugin) {
		load(plugin);
	}

	@Override
	public String getName() {
		return "&eMob (Passive)";
	}

	@Override
	public void load(HotbarPets plugin) {
		new IronGolemPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_IRON_GOLEM", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODkwOTFkNzllYTBmNTllZjdlZjk0ZDdiYmE2ZTVmMTdmMmY3ZDQ1NzJjNDRmOTBmNzZjNDgxOWE3MTQifX19", "&7Iron Golem Pet", getName(), "&7Favourite Food: Iron Ingots", "", "&rRight-Click: &7Gives you Resistance"), new ItemStack(Material.IRON_INGOT), new ItemStack[]{
				new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.PUMPKIN), new ItemStack(Material.IRON_BLOCK),
				new ItemStack(Material.IRON_INGOT), new ItemStack(Material.EMERALD), new ItemStack(Material.IRON_INGOT),
				new ItemStack(Material.IRON_INGOT), SlimefunItems.GOLD_16K, new ItemStack(Material.IRON_INGOT)
		}).register();

		new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_SLIME", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTZhZDIwZmMyZDU3OWJlMjUwZDNkYjY1OWM4MzJkYTJiNDc4YTczYTY5OGI3ZWExMGQxOGM5MTYyZTRkOWI1In19fQ==", "&aSlime Pet", getName(), "&7Favourite Food: Glowstone Dust", "", "&rImmune to Fall Damage"), new ItemStack(Material.GLOWSTONE_DUST), new ItemStack[]{
				new ItemStack(Material.SLIME_BALL), new ItemStack(Material.DIAMOND), new ItemStack(Material.SLIME_BALL),
				new ItemStack(Material.SLIME_BALL), new ItemStack(Material.EMERALD), new ItemStack(Material.SLIME_BALL),
				SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
		}).register();
	}



}
