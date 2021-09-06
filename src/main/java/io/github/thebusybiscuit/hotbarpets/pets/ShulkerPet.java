package io.github.thebusybiscuit.hotbarpets.pets;

import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.hotbarpets.SimpleBasePet;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

public class ShulkerPet extends SimpleBasePet {

    private final HotbarPets plugin;

    public ShulkerPet(HotbarPets plugin, SlimefunItemStack item, ItemStack food, ItemStack[] recipe) {
        super(plugin.getItemGroup(), item, food, recipe);

        this.plugin = plugin;
    }

    @Override
    public void onUseItem(Player p) {
        Arrow arrow = p.launchProjectile(Arrow.class);
        arrow.addCustomEffect(new PotionEffect(PotionEffectType.LEVITATION, 10, 0), true);
        arrow.setMetadata("hotbarpets_projectile", new FixedMetadataValue(plugin, true));

        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SHULKER_AMBIENT, 1.0F, 2.0F);
    }

}
