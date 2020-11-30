package io.github.thebusybiscuit.hotbarpets.groups;

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
        return "&9特殊";
    }

    @Override
    public void load(HotbarPets plugin) {
        // @formatter:off
		new PurpliciousCowPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_PURPLICIOUS_COW", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2UxZmM2M2QzMDNlYjVmMzY2YWVjYWU2ZDI1MGQ0ZTJkNzc5YTlmNWVmOGRlYWZmNWIzYmM5NTMwN2ZmOSJ9fX0=", "&5Purplicious 牛寵物", getName(), "&7喜愛的食物: 金蘋果", "", "&f右鍵點擊: &7給予你生命回復"), new ItemStack(Material.GOLDEN_APPLE), new ItemStack[]{
				new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKED_BEEF),
				new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
				SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
		}).register(plugin);

		new CookieSlimePet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_MRCOOKIESLIME", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTY3MDlkODdlODVkMTUzYmI4ODNhMjNhNWE4ODNlZTQ0ZGRiMjg0ZDUzMThiNzgwYTE2ZTgyYTlkYWM2NTEifX19", "&amrCookieSlime 寵物", getName(), "&7喜愛的食物: 餅乾", "", "&f免疫摔落傷害", "&f右鍵點擊: &7給予你生命回復"), new ItemStack(Material.COOKIE), new ItemStack[]{
				new ItemStack(Material.COOKIE), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKIE),
				new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
				SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
		}).register(plugin);

		new PatriotPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_PATRIOT", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzhhNTY0NmM4NDczZTFiZjQ1NTEzYmU0ZTZlODY1NjA1MDY3MWI2NTEzM2MwMDQ4ZDQ4NGUxYmYwYjQ2Mjk1ZiJ9fX0=", "&5Patriot 寵物", getName(), "&7喜愛的食物: 地獄疙瘩", "", "&f給予你抗性, 生命回復, 力量, ", "&f和 飽食"), new ItemStack(Material.NETHER_WART), new ItemStack[]{
				new ItemStack(Material.REDSTONE), SlimefunItems.MAGIC_LUMP_1, new ItemStack(Material.REDSTONE),
				SlimefunItems.MAGIC_LUMP_1, SlimefunItems.RAW_CARBONADO, SlimefunItems.MAGIC_LUMP_1,
				SlimefunItems.GOLD_4K, new ItemStack(Material.REDSTONE), SlimefunItems.GOLD_4K
		}).register(plugin);

		new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_WALSHRUS", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzk2NmYwZWJkNzdmMWJjZDY1NmZhMmRjM2VmMDMwM2UyNmE2YTNkZTQ5OGMzOTk5ZDM5ZmRjYWNjNWY1YWQifX19", "&bWalshrus 寵物", getName(), "&7喜愛的食物: 生鱈魚", "", "&f你不會淹死"), new ItemStack(Material.COD), new ItemStack[]{
				new ItemStack(Material.COD), new ItemStack(Material.DIAMOND), new ItemStack(Material.COD),
				new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
				SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
		}).register(plugin);

		new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_EYAMAZ", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTg0NzRmN2E2YzEzOWYxY2NkNzM1YTQ2NzdjMDQ1M2M0YmVmZWRmYzg5ZmVkYTQ5ZWE4ODZlYjE4ZGRmNmNkZiJ9fX0=", "&4Eyamaz 寵物", getName(), "&7喜愛的食物: 靈魂", "", "&f注意! Eyamaz 會用你殺死的靈魂", "&f來做靈魂派!"), new ItemStack(Material.SOUL_SAND), new ItemStack[]{
				new ItemStack(Material.SOUL_SAND), new ItemStack(Material.DIAMOND), new ItemStack(Material.SOUL_SAND),
				new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
				SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
		}).register(plugin);
        // @formatter:on
    }

}
