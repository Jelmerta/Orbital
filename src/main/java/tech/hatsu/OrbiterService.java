package tech.hatsu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrbiterService {
    @GetMapping("/orbiters/")
    public String orbiters() throws JsonProcessingException {
        List<Orbiter> currentOrbitersInRoom = OrbiterManager.getCurrentOrbitersInRoom();
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(currentOrbitersInRoom);
        return objectMapper.writeValueAsString(currentOrbitersInRoom);
    }

    @GetMapping("/orbiterevents/")
    public String orbiterEvents() throws JsonProcessingException {
        List<OrbiterEvent> orbiterEvents = new ArrayList<>();
        for (OrbiterEventSource eventSource : orbiterEventSources) {
            orbiterEvents.addAll(eventSource.getOrbiterEvents());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(orbiterEvents);
    }
}
