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
		new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_FISH" ,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmY5OWI1ODBkNDVhNzg0ZTdhOTY0ZTdkM2IxZjk3Y2VjZTc0OTExMTczYmQyMWMxZDdjNTZhY2RjMzg1ZWQ1In19fQ==", "&3Fish Pet", getName(), "&7Favourite Food: Seeds", "", "&fGives you Fish over time..."), new ItemStack(Material.WHEAT_SEEDS), new ItemStack[] {
				new ItemStack(Material.IRON_INGOT), new ItemStack(Material.COD), new ItemStack(Material.IRON_INGOT),
				new ItemStack(Material.COD), new ItemStack(Material.DIAMOND), new ItemStack(Material.COD),
				new ItemStack(Material.WATER_BUCKET), SlimefunItems.GOLD_18K, new ItemStack(Material.WATER_BUCKET)
		}).register(plugin);

		new SquidPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_SQUID" ,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMDE0MzNiZTI0MjM2NmFmMTI2ZGE0MzRiODczNWRmMWViNWIzY2IyY2VkZTM5MTQ1OTc0ZTljNDgzNjA3YmFjIn19fQ==", "&bSquid Pet", getName(), "&7Favourite Food: Raw Cod", "", "&fRight-Click: &7Gives you Water Breathing"), new ItemStack(Material.COD), new ItemStack[] {
				new ItemStack(Material.COAL), new ItemStack(Material.COD), new ItemStack(Material.COAL),
				new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.DIAMOND), new ItemStack(Material.WATER_BUCKET),
				new ItemStack(Material.COD), SlimefunItems.GOLD_16K, new ItemStack(Material.COD)
		}).register(plugin);

		new RabbitPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_RABBIT", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmYxNTU5MTk0YTE3NTkzNWI4YjRmZWE2NjE0YmVjNjBiZjgxY2Y1MjRhZjZmNTY0MzMzYzU1NWU2NTdiYyJ9fX0=", "&eRabbit Pet", getName(), "&7Favourite Food: Carrots", "", "&fRight-Click: &7Gives you 30 seconds of Luck"), new ItemStack(Material.CARROT), new ItemStack[] {
				new ItemStack(Material.GOLDEN_CARROT), new ItemStack(Material.RABBIT_HIDE), new ItemStack(Material.GOLDEN_CARROT),
				new ItemStack(Material.RABBIT_HIDE), new ItemStack(Material.DIAMOND), new ItemStack(Material.RABBIT_HIDE),
				new ItemStack(Material.GOLDEN_CARROT), new ItemStack(Material.RABBIT_FOOT), new ItemStack(Material.GOLDEN_CARROT)
		}).register(plugin);

		new DolphinPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_DOLPHIN", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2VmZTdkODAzYTQ1YWEyYWYxOTkzZGYyNTQ0YTI4ZGY4NDlhNzYyNjYzNzE5YmZlZmM1OGJmMzg5YWI3ZjUifX19", "&bDolphin Pet", getName(), "&7Favourite Food: Ink Sacks", "", "&fRight-Click: &7Dolphin's Grace"), new ItemStack(Material.INK_SAC), new ItemStack[] {
				new ItemStack(Material.LAPIS_LAZULI), new ItemStack(Material.COD), new ItemStack(Material.LAPIS_LAZULI),
				new ItemStack(Material.SALMON), new ItemStack(Material.EMERALD), new ItemStack(Material.SALMON),
				new ItemStack(Material.LAPIS_LAZULI), new ItemStack(Material.COD), new ItemStack(Material.LAPIS_LAZULI)
		}).register(plugin);

		new HotbarPet(plugin.getCategory(), new SlimefunItemStack("HOTBAR_PET_PANDA", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDE0ZmY2MjdhNmE2ZjM1ZTFkNzE3ZWJjYjE5MWU0YzdmOTA5NzU0MmRiNTk5ZTcxMDhhZTJjN2RkMzUxM2U1MSJ9fX0=", "&8Panda &fPet", getName(),"&7Favorite Food: Bamboo", "", "&fThis sleepy Panda protects you from Insomnia", "&fPhantoms will no longer chase you at night"), new ItemStack(Material.BAMBOO), new ItemStack[] {
				new ItemStack(Material.BAMBOO), new ItemStack(Material.DIAMOND), new ItemStack(Material.BAMBOO),
				new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
				new ItemStack(Material.ACACIA_LEAVES), new ItemStack(Material.BAMBOO), new ItemStack(Material.ACACIA_LEAVES)
		}).register(plugin);
	}
}
