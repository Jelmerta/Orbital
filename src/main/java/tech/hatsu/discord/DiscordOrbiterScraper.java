package tech.hatsu.discord;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import io.github.cdimascio.dotenv.Dotenv;

public class DiscordOrbiterScraper {
    private static Dotenv dotenv = Dotenv.load();
    public static final String DISCORD_USER = dotenv.get("username");
    public static final String DISCORD_PASSWORD = dotenv.get("password");
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
        executorService.scheduleAtFixedRate(updateOrbitersInDestinysRoomTask, 0, 30, TimeUnit.SECONDS);
    }

    private static String callDiscord() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ec2-user/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--headless"); // applicable to Windows os only
        options.addArguments("window-size=1920x1080");
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-blink-features=AutomationControlled");

        options.setBinary("/bin/google-chrome-stable");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // TODO Seems to be necessary for loading all data?

        // TODO Better logic when to log in...?
        login(driver);

        String destinysRoom = getDestinysRoom(driver);

        driver.quit();

        return destinysRoom;
    }

    private static String getDestinysRoom(WebDriver driver) throws InterruptedException {
        return getPageSource(driver);
    }

    private static String getPageSource(WebDriver driver) throws InterruptedException {
	System.out.println("Navigating to the discord");
        driver.get("https://discord.com/channels/265256381437706240/270578632026488851");
	System.out.println("Navigated to the discord");

        synchronized(driver) {
            driver.wait(5000);
        }
	System.out.println(driver.findElement(By.xpath("//*")));
	System.out.println(driver.getPageSource());

        //WebElement destinysRoom = driver.findElement(By.xpath("//*[@id=\"channels\"]/ul/li[@data-dnd-name=\"Destiny\'s Room\"]"));
	WebElement destinysRoom;
	try {
		destinysRoom = driver.findElement(By.xpath("//*[@id=\"channels\"]/ul/li[@data-dnd-name=\"General Lobby\"]"));
	} catch (Exception e) {
//		System.out.println(e);
		System.out.println(DISCORD_USER);
		System.out.println(DISCORD_PASSWORD);
		throw e;
	}
	System.out.println("The room");
	System.out.println(destinysRoom.getText());

        String outerHTML = destinysRoom.getAttribute("outerHTML");
        // Note: We also have access to the names with getText, but we probably prefer the ids.
	System.out.println();
	System.out.println(outerHTML);

        return outerHTML;
    }

    private static void login(WebDriver driver) throws InterruptedException {
	System.out.println("Logging in");
        driver.get("https://discord.com/login");
        synchronized(driver) {
            driver.wait(5300);
        }

        WebElement username = driver.findElement(By.name("email"));
        if (username == null) {
            System.out.println("No username field found! No need to log in");
            return;
        }
	System.out.println("Found email element");

        username.click();
        username.sendKeys(DISCORD_USER);

        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.sendKeys(DISCORD_PASSWORD);

	System.out.println("Password set");

        WebElement login = driver.findElement(By.className("button-1cRKG6"));
        System.out.println(login);
        login.click();

	System.out.println("Clicked login");

        synchronized(driver) {
            driver.wait(5000);
        }
    }

    private List<String> retrieveOrbitersInDestinysRoom() throws IOException, InterruptedException, URISyntaxException, ParserConfigurationException, SAXException, XPathExpressionException {
        String destinysRoom = callDiscord();
	System.out.println(destinysRoom);

        // Add the orbiter names based on the ids found in the voice channel
        Map<String, String> orbiters = DiscordOrbiterMapper.getOrbiters();
        List<String> orbiterNames = new ArrayList<>();
	System.out.println(orbiters.keySet());
        for (Map.Entry<String, String> orbiter : orbiters.entrySet()) {
            String orbiterId = orbiter.getKey();
            if (destinysRoom.contains(orbiterId)) {
                orbiterNames.add(DiscordOrbiterMapper.toNormalizedName(orbiter.getValue()));
            }
        }
        System.out.println("FOUND ORBITERS");
        System.out.println(orbiterNames);
        return orbiterNames;
    }

    public List<String> getCurrentOrbitersInRoom() {
        return currentOrbitersInRoom;
    }
}
