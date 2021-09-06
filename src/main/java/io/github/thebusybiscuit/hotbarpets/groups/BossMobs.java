package io.github.thebusybiscuit.hotbarpets.groups;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.hotbarpets.HotbarPet;
import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.hotbarpets.PetGroup;
import io.github.thebusybiscuit.hotbarpets.PetTexture;
import io.github.thebusybiscuit.hotbarpets.pets.EnderDragonPet;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

public final class BossMobs implements PetGroup {

    public BossMobs(HotbarPets plugin) {
        load(plugin);
    }

    @Override
    public String getName() {
        return "&4Boss 怪物 (敵對)";
    }

    @Override
    public void load(HotbarPets plugin) {
        // @formatter:off
        new EnderDragonPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_DRAGON", Material.DRAGON_HEAD, "&5終界龍寵物", getName(), "&7喜愛的食物: 終界之眼", "", "&f右鍵點擊: &7發射終界龍的火球 & 給予抗性效果"), new ItemStack(Material.ENDER_EYE), new ItemStack[]{
                new ItemStack(Material.PRISMARINE_CRYSTALS), new ItemStack(Material.DRAGON_BREATH), new ItemStack(Material.PRISMARINE_CRYSTALS),
                SlimefunItems.ENDER_LUMP_3, new ItemStack(Material.DRAGON_HEAD), SlimefunItems.ENDER_LUMP_3,
                new ItemStack(Material.PRISMARINE_CRYSTALS), new ItemStack(Material.DRAGON_BREATH), new ItemStack(Material.PRISMARINE_CRYSTALS)
        }).register(plugin);

        new HotbarPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_WITHER", PetTexture.WITHER_PET.getHash(), "&8凋零寵物", getName(), "&7喜愛的食物: 靈魂沙", "", "&f免疫凋零"), new ItemStack(Material.SOUL_SAND), new ItemStack[]{
                new ItemStack(Material.COAL), new ItemStack(Material.WITHER_SKELETON_SKULL), new ItemStack(Material.COAL),
                new ItemStack(Material.SOUL_SAND), new ItemStack(Material.NETHER_STAR), new ItemStack(Material.SOUL_SAND),
                new ItemStack(Material.SOUL_SAND), SlimefunItems.GOLD_24K, new ItemStack(Material.SOUL_SAND)
        }).register(plugin);
        // @formatter:on
    }

}
