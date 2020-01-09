package io.github.thebusybiscuit.hotbarpets;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.hotbarpets.groups.BossMobs;
import io.github.thebusybiscuit.hotbarpets.groups.FarmAnimals;
import io.github.thebusybiscuit.hotbarpets.groups.HostileMobs;
import io.github.thebusybiscuit.hotbarpets.groups.PassiveMobs;
import io.github.thebusybiscuit.hotbarpets.groups.PeacefulAnimals;
import io.github.thebusybiscuit.hotbarpets.groups.SpecialPets;
import io.github.thebusybiscuit.hotbarpets.groups.UtilityPets;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.Slimefun.SlimefunPlugin;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.bstats.bukkit.Metrics;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import me.mrCookieSlime.Slimefun.cscorelib2.updater.GitHubBuildsUpdater;
import me.mrCookieSlime.Slimefun.cscorelib2.updater.Updater;

public class HotbarPets extends JavaPlugin implements Listener {
	
	private Category category;

	@Override
	public void onEnable() {
		Config cfg = new Config(this);

		// Setting up bStats
		new Metrics(this);

		if (getDescription().getVersion().startsWith("DEV - ")) {
			Updater updater = new GitHubBuildsUpdater(this, getFile(), "TheBusyBiscuit/HotbarPets/master");
			
			// Only run the Updater if it has not been disabled
			if (cfg.getBoolean("options.auto-update")) updater.start();
		}
		
		category = new Category(new CustomItem(SkullItem.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjIxNjY4ZWY3Y2I3OWRkOWMyMmNlM2QxZjNmNGNiNmUyNTU5ODkzYjZkZjRhNDY5NTE0ZTY2N2MxNmFhNCJ9fX0="), "&dHotbar Pets", "", "&a> Click to open"));
		
		// Add all the Pets via their Group class
		new FarmAnimals(this);
		new PeacefulAnimals(this);
		new PassiveMobs(this);
		new HostileMobs(this);
		new BossMobs(this);
		new UtilityPets(this);
		new SpecialPets(this);
		
		SlimefunPlugin.getLocal().setDefaultMessage("hotbarpets.neglected-pet", "&9Your %pet% &9would have helped you if you did not neglect it by not feeding it :(");
		SlimefunPlugin.getLocal().save();
		
		// Registering the Listener and Runnable
		new HotbarPetsListener(this);
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new HotbarPetsRunnable(), 0L, 2000L);
	}

	public Category getCategory() {
		return category;
	}
}
