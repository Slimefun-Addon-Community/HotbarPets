package io.github.thebusybiscuit.hotbarpets.groups;

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
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public final class HostileMobs implements PetGroup {

    public HostileMobs(HotbarPets plugin) {
        load(plugin);
    }

    @Override
    public String getName() {
        return "&c怪物 (敵對)";
    }

    @Override
    public void load(HotbarPets plugin) {
        // @formatter:off
		new SpiderPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_SPIDER", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjdhNGMyNTZmMGRmNjE0MjMxZjhkNTUzNDRjOWRlMzkzODkzNjFhNzQwYzExZmFjYzBkMjk5ZjY3NmRkOWEifX19", "&8蜘蛛寵物", getName(), "&7喜愛的食物: 腐肉", "", "&f右鍵點擊: &7給予你跳躍提升"), new ItemStack(Material.ROTTEN_FLESH), new ItemStack[]{
				new ItemStack(Material.COAL), new ItemStack(Material.STRING), new ItemStack(Material.COAL),
				new ItemStack(Material.SPIDER_EYE), new ItemStack(Material.EMERALD), new ItemStack(Material.SPIDER_EYE),
				new ItemStack(Material.STRING), SlimefunItems.GOLD_16K, new ItemStack(Material.STRING)
		}).register(plugin);

		new GhastPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_GHAST", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGI2YTcyMTM4ZDY5ZmJiZDJmZWEzZmEyNTFjYWJkODcxNTJlNGYxYzk3ZTVmOTg2YmY2ODU1NzFkYjNjYzAifX19", "&f地域幽靈寵物", getName(), "&7喜愛的食物: 火焰彈", "", "&f右鍵點擊: &7發射火焰彈"), new ItemStack(Material.FIRE_CHARGE), new ItemStack[]{
				new ItemStack(Material.GHAST_TEAR), new ItemStack(Material.DIAMOND), new ItemStack(Material.GHAST_TEAR),
				new ItemStack(Material.QUARTZ_BLOCK), new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.QUARTZ_BLOCK),
				SlimefunItems.GOLD_24K, new ItemStack(Material.TNT), SlimefunItems.GOLD_24K
		}).register(plugin);

		new ShulkerPet(plugin, new SlimefunItemStack("HOTBAR_PET_SHULKER", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjFkMzUzNGQyMWZlODQ5OTI2MmRlODdhZmZiZWFjNGQyNWZmZGUzNWM4YmRjYTA2OWU2MWUxNzg3ZmYyZiJ9fX0==", "&d界伏盒寵物", getName(), "&7喜愛的食物: 紫頌果", "", "&f右鍵點擊: &7發射帶有懸浮效果的箭矢"), new ItemStack(Material.CHORUS_FRUIT), new ItemStack[]{
				new ItemStack(Material.NETHER_WART), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.NETHER_WART),
				new ItemStack(Material.QUARTZ), new ItemStack(Material.GLOWSTONE_DUST), new ItemStack(Material.QUARTZ),
				new ItemStack(Material.FEATHER), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.FEATHER)
		}).register(plugin);

		new PhantomPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_PHANTOM", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDBiOTE4OWMzNzEzZjBkYWNhYzliMmJiNjA2NTA5MGM1MmIwYzkwZjEwODIwOGUwYTg2YmU1ODg1ZTk5NTc5YSJ9fX0=", "&7夜魅", getName(), "&7喜愛的食物: 甜菜根", "", "&f右鍵點擊: &7給予你緩降"), new ItemStack(Material.BEETROOT), new ItemStack[]{
				new ItemStack(Material.PHANTOM_MEMBRANE), new ItemStack(Material.RABBIT_FOOT), new ItemStack(Material.PHANTOM_MEMBRANE),
				new ItemStack(Material.DIAMOND), SlimefunItems.GOLD_6K, new ItemStack(Material.DIAMOND),
				new ItemStack(Material.PHANTOM_MEMBRANE), new ItemStack(Material.RABBIT_FOOT), new ItemStack(Material.PHANTOM_MEMBRANE)
		}).register(plugin);

		new EndermanPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_ENDER_MAN", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2E1OWJiMGE3YTMyOTY1YjNkOTBkOGVhZmE4OTlkMTgzNWY0MjQ1MDllYWRkNGU2YjcwOWFkYTUwYjljZiJ9fX0=", "&8安德寵物", getName(), "&7喜愛的食物: 終界石", "", "&f右鍵點擊: &7發射終界珍珠"), new ItemStack(Material.END_STONE), new ItemStack[]{
				new ItemStack(Material.OBSIDIAN), new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.OBSIDIAN),
				new ItemStack(Material.ENDER_EYE), new ItemStack(Material.EMERALD), new ItemStack(Material.ENDER_EYE),
				new ItemStack(Material.ENDER_PEARL), SlimefunItems.GOLD_16K, new ItemStack(Material.ENDER_PEARL)
		}).register(plugin);

		new CreeperPet(plugin, new SlimefunItemStack("HOTBAR_PET_CREEPER", Material.CREEPER_HEAD, "&2苦力怕寵物", getName(), "&7喜愛的食物: 火藥", "", "&f免疫爆炸", "&f右鍵點擊: &7爆炸"), new ItemStack(Material.GUNPOWDER), new ItemStack[]{
				new ItemStack(Material.DIAMOND), new ItemStack(Material.CREEPER_HEAD), new ItemStack(Material.DIAMOND),
				new ItemStack(Material.GUNPOWDER), new ItemStack(Material.EMERALD), new ItemStack(Material.GUNPOWDER),
				new ItemStack(Material.DIAMOND), SlimefunItems.GOLD_20K, new ItemStack(Material.DIAMOND)
		}).register(plugin);

		new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_MAGMA_CUBE", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzg5NTdkNTAyM2M5MzdjNGM0MWFhMjQxMmQ0MzQxMGJkYTIzY2Y3OWE5ZjZhYjM2Yjc2ZmVmMmQ3YzQyOSJ9fX0=", "&4熔岩史萊姆寵物", getName(), "&7喜愛的食物: 地獄石英", "", "&f免疫岩漿", "&f會餓"), new ItemStack(Material.QUARTZ), new ItemStack[]{
				new ItemStack(Material.REDSTONE), new ItemStack(Material.MAGMA_CREAM), new ItemStack(Material.REDSTONE),
				new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.EMERALD), new ItemStack(Material.BLAZE_POWDER),
				new ItemStack(Material.NETHERRACK), SlimefunItems.GOLD_20K, new ItemStack(Material.NETHERRACK)
		}).register(plugin);

		new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_BLAZE", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjI1MDViZTc3OTZiN2Q3OGE3MTdjM2U2NWVhNDJiZjIxMTQ0OWZkYjZkOTNmMmI0MDZhODhhYjcxYjcwIn19fQ==", "&6烈焰使者寵物", getName(), "&7喜愛的食物: 地獄石英", "", "&f免疫火"), new ItemStack(Material.QUARTZ), new ItemStack[]{
				new ItemStack(Material.GLOWSTONE_DUST), new ItemStack(Material.BLAZE_ROD), new ItemStack(Material.GLOWSTONE_DUST),
				new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.EMERALD), new ItemStack(Material.BLAZE_POWDER),
				SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
		}).register(plugin);

		new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_ZOMBIE", Material.ZOMBIE_HEAD, "&2殭屍寵物", getName(), "", "&f讓你吃腐肉", "&f沒有飢餓"), new ItemStack(Material.ROTTEN_FLESH), new ItemStack[] {
				new ItemStack(Material.DIAMOND), new ItemStack(Material.ZOMBIE_HEAD), new ItemStack(Material.DIAMOND),
				new ItemStack(Material.MOSSY_COBBLESTONE), new ItemStack(Material.EMERALD), new ItemStack(Material.MOSSY_COBBLESTONE),
				new ItemStack(Material.ROTTEN_FLESH), SlimefunItems.NECROTIC_SKULL, new ItemStack(Material.ROTTEN_FLESH)
		}).register(plugin);
        // @formatter:on
    }

}
