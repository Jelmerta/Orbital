package tech.hatsu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.hatsu.helper.OrbiterEvent;
import tech.hatsu.orbiter.OrbiterManager;

import java.util.List;

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

    @GetMapping("/orbiterevents/")
    public String orbiterEvents() throws JsonProcessingException {
        List<OrbiterEvent> orbiterEvents = Orbital.getOrbiterManager().getOrbiterEvents();
        return objectMapper.writeValueAsString(orbiterEvents);
    }
}
