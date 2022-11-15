package tech.hatsu;

import tech.hatsu.discord.DiscordBotManager;
import tech.hatsu.discord.OrbiterManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Orbital {
    public static void main(String[] args) {
        // Load discord orbiter ids
        DiscordBotManager.loadOrbiters();

        // Keep updating current orbiters in voice channel
        OrbiterManager.start();

        SpringApplication.run(Orbital.class, args);
    }
}