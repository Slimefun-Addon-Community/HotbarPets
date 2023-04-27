package io.github.thebusybiscuit.hotbarpets;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;

public class HotbarPet extends SlimefunItem {

    private static final long MESSAGE_DELAY = 2000;
    private static final Map<UUID, Long> messageDelay = new HashMap<>();

    private final ItemStack food;

    public HotbarPet(ItemGroup itemGroup, SlimefunItemStack item, ItemStack food, ItemStack[] recipe) {
        super(itemGroup, item, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        this.food = food;
    }

    public ItemStack getFavouriteFood() {
        return this.food;
    }

    /**
     * Tries to consume the pets favourite food, if this was successful it will return true. Otherwise false.
     * If it fails to consume food it will send a message to the player, this is on a delay as to not spam the player.
     * The default delay is {@link #MESSAGE_DELAY}.
     *
     * @param player
     *            The {@link Player} who owns this pet
     * 
     * @return If the food consumption was successful
     */
    public boolean checkAndConsumeFood(Player player) {
        if (!player.getInventory().containsAtLeast(getFavouriteFood(), 1)) {
            if (messageDelay.getOrDefault(player.getUniqueId(), 0L) <= System.currentTimeMillis()) {
                player.sendMessage(ChatColor.BLUE + "${hotbarpets.feedfood.message.01}" + getItemName() + ChatColor.BLUE + "${hotbarpets.feedfood.message.02}");
                messageDelay.put(player.getUniqueId(), System.currentTimeMillis() + MESSAGE_DELAY);
            }

            return false;
        }

        player.getInventory().removeItem(getFavouriteFood());
        return true;
    }

    public static Map<UUID, Long> getMessageDelay() {
        return messageDelay;
    }
}
