package tech.hatsu.discord;

import net.dv8tion.jda.api.entities.Member;

import java.util.HashMap;
import java.util.Map;

public class DiscordOrbiterMapper {
    private static final Map<String, String> orbiters = new HashMap<>();

    public static void loadOrbiters() {
        System.out.println("Loading Discord orbiters");

        // NOT ORBITERS:
        // orbiters.put("265255911012958208", "Destiny"); // Could also be filtered frontend...

        // QUESTIONABLE
        orbiters.put("108940081313632256", "Lycan");
        orbiters.put("221480025025675265", "MrMouton");
        orbiters.put("202553539833233409", "Dan");
        orbiters.put("567269090306031618", "Melina");
        orbiters.put("471837338557874176", "RightToBearArmsLOL");

        // OUTSIDE ORBIT / OWN ORBIT / NEVER ON ? / BOT
        // orbiters.put("", "Kaceytron");
        // orbiters.put("", "SargonOfAkkad");
        // orbiters.put("", "Biden");
        orbiters.put("80866328507842560", "TriHex");
        // orbiters.put("", "Lex"); // DUPLICATE
        orbiters.put("580604479808864267", "Lex"); // Fridman
        // orbiters.put("", "Andy Milonakis");
        // orbiters.put("", "August");
        orbiters.put("107883526078095360", "Koibu");
        // orbiters.put("", "LilyPichu");
        orbiters.put("195980608822837249", "XQC");
        orbiters.put("532262143903531030", "TrainwrecksTV");
        // orbiters.put("", "The Saint and The Sinner");
        // orbiters.put("", "tng69"); // A BOT NO DISCORD ID

        // OTHER CONTENT
        // orbiters.put("", "DnD");

        // VISUALIZATION?
        // orbiters.put("", "Drama Index");
        // orbiters.put("", "DGG Chat (yes) vs YouTube Chat (no)");
        // orbiters.put("", "Current Caller"); <-- Pretty interesting and relevant. Should only be one person in call though? Do they get kicked then? Is next caller safe??? worth ideaing around
        // orbiters.put("", "OOOO vs MMMM");
        // orbiters.put("", "PEPE vs YEE");
        // orbiters.put("", "Drama Index"); DUPLICATE DUMMY

        // DUMB MARKET PROBABLY DUMBFUCK
        // orbiters.put("", "random Chud orbiter"); ????
        // orbiters.put("", "PepoTurkey");
        // orbiters.put("", "Evil Fossil");
        // orbiters.put("", "DGG/Destiny Orbiter Empire Stability"); ... maybe visualization
        // orbiters.put("", "OBAMNA");

        // BANNED FROM ORBIT (but still could join i suppose)
        // orbiters.put("", "MrGirl"); // Mrgirl#7211 ?
        orbiters.put("996489063848751124", "Lav");

        // ORBITERS:
        orbiters.put("887772050410831943", "LowTierGod");
        // orbiters.put("", "Ethan Ralph");
        // orbiters.put("", "Anastasiya");
        // orbiters.put("", "Zherka");
        // orbiters.put("", "TreeOfLogic");
        orbiters.put("637653870012530688", "ChudLogic");
        orbiters.put("176154478133772288", "Chaeiry");
        // orbiters.put("", "Nick Fuentes"); // Probably not this guy? 414462424566202369
        orbiters.put("408812056322637825", "RagePope");
        orbiters.put("566321753538953229", "Rosewrist");
        orbiters.put("135553285934415873", "Booksmarts");
        orbiters.put("527401780326432768", "JadeIsABoss");
        orbiters.put("132605254712819713", "Kelly Jean"); // Has two stocks
        orbiters.put("213145047363747842", "Ahrelevant");
        orbiters.put("267130156164841472", "Brittany Simon");
        orbiters.put("137349633679687680", "MindWaves");
        // orbiters.put("", "Myron"); // myron#4880 ?
        orbiters.put("810005623198449684", "JiDion");
        // orbiters.put("", "Politically Provoked Brittany");
        orbiters.put("240325507239903242", "Sondsol");
        orbiters.put("703190560575455276", "Aba");
        orbiters.put("268551296586481664", "Pxie");
        orbiters.put("141825821903028224", "4THOT");
        // orbiters.put("528813710353891369", "notsoErudite");
        orbiters.put("528813710353891369", "Erudite"); // NICE DUPLICATE!!!
        orbiters.put("981316730766917642", "Stardust");
        // orbiters.put("", "Anastasiya");
        orbiters.put("265560531450986497", "Dylan Burns");
        orbiters.put("185966850268463104", "Pisco");
        // orbiters.put("", "InvaderVie");
        orbiters.put("696191869507600436", "Straighterade");
        // orbiters.put("696191869507600436", "Erin"); // STRAIGHTERADE HAS THREE STOCKS ARE YOU OKAY BUDDY DELETE IF ONLY ONE IS USED
        orbiters.put("127629149559980033", "WickedSupreme");
        // orbiters.put("", "Sneako");
        orbiters.put("588523841517649921", "Boze");
        orbiters.put("112332482505912320", "VeganGains");
        orbiters.put("202947932100493312", "Rem"); // "Reading Kant" lol
        orbiters.put("406154268844752898", "imreallyimportant");
        orbiters.put("167152339617185792", "Darius");
        orbiters.put("1037525062288408647", "Annalicia"); // Not notable not sure
        orbiters.put("239219373871595520", "Econoboi");
        orbiters.put("884961422352715847", "Dooby");
        orbiters.put("104616715396087808", "esportsbatman");
        orbiters.put("252869311545212928", "Cake");

        System.out.println("Loaded Discord orbiters");
    }

    public static Map<String, String> getOrbiters() {
        return orbiters;
    }

    public static String toNormalizedName(String name) {
        return name.toLowerCase();
    }
}
