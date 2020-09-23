package io.github.thebusybiscuit.hotbarpets;

import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.hotbarpets.groups.BossMobs;
import io.github.thebusybiscuit.hotbarpets.groups.FarmAnimals;
import io.github.thebusybiscuit.hotbarpets.groups.HostileMobs;
import io.github.thebusybiscuit.hotbarpets.groups.PassiveMobs;
import io.github.thebusybiscuit.hotbarpets.groups.PeacefulAnimals;
import io.github.thebusybiscuit.hotbarpets.groups.SpecialPets;
import io.github.thebusybiscuit.hotbarpets.groups.UtilityPets;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.bstats.bukkit.Metrics;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;

public class HotbarPets extends JavaPlugin implements Listener, SlimefunAddon {

    private Category category;

    @Override
    public void onEnable() {

        // Setting up bStats
        new Metrics(this, 4859);

        category = new Category(new NamespacedKey(this, "pets"), new CustomItem(SkullItem.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjIxNjY4ZWY3Y2I3OWRkOWMyMmNlM2QxZjNmNGNiNmUyNTU5ODkzYjZkZjRhNDY5NTE0ZTY2N2MxNmFhNCJ9fX0="), "&d背包寵物", "", "&a> 點擊開啟"));

        // Add all the Pets via their Group class
        new FarmAnimals(this);
        new PeacefulAnimals(this);
        new PassiveMobs(this);
        new HostileMobs(this);
        new BossMobs(this);
        new UtilityPets(this);
        new SpecialPets(this);

        SlimefunPlugin.getLocalization().setDefaultMessage("hotbarpets.neglected-pet", "&9你的 %pet% &9會幫助你如果您不忽視它和不餵食 :(");
        SlimefunPlugin.getLocalization().save();

        // Registering the Listener and Runnable
        new HotbarPetsListener(this);
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new HotbarPetsRunnable(), 0L, 2000L);
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/xMikux/HotbarPets/issues";
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }
}
