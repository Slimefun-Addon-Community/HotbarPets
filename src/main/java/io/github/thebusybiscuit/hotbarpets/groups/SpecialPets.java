package io.github.thebusybiscuit.hotbarpets.groups;

import io.github.thebusybiscuit.hotbarpets.HeadTextures;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.hotbarpets.HotbarPet;
import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.hotbarpets.PetGroup;
import io.github.thebusybiscuit.hotbarpets.pets.special.CookieSlimePet;
import io.github.thebusybiscuit.hotbarpets.pets.special.PatriotPet;
import io.github.thebusybiscuit.hotbarpets.pets.special.PurpliciousCowPet;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public final class SpecialPets implements PetGroup {

    public SpecialPets(HotbarPets plugin) {
        load(plugin);
    }

    @Override
    public String getName() {
        return "&9Special";
    }

    @Override
    public void load(HotbarPets plugin) {
        // @formatter:off
        new PurpliciousCowPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_PURPLICIOUS_COW", HeadTextures.PURPLICIOUS_COW_PET.getHash(), "&5Purplicious Cow Pet", getName(), "&7Favourite Food: Golden Apples", "", "&fRight-Click: &7Gives you Health Regeneration"), new ItemStack(Material.GOLDEN_APPLE), new ItemStack[] {
                new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKED_BEEF),
                new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
                SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
        }).register(plugin);

        new CookieSlimePet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_MRCOOKIESLIME", HeadTextures.MR_COOKIE_SLIME_PET.getHash(), "&amrCookieSlime Pet", getName(), "&7Favourite Food: Cookies", "", "&fImmune to Fall Damage", "&fRight-Click: &7Gives you Health Regeneration"), new ItemStack(Material.COOKIE), new ItemStack[] {
                new ItemStack(Material.COOKIE), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKIE),
                new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
                SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
        }).register(plugin);

        new PatriotPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_PATRIOT", HeadTextures.PATRIOT_PET.getHash(), "&5Patriot Pet", getName(), "&7Favourite Food: Nether Wart", "", "&fGives Resistance, Regeneration, Strength, ", "&fand Saturation"), new ItemStack(Material.NETHER_WART), new ItemStack[] {
                new ItemStack(Material.REDSTONE), SlimefunItems.MAGIC_LUMP_1, new ItemStack(Material.REDSTONE),
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.RAW_CARBONADO, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.GOLD_4K, new ItemStack(Material.REDSTONE), SlimefunItems.GOLD_4K
        }).register(plugin);

        new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_WALSHRUS", HeadTextures.WALSHRUS_PET.getHash(), "&bWalshrus Pet", getName(), "&7Favourite Food: Raw Cod", "", "&fCannot drown"), new ItemStack(Material.COD), new ItemStack[] {
                new ItemStack(Material.COD), new ItemStack(Material.DIAMOND), new ItemStack(Material.COD),
                new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
                SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
        }).register(plugin);

        new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_EYAMAZ", HeadTextures.EYAMAZ_PET.getHash(), "&4Eyamaz Pet", getName(), "&7Favourite Food: Souls", "", "&fBeware! Eyamaz makes a Soul Pie", "&fout of the Souls of everything you kill"), new ItemStack(Material.SOUL_SAND), new ItemStack[] {
                new ItemStack(Material.SOUL_SAND), new ItemStack(Material.DIAMOND), new ItemStack(Material.SOUL_SAND),
                new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
                SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
        }).register(plugin);
        // @formatter:on
    }

}
