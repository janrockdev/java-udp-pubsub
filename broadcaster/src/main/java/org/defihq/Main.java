package org.defihq;

import java.io.IOException;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        String message = "Hello, receivers!";
        int[] ports = {8888, 8889, 8890};

        for (int port : ports) {
            Thread thread = new Thread(() -> {
                try (DatagramSocket socket = new DatagramSocket()) {
                    InetAddress broadcastAddress = InetAddress.getByName("255.255.255.255");

                    byte[] buffer = message.getBytes();
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, broadcastAddress, port);

                    socket.send(packet);

                    System.out.println("Message broadcasted to port " + port + " successfully.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            thread.start();
        }
    }
}

//public class UdpBroadcaster {
//    public static void main(String[] args) {
//        int port = 8888; // Port number to broadcast to
//        String message = "Hello, receivers!";
//
//        String[] addresses = {"192.168.0.255", "192.168.1.255", "192.168.2.255"}; // Example addresses
//
//        for (String address : addresses) {
//            Thread thread = new Thread(() -> {
//                try (DatagramSocket socket = new DatagramSocket()) {
//                    InetAddress broadcastAddress = InetAddress.getByName(address);
//
//                    byte[] buffer = message.getBytes();
//                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, broadcastAddress, port);
//
//                    socket.send(packet);
//
//                    System.out.println("Message broadcasted to " + broadcastAddress.getHostAddress());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//
//            thread.start();
//        }
//    }
//}