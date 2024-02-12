package ua.dymohlo.networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 8921;
    private static final int POOL_SIZE = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            Socket accept;
            try {
                accept = serverSocket.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            executorService.submit(() -> {
                handleConnection(accept);
            });

        }
    }

    private static void handleConnection(Socket accept) {
        try (accept;
             InputStream inputStream = accept.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
             OutputStream outputStream = accept.getOutputStream();
             Writer writer = new BufferedWriter(new OutputStreamWriter(outputStream));) {

            String response = reader.readLine();
            System.out.println(response);
            writer.write("response from server!\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
