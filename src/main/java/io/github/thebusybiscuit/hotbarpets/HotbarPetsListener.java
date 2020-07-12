package io.github.thebusybiscuit.hotbarpets;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Phantom;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.protection.ProtectableAction;

public class HotbarPetsListener implements Listener {

    private static final String METADATA_KEY = "hotbarpets_player";
    private final HotbarPets plugin;

    private final HotbarPet creeper;
    private final HotbarPet magmacube;
    private final HotbarPet slime;
    private final HotbarPet mrCookieSlime;
    private final HotbarPet wither;
    private final HotbarPet walshrus;
    private final HotbarPet blaze;
    private final HotbarPet pig;
    private final HotbarPet zombie;
    private final HotbarPet eyamaz;
    private final HotbarPet panda;

    public HotbarPetsListener(HotbarPets plugin) {
        this.plugin = plugin;

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
        panda = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_PANDA");

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onTippedArrowHit(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Arrow && e.getEntity().hasMetadata("hotbarpets_projectile")) {
            e.getEntity().removeMetadata("hotbarpets_projectile", plugin);
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
        Player p = e.getPlayer();

        for (int i = 0; i < 9; ++i) {
            ItemStack item = p.getInventory().getItem(i);

            if (pig != null && SlimefunUtils.isItemSimilar(item, pig.getItem(), true)) {

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
            else if (zombie != null && SlimefunUtils.isItemSimilar(e.getItem(), new ItemStack(Material.ROTTEN_FLESH), true) && SlimefunUtils.isItemSimilar(item, zombie.getItem(), true)) {
                plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> p.removePotionEffect(PotionEffectType.HUNGER), 2L);
            }
        }

    }

    @EventHandler
    public void onSoulHarvest(EntityDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player) {
            Player p = e.getEntity().getKiller();

            for (int i = 0; i < 9; ++i) {
                ItemStack item = p.getInventory().getItem(i);

                if (eyamaz != null && SlimefunUtils.isItemSimilar(item, eyamaz.getItem(), true)) {
                    e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), new CustomItem(new ItemStack(Material.PUMPKIN_PIE), "&bSoul Pie"));
                }
            }
        }

    }

    @EventHandler
    public void onTNT(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof TNTPrimed && e.getDamager().hasMetadata(METADATA_KEY)) {
            Player attacker = (Player) e.getDamager().getMetadata(METADATA_KEY).get(0).value();

            e.getDamager().removeMetadata("hotbarpets_player", plugin);
            if (!SlimefunPlugin.getProtectionManager().hasPermission(attacker, e.getEntity().getLocation(), ProtectableAction.PVP)) {
                e.setCancelled(true);
                attacker.sendMessage(ChatColor.DARK_RED + "You cannot harm Players in here!");
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
                    if (creeper != null && SlimefunUtils.isItemSimilar(item, creeper.getItem(), true)) {
                        if (!creeper.checkAndConsumeFood(p)) return;

                        e.setCancelled(true);
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1.0F, 2.0F);
                    }
                    break;
                case LAVA:
                    if (magmacube != null && SlimefunUtils.isItemSimilar(item, magmacube.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(magmacube.getFavouriteFood(), 1)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &4Magma Cube Pet &9would have helped you if you did not neglect it by not feeding it :("));
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
                        if (!slime.checkAndConsumeFood(p)) return;

                        e.setCancelled(true);
                        p.getWorld().playSound(p.getLocation(), Sound.BLOCK_SLIME_BLOCK_STEP, 1.0F, 2.0F);
                    }

                    if (mrCookieSlime != null && SlimefunUtils.isItemSimilar(item, mrCookieSlime.getItem(), true)) {
                        if (!mrCookieSlime.checkAndConsumeFood(p)) return;

                        e.setCancelled(true);
                        p.getWorld().playSound(p.getLocation(), Sound.BLOCK_SLIME_BLOCK_STEP, 1.0F, 2.0F);
                    }
                    break;
                case WITHER:
                    if (wither != null && SlimefunUtils.isItemSimilar(item, wither.getItem(), true)) {
                        if (!wither.checkAndConsumeFood(p)) return;

                        e.setCancelled(true);
                        p.removePotionEffect(PotionEffectType.WITHER);
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_WITHER_AMBIENT, 1.0F, 2.0F);
                    }
                    break;
                case DROWNING:
                    if (walshrus != null && SlimefunUtils.isItemSimilar(item, walshrus.getItem(), true)) {
                        if (!walshrus.checkAndConsumeFood(p)) return;

                        e.setCancelled(true);
                    }
                    break;
                case FIRE:
                case FIRE_TICK:
                    if (blaze != null && SlimefunUtils.isItemSimilar(item, blaze.getItem(), true)) {
                        if (!blaze.checkAndConsumeFood(p)) return;

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

    @EventHandler
    public void onPhantomSpawn(EntityTargetLivingEntityEvent e) {
        if (e.getEntityType() == EntityType.PHANTOM && ((Phantom) e.getEntity()).getTarget() instanceof Player) {
            Player p = (Player) ((Phantom) e.getEntity()).getTarget();

            if (!hasHotBarPet(p, panda) || !panda.checkAndConsumeFood(p)) return;

            e.getEntity().remove();
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        HotbarPet.getMessageDelay().remove(e.getPlayer().getUniqueId());
    }

    private boolean hasHotBarPet(Player player, HotbarPet pet) {
        for (int i = 0; i < 9; i++) {
            if (pet.isItem(player.getInventory().getItem(i))) return true;
        }

        return false;
    }
}
