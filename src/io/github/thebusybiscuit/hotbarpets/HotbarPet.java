package io.github.thebusybiscuit.hotbarpets;

import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.inventory.ItemStack;

public class HotbarPet extends SlimefunItem {

	public static Category category;

	static {
		try {
			category = new Category(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjIxNjY4ZWY3Y2I3OWRkOWMyMmNlM2QxZjNmNGNiNmUyNTU5ODkzYjZkZjRhNDY5NTE0ZTY2N2MxNmFhNCJ9fX0="), "&dHotbar Pets", "", "&a> Click to open"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private ItemStack food;

	public HotbarPet(ItemStack item, String name, ItemStack food, ItemStack[] recipe) {
		super(category, item, name, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
		this.food = food;
	}

	public ItemStack getFavouriteFood() {
		return this.food;
	}
}