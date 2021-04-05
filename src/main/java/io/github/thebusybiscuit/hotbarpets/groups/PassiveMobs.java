package io.github.thebusybiscuit.hotbarpets.groups;

import io.github.thebusybiscuit.hotbarpets.HeadTextures;
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
        return "&eMob (Passive)";
    }

    @Override
    public void load(HotbarPets plugin) {
        // @formatter:off
        new IronGolemPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_IRON_GOLEM", HeadTextures.IRON_GOLEM_PET.getHash(), "&7Iron Golem Pet", getName(), "&7Favourite Food: Iron Ingots", "", "&fRight-Click: &7Gives you Resistance"), new ItemStack(Material.IRON_INGOT), new ItemStack[]{
                new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.PUMPKIN), new ItemStack(Material.IRON_BLOCK),
                new ItemStack(Material.IRON_INGOT), new ItemStack(Material.EMERALD), new ItemStack(Material.IRON_INGOT),
                new ItemStack(Material.IRON_INGOT), SlimefunItems.GOLD_16K, new ItemStack(Material.IRON_INGOT)
        }).register(plugin);

        new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_SLIME", HeadTextures.SLIME_PET.getHash(), "&aSlime Pet", getName(), "&7Favourite Food: Glowstone Dust", "", "&fImmune to Fall Damage"), new ItemStack(Material.GLOWSTONE_DUST), new ItemStack[]{
                new ItemStack(Material.SLIME_BALL), new ItemStack(Material.DIAMOND), new ItemStack(Material.SLIME_BALL),
                new ItemStack(Material.SLIME_BALL), new ItemStack(Material.EMERALD), new ItemStack(Material.SLIME_BALL),
                SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
        }).register(plugin);
        // @formatter:on
    }

}
