package io.github.thebusybiscuit.hotbarpets;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;

public class HotbarPetsListener implements Listener {
	
	private HotbarPets plugin;

	public HotbarPetsListener(HotbarPets plugin) {
		this.plugin = plugin;
		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
    public void onTippedArrowHit(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Arrow && e.getEntity().hasMetadata("hotbarpets_projectile")) {
            e.getEntity().remove();
        }
    }
	
	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onPlace(BlockPlaceEvent e) {
        SlimefunItem item = SlimefunItem.getByItem(e.getItemInHand());

        if (item != null && item instanceof HotbarPet) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onEquip(InventoryClickEvent e) {
        if (e.getSlotType() == SlotType.ARMOR) {
            SlimefunItem item = SlimefunItem.getByItem(e.getCursor());
            if (item != null && item instanceof HotbarPet) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e) {
        final Player p = e.getPlayer();

        for (int i = 0; i < 9; ++i) {
            ItemStack item = p.getInventory().getItem(i);
            final HotbarPet pet = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_PIG");
            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &5Pig Pet &9would have helped you if you did not neglect it by not feeding it :("));
                    return;
                }

                plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                    p.getInventory().removeItem(pet.getFavouriteFood());
                    p.setSaturation(p.getSaturation() + 8.0F);
                    p.removePotionEffect(PotionEffectType.POISON);
                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PIG_AMBIENT, 1.0F, 2.0F);
                }, 2L);
            }
        }

    }

    @EventHandler
    public void onSoulHarvest(EntityDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player) {
            Player p = e.getEntity().getKiller();

            for (int i = 0; i < 9; ++i) {
                ItemStack item = p.getInventory().getItem(i);

                HotbarPet pet = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_EYAMAZ");
                if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                    e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), new CustomItem(new ItemStack(Material.PUMPKIN_PIE), "&bSoul Pie"));
                }
            }
        }

    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();

            for (int i = 0; i < 9; ++i) {
                ItemStack item = p.getInventory().getItem(i);
                HotbarPet pet;

                if (e.getCause() != DamageCause.ENTITY_EXPLOSION && e.getCause() != DamageCause.BLOCK_EXPLOSION) {
                    if (e.getCause() == DamageCause.LAVA) {

                        pet = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_MAGMA_CUBE");
                        if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                            if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &4Magma Cube Pet &9would have helped you if you did not neglect it by not feeding it :("));
                                return;
                            }

                            if (CSCoreLib.randomizer().nextInt(100) < 30) {
                                p.getInventory().removeItem(pet.getFavouriteFood());
                            }

                            e.setCancelled(true);
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_MAGMA_CUBE_JUMP, 1.0F, 2.0F);
                        }

                    } else if (e.getCause() != DamageCause.FIRE && e.getCause() != DamageCause.FIRE_TICK) {
                        if (e.getCause() == DamageCause.FALL) {
                            pet = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_SLIME");
                            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &aSlime Pet &9would have helped you if you did not neglect it by not feeding it :("));
                                    return;
                                }

                                p.getInventory().removeItem(pet.getFavouriteFood());
                                e.setCancelled(true);
                                p.getWorld().playSound(p.getLocation(), Sound.BLOCK_SLIME_BLOCK_STEP, 1.0F, 2.0F);
                            }

                            pet = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_MRCOOKIESLIME");
                            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &amrCookieSlime Pet &9would have helped you if you did not neglect it by not feeding it :("));
                                    return;
                                }

                                p.getInventory().removeItem(pet.getFavouriteFood());
                                e.setCancelled(true);
                                p.getWorld().playSound(p.getLocation(), Sound.BLOCK_SLIME_BLOCK_STEP, 1.0F, 2.0F);
                            }

                        } else if (e.getCause() == DamageCause.WITHER) {
                            pet = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_WITHER");
                            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &8Wither Pet &9would have helped you if you did not neglect it by not feeding it :("));
                                    return;
                                }

                                p.getInventory().removeItem(pet.getFavouriteFood());
                                e.setCancelled(true);
                                p.removePotionEffect(PotionEffectType.WITHER);
                                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_WITHER_AMBIENT, 1.0F, 2.0F);
                            }

                        } else if (e.getCause() == DamageCause.DROWNING) {
                            pet = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_WALSHRUS");
                            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &bWalshrus Pet &9would have helped you if you did not neglect it by not feeding it :("));
                                    return;
                                }

                                p.getInventory().removeItem(pet.getFavouriteFood());
                                e.setCancelled(true);
                            }
                        }

                    } else {
                        pet = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_BLAZE");
                        if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                            if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &6Blaze Pet &9would have helped you if you did not neglect it by not feeding it :("));
                                return;
                            }

                            p.getInventory().removeItem(pet.getFavouriteFood());
                            e.setCancelled(true);
                            p.setFireTicks(0);
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_BLAZE_AMBIENT, 1.0F, 2.0F);
                        }
                    }

                } else {
                    pet = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_CREEPER");
                    if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &2Creeper Pet &9would have helped you if you did not neglect it by not feeding it :("));
                            return;
                        }

                        p.getInventory().removeItem(pet.getFavouriteFood());
                        e.setCancelled(true);
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1.0F, 2.0F);
                    }
                }
            }
        }
    }
	
}
