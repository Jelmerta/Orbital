package tech.hatsu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Orbital {
    public static void main(String[] args) {
        new OrbiterManager();
        SpringApplication.run(Orbital.class, args);
    }
}