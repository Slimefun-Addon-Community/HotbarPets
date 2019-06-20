package me.mrCookieSlime.HotbarPets;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.PluginUtils;
import me.mrCookieSlime.CSCoreLibPlugin.events.ItemUseEvent;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemInteractionHandler;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;

public class HotbarPets extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        try {
            this.getServer().getPluginManager().registerEvents(this, this);

            PluginUtils utils = new PluginUtils(this);
            utils.setupUpdater(95069, this.getFile());
            utils.setupMetrics();

            new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjIxNjY4ZWY3Y2I3OWRkOWMyMmNlM2QxZjNmNGNiNmUyNTU5ODkzYjZkZjRhNDY5NTE0ZTY2N2MxNmFhNCJ9fX0="), "&dPig Pet", new String[]{"&2Farm Animal (Peaceful)", "&7Favourite Food: Carrots", "", "&rBonus Saturation when eating", "&rAllows you to eat poisonous Food"}), "HOTBAR_PET_PIG", new ItemStack(Material.CARROT), new ItemStack[] {
                    new ItemStack(Material.REDSTONE), new ItemStack(Material.CARROT), new ItemStack(Material.REDSTONE),
                    new ItemStack(Material.PORKCHOP), new ItemStack(Material.DIAMOND), new ItemStack(Material.PORKCHOP),
                    new ItemStack(Material.REDSTONE), SlimefunItems.GOLD_16K, new ItemStack(Material.REDSTONE)
            }).register();

            new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTYzODQ2OWE1OTljZWVmNzIwNzUzNzYwMzI0OGE5YWIxMWZmNTkxZmQzNzhiZWE0NzM1YjM0NmE3ZmFlODkzIn19fQ=="), "&rChicken Pet", new String[]{"&2Farm Animal (Peaceful)", "&7Favourite Food: Seeds", "", "&rGives you Eggs over time..."}), "HOTBAR_PET_CHICKEN", new ItemStack(Material.WHEAT_SEEDS), new ItemStack[] {
                    new ItemStack(Material.REDSTONE), new ItemStack(Material.FEATHER), new ItemStack(Material.REDSTONE),
                    new ItemStack(Material.COOKED_CHICKEN), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKED_CHICKEN),
                    new ItemStack(Material.REDSTONE), SlimefunItems.GOLD_16K, new ItemStack(Material.REDSTONE)
            }).register();

            new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDBiYzYxYjk3NTdhN2I4M2UwM2NkMjUwN2EyMTU3OTEzYzJjZjAxNmU3YzA5NmE0ZDZjZjFmZTFiOGRiIn19fQ=="), "&dMooshroom Pet", new String[]{"&2Farm Animal (Peaceful)", "&7Favourite Food: Red Mushrooms", "", "&rGives you Beetroot Soup over time..."}), "HOTBAR_PET_MOOSHROOM", new ItemStack(Material.RED_MUSHROOM), new ItemStack[] {
                    new ItemStack(Material.LAPIS_LAZULI), new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.LAPIS_LAZULI),
                    new ItemStack(Material.RED_MUSHROOM), new ItemStack(Material.DIAMOND), new ItemStack(Material.BROWN_MUSHROOM),
                    new ItemStack(Material.LAPIS_LAZULI), SlimefunItems.GOLD_16K, new ItemStack(Material.LAPIS_LAZULI)
            }).register();

            final HotbarPet cow = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWQ2YzZlZGE5NDJmN2Y1ZjcxYzMxNjFjNzMwNmY0YWVkMzA3ZDgyODk1ZjlkMmIwN2FiNDUyNTcxOGVkYzUifX19"), "&6Cow Pet", new String[]{"&2Farm Animal (Peaceful)", "&7Favourite Food: Wheat", "", "&rRight-Click: &7Removes negative Potion Effects"}), "HOTBAR_PET_COW", new ItemStack(Material.WHEAT), new ItemStack[] {
                    new ItemStack(Material.COAL), new ItemStack(Material.WHEAT), new ItemStack(Material.COAL),
                    new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKED_BEEF),
                    new ItemStack(Material.COAL), SlimefunItems.GOLD_16K, new ItemStack(Material.COAL)
            });

            cow.register(new ItemInteractionHandler() {

                @Override
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, cow.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(cow.getFavouriteFood(), 1)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &6Cow Pet &9would have helped you if you did not neglect it by not feeding it :("));
                        }
                        else {
                            p.getInventory().removeItem(cow.getFavouriteFood());
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
                    }
                    else {
                        return false;
                    }
                }
            });

            final HotbarPet squid = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMDE0MzNiZTI0MjM2NmFmMTI2ZGE0MzRiODczNWRmMWViNWIzY2IyY2VkZTM5MTQ1OTc0ZTljNDgzNjA3YmFjIn19fQ=="), "&bSquid Pet", new String[]{"&aAnimal (Peaceful)", "&7Favourite Food: Raw Cod", "", "&rRight-Click: &7Gives you Water Breathing"}), "HOTBAR_PET_SQUID", new ItemStack(Material.COD), new ItemStack[] {
                    new ItemStack(Material.COAL), new ItemStack(Material.COD), new ItemStack(Material.COAL),
                    new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.DIAMOND), new ItemStack(Material.WATER_BUCKET),
                    new ItemStack(Material.COD), SlimefunItems.GOLD_16K, new ItemStack(Material.COD)
            });

            squid.register(new ItemInteractionHandler() {

                @Override
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, squid.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(squid.getFavouriteFood(), 1)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &bSquid Pet &9would have helped you if you did not neglect it by not feeding it :("));
                        }
                        else {
                            p.getInventory().removeItem(squid.getFavouriteFood());
                            p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1200, 2));
                        }
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            });

            final HotbarPet spider = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjdhNGMyNTZmMGRmNjE0MjMxZjhkNTUzNDRjOWRlMzkzODkzNjFhNzQwYzExZmFjYzBkMjk5ZjY3NmRkOWEifX19"), "&8Spider Pet", new String[]{"&cMob (Hostile)", "&7Favourite Food: Rotten Flesh", "", "&rRight-Click: &7Gives you Jump Boost"}), "HOTBAR_PET_SPIDER", new ItemStack(Material.ROTTEN_FLESH), new ItemStack[] {
                    new ItemStack(Material.COAL), new ItemStack(Material.STRING), new ItemStack(Material.COAL),
                    new ItemStack(Material.SPIDER_EYE), new ItemStack(Material.EMERALD), new ItemStack(Material.SPIDER_EYE),
                    new ItemStack(Material.STRING), SlimefunItems.GOLD_16K, new ItemStack(Material.STRING)
            });

            spider.register(new ItemInteractionHandler() {

                @Override
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, spider.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(spider.getFavouriteFood(), 1)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9Your &8Spider Pet &9would have helped you if you did not neglect it by not feeding it :("));
                        }
                        else {
                            p.getInventory().removeItem(spider.getFavouriteFood());
                            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200, 3));
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SPIDER_AMBIENT, 1.0F, 2.0F);
                        }
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            });

            final HotbarPet golem = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODkwOTFkNzllYTBmNTllZjdlZjk0ZDdiYmE2ZTVmMTdmMmY3ZDQ1NzJjNDRmOTBmNzZjNDgxOWE3MTQifX19"), "&7Iron Golem Pet", new String[]{"&eMob (Passive)", "&7Favourite Food: Iron Ingots", "", "&rRight-Click: &7Gives you Resistance"}), "HOTBAR_PET_IRON_GOLEM", new ItemStack(Material.IRON_INGOT), new ItemStack[] {
                    new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.PUMPKIN), new ItemStack(Material.IRON_BLOCK),
                    new ItemStack(Material.IRON_INGOT), new ItemStack(Material.EMERALD), new ItemStack(Material.IRON_INGOT),
                    new ItemStack(Material.IRON_INGOT), SlimefunItems.GOLD_16K, new ItemStack(Material.IRON_INGOT)
            });

            golem.register(new ItemInteractionHandler() {

                @Override
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, golem.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(golem.getFavouriteFood(), 1)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9Your &7Iron Golem Pet &9would have helped you if you did not neglect it by not feeding it :("));
                        }
                        else {
                            p.getInventory().removeItem(golem.getFavouriteFood());
                            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 500, 0));
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_IRON_GOLEM_STEP, 1.0F, 2.0F);
                        }
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            });

            final HotbarPet ghast = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGI2YTcyMTM4ZDY5ZmJiZDJmZWEzZmEyNTFjYWJkODcxNTJlNGYxYzk3ZTVmOTg2YmY2ODU1NzFkYjNjYzAifX19"), "&rGhast Pet", new String[]{"&cMob (Hostile)", "&7Favourite Food: Fire Charge", "", "&rRight-Click: &7Launches Fireballs"}), "HOTBAR_PET_GHAST", new ItemStack(Material.FIRE_CHARGE), new ItemStack[] {
                    new ItemStack(Material.GHAST_TEAR), new ItemStack(Material.DIAMOND), new ItemStack(Material.GHAST_TEAR),
                    new ItemStack(Material.QUARTZ_BLOCK), new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.QUARTZ_BLOCK),
                    SlimefunItems.GOLD_24K, new ItemStack(Material.TNT), SlimefunItems.GOLD_24K
            });

            ghast.register(new ItemInteractionHandler() {

                @Override
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, ghast.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(ghast.getFavouriteFood(), 1)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7Your &rGhast Pet &7would have helped you if you did not neglect it by not giving it food!"));
                        }
                        else {
                            p.getInventory().removeItem(ghast.getFavouriteFood());
                            p.launchProjectile(Fireball.class);
                            p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 500, 1));
                        }
                        return true;

                    }
                    else {
                        return false;
                    }
                }
            });

            final HotbarPet shulker = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjFkMzUzNGQyMWZlODQ5OTI2MmRlODdhZmZiZWFjNGQyNWZmZGUzNWM4YmRjYTA2OWU2MWUxNzg3ZmYyZiJ9fX0=="), "&dShulker Pet", new String[]{"&cMob (Hostile)", "&7Favourite Food: Chorus Fruit", "", "&rRight-Click: &7Shoots arrows tipped with levitation"}), "HOTBAR_PET_SHULKER", new ItemStack(Material.CHORUS_FRUIT), new ItemStack[] {
                    new ItemStack(Material.NETHER_WART), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.NETHER_WART),
                    new ItemStack(Material.QUARTZ), new ItemStack(Material.GLOWSTONE_DUST), new ItemStack(Material.QUARTZ),
                    new ItemStack(Material.FEATHER), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.FEATHER)
            });

            shulker.register(new ItemInteractionHandler() {
                @Override
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, shulker.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(shulker.getFavouriteFood(), 1)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Your &dShulker Pet &7would have helped you if you did not neglect it by not giving it food!"));
                        } else {
                            p.getInventory().removeItem(shulker.getFavouriteFood());

                            p.launchProjectile(TippedArrow.class).addCustomEffect(new PotionEffect(PotionEffectType.LEVITATION, 10 ,0), true);

                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SHULKER_AMBIENT, 1.0F, 2.0F);
                        }
                        return true;

                    }
                    else {
                        return false;
                    }
                }
            });

            final HotbarPet phantom = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDBiOTE4OWMzNzEzZjBkYWNhYzliMmJiNjA2NTA5MGM1MmIwYzkwZjEwODIwOGUwYTg2YmU1ODg1ZTk5NTc5YSJ9fX0="), "&7Phantom Pet", new String[]{"&cMob (Hostile)", "&7Favourite Food: Beetroot", "", "&rRight-Click: &7Gives Slow Falling"}), "HOTBAR_PET_PHANTOM", new ItemStack(Material.BEETROOT), new ItemStack[]{
                    new ItemStack(Material.PHANTOM_MEMBRANE), new ItemStack(Material.RABBIT_FOOT), new ItemStack(Material.PHANTOM_MEMBRANE),
                    new ItemStack(Material.DIAMOND), SlimefunItems.GOLD_6K, new ItemStack(Material.DIAMOND),
                    new ItemStack(Material.PHANTOM_MEMBRANE), new ItemStack(Material.RABBIT_FOOT), new ItemStack(Material.PHANTOM_MEMBRANE)
            });

            phantom.register(new ItemInteractionHandler() {
                @Override
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, phantom.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(phantom.getFavouriteFood(), 1)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Your &8Phantom Pet &7would have helped you if you did not neglect it by not giving it food!"));
                        } else {
                            p.getInventory().removeItem(phantom.getFavouriteFood());
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 250, 0));
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PHANTOM_AMBIENT, 1.0F, 2.0F);
                        }
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            });

            final HotbarPet enderman = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2E1OWJiMGE3YTMyOTY1YjNkOTBkOGVhZmE4OTlkMTgzNWY0MjQ1MDllYWRkNGU2YjcwOWFkYTUwYjljZiJ9fX0="), "&8Enderman Pet", new String[]{"&cMob (Hostile)", "&7Favourite Food: End Stone", "", "&rRight-Click: &7Shoots an Ender Pearl"}), "HOTBAR_PET_ENDER_MAN", new ItemStack(Material.END_STONE), new ItemStack[] {
                    new ItemStack(Material.OBSIDIAN), new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.OBSIDIAN),
                    new ItemStack(Material.ENDER_EYE), new ItemStack(Material.EMERALD), new ItemStack(Material.ENDER_EYE),
                    new ItemStack(Material.ENDER_PEARL), SlimefunItems.GOLD_16K, new ItemStack(Material.ENDER_PEARL)
            });

            enderman.register(new ItemInteractionHandler() {

                @Override
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, enderman.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(enderman.getFavouriteFood(), 1)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9Your &8Enderman Pet &9would have helped you if you did not neglect it by not feeding it :("));
                        }
                        else {
                            p.getInventory().removeItem(enderman.getFavouriteFood());
                            p.launchProjectile(EnderPearl.class);
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_AMBIENT, 1.0F, 2.0F);
                        }
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            });

            final HotbarPet creeper = new HotbarPet(new CustomItem(Material.CREEPER_HEAD, "&2Creeper Pet", "&cMob (Hostile)", "&7Favourite Food: Gunpowder", "", "&rImmune to Explosions", "&rRight-Click: &7Explode"), "HOTBAR_PET_CREEPER", new ItemStack(Material.GUNPOWDER), new ItemStack[] {
                    new ItemStack(Material.DIAMOND), new ItemStack(Material.CREEPER_HEAD), new ItemStack(Material.DIAMOND),
                    new ItemStack(Material.GUNPOWDER), new ItemStack(Material.EMERALD), new ItemStack(Material.GUNPOWDER),
                    new ItemStack(Material.DIAMOND), SlimefunItems.GOLD_20K, new ItemStack(Material.DIAMOND)
            });

            creeper.register(new ItemInteractionHandler() {

                @Override
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, creeper.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(creeper.getFavouriteFood(), 1)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &2Creeper Pet &9would have helped you if you did not neglect it by not feeding it :("));
                        }
                        else {
                            p.getInventory().removeItem(new ItemStack[]{creeper.getFavouriteFood()});
                            TNTPrimed tnt = (TNTPrimed)p.getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT);
                            tnt.setFuseTicks(0);
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1.0F, 2.0F);
                        }
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            });

            new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmY5OWI1ODBkNDVhNzg0ZTdhOTY0ZTdkM2IxZjk3Y2VjZTc0OTExMTczYmQyMWMxZDdjNTZhY2RjMzg1ZWQ1In19fQ=="), "&3Fish Pet", new String[]{"&aAnimal (Peaceful)", "&7Favourite Food: Seeds", "", "&rGives you Fish over time..."}), "HOTBAR_PET_FISH", new ItemStack(Material.WHEAT_SEEDS), new ItemStack[] {
                    new ItemStack(Material.IRON_INGOT), new ItemStack(Material.COD), new ItemStack(Material.IRON_INGOT),
                    new ItemStack(Material.COD), new ItemStack(Material.DIAMOND), new ItemStack(Material.COD),
                    new ItemStack(Material.WATER_BUCKET), SlimefunItems.GOLD_18K, new ItemStack(Material.WATER_BUCKET)
            }).register();

            new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzg5NTdkNTAyM2M5MzdjNGM0MWFhMjQxMmQ0MzQxMGJkYTIzY2Y3OWE5ZjZhYjM2Yjc2ZmVmMmQ3YzQyOSJ9fX0="), "&4Magma Cube Pet", new String[]{"&cMob (Hostile)", "&7Favourite Food: Nether Quartz", "", "&rImmune to Lava", "&rQuite hungry"}), "HOTBAR_PET_MAGMA_CUBE", new ItemStack(Material.QUARTZ), new ItemStack[] {
                    new ItemStack(Material.REDSTONE), new ItemStack(Material.MAGMA_CREAM), new ItemStack(Material.REDSTONE),
                    new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.EMERALD), new ItemStack(Material.BLAZE_POWDER),
                    new ItemStack(Material.NETHERRACK), SlimefunItems.GOLD_20K, new ItemStack(Material.NETHERRACK)
            }).register();

            new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2RmNzRlMzIzZWQ0MTQzNjk2NWY1YzU3ZGRmMjgxNWQ1MzMyZmU5OTllNjhmYmI5ZDZjZjVjOGJkNDEzOWYifX19"), "&8Wither Pet", new String[]{"&4Boss Mob (Hostile)", "&7Favourite Food: Soul Sand", "", "&rImmune to Wither Effect"}), "HOTBAR_PET_WITHER", new ItemStack(Material.SOUL_SAND), new ItemStack[] {
                    new ItemStack(Material.COAL), new ItemStack(Material.WITHER_SKELETON_SKULL), new ItemStack(Material.COAL),
                    new ItemStack(Material.SOUL_SAND), new ItemStack(Material.NETHER_STAR), new ItemStack(Material.SOUL_SAND),
                    new ItemStack(Material.SOUL_SAND), SlimefunItems.GOLD_24K, new ItemStack(Material.SOUL_SAND)
            }).register();

            new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjI1MDViZTc3OTZiN2Q3OGE3MTdjM2U2NWVhNDJiZjIxMTQ0OWZkYjZkOTNmMmI0MDZhODhhYjcxYjcwIn19fQ=="), "&6Blaze Pet", new String[]{"&cMob (Hostile)", "&7Favourite Food: Nether Quartz", "", "&rImmune to Fire"}), "HOTBAR_PET_BLAZE", new ItemStack(Material.QUARTZ), new ItemStack[] {
                    new ItemStack(Material.GLOWSTONE_DUST), new ItemStack(Material.BLAZE_ROD), new ItemStack(Material.GLOWSTONE_DUST),
                    new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.EMERALD), new ItemStack(Material.BLAZE_POWDER),
                    SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
            }).register();

            final HotbarPet bed = new HotbarPet(new CustomItem(Material.RED_BED, "&rBed Pet", new String[]{"&aUtility (Peaceful)", "&7Favourite Food: Wool", "", "&rRight-Click: &7Sleep"}), "HOTBAR_PET_BED", new ItemStack(Material.WHITE_WOOL), new ItemStack[] {
                    new ItemStack(Material.IRON_INGOT), new ItemStack(Material.RED_BED), new ItemStack(Material.IRON_INGOT),
                    new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.DIAMOND), new ItemStack(Material.WHITE_WOOL),
                    new ItemStack(Material.OAK_PLANKS), SlimefunItems.GOLD_14K, new ItemStack(Material.OAK_PLANKS)
            });

            bed.register(new ItemInteractionHandler() {

                @Override
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, bed.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(bed.getFavouriteFood(), 1)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "\"&9Your &rBed Pet &9would have helped you if you did not neglect it by not feeding it :(\""));
                        }
                        else {
                            p.getInventory().removeItem(new ItemStack[]{bed.getFavouriteFood()});
                            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 2));
                            p.getWorld().setTime(0L);
                        }
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            });

            final HotbarPet enderchest = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTZjYzQ4NmMyYmUxY2I5ZGZjYjJlNTNkZDlhM2U5YTg4M2JmYWRiMjdjYjk1NmYxODk2ZDYwMmI0MDY3In19fQ=="), "&5Ender Chest Pet", new String[]{"&aUtility (Peaceful)", "&7Favourite Food: Ender Pearls", "", "&rRight-Click: &7Open"}), "HOTBAR_PET_ENDER_CHEST", new ItemStack(Material.ENDER_PEARL), new ItemStack[] {
                    new ItemStack(Material.OBSIDIAN), new ItemStack(Material.ENDER_EYE), new ItemStack(Material.OBSIDIAN),
                    new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.EMERALD), new ItemStack(Material.ENDER_PEARL),
                    new ItemStack(Material.OBSIDIAN), SlimefunItems.GOLD_16K, new ItemStack(Material.OBSIDIAN)
            });

            enderchest.register(new ItemInteractionHandler() {

                @Override
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, enderchest.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(enderchest.getFavouriteFood(), 1)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "\"&9Your &5Ender Chest Pet &9would have helped you if you did not neglect it by not feeding it :(\""));
                        }
                        else {
                            p.getInventory().removeItem(enderchest.getFavouriteFood());
                            p.openInventory(p.getEnderChest());
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 2.0F);
                        }
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            });

            final HotbarPet workbench = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGFkODgxZDY4NTQ3MTYxYWE3YjI5MjVlMzgzNzc4NzU2YmM2N2E3NWI0NDRhNTg2ZTUxNTk1M2VmODNhOSJ9fX0="), "&6Workbench Pet", new String[]{"&aUtility (Peaceful)", "&7Favourite Food: Wooden Planks", "", "&rRight-Click: &7Open"}), "HOTBAR_PET_WORKBENCH", new ItemStack(Material.OAK_PLANKS), new ItemStack[] {
                    new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.CRAFTING_TABLE), new ItemStack(Material.OAK_PLANKS),
                    new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.OAK_PLANKS),
                    new ItemStack(Material.OAK_PLANKS), SlimefunItems.GOLD_16K, new ItemStack(Material.OAK_PLANKS)
            });

            workbench.register(new ItemInteractionHandler() {

                @Override
                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                    if (SlimefunManager.isItemSimiliar(item, workbench.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(workbench.getFavouriteFood(), 1)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "\"&9Your &6Workbench Pet &9would have helped you if you did not neglect it by not feeding it :(\""));
                        }
                        else {
                            p.getInventory().removeItem(workbench.getFavouriteFood());
                            p.openWorkbench(p.getLocation(), true);
                            p.getWorld().playSound(p.getLocation(), Sound.BLOCK_WOODEN_BUTTON_CLICK_ON, 1.0F, 2.0F);
                        }
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            });

            new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTZhZDIwZmMyZDU3OWJlMjUwZDNkYjY1OWM4MzJkYTJiNDc4YTczYTY5OGI3ZWExMGQxOGM5MTYyZTRkOWI1In19fQ=="), "&aSlime Pet", new String[]{"&eMob (Passive)", "&7Favourite Food: Glowstone Dust", "", "&rImmune to Fall Damage"}), "HOTBAR_PET_SLIME", new ItemStack(Material.GLOWSTONE_DUST), new ItemStack[] {
                    new ItemStack(Material.SLIME_BALL), new ItemStack(Material.DIAMOND), new ItemStack(Material.SLIME_BALL),
                    new ItemStack(Material.SLIME_BALL), new ItemStack(Material.EMERALD), new ItemStack(Material.SLIME_BALL),
                    SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
            }).register();

            this.loadSpecialGuests();

            this.getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
                for (Player p: Bukkit.getOnlinePlayers()) {
                    for(int i = 0; i < 9; ++i) {
                        ItemStack item = p.getInventory().getItem(i);

                        if (item == null || item.getType() == null || item.getType().equals(Material.AIR)) continue;

                        HotbarPet pet = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_CHICKEN");
                        if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                            if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9Your &rChicken Pet &9would have helped you if you did not neglect it by not feeding it :("));
                            }
                            else {
                                p.getInventory().removeItem(pet.getFavouriteFood());
                                p.getInventory().addItem(new ItemStack(Material.EGG));
                                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1.0F, 2.0F);
                            }
                        }

                        pet = (HotbarPet)SlimefunItem.getByID("HOTBAR_PET_MOOSHROOM");
                        if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                            if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &dMooshroom Pet &9would have helped you if you did not neglect it by not feeding it :("));
                            }
                            else {
                                p.getInventory().removeItem(pet.getFavouriteFood());
                                p.getInventory().addItem(new ItemStack(Material.BEETROOT_SOUP));
                                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_COW_AMBIENT, 1.0F, 2.0F);
                            }
                        }

                        pet = (HotbarPet)SlimefunItem.getByID("HOTBAR_PET_FISH");
                        if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                            if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9Your &3Fish Pet &9would have helped you if you did not neglect it by not feeding it :("));
                            }
                            else {
                                p.getInventory().removeItem(pet.getFavouriteFood());
                                p.getInventory().addItem(new ItemStack(Material.COOKED_COD));
                                p.getWorld().playSound(p.getLocation(), Sound.BLOCK_WATER_AMBIENT, 1.0F, 2.0F);
                            }
                        }
                    }
                }
            }, 0L, 2000L);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadSpecialGuests() throws Exception {
        final HotbarPet purplicious_cow = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2UxZmM2M2QzMDNlYjVmMzY2YWVjYWU2ZDI1MGQ0ZTJkNzc5YTlmNWVmOGRlYWZmNWIzYmM5NTMwN2ZmOSJ9fX0="), "&5Purplicious Cow Pet", new String[]{"&9Special", "&7Favourite Food: Golden Apples", "", "&rRight-Click: &7Gives you Health Regeneration"}), "HOTBAR_PET_PURPLICIOUS_COW", new ItemStack(Material.GOLDEN_APPLE), new ItemStack[] {
                new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKED_BEEF),
                new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
                SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
        });

        purplicious_cow.register(new ItemInteractionHandler() {

            @Override
            public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                if (SlimefunManager.isItemSimiliar(item, purplicious_cow.getItem(), true)) {
                    if (!p.getInventory().containsAtLeast(purplicious_cow.getFavouriteFood(), 1)) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9Your &5Purplicious Cow Pet &9would have helped you if you did not neglect it by not feeding it :("));
                    }
                    else {
                        p.getInventory().removeItem(purplicious_cow.getFavouriteFood());
                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 160, 2));
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_COW_AMBIENT, 1.0F, 2.0F);
                    }
                    return true;
                }
                else {
                    return false;
                }
            }
        });

        final HotbarPet cookie_slime = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTY3MDlkODdlODVkMTUzYmI4ODNhMjNhNWE4ODNlZTQ0ZGRiMjg0ZDUzMThiNzgwYTE2ZTgyYTlkYWM2NTEifX19"), "&amrCookieSlime Pet", new String[]{"&9Special", "&7Favourite Food: Cookies", "", "&rImmune to Fall Damage", "&rRight-Click: &7Gives you Health Regeneration"}), "HOTBAR_PET_MRCOOKIESLIME", new ItemStack(Material.COOKIE), new ItemStack[] {
                new ItemStack(Material.COOKIE), new ItemStack(Material.DIAMOND), new ItemStack(Material.COOKIE),
                new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
                SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
        });

        cookie_slime.register(new ItemInteractionHandler() {

            @Override
            public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                if (SlimefunManager.isItemSimiliar(item, cookie_slime.getItem(), true)) {
                    if (!p.getInventory().containsAtLeast(cookie_slime.getFavouriteFood(), 1)) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9Your &amrCookieSlime Pet &9would have helped you if you did not neglect it by not feeding it :("));
                    }
                    else {
                        p.getInventory().removeItem(new ItemStack[]{cookie_slime.getFavouriteFood()});
                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 160, 2));
                        p.getWorld().playSound(p.getLocation(), Sound.BLOCK_SLIME_BLOCK_STEP, 1.0F, 2.0F);
                    }
                    return true;
                }
                else {
                    return false;
                }
            }
        });

        final HotbarPet patriot_pet = new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzhhNTY0NmM4NDczZTFiZjQ1NTEzYmU0ZTZlODY1NjA1MDY3MWI2NTEzM2MwMDQ4ZDQ4NGUxYmYwYjQ2Mjk1ZiJ9fX0="), "&5Patriot Pet", new String[]{"&9Special", "&7Favourite Food: Nether Wart", "", "&rGives Resistance, Regeneration, Strength, ","&rand Saturation"}), "HOTBAR_PET_PATRIOT", new ItemStack(Material.NETHER_WART), new ItemStack[] {
                new ItemStack(Material.REDSTONE), SlimefunItems.MAGIC_LUMP_1, new ItemStack(Material.REDSTONE),
                SlimefunItems.MAGIC_LUMP_1, SlimefunItems.RAW_CARBONADO, SlimefunItems.MAGIC_LUMP_1,
                SlimefunItems.GOLD_4K, new ItemStack(Material.REDSTONE), SlimefunItems.GOLD_4K
        });

        patriot_pet.register(new ItemInteractionHandler() {

            @Override
            public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item) {
                if (SlimefunManager.isItemSimiliar(item, patriot_pet.getItem(), true)) {
                    if (!p.getInventory().containsAtLeast(patriot_pet.getFavouriteFood(), 1)) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7Your &5Patriot Pet &7would have helped you if you didn't neglect it by not giving it food!"));
                    }
                    else {
                        p.getInventory().removeItem(patriot_pet.getFavouriteFood());
                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 600, 1));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600, 0));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 300, 1));
                    }
                    return true;

                }
                else {
                    return false;
                }
            }
        });

        new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzk2NmYwZWJkNzdmMWJjZDY1NmZhMmRjM2VmMDMwM2UyNmE2YTNkZTQ5OGMzOTk5ZDM5ZmRjYWNjNWY1YWQifX19"), "&bWalshrus Pet", new String[]{"&9Special", "&7Favourite Food: Raw Cod", "", "&rCannot drown"}), "HOTBAR_PET_WALSHRUS", new ItemStack(Material.COD), new ItemStack[] {
                new ItemStack(Material.COD), new ItemStack(Material.DIAMOND), new ItemStack(Material.COD),
                new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
                SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
        }).register();

        new HotbarPet(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTg0NzRmN2E2YzEzOWYxY2NkNzM1YTQ2NzdjMDQ1M2M0YmVmZWRmYzg5ZmVkYTQ5ZWE4ODZlYjE4ZGRmNmNkZiJ9fX0="), "&4Eyamaz Pet", new String[]{"&9Special", "&7Favourite Food: Souls", "", "&rBeware! Eyamaz makes a Soul Pie", "&rout of the Souls of everything you kill"}), "HOTBAR_PET_EYAMAZ", new ItemStack(Material.SOUL_SAND), new ItemStack[] {
                new ItemStack(Material.SOUL_SAND), new ItemStack(Material.DIAMOND), new ItemStack(Material.SOUL_SAND),
                new ItemStack(Material.DIAMOND), new ItemStack(Material.EMERALD), new ItemStack(Material.DIAMOND),
                SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
        }).register();

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

        for(int i = 0; i < 9; ++i) {
            ItemStack item = p.getInventory().getItem(i);
            final HotbarPet pet = (HotbarPet)SlimefunItem.getByID("HOTBAR_PET_PIG");
            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9Your &5Pig Pet &9would have helped you if you did not neglect it by not feeding it :("));
                    return;
                }

                this.getServer().getScheduler().scheduleSyncDelayedTask(this, () -> {
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

            for(int i = 0; i < 9; ++i) {
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
            Player p = (Player)e.getEntity();

            for(int i = 0; i < 9; ++i) {
                ItemStack item = p.getInventory().getItem(i);
                HotbarPet pet;

                if (e.getCause() != DamageCause.ENTITY_EXPLOSION && e.getCause() != DamageCause.BLOCK_EXPLOSION) {
                    if (e.getCause() == DamageCause.LAVA) {

                        pet = (HotbarPet) SlimefunItem.getByID("HOTBAR_PET_MAGMA_CUBE");
                        if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                            if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9Your &4Magma Cube Pet &9would have helped you if you did not neglect it by not feeding it :("));
                                return;
                            }

                            if (CSCoreLib.randomizer().nextInt(100) < 30) {
                                p.getInventory().removeItem(pet.getFavouriteFood());
                            }

                            e.setCancelled(true);
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_MAGMA_CUBE_JUMP, 1.0F, 2.0F);
                        }

                    }
                    else if (e.getCause() != DamageCause.FIRE && e.getCause() != DamageCause.FIRE_TICK) {
                        if (e.getCause() == DamageCause.FALL) {
                            pet = (HotbarPet)SlimefunItem.getByID("HOTBAR_PET_SLIME");
                            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9Your &aSlime Pet &9would have helped you if you did not neglect it by not feeding it :("));
                                    return;
                                }

                                p.getInventory().removeItem(pet.getFavouriteFood());
                                e.setCancelled(true);
                                p.getWorld().playSound(p.getLocation(), Sound.BLOCK_SLIME_BLOCK_STEP, 1.0F, 2.0F);
                            }

                            pet = (HotbarPet)SlimefunItem.getByID("HOTBAR_PET_MRCOOKIESLIME");
                            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9Your &amrCookieSlime Pet &9would have helped you if you did not neglect it by not feeding it :("));
                                    return;
                                }

                                p.getInventory().removeItem(pet.getFavouriteFood());
                                e.setCancelled(true);
                                p.getWorld().playSound(p.getLocation(), Sound.BLOCK_SLIME_BLOCK_STEP, 1.0F, 2.0F);
                            }

                        }
                        else if (e.getCause() == DamageCause.WITHER) {
                            pet = (HotbarPet)SlimefunItem.getByID("HOTBAR_PET_WITHER");
                            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9Your &8Wither Pet &9would have helped you if you did not neglect it by not feeding it :("));
                                    return;
                                }

                                p.getInventory().removeItem(pet.getFavouriteFood());
                                e.setCancelled(true);
                                p.removePotionEffect(PotionEffectType.WITHER);
                                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_WITHER_AMBIENT, 1.0F, 2.0F);
                            }

                        }
                        else if (e.getCause() == DamageCause.DROWNING) {
                            pet = (HotbarPet)SlimefunItem.getByID("HOTBAR_PET_WALSHRUS");
                            if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                                if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9Your &bWalshrus Pet &9would have helped you if you did not neglect it by not feeding it :("));
                                    return;
                                }

                                p.getInventory().removeItem(pet.getFavouriteFood());
                                e.setCancelled(true);
                            }
                        }

                    }
                    else {
                        pet = (HotbarPet)SlimefunItem.getByID("HOTBAR_PET_BLAZE");
                        if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                            if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9Your &6Blaze Pet &9would have helped you if you did not neglect it by not feeding it :("));
                                return;
                            }

                            p.getInventory().removeItem(pet.getFavouriteFood());
                            e.setCancelled(true);
                            p.setFireTicks(0);
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_BLAZE_AMBIENT, 1.0F, 2.0F);
                        }
                    }

                }
                else {
                    pet = (HotbarPet)SlimefunItem.getByID("HOTBAR_PET_CREEPER");
                    if (pet != null && SlimefunManager.isItemSimiliar(item, pet.getItem(), true)) {
                        if (!p.getInventory().containsAtLeast(pet.getFavouriteFood(), 1)) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9Your &2Creeper Pet &9would have helped you if you did not neglect it by not feeding it :("));
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
