package io.github.thebusybiscuit.hotbarpets;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.mrCookieSlime.CSCoreLibPlugin.events.ItemUseEvent;
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
		this.register(new ItemInteractionHandler() {

			@Override
			public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
				if (SlimefunManager.isItemSimilar(item, getItem(), true)) {
					if (!p.getInventory().containsAtLeast(getFavouriteFood(), 1)) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &r" + getItem().getItemMeta().getDisplayName() + " &9would have helped you if you did not neglect it by not feeding it :("));
					} 
					else {
						p.getInventory().removeItem(getFavouriteFood());
						onUseItem(p);
					}
					return true;
				} 
				else {
					return false;
				}
			}
		});
	}

}
