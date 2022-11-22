package tech.hatsu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.hatsu.helper.OrbiterEvent;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrbiterService {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/orbiters/")
    public String orbiters() throws JsonProcessingException {
//        List<Orbiter> currentOrbitersInRoom = OrbiterManager.getCurrentOrbitersInRoom();
//        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println(currentOrbitersInRoom);
//        return objectMapper.writeValueAsString(currentOrbitersInRoom);
        return "";
    }


    // TODO Instant serialization
    @GetMapping("/orbiterevents/")
    public String orbiterEvents() throws JsonProcessingException {
        List<OrbiterEvent> orbiterEvents = Orbital.getOrbiterManager().getOrbiterEvents().stream()
                .filter(this::keepEvent)
                .collect(Collectors.toList());

        return objectMapper.writeValueAsString(orbiterEvents);
    }

    private boolean keepEvent(OrbiterEvent orbiterEvent) {
        Instant now = Instant.now();
        Duration timeBetween = Duration.between(orbiterEvent.getTimestamp(), now);
        System.out.println(now.getEpochSecond());
        System.out.println(orbiterEvent.getTimestamp().getEpochSecond());
        System.out.println(timeBetween.getSeconds());

        if (orbiterEvent.getType() == OrbiterEvent.Type.DISCORD_CHANNEL_JOIN) {
            return false;
        }

        System.out.println(timeBetween.compareTo(Duration.ofMinutes(10)));
        if (timeBetween.compareTo(Duration.ofMinutes(10)) > 0) { // Longer than 10 minutes ago. Can probably remove...?
            return false;
        }

        return true;

        // Current people in channel // TODO Should we trust just the events? But what else should we trust
        // TODO Maybe just dgg chat here for now?
    }
}
