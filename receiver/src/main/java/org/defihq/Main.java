package org.defihq;

import java.io.IOException;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]); // Port number to listen on

        try (DatagramSocket socket = new DatagramSocket(port)) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);

            String receivedMessage = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received message: " + receivedMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}