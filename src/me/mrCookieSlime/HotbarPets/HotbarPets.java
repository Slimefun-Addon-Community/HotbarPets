package me.mrCookieSlime.HotbarPets;

import java.util.Iterator;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.PluginUtils;
import me.mrCookieSlime.CSCoreLibPlugin.events.ItemUseEvent;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemInteractionHandler;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HotbarPets extends JavaPlugin implements Listener {
    public HotbarPets() {
    }

    public void onEnable() {
        try {
            this.getServer().getPluginManager().registerEvents(this, this);
            PluginUtils utils = new PluginUtils(this);
            utils.setupUpdater(95069, this.getFile());
            utils.setupMetrics();
            (new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjIxNjY4ZWY3Y2I3OWRkOWMyMmNlM2QxZjNmNGNiNmUyNTU5ODkzYjZkZjRhNDY5NTE0ZTY2N2MxNmFhNCJ9fX0="), "§dPig Pet", new String[]{"§2Farm Animal (Peaceful)", "§7Favourite Food: Carrots", "", "§rBonus Saturation when eating", "§rAllows you to eat poisonous Food"}), "HOTBAR_PET_PIG", new ItemStack(Material.CARROT), new ItemStack[]{new ItemStack(Material.REDSTONE), new ItemStack(Material.CARROT), new ItemStack(Material.REDSTONE), new ItemStack(Material.PORKCHOP), new ItemStack(Material.DIAMOND), new ItemStack(Material.PORKCHOP), new ItemStack(Material.REDSTONE), SlimefunItems.GOLD_16K, new ItemStack(Material.REDSTONE)})).register();
            (new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTYzODQ2OWE1OTljZWVmNzIwNzUzNzYwMzI0OGE5YWIxMWZmNTkxZmQzNzhiZWE0NzM1YjM0NmE3ZmFlODkzIn19fQ=="), "§rChicken Pet", new String[]{"§2Farm Animal (Peaceful)", "§7Favourite Food: Seeds", "", "§rGives you Eggs over time..."}), "HOTBAR_PET_CHICKEN", new ItemStack(Material.WHEAT_SEEDS), new ItemStack[]{new ItemStack(Material.REDSTONE), new ItemStack(Material.FEATHER), new ItemStack(Material.REDSTONE), new ItemStack(Material.COOKED_CHICKEN), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKED_CHICKEN), new ItemStack(Material.REDSTONE), SlimefunItems.GOLD_16K, new ItemStack(Material.REDSTONE)})).register();
            (new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDBiYzYxYjk3NTdhN2I4M2UwM2NkMjUwN2EyMTU3OTEzYzJjZjAxNmU3YzA5NmE0ZDZjZjFmZTFiOGRiIn19fQ=="), "§dMooshroom Pet", new String[]{"§2Farm Animal (Peaceful)", "§7Favourite Food: Red Mushrooms", "", "§rGives you Beetroot Soup over time..."}), "HOTBAR_PET_MOOSHROOM", new ItemStack(Material.RED_MUSHROOM), new ItemStack[]{(new ItemStack(Material.LAPIS_LAZULI)), new ItemStack(Material.COOKED_BEEF), (new ItemStack(Material.LAPIS_LAZULI)), new ItemStack(Material.RED_MUSHROOM), new ItemStack(Material.DIAMOND), new ItemStack(Material.BROWN_MUSHROOM), (new ItemStack(Material.LAPIS_LAZULI)), SlimefunItems.GOLD_16K, (new ItemStack(Material.LAPIS_LAZULI))})).register();
            final HotbarPet cow = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWQ2YzZlZGE5NDJmN2Y1ZjcxYzMxNjFjNzMwNmY0YWVkMzA3ZDgyODk1ZjlkMmIwN2FiNDUyNTcxOGVkYzUifX19"), "§6Cow Pet", new String[]{"§2Farm Animal (Peaceful)", "§7Favourite Food: Wheat", "", "§rRight-Click: §7Removes negative Potion Effects"}), "HOTBAR_PET_COW", new ItemStack(Material.WHEAT), new ItemStack[]{new ItemStack(Material.COAL), new ItemStack(Material.WHEAT), new ItemStack(Material.COAL), new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.COAL), SlimefunItems.GOLD_16K, new ItemStack(Material.COAL)});
            cow.register(new ItemHandler[]{new ItemInteractionHandler() {
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, cow.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(cow.getFavouriteFood(), 1)) {
                            p.sendMessage("§9Your §6Cow Pet §9would have helped you if you did not neglect it by not feeding it :(");
                        } else {
                            p.getInventory().removeItem(new ItemStack[]{cow.getFavouriteFood()});
                            p.removePotionEffect(PotionEffectType.BLINDNESS);
                            p.removePotionEffect(PotionEffectType.CONFUSION);
                            p.removePotionEffect(PotionEffectType.HUNGER);
                            p.removePotionEffect(PotionEffectType.POISON);
                            p.removePotionEffect(PotionEffectType.SLOW);
                            p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
                            p.removePotionEffect(PotionEffectType.WEAKNESS);
                            p.removePotionEffect(PotionEffectType.WITHER);
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_COW_AMBIENT, 1.0F, 2.0F);
                        }

                        return true;
                    } else {
                        return false;
                    }
                }
            }});
            final HotbarPet squid = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMDE0MzNiZTI0MjM2NmFmMTI2ZGE0MzRiODczNWRmMWViNWIzY2IyY2VkZTM5MTQ1OTc0ZTljNDgzNjA3YmFjIn19fQ=="), "§bSquid Pet", new String[]{"§aAnimal (Peaceful)", "§7Favourite Food: Raw Cod", "", "§rRight-Click: §7Gives you Water Breathing"}), "HOTBAR_PET_SQUID", new ItemStack(Material.COD), new ItemStack[]{new ItemStack(Material.COAL), new ItemStack(Material.COD), new ItemStack(Material.COAL), new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.DIAMOND), new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.COD), SlimefunItems.GOLD_16K, new ItemStack(Material.COD)});
            squid.register(new ItemHandler[]{new ItemInteractionHandler() {
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, squid.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(squid.getFavouriteFood(), 1)) {
                            p.sendMessage("§9Your §bSquid Pet §9would have helped you if you did not neglect it by not feeding it :(");
                        } else {
                            p.getInventory().removeItem(new ItemStack[]{squid.getFavouriteFood()});
                            p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1200, 2));
                        }

                        return true;
                    } else {
                        return false;
                    }
                }
            }});
            final HotbarPet spider = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjdhNGMyNTZmMGRmNjE0MjMxZjhkNTUzNDRjOWRlMzkzODkzNjFhNzQwYzExZmFjYzBkMjk5ZjY3NmRkOWEifX19"), "§8Spider Pet", new String[]{"§cMob (Hostile)", "§7Favourite Food: Rotten Flesh", "", "§rRight-Click: §7Gives you Jump Boost"}), "HOTBAR_PET_SPIDER", new ItemStack(Material.ROTTEN_FLESH), new ItemStack[]{new ItemStack(Material.COAL), new ItemStack(Material.STRING), new ItemStack(Material.COAL), new ItemStack(Material.SPIDER_EYE), new ItemStack(Material.EMERALD), new ItemStack(Material.SPIDER_EYE), new ItemStack(Material.STRING), SlimefunItems.GOLD_16K, new ItemStack(Material.STRING)});
            spider.register(new ItemHandler[]{new ItemInteractionHandler() {
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, spider.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(spider.getFavouriteFood(), 1)) {
                            p.sendMessage("§9Your §8Spider Pet §9would have helped you if you did not neglect it by not feeding it :(");
                        } else {
                            p.getInventory().removeItem(new ItemStack[]{spider.getFavouriteFood()});
                            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200, 3));
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SPIDER_AMBIENT, 1.0F, 2.0F);
                        }

                        return true;
                    } else {
                        return false;
                    }
                }
            }});
            final HotbarPet golem = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODkwOTFkNzllYTBmNTllZjdlZjk0ZDdiYmE2ZTVmMTdmMmY3ZDQ1NzJjNDRmOTBmNzZjNDgxOWE3MTQifX19"), "§7Iron Golem Pet", new String[]{"§eMob (Passive)", "§7Favourite Food: Iron Ingots", "", "§rRight-Click: §7Gives you Resistance"}), "HOTBAR_PET_IRON_GOLEM", new ItemStack(Material.IRON_INGOT), new ItemStack[]{new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.PUMPKIN), new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.EMERALD), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), SlimefunItems.GOLD_16K, new ItemStack(Material.IRON_INGOT)});
            golem.register(new ItemHandler[]{new ItemInteractionHandler() {
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, golem.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(golem.getFavouriteFood(), 1)) {
                            p.sendMessage("§9Your §7Iron Golem Pet §9would have helped you if you did not neglect it by not feeding it :(");
                        } else {
                            p.getInventory().removeItem(new ItemStack[]{golem.getFavouriteFood()});
                            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 500, 0));
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_IRON_GOLEM_STEP, 1.0F, 2.0F);
                        }

                        return true;
                    } else {
                        return false;
                    }
                }
            }});
            final HotbarPet enderman = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2E1OWJiMGE3YTMyOTY1YjNkOTBkOGVhZmE4OTlkMTgzNWY0MjQ1MDllYWRkNGU2YjcwOWFkYTUwYjljZiJ9fX0="), "§8Enderman Pet", new String[]{"§cMob (Hostile)", "§7Favourite Food: End Stone", "", "§rRight-Click: §7Shoots an Ender Pearl"}), "HOTBAR_PET_ENDER_MAN", new ItemStack(Material.END_STONE), new ItemStack[]{new ItemStack(Material.OBSIDIAN), new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.ENDER_EYE), new ItemStack(Material.EMERALD), new ItemStack(Material.ENDER_EYE), new ItemStack(Material.ENDER_PEARL), SlimefunItems.GOLD_16K, new ItemStack(Material.ENDER_PEARL)});
            enderman.register(new ItemHandler[]{new ItemInteractionHandler() {
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, enderman.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(enderman.getFavouriteFood(), 1)) {
                            p.sendMessage("§9Your §8Enderman Pet §9would have helped you if you did not neglect it by not feeding it :(");
                        } else {
                            p.getInventory().removeItem(new ItemStack[]{enderman.getFavouriteFood()});
                            p.launchProjectile(EnderPearl.class);
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_AMBIENT, 1.0F, 2.0F);
                        }

                        return true;
                    } else {
                        return false;
                    }
                }
            }});
            final HotbarPet creeper = new HotbarPet(new CustomItem(new MaterialData(Material.CREEPER_HEAD, (byte)4), "§2Creeper Pet", new String[]{"§cMob (Hostile)", "§7Favourite Food: Gunpowder", "", "§rImmune to Explosions", "§rRight-Click: §7Explode"}), "HOTBAR_PET_CREEPER", new ItemStack(Material.GUNPOWDER), new ItemStack[]{new ItemStack(Material.DIAMOND), (new MaterialData(Material.CREEPER_HEAD, (byte)4)).toItemStack(1), new ItemStack(Material.DIAMOND), new ItemStack(Material.GUNPOWDER), new ItemStack(Material.EMERALD), new ItemStack(Material.GUNPOWDER), new ItemStack(Material.DIAMOND), SlimefunItems.GOLD_20K, new ItemStack(Material.DIAMOND)});
            creeper.register(new ItemHandler[]{new ItemInteractionHandler() {
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, creeper.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(creeper.getFavouriteFood(), 1)) {
                            p.sendMessage("§9Your §2Creeper Pet §9would have helped you if you did not neglect it by not feeding it :(");
                        } else {
                            p.getInventory().removeItem(new ItemStack[]{creeper.getFavouriteFood()});
                            TNTPrimed tnt = (TNTPrimed)p.getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT);
                            tnt.setFuseTicks(0);
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1.0F, 2.0F);
                        }

                        return true;
                    } else {
                        return false;
                    }
                }
            }});
            (new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmY5OWI1ODBkNDVhNzg0ZTdhOTY0ZTdkM2IxZjk3Y2VjZTc0OTExMTczYmQyMWMxZDdjNTZhY2RjMzg1ZWQ1In19fQ=="), "§3Fish Pet", new String[]{"§aAnimal (Peaceful)", "§7Favourite Food: Seeds", "", "§rGives you Fish over time..."}), "HOTBAR_PET_FISH", new ItemStack(Material.WHEAT_SEEDS), new ItemStack[]{new ItemStack(Material.IRON_INGOT), new ItemStack(Material.COD), new ItemStack(Material.IRON_INGOT), (new MaterialData(Material.COD, (byte)1)).toItemStack(1), new ItemStack(Material.DIAMOND), (new MaterialData(Material.COD, (byte)2)).toItemStack(1), new ItemStack(Material.WATER_BUCKET), SlimefunItems.GOLD_18K, new ItemStack(Material.WATER_BUCKET)})).register();
            (new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzg5NTdkNTAyM2M5MzdjNGM0MWFhMjQxMmQ0MzQxMGJkYTIzY2Y3OWE5ZjZhYjM2Yjc2ZmVmMmQ3YzQyOSJ9fX0="), "§4Magma Cube Pet", new String[]{"§cMob (Hostile)", "§7Favourite Food: Nether Quartz", "", "§rImmune to Lava", "§rQuite hungry"}), "HOTBAR_PET_MAGMA_CUBE", new ItemStack(Material.QUARTZ), new ItemStack[]{new ItemStack(Material.REDSTONE), new ItemStack(Material.MAGMA_CREAM), new ItemStack(Material.REDSTONE), new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.EMERALD), new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.NETHERRACK), SlimefunItems.GOLD_20K, new ItemStack(Material.NETHERRACK)})).register();
            (new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2RmNzRlMzIzZWQ0MTQzNjk2NWY1YzU3ZGRmMjgxNWQ1MzMyZmU5OTllNjhmYmI5ZDZjZjVjOGJkNDEzOWYifX19"), "§8Wither Pet", new String[]{"§4Boss Mob (Hostile)", "§7Favourite Food: Soul Sand", "", "§rImmune to Wither Effect"}), "HOTBAR_PET_WITHER", new ItemStack(Material.SOUL_SAND), new ItemStack[]{new ItemStack(Material.COAL), (new MaterialData(Material.WITHER_SKELETON_SKULL, (byte)1)).toItemStack(1), new ItemStack(Material.COAL), new ItemStack(Material.SOUL_SAND), new ItemStack(Material.NETHER_STAR), new ItemStack(Material.SOUL_SAND), new ItemStack(Material.SOUL_SAND), SlimefunItems.GOLD_24K, new ItemStack(Material.SOUL_SAND)})).register();
            (new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjI1MDViZTc3OTZiN2Q3OGE3MTdjM2U2NWVhNDJiZjIxMTQ0OWZkYjZkOTNmMmI0MDZhODhhYjcxYjcwIn19fQ=="), "§6Blaze Pet", new String[]{"§cMob (Hostile)", "§7Favourite Food: Nether Quartz", "", "§rImmune to Fire"}), "HOTBAR_PET_BLAZE", new ItemStack(Material.QUARTZ), new ItemStack[]{new ItemStack(Material.GLOWSTONE_DUST), new ItemStack(Material.BLAZE_ROD), new ItemStack(Material.GLOWSTONE_DUST), new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.EMERALD), new ItemStack(Material.BLAZE_POWDER), SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K})).register();
            final HotbarPet bed = new HotbarPet(new CustomItem(new MaterialData(Material.RED_BED), "§rBed Pet", new String[]{"§aUtility (Peaceful)", "§7Favourite Food: Wool", "", "§rRight-Click: §7Sleep"}), "HOTBAR_PET_BED", new ItemStack(Material.WHITE_WOOL), new ItemStack[]{new ItemStack(Material.IRON_INGOT), new ItemStack(Material.RED_BED), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.DIAMOND), new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.OAK_PLANKS), SlimefunItems.GOLD_14K, new ItemStack(Material.OAK_PLANKS)});
            bed.register(new ItemHandler[]{new ItemInteractionHandler() {
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, bed.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(bed.getFavouriteFood(), 1)) {
                            p.sendMessage("§9Your §rBed Pet §9would have helped you if you did not neglect it by not feeding it :(");
                        } else {
                            p.getInventory().removeItem(new ItemStack[]{bed.getFavouriteFood()});
                            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 2));
                            p.getWorld().setTime(0L);
                        }

                        return true;
                    } else {
                        return false;
                    }
                }
            }});
            final HotbarPet enderchest = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTZjYzQ4NmMyYmUxY2I5ZGZjYjJlNTNkZDlhM2U5YTg4M2JmYWRiMjdjYjk1NmYxODk2ZDYwMmI0MDY3In19fQ=="), "§5Ender Chest Pet", new String[]{"§aUtility (Peaceful)", "§7Favourite Food: Ender Pearls", "", "§rRight-Click: §7Open"}), "HOTBAR_PET_ENDER_CHEST", new ItemStack(Material.ENDER_PEARL), new ItemStack[]{new ItemStack(Material.OBSIDIAN), new ItemStack(Material.ENDER_EYE), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.EMERALD), new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.OBSIDIAN), SlimefunItems.GOLD_16K, new ItemStack(Material.OBSIDIAN)});
            enderchest.register(new ItemHandler[]{new ItemInteractionHandler() {
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, enderchest.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(enderchest.getFavouriteFood(), 1)) {
                            p.sendMessage("§9Your §5Ender Chest Pet §9would have helped you if you did not neglect it by not feeding it :(");
                        } else {
                            p.getInventory().removeItem(new ItemStack[]{enderchest.getFavouriteFood()});
                            p.openInventory(p.getEnderChest());
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 2.0F);
                        }

                        return true;
                    } else {
                        return false;
                    }
                }
            }});
            final HotbarPet Workbench = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGFkODgxZDY4NTQ3MTYxYWE3YjI5MjVlMzgzNzc4NzU2YmM2N2E3NWI0NDRhNTg2ZTUxNTk1M2VmODNhOSJ9fX0="), "§6Workbench Pet", new String[]{"§aUtility (Peaceful)", "§7Favourite Food: Wooden Planks", "", "§rRight-Click: §7Open"}), "HOTBAR_PET_Workbench", new ItemStack(Material.OAK_PLANKS), new ItemStack[]{new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.CRAFTING_TABLE), new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.OAK_PLANKS), SlimefunItems.GOLD_16K, new ItemStack(Material.OAK_PLANKS)});
            Workbench.register(new ItemHandler[]{new ItemInteractionHandler() {
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, Workbench.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(Workbench.getFavouriteFood(), 1)) {
                            p.sendMessage("§9Your §6Workbench Pet §9would have helped you if you did not neglect it by not feeding it :(");
                        } else {
                            p.getInventory().removeItem(new ItemStack[]{Workbench.getFavouriteFood()});
                            p.openWorkbench(p.getLocation(), true);
                            p.getWorld().playSound(p.getLocation(), Sound.BLOCK_WOODEN_BUTTON_CLICK_ON, 1.0F, 2.0F);
                        }

                        return true;
                    } else {
                        return false;
                    }
                }
            }});
            (new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTZhZDIwZmMyZDU3OWJlMjUwZDNkYjY1OWM4MzJkYTJiNDc4YTczYTY5OGI3ZWExMGQxOGM5MTYyZTRkOWI1In19fQ=="), "§aSlime Pet", new String[]{"§eMob (Passive)", "§7Favourite Food: Glowstone Dust", "", "§rImmune to Fall Damage"}), "HOTBAR_PET_SLIME", new ItemStack(Material.GLOWSTONE_DUST), new ItemStack[]{new ItemStack(Material.SLIME_BALL), new ItemStack(Material.DIAMOND), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.EMERALD), new ItemStack(Material.SLIME_BALL), SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K})).register();
            this.loadSpecialGuests();
            this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
                public void run() {
                    Iterator var2 = Bukkit.getOnlinePlayers().iterator();

                    while(var2.hasNext()) {
                        Player p = (Player)var2.next();

                        for(int i = 0; i < 9; ++i) {
                            ItemStack item = p.getInventory().getItem(i);
                            HotbarPet pet = (HotbarPet)SlimefunItem.getByName("HOTBAR_PET_CHICKEN");
                            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                    p.sendMessage("§9Your §rChicken Pet §9would have helped you if you did not neglect it by not feeding it :(");
                                } else {
                                    p.getInventory().removeItem(new ItemStack[]{pet.getFavouriteFood()});
                                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.EGG)});
                                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1.0F, 2.0F);
                                }
                            }

                            pet = (HotbarPet)SlimefunItem.getByName("HOTBAR_PET_MOOSHROOM");
                            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                    p.sendMessage("§9Your §dMooshroom Pet §9would have helped you if you did not neglect it by not feeding it :(");
                                } else {
                                    p.getInventory().removeItem(new ItemStack[]{pet.getFavouriteFood()});
                                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.BEETROOT_SOUP)});
                                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_COW_AMBIENT, 1.0F, 2.0F);
                                }
                            }

                            pet = (HotbarPet)SlimefunItem.getByName("HOTBAR_PET_FISH");
                            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                    p.sendMessage("§9Your §3Fish Pet §9would have helped you if you did not neglect it by not feeding it :(");
                                } else {
                                    p.getInventory().removeItem(new ItemStack[]{pet.getFavouriteFood()});
                                    p.getInventory().addItem(new ItemStack[]{(new MaterialData(Material.COOKED_COD, (byte)CSCoreLib.randomizer().nextInt(3))).toItemStack(1)});
                                    p.getWorld().playSound(p.getLocation(), Sound.BLOCK_WATER_AMBIENT, 1.0F, 2.0F);
                                }
                            }
                        }
                    }

                }
            }, 0L, 2000L);
        } catch (Exception var11) {
            var11.printStackTrace();
        }

    }

    private void loadSpecialGuests() throws Exception {
        final HotbarPet purplicious_cow = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2UxZmM2M2QzMDNlYjVmMzY2YWVjYWU2ZDI1MGQ0ZTJkNzc5YTlmNWVmOGRlYWZmNWIzYmM5NTMwN2ZmOSJ9fX0="), "§5Purplicious Cow Pet", new String[]{"§9Special", "§7Favourite Food: Golden Apples", "", "§rRight-Click: §7Gives you Health Regeneration"}), "HOTBAR_PET_PURPLICIOUS_COW", new ItemStack(Material.GOLDEN_APPLE), new ItemStack[]{new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND), SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K});
        purplicious_cow.register(new ItemHandler[]{new ItemInteractionHandler() {
            public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                if (SlimefunManager.isItemSimiliar(item, purplicious_cow.getItem(), true)) {
                    if (!p.getInventory().containsAtLeast(purplicious_cow.getFavouriteFood(), 1)) {
                        p.sendMessage("§9Your §5Purplicious Cow Pet §9would have helped you if you did not neglect it by not feeding it :(");
                    } else {
                        p.getInventory().removeItem(new ItemStack[]{purplicious_cow.getFavouriteFood()});
                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 160, 2));
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_COW_AMBIENT, 1.0F, 2.0F);
                    }

                    return true;
                } else {
                    return false;
                }
            }
        }});
        final HotbarPet cookie_slime = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTY3MDlkODdlODVkMTUzYmI4ODNhMjNhNWE4ODNlZTQ0ZGRiMjg0ZDUzMThiNzgwYTE2ZTgyYTlkYWM2NTEifX19"), "§amrCookieSlime Pet", new String[]{"§9Special", "§7Favourite Food: Cookies", "", "§rImmune to Fall Damage", "§rRight-Click: §7Gives you Health Regeneration"}), "HOTBAR_PET_MRCOOKIESLIME", new ItemStack(Material.COOKIE), new ItemStack[]{new ItemStack(Material.COOKIE), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKIE), new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND), SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K});
        cookie_slime.register(new ItemHandler[]{new ItemInteractionHandler() {
            public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                if (SlimefunManager.isItemSimiliar(item, cookie_slime.getItem(), true)) {
                    if (!p.getInventory().containsAtLeast(cookie_slime.getFavouriteFood(), 1)) {
                        p.sendMessage("§9Your §amrCookieSlime Pet §9would have helped you if you did not neglect it by not feeding it :(");
                    } else {
                        p.getInventory().removeItem(new ItemStack[]{cookie_slime.getFavouriteFood()});
                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 160, 2));
                        p.getWorld().playSound(p.getLocation(), Sound.BLOCK_SLIME_BLOCK_STEP, 1.0F, 2.0F);
                    }

                    return true;
                } else {
                    return false;
                }
            }
        }});
        (new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzk2NmYwZWJkNzdmMWJjZDY1NmZhMmRjM2VmMDMwM2UyNmE2YTNkZTQ5OGMzOTk5ZDM5ZmRjYWNjNWY1YWQifX19"), "§bWalshrus Pet", new String[]{"§9Special", "§7Favourite Food: Raw Cod", "", "§rCannot drown"}), "HOTBAR_PET_WALSHRUS", new ItemStack(Material.COD), new ItemStack[]{new ItemStack(Material.COD), new ItemStack(Material.DIAMOND), new ItemStack(Material.COD), new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND), SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K})).register();
        (new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTg0NzRmN2E2YzEzOWYxY2NkNzM1YTQ2NzdjMDQ1M2M0YmVmZWRmYzg5ZmVkYTQ5ZWE4ODZlYjE4ZGRmNmNkZiJ9fX0="), "§4Eyamaz Pet", new String[]{"§9Special", "§7Favourite Food: Souls", "", "§rBeware! Eyamaz makes a Soul Pie", "§rout of the Souls of everything you kill"}), "HOTBAR_PET_EYAMAZ", new ItemStack(Material.SOUL_SAND), new ItemStack[]{new ItemStack(Material.SOUL_SAND), new ItemStack(Material.DIAMOND), new ItemStack(Material.SOUL_SAND), new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND), SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K})).register();
    }

    @EventHandler(
        priority = EventPriority.LOWEST,
        ignoreCancelled = true
    )
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

        for(int i = 0; i < 9; ++i) {
            ItemStack item = p.getInventory().getItem(i);
            final HotbarPet pet = (HotbarPet)SlimefunItem.getByName("HOTBAR_PET_PIG");
            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                    p.sendMessage("§9Your §5Pig Pet §9would have helped you if you did not neglect it by not feeding it :(");
                    return;
                }

                this.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                    public void run() {
                        p.getInventory().removeItem(new ItemStack[]{pet.getFavouriteFood()});
                        p.setSaturation(p.getSaturation() + 8.0F);
                        p.removePotionEffect(PotionEffectType.POISON);
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PIG_AMBIENT, 1.0F, 2.0F);
                    }
                }, 2L);
            }
        }

    }

    @EventHandler
    public void onSoulHarvest(EntityDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player) {
            Player p = e.getEntity().getKiller();

            for(int i = 0; i < 9; ++i) {
                ItemStack item = p.getInventory().getItem(i);
                HotbarPet pet = (HotbarPet)SlimefunItem.getByName("HOTBAR_PET_EYAMAZ");
                if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                    e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), new CustomItem(new ItemStack(Material.PUMPKIN_PIE), "§bSoul Pie"));
                }
            }
        }

    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player)e.getEntity();

            for(int i = 0; i < 9; ++i) {
                ItemStack item = p.getInventory().getItem(i);
                HotbarPet pet;
                if (e.getCause() != DamageCause.ENTITY_EXPLOSION && e.getCause() != DamageCause.BLOCK_EXPLOSION) {
                    if (e.getCause() == DamageCause.LAVA) {
                        pet = (HotbarPet)SlimefunItem.getByName("HOTBAR_PET_MAGMA_CUBE");
                        if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                            if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                p.sendMessage("§9Your §4Magma Cube Pet §9would have helped you if you did not neglect it by not feeding it :(");
                                return;
                            }

                            if (CSCoreLib.randomizer().nextInt(100) < 30) {
                                p.getInventory().removeItem(new ItemStack[]{pet.getFavouriteFood()});
                            }

                            e.setCancelled(true);
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_MAGMA_CUBE_JUMP, 1.0F, 2.0F);
                        }
                    } else if (e.getCause() != DamageCause.FIRE && e.getCause() != DamageCause.FIRE_TICK) {
                        if (e.getCause() == DamageCause.FALL) {
                            pet = (HotbarPet)SlimefunItem.getByName("HOTBAR_PET_SLIME");
                            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                    p.sendMessage("§9Your §aSlime Pet §9would have helped you if you did not neglect it by not feeding it :(");
                                    return;
                                }

                                p.getInventory().removeItem(new ItemStack[]{pet.getFavouriteFood()});
                                e.setCancelled(true);
                                p.getWorld().playSound(p.getLocation(), Sound.BLOCK_SLIME_BLOCK_STEP, 1.0F, 2.0F);
                            }

                            pet = (HotbarPet)SlimefunItem.getByName("HOTBAR_PET_MRCOOKIESLIME");
                            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                    p.sendMessage("§9Your §amrCookieSlime Pet §9would have helped you if you did not neglect it by not feeding it :(");
                                    return;
                                }

                                p.getInventory().removeItem(new ItemStack[]{pet.getFavouriteFood()});
                                e.setCancelled(true);
                                p.getWorld().playSound(p.getLocation(), Sound.BLOCK_SLIME_BLOCK_STEP, 1.0F, 2.0F);
                            }
                        } else if (e.getCause() == DamageCause.WITHER) {
                            pet = (HotbarPet)SlimefunItem.getByName("HOTBAR_PET_WITHER");
                            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                    p.sendMessage("§9Your §8Wither Pet §9would have helped you if you did not neglect it by not feeding it :(");
                                    return;
                                }

                                p.getInventory().removeItem(new ItemStack[]{pet.getFavouriteFood()});
                                e.setCancelled(true);
                                p.removePotionEffect(PotionEffectType.WITHER);
                                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_WITHER_AMBIENT, 1.0F, 2.0F);
                            }
                        } else if (e.getCause() == DamageCause.DROWNING) {
                            pet = (HotbarPet)SlimefunItem.getByName("HOTBAR_PET_WALSHRUS");
                            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                    p.sendMessage("§9Your §bWalshrus Pet §9would have helped you if you did not neglect it by not feeding it :(");
                                    return;
                                }

                                p.getInventory().removeItem(new ItemStack[]{pet.getFavouriteFood()});
                                e.setCancelled(true);
                            }
                        }
                    } else {
                        pet = (HotbarPet)SlimefunItem.getByName("HOTBAR_PET_BLAZE");
                        if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                            if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                p.sendMessage("§9Your §6Blaze Pet §9would have helped you if you did not neglect it by not feeding it :(");
                                return;
                            }

                            p.getInventory().removeItem(new ItemStack[]{pet.getFavouriteFood()});
                            e.setCancelled(true);
                            p.setFireTicks(0);
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_BLAZE_AMBIENT, 1.0F, 2.0F);
                        }
                    }
                } else {
                    pet = (HotbarPet)SlimefunItem.getByName("HOTBAR_PET_CREEPER");
                    if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                            p.sendMessage("§9Your §2Creeper Pet §9would have helped you if you did not neglect it by not feeding it :(");
                            return;
                        }

                        p.getInventory().removeItem(new ItemStack[]{pet.getFavouriteFood()});
                        e.setCancelled(true);
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1.0F, 2.0F);
                    }
                }
            }

        }
    }
}