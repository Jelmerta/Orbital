package tech.hatsu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.hatsu.dgg.DggChatManager;
import tech.hatsu.discord.DiscordChannelManager;
import tech.hatsu.orbiter.OrbiterManager;

@SpringBootApplication
public class Orbital {
    private static OrbiterManager orbiterManager;
    public static void main(String[] args) {
        orbiterManager = new OrbiterManager();

        new DggChatManager(orbiterManager);
        new DiscordChannelManager(orbiterManager);

        SpringApplication.run(Orbital.class, args);
    }

    public static OrbiterManager getOrbiterManager() {
        return orbiterManager;
    }
}