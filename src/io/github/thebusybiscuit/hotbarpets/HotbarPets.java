package io.github.thebusybiscuit.hotbarpets;

import org.bstats.bukkit.Metrics;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.cscorelib2.updater.BukkitUpdater;
import io.github.thebusybiscuit.cscorelib2.updater.GitHubBuildsUpdater;
import io.github.thebusybiscuit.cscorelib2.updater.Updater;
import io.github.thebusybiscuit.hotbarpets.groups.Animals;
import io.github.thebusybiscuit.hotbarpets.groups.BossMobs;
import io.github.thebusybiscuit.hotbarpets.groups.FarmAnimals;
import io.github.thebusybiscuit.hotbarpets.groups.HostileMobs;
import io.github.thebusybiscuit.hotbarpets.groups.PassiveMobs;
import io.github.thebusybiscuit.hotbarpets.groups.SpecialPets;
import io.github.thebusybiscuit.hotbarpets.groups.UtilityPets;
import me.mrCookieSlime.CSCoreLibPlugin.PluginUtils;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;

public class HotbarPets extends JavaPlugin implements Listener {
	
    @Override
    public void onEnable() {
    	PluginUtils utils = new PluginUtils(this);
        utils.setupUpdater(95069, this.getFile());
        utils.setupConfig();
        Config cfg = utils.getConfig();
        
        // Setting up bStats
    	new Metrics(this);
     			
    	// Setting up the Auto-Updater
    	Updater updater;
     			
    	if (!getDescription().getVersion().startsWith("DEV - ")) {
				// We are using an official build, use the BukkitDev Updater
				updater = new BukkitUpdater(this, getFile(), 53485);
			}
			else {
				// If we are using a development build, we want to switch to our custom 
				updater = new GitHubBuildsUpdater(this, getFile(), "TheBusyBiscuit/Slimefun4/master");
			}
			
			if (cfg.getBoolean("options.auto-update")) updater.start();
        
        new HotbarPetsListener(this);

        try {
        	new FarmAnimals(this);
            new Animals(this);
            new PassiveMobs(this);
            new HostileMobs(this);
            new BossMobs(this);
            new UtilityPets(this);
            new SpecialPets(this);
        } catch (Exception x) {
        	x.printStackTrace();
        }

        getServer().getScheduler().scheduleSyncRepeatingTask(this, new HotbarPetsRunnable(), 0L, 2000L);
    }
}
