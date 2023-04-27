package io.github.thebusybiscuit.hotbarpets.listeners;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.hotbarpets.HotbarPet;
import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;

public class DamageListener implements Listener {

    private final HotbarPet creeper;
    private final HotbarPet magmacube;
    private final HotbarPet slime;
    private final HotbarPet mrCookieSlime;
    private final HotbarPet wither;
    private final HotbarPet walshrus;
    private final HotbarPet blaze;

    public DamageListener(HotbarPets plugin) {
        creeper = (HotbarPet) SlimefunItem.getById("HOTBAR_PET_CREEPER");
        magmacube = (HotbarPet) SlimefunItem.getById("HOTBAR_PET_MAGMA_CUBE");
        slime = (HotbarPet) SlimefunItem.getById("HOTBAR_PET_SLIME");
        mrCookieSlime = (HotbarPet) SlimefunItem.getById("HOTBAR_PET_MRCOOKIESLIME");
        wither = (HotbarPet) SlimefunItem.getById("HOTBAR_PET_WITHER");
        walshrus = (HotbarPet) SlimefunItem.getById("HOTBAR_PET_WALSHRUS");
        blaze = (HotbarPet) SlimefunItem.getById("HOTBAR_PET_BLAZE");

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();

            for (int i = 0; i < 9; ++i) {
                ItemStack item = p.getInventory().getItem(i);

                switch (e.getCause()) {
                case ENTITY_EXPLOSION:
                case BLOCK_EXPLOSION:
                    if (creeper != null && SlimefunUtils.isItemSimilar(item, creeper.getItem(), true)) {
                        if (!creeper.checkAndConsumeFood(p)) {
                            return;
                        }

                        e.setCancelled(true);
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1.0F, 2.0F);
                    }
                    break;
                case LAVA:
                    if (magmacube != null && SlimefunUtils.isItemSimilar(item, magmacube.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(magmacube.getFavouriteFood(), 1)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "${hotbarpets.feedfood.message.04}"));
                            return;
                        }

                        if (ThreadLocalRandom.current().nextInt(100) < 30) {
                            p.getInventory().removeItem(magmacube.getFavouriteFood());
                        }

                        e.setCancelled(true);
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_MAGMA_CUBE_JUMP, 1.0F, 2.0F);
                    }
                    break;
                case FALL:
                    if (slime != null && SlimefunUtils.isItemSimilar(item, slime.getItem(), true)) {
                        if (!slime.checkAndConsumeFood(p)) {
                            return;
                        }

                        e.setCancelled(true);
                        p.getWorld().playSound(p.getLocation(), Sound.BLOCK_SLIME_BLOCK_STEP, 1.0F, 2.0F);
                    }

                    if (mrCookieSlime != null && SlimefunUtils.isItemSimilar(item, mrCookieSlime.getItem(), true)) {
                        if (!mrCookieSlime.checkAndConsumeFood(p)) {
                            return;
                        }

                        e.setCancelled(true);
                        p.getWorld().playSound(p.getLocation(), Sound.BLOCK_SLIME_BLOCK_STEP, 1.0F, 2.0F);
                    }
                    break;
                case WITHER:
                    if (wither != null && SlimefunUtils.isItemSimilar(item, wither.getItem(), true)) {
                        if (!wither.checkAndConsumeFood(p)) {
                            return;
                        }

                        e.setCancelled(true);
                        p.removePotionEffect(PotionEffectType.WITHER);
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_WITHER_AMBIENT, 1.0F, 2.0F);
                    }
                    break;
                case DROWNING:
                    if (walshrus != null && SlimefunUtils.isItemSimilar(item, walshrus.getItem(), true)) {
                        if (!walshrus.checkAndConsumeFood(p)) {
                            return;
                        }

                        e.setCancelled(true);
                    }
                    break;
                case FIRE:
                case FIRE_TICK:
                    if (blaze != null && SlimefunUtils.isItemSimilar(item, blaze.getItem(), true)) {
                        if (!blaze.checkAndConsumeFood(p)) {
                            return;
                        }

                        e.setCancelled(true);
                        p.setFireTicks(0);
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_BLAZE_AMBIENT, 1.0F, 2.0F);
                    }

                    break;
                default:
                    break;
                }
            }
        }
    }
}
