package io.github.thebusybiscuit.hotbarpets;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.cscorelib2.protection.ProtectableAction;
import io.github.thebusybiscuit.cscorelib2.protection.ProtectionManager;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;

public class HotbarPetsListener implements Listener {

	private HotbarPets plugin;
	private ProtectionManager protection;

	private HotbarPet creeper; 
	private HotbarPet magmacube; 
	private HotbarPet slime; 
	private HotbarPet mrCookieSlime; 
	private HotbarPet wither; 
	private HotbarPet walshrus; 
	private HotbarPet blaze;
	private HotbarPet pig;
	private HotbarPet zombie;
	private HotbarPet eyamaz;

	public HotbarPetsListener(HotbarPets plugin) {
		this.plugin = plugin;
		this.protection = new ProtectionManager(plugin.getServer());

		creeper = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_CREEPER");
		magmacube = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_MAGMA_CUBE");
		slime = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_SLIME");
		mrCookieSlime = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_MRCOOKIESLIME");
		wither = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_WITHER");
		walshrus = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_WALSHRUS");
		blaze = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_BLAZE");
		pig = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_PIG");
		zombie = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_ZOMBIE");
		eyamaz = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_EYAMAZ");

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
		if (SlimefunItem.getByItem(e.getItemInHand()) instanceof HotbarPet) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onEquip(InventoryClickEvent e) {
		if (e.getSlotType() == SlotType.ARMOR && SlimefunItem.getByItem(e.getCursor()) instanceof HotbarPet) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onEat(PlayerItemConsumeEvent e) {
		final Player p = e.getPlayer();

		for (int i = 0; i < 9; ++i) {
			ItemStack item = p.getInventory().getItem(i);
			
			if (pig != null && SlimefunManager.isItemSimiliar(item, pig.getItem(), true)) {

				if (!p.getInventory().containsAtLeast(pig.getFavouriteFood(), 1)) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &5Pig Pet &9would have helped you if you did not neglect it by not feeding it :("));
					return;
				}

				plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
					p.getInventory().removeItem(pig.getFavouriteFood());
					p.setSaturation(p.getSaturation() + 8.0F);
					p.removePotionEffect(PotionEffectType.POISON);
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PIG_AMBIENT, 1.0F, 2.0F);
				}, 2L);
			}
			else if (zombie != null && SlimefunManager.isItemSimiliar(e.getItem(), new ItemStack(Material.ROTTEN_FLESH), true) && SlimefunManager.isItemSimiliar(item, zombie.getItem(), true)) {
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
					p.removePotionEffect(PotionEffectType.HUNGER);
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

				if (eyamaz != null && SlimefunManager.isItemSimiliar(item, eyamaz.getItem(), true)) {
					e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), new CustomItem(new ItemStack(Material.PUMPKIN_PIE), "&bSoul Pie"));
				}
			}
		}

	}
	
	@EventHandler
	public void onTNT(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof TNTPrimed) {
			if (e.getDamager().hasMetadata("hotbarpets_player")) {
				Player attacker = (Player) e.getDamager().getMetadata("hotbarpets_player").get(0);
			
				if (!protection.hasPermission(attacker, e.getEntity().getLocation(), ProtectableAction.PVP)) {
					e.setCancelled(true);
					attacker.sendMessage(ChatColor.DARK_RED + "You cannot harm Players in here!");
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

				switch (e.getCause()) {
				case ENTITY_EXPLOSION:
				case BLOCK_EXPLOSION:
				{
					if (creeper != null && SlimefunManager.isItemSimiliar(item, creeper.getItem(), true)) {
						if (!p.getInventory().containsAtLeast(creeper.getFavouriteFood(), 1)) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &2Creeper Pet &9would have helped you if you did not neglect it by not feeding it :("));
							return;
						}

						p.getInventory().removeItem(creeper.getFavouriteFood());
						e.setCancelled(true);
						p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1.0F, 2.0F);
					}
					break;
				}
				case LAVA:
				{
					if (magmacube != null && SlimefunManager.isItemSimiliar(item, magmacube.getItem(), true)) {
						if (!p.getInventory().containsAtLeast(magmacube.getFavouriteFood(), 1)) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &4Magma Cube Pet &9would have helped you if you did not neglect it by not feeding it :("));
							return;
						}

						if (CSCoreLib.randomizer().nextInt(100) < 30) {
							p.getInventory().removeItem(magmacube.getFavouriteFood());
						}

						e.setCancelled(true);
						p.getWorld().playSound(p.getLocation(), Sound.ENTITY_MAGMA_CUBE_JUMP, 1.0F, 2.0F);
					}
					break;
				}
				case FALL:
				{
					if (slime != null && SlimefunManager.isItemSimiliar(item, slime.getItem(), true)) {
						if (!p.getInventory().containsAtLeast(slime.getFavouriteFood(), 1)) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &aSlime Pet &9would have helped you if you did not neglect it by not feeding it :("));
							return;
						}

						p.getInventory().removeItem(slime.getFavouriteFood());
						e.setCancelled(true);
						p.getWorld().playSound(p.getLocation(), Sound.BLOCK_SLIME_BLOCK_STEP, 1.0F, 2.0F);
					}

					if (mrCookieSlime != null && SlimefunManager.isItemSimiliar(item, mrCookieSlime.getItem(), true)) {
						if (!p.getInventory().containsAtLeast(mrCookieSlime.getFavouriteFood(), 1)) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &amrCookieSlime Pet &9would have helped you if you did not neglect it by not feeding it :("));
							return;
						}

						p.getInventory().removeItem(mrCookieSlime.getFavouriteFood());
						e.setCancelled(true);
						p.getWorld().playSound(p.getLocation(), Sound.BLOCK_SLIME_BLOCK_STEP, 1.0F, 2.0F);
					}
					break;
				}
				case WITHER:
				{
					if (wither != null && SlimefunManager.isItemSimiliar(item, wither.getItem(), true)) {
						if (!p.getInventory().containsAtLeast(wither.getFavouriteFood(), 1)) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &8Wither Pet &9would have helped you if you did not neglect it by not feeding it :("));
							return;
						}

						p.getInventory().removeItem(wither.getFavouriteFood());
						e.setCancelled(true);
						p.removePotionEffect(PotionEffectType.WITHER);
						p.getWorld().playSound(p.getLocation(), Sound.ENTITY_WITHER_AMBIENT, 1.0F, 2.0F);
					}
					break;
				}
				case DROWNING:
				{
					if (walshrus != null && SlimefunManager.isItemSimiliar(item, walshrus.getItem(), true)) {
						if (!p.getInventory().containsAtLeast(walshrus.getFavouriteFood(), 1)) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &bWalshrus Pet &9would have helped you if you did not neglect it by not feeding it :("));
							return;
						}

						p.getInventory().removeItem(walshrus.getFavouriteFood());
						e.setCancelled(true);
					}
					break;
				}
				case FIRE:
				case FIRE_TICK:
				{
					if (blaze != null && SlimefunManager.isItemSimiliar(item, blaze.getItem(), true)) {
						if (!p.getInventory().containsAtLeast(blaze.getFavouriteFood(), 1)) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &6Blaze Pet &9would have helped you if you did not neglect it by not feeding it :("));
							return;
						}

						p.getInventory().removeItem(blaze.getFavouriteFood());
						e.setCancelled(true);
						p.setFireTicks(0);
						p.getWorld().playSound(p.getLocation(), Sound.ENTITY_BLAZE_AMBIENT, 1.0F, 2.0F);
					}

					break;
				}
				default:
					break;
				}
			}
		}
	}

}
