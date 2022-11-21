package tech.hatsu.dgg;


import java.util.HashMap;
import java.util.Map;

public class DggOrbiterMapper {

    private static Map<String, String> dggOrbiters = new HashMap<>();

    static {
        dggOrbiters.put("jelmer", "Sweatstiny"); // TODO JUST FOR TESTING NOW THIS IS SWEATSTINY ACCOUNT

        // NOT ORBITERS:
        // orbiters.put("265255911012958208", "Destiny"); // Could also be filtered frontend...

        // QUESTIONABLE
        dggOrbiters.put("lycan", "Lycan");
        dggOrbiters.put("mrmouton", "MrMouton");
        dggOrbiters.put("dancantstream", "Dan");
        dggOrbiters.put("melina", "Melina");
        dggOrbiters.put("righttobeararmslol", "RightToBearArmsLOL");

        // OUTSIDE ORBIT / OWN ORBIT / NEVER ON ? / BOT
        // orbiters.put("", "Kaceytron");
        // orbiters.put("", "SargonOfAkkad");
        // orbiters.put("", "Biden");
        dggOrbiters.put("trihex", "TriHex");
        // orbiters.put("", "Lex"); // DUPLICATE
//        dggOrbiters.put("580604479808864267", "Lex"); // Fridman could be "lex" just some messages in 2018
        dggOrbiters.put("andymilonakis", "Andy Milonakis");
        dggOrbiters.put("august", "August");
//        dggOrbiters.put("Koibu", "Koibu"); ?
        dggOrbiters.put("lilypichu", "LilyPichu");
//        dggOrbiters.put("195980608822837249", "XQC");
        dggOrbiters.put("trainwreckstv", "TrainwrecksTV");
        // orbiters.put("", "The Saint and The Sinner");
        dggOrbiters.put("tng69", "tng69"); // A BOT NO DISCORD ID

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
        dggOrbiters.put("lav", "Lav");

        // ORBITERS:
//        dggOrbiters.put("887772050410831943", "LowTierGod");
        // orbiters.put("", "Ethan Ralph");
        // orbiters.put("", "Anastasiya");
        // orbiters.put("", "Zherka");
        dggOrbiters.put("treeoflogic", "TreeOfLogic");
        dggOrbiters.put("chudlogic", "ChudLogic");
        dggOrbiters.put("chaeiry", "Chaeiry");
        // orbiters.put("", "Nick Fuentes"); // Probably not this guy? 414462424566202369
        dggOrbiters.put("ragepope", "RagePope");
        dggOrbiters.put("rosewrist", "Rosewrist");
        dggOrbiters.put("booksmarts", "Booksmarts");
        dggOrbiters.put("jadeisaboss", "JadeIsABoss");
        dggOrbiters.put("Kelly_Jean", "Kelly Jean"); // Has two stocks
        dggOrbiters.put("ahrelevant", "Ahrelevant");
//        dggOrbiters.put("267130156164841472", "Brittany Simon");
        dggOrbiters.put("mindwaves", "MindWaves");
        // orbiters.put("", "Myron"); // myron#4880 ?
//        dggOrbiters.put("810005623198449684", "JiDion");
        // orbiters.put("", "Politically Provoked Brittany");
        dggOrbiters.put("sondsol", "Sondsol");
//        dggOrbiters.put("703190560575455276", "Aba"); // yt andy...
        dggOrbiters.put("pxie", "Pxie");
        dggOrbiters.put("4thot", "4THOT");
        // orbiters.put("528813710353891369", "notsoErudite");
//        dggOrbiters.put("528813710353891369", "Erudite"); // NICE DUPLICATE!!!
        dggOrbiters.put("stardust", "Stardust");
        // orbiters.put("", "Anastasiya");
//        dggOrbiters.put("265560531450986497", "Dylan Burns");
        dggOrbiters.put("pisco95", "Pisco");
        // orbiters.put("", "InvaderVie");
        dggOrbiters.put("straighterade", "Straighterade");
        // orbiters.put("696191869507600436", "Erin"); // STRAIGHTERADE HAS THREE STOCKS ARE YOU OKAY BUDDY DELETE IF ONLY ONE IS USED
        dggOrbiters.put("wickedsupreme", "WickedSupreme");
        // orbiters.put("", "Sneako");
        dggOrbiters.put("bigbossboze", "Boze");
//        dggOrbiters.put("112332482505912320", "VeganGains");
        dggOrbiters.put("imremthebathboi ", "Rem"); // "Reading Kant" lol
        dggOrbiters.put("imreallyimportant", "imreallyimportant");
        dggOrbiters.put("darius", "Darius");
//        dggOrbiters.put("1037525062288408647", "Annalicia"); // Not notable not sure
        dggOrbiters.put("econoboi", "Econoboi");
        dggOrbiters.put("dooby", "Dooby");
        dggOrbiters.put("esportsbatman", "esportsbatman");
        dggOrbiters.put("cake", "Cake");
        dggOrbiters.put("gappyv", "GappyV");
        dggOrbiters.put("erisann", "ErisAnn");
    }

    public static boolean isOrbiter(String name) {
        return dggOrbiters.containsKey(name.toLowerCase());
    }
}
