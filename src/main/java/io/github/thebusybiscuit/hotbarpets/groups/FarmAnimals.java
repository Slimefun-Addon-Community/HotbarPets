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
        return "&2農場動物 (友善)";
    }

    @Override
    public void load(HotbarPets plugin) {
        // @formatter:off
		SlimefunItemStack cow = new SlimefunItemStack("HOTBAR_PET_COW", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWQ2YzZlZGE5NDJmN2Y1ZjcxYzMxNjFjNzMwNmY0YWVkMzA3ZDgyODk1ZjlkMmIwN2FiNDUyNTcxOGVkYzUifX19", "&6牛寵物", getName(), "&7喜愛的食物: 小麥", "", "&f右鍵點擊: &7移除負面藥水效果");
		
		new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_PIG", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjIxNjY4ZWY3Y2I3OWRkOWMyMmNlM2QxZjNmNGNiNmUyNTU5ODkzYjZkZjRhNDY5NTE0ZTY2N2MxNmFhNCJ9fX0=", "&d豬寵物", getName(), "&7喜愛的食物: 胡蘿蔔", "", "&f進食時增加飽食度", "&f允許你食用有毒的食物"), new ItemStack(Material.CARROT), new ItemStack[]{
				new ItemStack(Material.REDSTONE), new ItemStack(Material.CARROT), new ItemStack(Material.REDSTONE),
				new ItemStack(Material.PORKCHOP), new ItemStack(Material.DIAMOND), new ItemStack(Material.PORKCHOP),
				new ItemStack(Material.REDSTONE), SlimefunItems.GOLD_16K, new ItemStack(Material.REDSTONE)
		}).register(plugin);

		new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_CHICKEN", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTYzODQ2OWE1OTljZWVmNzIwNzUzNzYwMzI0OGE5YWIxMWZmNTkxZmQzNzhiZWE0NzM1YjM0NmE3ZmFlODkzIn19fQ==", "&f雞寵物", getName(), "&7喜愛的食物: 種子", "", "&f隨著時間的推移而生蛋..."), new ItemStack(Material.WHEAT_SEEDS), new ItemStack[]{
				new ItemStack(Material.REDSTONE), new ItemStack(Material.FEATHER), new ItemStack(Material.REDSTONE),
				new ItemStack(Material.COOKED_CHICKEN), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKED_CHICKEN),
				new ItemStack(Material.REDSTONE), SlimefunItems.GOLD_16K, new ItemStack(Material.REDSTONE)
		}).register(plugin);

		new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_MOOSHROOM", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDBiYzYxYjk3NTdhN2I4M2UwM2NkMjUwN2EyMTU3OTEzYzJjZjAxNmU3YzA5NmE0ZDZjZjFmZTFiOGRiIn19fQ==", "&d蘑菇牛寵物", getName(), "&7喜愛的食物: 紅蘑菇", "", "&f一段時間內給予你蘑菇方塊..."), new ItemStack(Material.RED_MUSHROOM), new ItemStack[]{
				new ItemStack(Material.LAPIS_LAZULI), new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.LAPIS_LAZULI),
				new ItemStack(Material.RED_MUSHROOM), new ItemStack(Material.DIAMOND), new ItemStack(Material.BROWN_MUSHROOM),
				new ItemStack(Material.LAPIS_LAZULI), SlimefunItems.GOLD_16K, new ItemStack(Material.LAPIS_LAZULI)
		}).register(plugin);

		new CowPet(plugin.getCategory(), cow, new ItemStack(Material.WHEAT), new ItemStack[]{
				new ItemStack(Material.COAL), new ItemStack(Material.WHEAT), new ItemStack(Material.COAL),
				new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKED_BEEF),
				new ItemStack(Material.COAL), SlimefunItems.GOLD_16K, new ItemStack(Material.COAL)
		}).register(plugin);

		new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_GOLDEN_COW", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGQxMDMzNThkOGYxYmRhZWYxMjE0YmZhNzdjNGRhNjQxNDMzMTg2YmQ0YmM0NGQ4NTdjMTY4MTE0NzZmZSJ9fX0=", "&6黃金牛寵物", getName(), "&7喜愛的食物: 金胡蘿蔔", "", "&f隨著時間的推移給予你金錠...", "&f(這意味著你有1個金粒的淨收益)"), new ItemStack(Material.GOLDEN_CARROT), new ItemStack[]{
				new ItemStack(Material.GOLDEN_CARROT), new ItemStack(Material.GOLD_NUGGET), new ItemStack(Material.GOLDEN_CARROT),
				new ItemStack(Material.GOLD_NUGGET), cow, new ItemStack(Material.GOLD_NUGGET),
				new ItemStack(Material.GOLDEN_CARROT), new ItemStack(Material.GOLD_NUGGET), new ItemStack(Material.GOLDEN_CARROT)
		}).register(plugin);
        // @formatter:on
    }

}
