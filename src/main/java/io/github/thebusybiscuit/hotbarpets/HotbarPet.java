package io.github.thebusybiscuit.hotbarpets;

import org.bukkit.inventory.ItemStack;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class HotbarPet extends SlimefunItem {

	private final ItemStack food;

	public HotbarPet(Category category, SlimefunItemStack item, ItemStack food, ItemStack[] recipe) {
		super(category, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
		this.food = food;
	}

	public ItemStack getFavouriteFood() {
		return this.food;
	}
}