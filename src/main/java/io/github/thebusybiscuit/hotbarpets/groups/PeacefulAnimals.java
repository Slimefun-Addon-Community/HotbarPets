package io.github.thebusybiscuit.hotbarpets.groups;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.hotbarpets.HotbarPet;
import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.hotbarpets.PetGroup;
import io.github.thebusybiscuit.hotbarpets.pets.DolphinPet;
import io.github.thebusybiscuit.hotbarpets.pets.RabbitPet;
import io.github.thebusybiscuit.hotbarpets.pets.SquidPet;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public final class PeacefulAnimals implements PetGroup {

    public PeacefulAnimals(HotbarPets plugin) {
        load(plugin);
    }

    @Override
    public String getName() {
        return "&aAnimal (Peaceful)";
    }

    @Override
    public void load(HotbarPets plugin) {
        // @formatter:off
        new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_FISH" ,"6f99b580d45a784e7a964e7d3b1f97cece74911173bd21c1d7c56acdc385ed5", "&3Fish Pet", getName(), "&7Favourite Food: Seeds", "", "&fGives you Fish over time..."), new ItemStack(Material.WHEAT_SEEDS), new ItemStack[] {
                new ItemStack(Material.IRON_INGOT), new ItemStack(Material.COD), new ItemStack(Material.IRON_INGOT),
                new ItemStack(Material.COD), new ItemStack(Material.DIAMOND), new ItemStack(Material.COD),
                new ItemStack(Material.WATER_BUCKET), SlimefunItems.GOLD_18K, new ItemStack(Material.WATER_BUCKET)
        }).register(plugin);

        new SquidPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_SQUID" ,"01433be242366af126da434b8735df1eb5b3cb2cede39145974e9c483607bac", "&bSquid Pet", getName(), "&7Favourite Food: Raw Cod", "", "&fRight-Click: &7Gives you Water Breathing"), new ItemStack(Material.COD), new ItemStack[] {
                new ItemStack(Material.COAL), new ItemStack(Material.COD), new ItemStack(Material.COAL),
                new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.DIAMOND), new ItemStack(Material.WATER_BUCKET),
                new ItemStack(Material.COD), SlimefunItems.GOLD_16K, new ItemStack(Material.COD)
        }).register(plugin);

        new RabbitPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_RABBIT", "ff1559194a175935b8b4fea6614bec60bf81cf524af6f564333c555e657bc", "&eRabbit Pet", getName(), "&7Favourite Food: Carrots", "", "&fRight-Click: &7Gives you 30 seconds of Luck"), new ItemStack(Material.CARROT), new ItemStack[] {
                new ItemStack(Material.GOLDEN_CARROT), new ItemStack(Material.RABBIT_HIDE), new ItemStack(Material.GOLDEN_CARROT),
                new ItemStack(Material.RABBIT_HIDE), new ItemStack(Material.DIAMOND), new ItemStack(Material.RABBIT_HIDE),
                new ItemStack(Material.GOLDEN_CARROT), new ItemStack(Material.RABBIT_FOOT), new ItemStack(Material.GOLDEN_CARROT)
        }).register(plugin);

        new DolphinPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_DOLPHIN", "cefe7d803a45aa2af1993df2544a28df849a762663719bfefc58bf389ab7f5", "&bDolphin Pet", getName(), "&7Favourite Food: Ink Sacks", "", "&fRight-Click: &7Dolphin's Grace"), new ItemStack(Material.INK_SAC), new ItemStack[] {
                new ItemStack(Material.LAPIS_LAZULI), new ItemStack(Material.COD), new ItemStack(Material.LAPIS_LAZULI),
                new ItemStack(Material.SALMON), new ItemStack(Material.EMERALD), new ItemStack(Material.SALMON),
                new ItemStack(Material.LAPIS_LAZULI), new ItemStack(Material.COD), new ItemStack(Material.LAPIS_LAZULI)
        }).register(plugin);

        new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_PANDA", "414ff627a6a6f35e1d717ebcb191e4c7f9097542db599e7108ae2c7dd3513e51", "&8Panda &fPet", getName(),"&7Favorite Food: Bamboo", "", "&fThis sleepy Panda protects you from Insomnia", "&fPhantoms will no longer chase you at night"), new ItemStack(Material.BAMBOO), new ItemStack[] {
                new ItemStack(Material.BAMBOO), new ItemStack(Material.DIAMOND), new ItemStack(Material.BAMBOO),
                new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
                new ItemStack(Material.ACACIA_LEAVES), new ItemStack(Material.BAMBOO), new ItemStack(Material.ACACIA_LEAVES)
        }).register(plugin);
        // @formatter:on
    }
}
