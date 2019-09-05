package io.github.thebusybiscuit.hotbarpets.groups;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.hotbarpets.HotbarPet;
import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.hotbarpets.PetGroup;
import io.github.thebusybiscuit.hotbarpets.pets.DolphinPet;
import io.github.thebusybiscuit.hotbarpets.pets.RabbitPet;
import io.github.thebusybiscuit.hotbarpets.pets.SquidPet;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;

public final class Animals implements PetGroup {

	public Animals(HotbarPets plugin) throws Exception {
		load(plugin);
	}

	@Override
	public String getName() {
		return "&aAnimal (Peaceful)";
	}

	@Override
	public void load(HotbarPets plugin) throws Exception {
		new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmY5OWI1ODBkNDVhNzg0ZTdhOTY0ZTdkM2IxZjk3Y2VjZTc0OTExMTczYmQyMWMxZDdjNTZhY2RjMzg1ZWQ1In19fQ=="), "&3Fish Pet", getName(), "&7Favourite Food: Seeds", "", "&rGives you Fish over time..."), "HOTBAR_PET_FISH", new ItemStack(Material.WHEAT_SEEDS), new ItemStack[] {
				new ItemStack(Material.IRON_INGOT), new ItemStack(Material.COD), new ItemStack(Material.IRON_INGOT),
				new ItemStack(Material.COD), new ItemStack(Material.DIAMOND), new ItemStack(Material.COD),
				new ItemStack(Material.WATER_BUCKET), SlimefunItems.GOLD_18K, new ItemStack(Material.WATER_BUCKET)
		}).register();

		new SquidPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMDE0MzNiZTI0MjM2NmFmMTI2ZGE0MzRiODczNWRmMWViNWIzY2IyY2VkZTM5MTQ1OTc0ZTljNDgzNjA3YmFjIn19fQ=="), "&bSquid Pet", getName(), "&7Favourite Food: Raw Cod", "", "&rRight-Click: &7Gives you Water Breathing"), "HOTBAR_PET_SQUID", new ItemStack(Material.COD), new ItemStack[] {
				new ItemStack(Material.COAL), new ItemStack(Material.COD), new ItemStack(Material.COAL),
				new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.DIAMOND), new ItemStack(Material.WATER_BUCKET),
				new ItemStack(Material.COD), SlimefunItems.GOLD_16K, new ItemStack(Material.COD)
		}).register();

		new RabbitPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmYxNTU5MTk0YTE3NTkzNWI4YjRmZWE2NjE0YmVjNjBiZjgxY2Y1MjRhZjZmNTY0MzMzYzU1NWU2NTdiYyJ9fX0="), "&eRabbit Pet", getName(), "&7Favourite Food: Carrots", "", "&rRight-Click: &7Gives you 30 seconds of Luck"), "HOTBAR_PET_RABBIT", new ItemStack(Material.CARROT), new ItemStack[] {
				new ItemStack(Material.GOLDEN_CARROT), new ItemStack(Material.RABBIT_HIDE), new ItemStack(Material.GOLDEN_CARROT),
				new ItemStack(Material.RABBIT_HIDE), new ItemStack(Material.DIAMOND), new ItemStack(Material.RABBIT_HIDE),
				new ItemStack(Material.GOLDEN_CARROT), new ItemStack(Material.RABBIT_FOOT), new ItemStack(Material.GOLDEN_CARROT)
		}).register();

		new DolphinPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2VmZTdkODAzYTQ1YWEyYWYxOTkzZGYyNTQ0YTI4ZGY4NDlhNzYyNjYzNzE5YmZlZmM1OGJmMzg5YWI3ZjUifX19"), "&bDolphin Pet", getName(), "&7Favourite Food: Ink Sacks", "", "&rRight-Click: &7Dolphin's Grace"), "HOTBAR_PET_DOLPHIN", new ItemStack(Material.INK_SAC), new ItemStack[] {
				new ItemStack(Material.LAPIS_LAZULI), new ItemStack(Material.COD), new ItemStack(Material.LAPIS_LAZULI),
				new ItemStack(Material.SALMON), new ItemStack(Material.EMERALD), new ItemStack(Material.SALMON),
				new ItemStack(Material.LAPIS_LAZULI), new ItemStack(Material.COD), new ItemStack(Material.LAPIS_LAZULI)
		}).register();
	}



}
