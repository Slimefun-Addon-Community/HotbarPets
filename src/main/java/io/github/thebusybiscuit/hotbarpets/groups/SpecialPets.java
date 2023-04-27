package io.github.thebusybiscuit.hotbarpets.groups;

import io.github.thebusybiscuit.hotbarpets.PetTexture;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.hotbarpets.HotbarPet;
import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.hotbarpets.PetGroup;
import io.github.thebusybiscuit.hotbarpets.pets.special.CookieSlimePet;
import io.github.thebusybiscuit.hotbarpets.pets.special.PatriotPet;
import io.github.thebusybiscuit.hotbarpets.pets.special.PurpliciousCowPet;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

public final class SpecialPets implements PetGroup {

    public SpecialPets(HotbarPets plugin) {
        load(plugin);
    }

    @Override
    public String getName() {
        return "${hotbarpets.itemgroup.special}";
    }

    @Override
    public void load(HotbarPets plugin) {
        // @formatter:off
        new PurpliciousCowPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_PURPLICIOUS_COW", PetTexture.PURPLICIOUS_COW_PET.getHash(), "${hotbarpets.hotbar_pet_purplicious_cow.name}", getName(), "${hotbarpets.hotbar_pet_purplicious_cow.lore}", "", "${hotbarpets.common.health_regeneration}"), new ItemStack(Material.GOLDEN_APPLE), new ItemStack[] {
                new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKED_BEEF),
                new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
                SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
        }).register(plugin);

        new CookieSlimePet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_MRCOOKIESLIME", PetTexture.MR_COOKIE_SLIME_PET.getHash(), "${hotbarpets.hotbar_pet_mrcookieslime.name}", getName(), "${hotbarpets.hotbar_pet_mrcookieslime.lore}", "", "${hotbarpets.common.fall_damage}", "${hotbarpets.common.health_regeneration}"), new ItemStack(Material.COOKIE), new ItemStack[] {
                new ItemStack(Material.COOKIE), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKIE),
                new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
                SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
        }).register(plugin);

        new PatriotPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_PATRIOT", PetTexture.PATRIOT_PET.getHash(), "${hotbarpets.hotbar_pet_patriot.name}", getName(), "${hotbarpets.hotbar_pet_patriot.lore.01}", "", "${hotbarpets.hotbar_pet_patriot.lore.02}", "${hotbarpets.hotbar_pet_patriot.lore.03}"), new ItemStack(Material.NETHER_WART), new ItemStack[] {
                new ItemStack(Material.REDSTONE), SlimefunItems.MAGIC_LUMP_1, new ItemStack(Material.REDSTONE),
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.RAW_CARBONADO, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.GOLD_4K, new ItemStack(Material.REDSTONE), SlimefunItems.GOLD_4K
        }).register(plugin);

        new HotbarPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_WALSHRUS", PetTexture.WALSHRUS_PET.getHash(), "${hotbarpets.hotbar_pet_walshrus.name}", getName(), "${hotbarpets.common.raw_cod}", "", "${hotbarpets.hotbar_pet_walshrus.lore}"), new ItemStack(Material.COD), new ItemStack[] {
                new ItemStack(Material.COD), new ItemStack(Material.DIAMOND), new ItemStack(Material.COD),
                new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
                SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
        }).register(plugin);

        new HotbarPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_EYAMAZ", PetTexture.EYAMAZ_PET.getHash(), "${hotbarpets.hotbar_pet_eyamaz.name}", getName(), "${hotbarpets.hotbar_pet_eyamaz.lore.01}", "", "${hotbarpets.hotbar_pet_eyamaz.lore.02}", "${hotbarpets.hotbar_pet_eyamaz.lore.03}"), new ItemStack(Material.SOUL_SAND), new ItemStack[] {
                new ItemStack(Material.SOUL_SAND), new ItemStack(Material.DIAMOND), new ItemStack(Material.SOUL_SAND),
                new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
                SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
        }).register(plugin);
        // @formatter:on
    }

}
