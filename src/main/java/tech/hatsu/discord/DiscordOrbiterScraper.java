package tech.hatsu.discord;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class DiscordOrbiterScraper {
    public static final String BOT_TOKEN = "BOT_TOKEN_HERE";

    private static List<String> currentOrbitersInRoom = new ArrayList<>();

    public DiscordOrbiterScraper() {
        DiscordOrbiterMapper.loadOrbiters();
        start();
    }

    private void start() {
        Runnable updateOrbitersInDestinysRoomTask = () -> {
            System.out.println("Executing orbiter update task");
            try {
                currentOrbitersInRoom = retrieveOrbitersInDestinysRoom();
            } catch (IOException | InterruptedException | URISyntaxException | ParserConfigurationException |
                     SAXException | XPathExpressionException e) {
                System.err.println("Unexpected error: " + e);
                throw new RuntimeException(e);
            }
            System.out.println("Done executing orbiter task");
        };

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(updateOrbitersInDestinysRoomTask, 0, 5, TimeUnit.SECONDS);
    }

//    public static void main(String[] args) {
//        String webpage = callDiscord();
//        System.out.println(webpage);
//    }

    private static String callDiscord() {
        return "";
    }

    private List<String> retrieveOrbitersInDestinysRoom() throws IOException, InterruptedException, URISyntaxException, ParserConfigurationException, SAXException, XPathExpressionException {
        String body = callDiscord();

        // Map to HTML (some lovely java redirection)
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(body);
        ByteArrayInputStream input =  new ByteArrayInputStream(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(input);

        // Find the HTML element with destiny's voice channel
        XPath xPath = XPathFactory.newInstance().newXPath();
        String destinysRoomExpression = "//*[@id=\"channels\"]/ul/li[@data-dnd-name=\"Destiny\\'s Room\"]";
        String destinysRoom = xPath.compile(destinysRoomExpression).evaluate(document);

        // Add the orbiter names based on the ids found in the voice channel
        Map<String, String> orbiters = DiscordOrbiterMapper.getOrbiters();
        List<String> orbiterNames = new ArrayList<>();
        for (Map.Entry<String, String> orbiter : orbiters.entrySet()) {
            String orbiterId = orbiter.getKey();
            if (destinysRoom.contains(orbiterId)) {
                orbiterNames.add(DiscordOrbiterMapper.toNormalizedName(orbiter.getValue()));
            }
        }

        return orbiterNames;
    }

    public List<String> getCurrentOrbitersInRoom() {
        return currentOrbitersInRoom;
    }
}
