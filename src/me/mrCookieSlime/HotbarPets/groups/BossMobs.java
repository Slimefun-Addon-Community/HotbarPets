package me.mrCookieSlime.HotbarPets.groups;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import me.mrCookieSlime.HotbarPets.HotbarPet;
import me.mrCookieSlime.HotbarPets.HotbarPets;
import me.mrCookieSlime.HotbarPets.PetGroup;
import me.mrCookieSlime.HotbarPets.pets.EnderDragonPet;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;

public final class BossMobs implements PetGroup {

	public BossMobs(HotbarPets plugin) throws Exception {
		load(plugin);
	}
	
	@Override
	public String getName() {
		return "&4Boss Mob (Hostile)";
	}

	@Override
	public void load(HotbarPets plugin) throws Exception {
		new EnderDragonPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzRmNjE0MjJlZDc5OGRmNzM1YWQ3Y2Q5M2VlYmM4NTE1OGQ4MDQwN2MzN2YxZGE1OThiZDE3ODM2ZGYzNjYifX19"), "&5Ender Dragon Pet", getName(), "&7Favourite Food: Eyes Of Ender", "", "&rRight-Click: &7Shoots Dragon Fireball & Gives Resistance"), "HOTBAR_PET_DRAGON", new ItemStack(Material.ENDER_EYE), new ItemStack[]{
                new ItemStack(Material.PRISMARINE_CRYSTALS), new ItemStack(Material.DRAGON_BREATH), new ItemStack(Material.PRISMARINE_CRYSTALS),
                SlimefunItems.ENDER_LUMP_3, new ItemStack(Material.DRAGON_HEAD), SlimefunItems.ENDER_LUMP_3,
                new ItemStack(Material.PRISMARINE_CRYSTALS), new ItemStack(Material.DRAGON_BREATH), new ItemStack(Material.PRISMARINE_CRYSTALS)
        }).register();

        new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2RmNzRlMzIzZWQ0MTQzNjk2NWY1YzU3ZGRmMjgxNWQ1MzMyZmU5OTllNjhmYmI5ZDZjZjVjOGJkNDEzOWYifX19"), "&8Wither Pet", getName(), "&7Favourite Food: Soul Sand", "", "&rImmune to Wither Effect"), "HOTBAR_PET_WITHER", new ItemStack(Material.SOUL_SAND), new ItemStack[]{
                new ItemStack(Material.COAL), new ItemStack(Material.WITHER_SKELETON_SKULL), new ItemStack(Material.COAL),
                new ItemStack(Material.SOUL_SAND), new ItemStack(Material.NETHER_STAR), new ItemStack(Material.SOUL_SAND),
                new ItemStack(Material.SOUL_SAND), SlimefunItems.GOLD_24K, new ItemStack(Material.SOUL_SAND)
        }).register();
	}
	
	

}
