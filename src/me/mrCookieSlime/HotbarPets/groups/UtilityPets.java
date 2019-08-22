package me.mrCookieSlime.HotbarPets.groups;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import me.mrCookieSlime.HotbarPets.HotbarPets;
import me.mrCookieSlime.HotbarPets.PetGroup;
import me.mrCookieSlime.HotbarPets.pets.BedPet;
import me.mrCookieSlime.HotbarPets.pets.EnderChestPet;
import me.mrCookieSlime.HotbarPets.pets.WorkbenchPet;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;

public final class UtilityPets implements PetGroup {

	public UtilityPets(HotbarPets plugin) throws Exception {
		load(plugin);
	}
	
	@Override
	public String getName() {
		return "&aUtility (Peaceful)";
	}

	@Override
	public void load(HotbarPets plugin) throws Exception {
		new BedPet(new CustomItem(Material.RED_BED, "&rBed Pet", getName(), "&7Favourite Food: Wool", "", "&rRight-Click: &7Sleep"), "HOTBAR_PET_BED", new ItemStack(Material.WHITE_WOOL), new ItemStack[]{
                new ItemStack(Material.IRON_INGOT), new ItemStack(Material.RED_BED), new ItemStack(Material.IRON_INGOT),
                new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.DIAMOND), new ItemStack(Material.WHITE_WOOL),
                new ItemStack(Material.OAK_PLANKS), SlimefunItems.GOLD_14K, new ItemStack(Material.OAK_PLANKS)
        }).register();

        new EnderChestPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTZjYzQ4NmMyYmUxY2I5ZGZjYjJlNTNkZDlhM2U5YTg4M2JmYWRiMjdjYjk1NmYxODk2ZDYwMmI0MDY3In19fQ=="), "&5Ender Chest Pet", getName(), "&7Favourite Food: Ender Pearls", "", "&rRight-Click: &7Open"), "HOTBAR_PET_ENDER_CHEST", new ItemStack(Material.ENDER_PEARL), new ItemStack[]{
                new ItemStack(Material.OBSIDIAN), new ItemStack(Material.ENDER_EYE), new ItemStack(Material.OBSIDIAN),
                new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.EMERALD), new ItemStack(Material.ENDER_PEARL),
                new ItemStack(Material.OBSIDIAN), SlimefunItems.GOLD_16K, new ItemStack(Material.OBSIDIAN)
        }).register();
        
        new WorkbenchPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGFkODgxZDY4NTQ3MTYxYWE3YjI5MjVlMzgzNzc4NzU2YmM2N2E3NWI0NDRhNTg2ZTUxNTk1M2VmODNhOSJ9fX0="), "&6Workbench Pet", getName(), "&7Favourite Food: Wooden Planks", "", "&rRight-Click: &7Open"), "HOTBAR_PET_WORKBENCH", new ItemStack(Material.OAK_PLANKS), new ItemStack[]{
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.CRAFTING_TABLE), new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.OAK_PLANKS),
                new ItemStack(Material.OAK_PLANKS), SlimefunItems.GOLD_16K, new ItemStack(Material.OAK_PLANKS)
        }).register();
	}
	
	

}
