package ua.dymohlo.networking;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private static final int PORT = 8921;

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Writer writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            writer.write("Hello!\n");
            writer.flush();

            String response = reader.readLine();
            System.out.println(response);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
