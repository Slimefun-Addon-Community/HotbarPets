package io.github.thebusybiscuit.hotbarpets.groups;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.hotbarpets.HotbarPet;
import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.hotbarpets.PetGroup;
import io.github.thebusybiscuit.hotbarpets.pets.CowPet;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public final class FarmAnimals implements PetGroup {

    public FarmAnimals(HotbarPets plugin) {
        load(plugin);
    }

    @Override
    public String getName() {
        return "&2Farm Animal (Peaceful)";
    }

    @Override
    public void load(HotbarPets plugin) {
        // @formatter:off
        SlimefunItemStack cow = new SlimefunItemStack("HOTBAR_PET_COW", "5d6c6eda942f7f5f71c3161c7306f4aed307d82895f9d2b07ab4525718edc5", "&6Cow Pet", getName(), "&7Favourite Food: Wheat", "", "&fRight-Click: &7Removes negative Potion Effects");

        new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_PIG", "621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4", "&dPig Pet", getName(), "&7Favourite Food: Carrots", "", "&fBonus Saturation when eating", "&fAllows you to eat poisonous Food"), new ItemStack(Material.CARROT), new ItemStack[] {
                new ItemStack(Material.REDSTONE), new ItemStack(Material.CARROT), new ItemStack(Material.REDSTONE),
                new ItemStack(Material.PORKCHOP), new ItemStack(Material.DIAMOND), new ItemStack(Material.PORKCHOP),
                new ItemStack(Material.REDSTONE), SlimefunItems.GOLD_16K, new ItemStack(Material.REDSTONE)
        }).register(plugin);

        new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_CHICKEN", "1638469a599ceef7207537603248a9ab11ff591fd378bea4735b346a7fae893", "&fChicken Pet", getName(), "&7Favourite Food: Seeds", "", "&fGives you Eggs over time..."), new ItemStack(Material.WHEAT_SEEDS), new ItemStack[] {
                new ItemStack(Material.REDSTONE), new ItemStack(Material.FEATHER), new ItemStack(Material.REDSTONE),
                new ItemStack(Material.COOKED_CHICKEN), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKED_CHICKEN),
                new ItemStack(Material.REDSTONE), SlimefunItems.GOLD_16K, new ItemStack(Material.REDSTONE)
        }).register(plugin);

        new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_MOOSHROOM", "d0bc61b9757a7b83e03cd2507a2157913c2cf016e7c096a4d6cf1fe1b8db", "&dMooshroom Pet", getName(), "&7Favourite Food: Red Mushrooms", "", "&fGives you Mushroom Stew over time..."), new ItemStack(Material.RED_MUSHROOM), new ItemStack[] {
                new ItemStack(Material.LAPIS_LAZULI), new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.LAPIS_LAZULI),
                new ItemStack(Material.RED_MUSHROOM), new ItemStack(Material.DIAMOND), new ItemStack(Material.BROWN_MUSHROOM),
                new ItemStack(Material.LAPIS_LAZULI), SlimefunItems.GOLD_16K, new ItemStack(Material.LAPIS_LAZULI)
        }).register(plugin);

        new CowPet(plugin.getCategory(), cow, new ItemStack(Material.WHEAT), new ItemStack[] {
                new ItemStack(Material.COAL), new ItemStack(Material.WHEAT), new ItemStack(Material.COAL),
                new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKED_BEEF),
                new ItemStack(Material.COAL), SlimefunItems.GOLD_16K, new ItemStack(Material.COAL)
        }).register(plugin);

        new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_GOLDEN_COW", "8d103358d8f1bdaef1214bfa77c4da641433186bd4bc44d857c16811476fe", "&6Golden Cow Pet", getName(), "&7Favourite Food: Golden Carrots", "", "&fGives you Golden Ingots over time...", "&f(That means you have a net gain of 1 golden nugget)"), new ItemStack(Material.GOLDEN_CARROT), new ItemStack[] {
                new ItemStack(Material.GOLDEN_CARROT), new ItemStack(Material.GOLD_NUGGET), new ItemStack(Material.GOLDEN_CARROT),
                new ItemStack(Material.GOLD_NUGGET), cow, new ItemStack(Material.GOLD_NUGGET),
                new ItemStack(Material.GOLDEN_CARROT), new ItemStack(Material.GOLD_NUGGET), new ItemStack(Material.GOLDEN_CARROT)
        }).register(plugin);
        // @formatter:on
    }

}
