package io.github.thebusybiscuit.hotbarpets.pets;

import io.github.thebusybiscuit.hotbarpets.SimpleBasePet;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CloudPet extends SimpleBasePet {

    public CloudPet(ItemGroup itemGroup, SlimefunItemStack item, ItemStack food, ItemStack[] recipe) {
        super(itemGroup, item, food, recipe);
    }

    @Override
    public void onUseItem(Player p) {
        p.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, p.getLocation(),1);
        p.getWorld().setClearWeatherDuration(6000);
    }

}