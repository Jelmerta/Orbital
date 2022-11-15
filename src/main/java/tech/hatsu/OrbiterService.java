package tech.hatsu;

import tech.hatsu.discord.OrbiterManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrbiterService {
    @GetMapping("/orbiters/")
    public String orbiters() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(OrbiterManager.getCurrentOrbitersInRoom());
    }
}
