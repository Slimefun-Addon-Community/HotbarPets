package io.github.thebusybiscuit.hotbarpets;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.handlers.ItemInteractionHandler;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public abstract class SimpleBasePet extends HotbarPet {

	public SimpleBasePet(Category category, SlimefunItemStack item, ItemStack food, ItemStack[] recipe) {
		super(category, item, food, recipe);
	}

	public abstract void onUseItem(Player p);
	
	@Override
	public void register() {
		this.register((ItemInteractionHandler) (e, p, item) -> {
			if (isItem(item)) {
				if (tryToConsumeFood(p))
					onUseItem(p);
				return true;
			}
			else {
				return false;
			}
		});
	}

}
