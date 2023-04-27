package io.github.thebusybiscuit.hotbarpets.groups;

import io.github.thebusybiscuit.hotbarpets.PetTexture;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.hotbarpets.HotbarPet;
import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.hotbarpets.PetGroup;
import io.github.thebusybiscuit.hotbarpets.pets.CreeperPet;
import io.github.thebusybiscuit.hotbarpets.pets.EndermanPet;
import io.github.thebusybiscuit.hotbarpets.pets.GhastPet;
import io.github.thebusybiscuit.hotbarpets.pets.PhantomPet;
import io.github.thebusybiscuit.hotbarpets.pets.ShulkerPet;
import io.github.thebusybiscuit.hotbarpets.pets.SpiderPet;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

public final class HostileMobs implements PetGroup {

    public HostileMobs(HotbarPets plugin) {
        load(plugin);
    }

    @Override
    public String getName() {
        return "${hotbarpets.itemgroup.mob.hostile}";
    }

    @Override
    public void load(HotbarPets plugin) {
        // @formatter:off
        new SpiderPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_SPIDER", PetTexture.SPIDER_PET.getHash(), "${hotbarpets.hotbar_pet_spider.name}", getName(), "${hotbarpets.hotbar_pet_spider.lore.01}", "", "${hotbarpets.hotbar_pet_spider.lore.02}"), new ItemStack(Material.ROTTEN_FLESH), new ItemStack[]{
                new ItemStack(Material.COAL), new ItemStack(Material.STRING), new ItemStack(Material.COAL),
                new ItemStack(Material.SPIDER_EYE), new ItemStack(Material.EMERALD), new ItemStack(Material.SPIDER_EYE),
                new ItemStack(Material.STRING), SlimefunItems.GOLD_16K, new ItemStack(Material.STRING)
        }).register(plugin);

        new GhastPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_GHAST", PetTexture.GHAST_PET.getHash(), "${hotbarpets.hotbar_pet_ghast.name}", getName(), "${hotbarpets.hotbar_pet_ghast.lore.01}", "", "${hotbarpets.hotbar_pet_ghast.lore.02}"), new ItemStack(Material.FIRE_CHARGE), new ItemStack[]{
                new ItemStack(Material.GHAST_TEAR), new ItemStack(Material.DIAMOND), new ItemStack(Material.GHAST_TEAR),
                new ItemStack(Material.QUARTZ_BLOCK), new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.QUARTZ_BLOCK),
                SlimefunItems.GOLD_24K, new ItemStack(Material.TNT), SlimefunItems.GOLD_24K
        }).register(plugin);

        new ShulkerPet(plugin, new SlimefunItemStack("HOTBAR_PET_SHULKER", PetTexture.SHULKER_PET.getHash(), "${hotbarpets.hotbar_pet_shulker.name}", getName(), "${hotbarpets.hotbar_pet_shulker.lore.01}", "", "${hotbarpets.hotbar_pet_shulker.lore.02}"), new ItemStack(Material.CHORUS_FRUIT), new ItemStack[]{
                new ItemStack(Material.NETHER_WART), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.NETHER_WART),
                new ItemStack(Material.QUARTZ), new ItemStack(Material.GLOWSTONE_DUST), new ItemStack(Material.QUARTZ),
                new ItemStack(Material.FEATHER), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.FEATHER)
        }).register(plugin);

        new PhantomPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_PHANTOM", PetTexture.PHANTOM_PET.getHash(), "${hotbarpets.hotbar_pet_phantom.name}", getName(), "${hotbarpets.hotbar_pet_phantom.lore.01}", "", "${hotbarpets.hotbar_pet_phantom.lore.02}"), new ItemStack(Material.BEETROOT), new ItemStack[]{
                new ItemStack(Material.PHANTOM_MEMBRANE), new ItemStack(Material.RABBIT_FOOT), new ItemStack(Material.PHANTOM_MEMBRANE),
                new ItemStack(Material.DIAMOND), SlimefunItems.GOLD_6K, new ItemStack(Material.DIAMOND),
                new ItemStack(Material.PHANTOM_MEMBRANE), new ItemStack(Material.RABBIT_FOOT), new ItemStack(Material.PHANTOM_MEMBRANE)
        }).register(plugin);

        new EndermanPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_ENDER_MAN", PetTexture.ENDERMAN_PET.getHash(), "${hotbarpets.hotbar_pet_ender_man.name}", getName(), "${hotbarpets.hotbar_pet_ender_man.lore.01}", "", "${hotbarpets.hotbar_pet_ender_man.lore.02}"), new ItemStack(Material.END_STONE), new ItemStack[]{
                new ItemStack(Material.OBSIDIAN), new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.OBSIDIAN),
                new ItemStack(Material.ENDER_EYE), new ItemStack(Material.EMERALD), new ItemStack(Material.ENDER_EYE),
                new ItemStack(Material.ENDER_PEARL), SlimefunItems.GOLD_16K, new ItemStack(Material.ENDER_PEARL)
        }).register(plugin);

        new CreeperPet(plugin, new SlimefunItemStack("HOTBAR_PET_CREEPER", Material.CREEPER_HEAD, "${hotbarpets.hotbar_pet_creeper.name}", getName(), "${hotbarpets.hotbar_pet_creeper.lore.01}", "", "${hotbarpets.hotbar_pet_creeper.lore.02}", "${hotbarpets.hotbar_pet_creeper.lore.03}"), new ItemStack(Material.GUNPOWDER), new ItemStack[]{
                new ItemStack(Material.DIAMOND), new ItemStack(Material.CREEPER_HEAD), new ItemStack(Material.DIAMOND),
                new ItemStack(Material.GUNPOWDER), new ItemStack(Material.EMERALD), new ItemStack(Material.GUNPOWDER),
                new ItemStack(Material.DIAMOND), SlimefunItems.GOLD_20K, new ItemStack(Material.DIAMOND)
        }).register(plugin);

        new HotbarPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_MAGMA_CUBE", PetTexture.MAGMA_CUBE_PET.getHash(), "${hotbarpets.hotbar_pet_magma_cube.name}", getName(), "${hotbarpets.common.nether_quartz}", "", "${hotbarpets.hotbar_pet_magma_cube.lore.01}", "${hotbarpets.hotbar_pet_magma_cube.lore.02}"), new ItemStack(Material.QUARTZ), new ItemStack[]{
                new ItemStack(Material.REDSTONE), new ItemStack(Material.MAGMA_CREAM), new ItemStack(Material.REDSTONE),
                new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.EMERALD), new ItemStack(Material.BLAZE_POWDER),
                new ItemStack(Material.NETHERRACK), SlimefunItems.GOLD_20K, new ItemStack(Material.NETHERRACK)
        }).register(plugin);

        new HotbarPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_BLAZE", PetTexture.BLAZE_PET.getHash(), "${hotbarpets.hotbar_pet_blaze.name}", getName(), "${hotbarpets.common.nether_quartz}", "", "${hotbarpets.hotbar_pet_blaze.lore}"), new ItemStack(Material.QUARTZ), new ItemStack[]{
                new ItemStack(Material.GLOWSTONE_DUST), new ItemStack(Material.BLAZE_ROD), new ItemStack(Material.GLOWSTONE_DUST),
                new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.EMERALD), new ItemStack(Material.BLAZE_POWDER),
                SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
        }).register(plugin);

        new HotbarPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_ZOMBIE", Material.ZOMBIE_HEAD, "${hotbarpets.hotbar_pet_zombie.name}", getName(), "", "${hotbarpets.hotbar_pet_zombie.lore.01}", "${hotbarpets.hotbar_pet_zombie.lore.02}"), new ItemStack(Material.ROTTEN_FLESH), new ItemStack[] {
                new ItemStack(Material.DIAMOND), new ItemStack(Material.ZOMBIE_HEAD), new ItemStack(Material.DIAMOND),
                new ItemStack(Material.MOSSY_COBBLESTONE), new ItemStack(Material.EMERALD), new ItemStack(Material.MOSSY_COBBLESTONE),
                new ItemStack(Material.ROTTEN_FLESH), SlimefunItems.NECROTIC_SKULL, new ItemStack(Material.ROTTEN_FLESH)
        }).register(plugin);
        // @formatter:on
    }
}
