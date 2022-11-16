package tech.hatsu.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class DiscordOrbiterUpdater {
    public static final String DESTINY_CHANNEL_ID = "265362793262350338"; // REAL CHANNEL
    public static final String BOT_TOKEN = "BOT_TOKEN_HERE";

//    public static final String BOT_TOKEN = "MTA0MDc0NDMzOTUzNTU4MTI3NQ.G7NuPU.JRV2kqp4bIy9Nb1OqzDw3LVDaf6hPJm8lAfxNE"; // TEST TOKEN
//    public static final String DESTINY_CHANNEL_ID = "1040711384037609567"; // TEST CHANNEL

    private static JDA jda;
    private static List<String> currentOrbitersInRoom = new ArrayList<>();

    static {
        try {
            jda = JDABuilder.createDefault(BOT_TOKEN)
                    .enableIntents(GatewayIntent.MESSAGE_CONTENT) // enables explicit access to message.getContentDisplay()
                    .build()
                    .awaitReady();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public DiscordOrbiterUpdater() {
        DiscordOrbiterMapper.loadOrbiters();
        start();
    }

    private void start() {
        // Or just for every voice state change? But we can't just listen for a single channel, have to listen all channels? Don't like an if-check for channel id...
        Runnable updateOrbitersInDestinysRoomTask = () -> {
            System.out.println("Executing orbiter update task");
            currentOrbitersInRoom = retrieveOrbitersInDestinysRoom(jda);
            System.out.println("Done executing orbiter task");
        };

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(updateOrbitersInDestinysRoomTask, 0, 5, TimeUnit.SECONDS);
    }

    private List<String> retrieveOrbitersInDestinysRoom(JDA jda) {
        VoiceChannel voiceChannelById = jda.getVoiceChannelById(DESTINY_CHANNEL_ID);

        List<Member> members = voiceChannelById.getMembers();
        return members.stream()
                .filter(DiscordOrbiterMapper::isOrbiter)
                .map(Member::getId)
                .map(DiscordOrbiterMapper::getOrbiterNormalizedName)
                .collect(Collectors.toList());
    }

    public List<String> getCurrentOrbitersInRoom() {
        return currentOrbitersInRoom;
    }
}
