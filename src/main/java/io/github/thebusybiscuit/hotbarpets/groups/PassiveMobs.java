package io.github.thebusybiscuit.hotbarpets.groups;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.hotbarpets.HotbarPet;
import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.hotbarpets.PetGroup;
import io.github.thebusybiscuit.hotbarpets.pets.IronGolemPet;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public final class PassiveMobs implements PetGroup {

    public PassiveMobs(HotbarPets plugin) {
        load(plugin);
    }

    @Override
    public String getName() {
        return "&e怪物 (中立)";
    }

    @Override
    public void load(HotbarPets plugin) {
        // @formatter:off
		new IronGolemPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_IRON_GOLEM", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODkwOTFkNzllYTBmNTllZjdlZjk0ZDdiYmE2ZTVmMTdmMmY3ZDQ1NzJjNDRmOTBmNzZjNDgxOWE3MTQifX19", "&7鐵巨人寵物", getName(), "&7喜愛的食物: 鐵錠", "", "&f右鍵點擊: &7給予你抗性"), new ItemStack(Material.IRON_INGOT), new ItemStack[]{
				new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.PUMPKIN), new ItemStack(Material.IRON_BLOCK),
				new ItemStack(Material.IRON_INGOT), new ItemStack(Material.EMERALD), new ItemStack(Material.IRON_INGOT),
				new ItemStack(Material.IRON_INGOT), SlimefunItems.GOLD_16K, new ItemStack(Material.IRON_INGOT)
		}).register(plugin);

		new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_SLIME", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTZhZDIwZmMyZDU3OWJlMjUwZDNkYjY1OWM4MzJkYTJiNDc4YTczYTY5OGI3ZWExMGQxOGM5MTYyZTRkOWI1In19fQ==", "&a史萊姆寵物", getName(), "&7喜愛的食物: 螢光粉", "", "&f免疫摔落傷害"), new ItemStack(Material.GLOWSTONE_DUST), new ItemStack[]{
				new ItemStack(Material.SLIME_BALL), new ItemStack(Material.DIAMOND), new ItemStack(Material.SLIME_BALL),
				new ItemStack(Material.SLIME_BALL), new ItemStack(Material.EMERALD), new ItemStack(Material.SLIME_BALL),
				SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
		}).register(plugin);
        // @formatter:on
    }

}
