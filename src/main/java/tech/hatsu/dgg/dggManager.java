package tech.hatsu.dgg;

import java.io.*;
import java.net.Socket;

public class dggManager {
    private static final String URL = "wss://chat.destiny.gg/ws";

    private static Socket dggclient;

    static {
        try {
            dggclient = new Socket(URL, 80);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static DataInputStream dataInputStream;

    static {
        try {
            dataInputStream = new DataInputStream(dggclient.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static DataOutputStream dataOutputStream;

    static {
        try {
            dataOutputStream = new DataOutputStream(dggclient.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    private PrintWriter out = new PrintWriter(dggclient.getOutputStream(), true);
//    private BufferedReader in = new BufferedReader(new InputStreamReader(dggclient.getInputStream()));
    private BufferedReader in = new BufferedReader(new InputStreamReader(dggclient.getInputStream()));

    public dggManager() throws IOException {
    }

//    private static final int PORT = "";

    public void startConnection() {
//        )
    }


    public static void main(String[] args) {
        String s = "";
        while (true) {
            in.readLine();
            s = dataInputStream.readUTF();
        }
    }
}
//    MSG {"nick":"Pyromaniac","features":["subscriber","flair13"],"timestamp":1668931872852,"data":"FeedNathan"}