package io.github.thebusybiscuit.hotbarpets.groups;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.hotbarpets.HotbarPet;
import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.hotbarpets.PetGroup;
import io.github.thebusybiscuit.hotbarpets.PetTexture;
import io.github.thebusybiscuit.hotbarpets.pets.CowPet;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

public final class FarmAnimals implements PetGroup {

    public FarmAnimals(HotbarPets plugin) {
        load(plugin);
    }

    @Override
    public String getName() {
        return "&2農場動物 (友善)";
    }

    @Override
    public void load(HotbarPets plugin) {
        // @formatter:off
        SlimefunItemStack cow = new SlimefunItemStack("HOTBAR_PET_COW", PetTexture.COW_PET.getHash(), "&6牛寵物", getName(), "&7喜愛的食物: 小麥", "", "&f右鍵點擊: &7移除負面藥水效果");

        new HotbarPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_PIG", PetTexture.PIG_PET.getHash(), "&d豬寵物", getName(), "&7喜愛的食物: 胡蘿蔔", "", "&f進食時增加飽食度", "&f允許你食用有毒的食物"), new ItemStack(Material.CARROT), new ItemStack[] {
                new ItemStack(Material.REDSTONE), new ItemStack(Material.CARROT), new ItemStack(Material.REDSTONE),
                new ItemStack(Material.PORKCHOP), new ItemStack(Material.DIAMOND), new ItemStack(Material.PORKCHOP),
                new ItemStack(Material.REDSTONE), SlimefunItems.GOLD_16K, new ItemStack(Material.REDSTONE)
        }).register(plugin);

        new HotbarPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_CHICKEN", PetTexture.CHICKEN_PET.getHash(), "&f雞寵物", getName(), "&7喜愛的食物: 種子", "", "&f隨著時間的推移而生蛋..."), new ItemStack(Material.WHEAT_SEEDS), new ItemStack[] {
                new ItemStack(Material.REDSTONE), new ItemStack(Material.FEATHER), new ItemStack(Material.REDSTONE),
                new ItemStack(Material.COOKED_CHICKEN), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKED_CHICKEN),
                new ItemStack(Material.REDSTONE), SlimefunItems.GOLD_16K, new ItemStack(Material.REDSTONE)
        }).register(plugin);

        new HotbarPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_MOOSHROOM", PetTexture.MOOSHROOM_PET.getHash(), "&d蘑菇牛寵物", getName(), "&7喜愛的食物: 紅蘑菇", "", "&f一段時間內給予你蘑菇方塊..."), new ItemStack(Material.RED_MUSHROOM), new ItemStack[] {
                new ItemStack(Material.LAPIS_LAZULI), new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.LAPIS_LAZULI),
                new ItemStack(Material.RED_MUSHROOM), new ItemStack(Material.DIAMOND), new ItemStack(Material.BROWN_MUSHROOM),
                new ItemStack(Material.LAPIS_LAZULI), SlimefunItems.GOLD_16K, new ItemStack(Material.LAPIS_LAZULI)
        }).register(plugin);

        new CowPet(plugin.getItemGroup(), cow, new ItemStack(Material.WHEAT), new ItemStack[] {
                new ItemStack(Material.COAL), new ItemStack(Material.WHEAT), new ItemStack(Material.COAL),
                new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKED_BEEF),
                new ItemStack(Material.COAL), SlimefunItems.GOLD_16K, new ItemStack(Material.COAL)
        }).register(plugin);

        new HotbarPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_GOLDEN_COW", PetTexture.GOLDEN_COW_PET.getHash(), "&6黃金牛寵物", getName(), "&7喜愛的食物: 金胡蘿蔔", "", "&f隨著時間的推移給予你金錠...", "&f(這意味著你有1個金粒的淨收益)"), new ItemStack(Material.GOLDEN_CARROT), new ItemStack[] {
                new ItemStack(Material.GOLDEN_CARROT), new ItemStack(Material.GOLD_NUGGET), new ItemStack(Material.GOLDEN_CARROT),
                new ItemStack(Material.GOLD_NUGGET), cow, new ItemStack(Material.GOLD_NUGGET),
                new ItemStack(Material.GOLDEN_CARROT), new ItemStack(Material.GOLD_NUGGET), new ItemStack(Material.GOLDEN_CARROT)
        }).register(plugin);
        // @formatter:on
    }

}
