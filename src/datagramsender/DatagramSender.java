/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datagramsender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Andreas
 */
public class DatagramSender {

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, InterruptedException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        String[] citatLista = new String[50];
        citatLista[0] = "Time flies like an arrow, fruit flies like a banana";
        citatLista[1] = ("Varför är det så mycket månad kvar vid slutet av pengarna?");
        citatLista[2] = ("Spara alltid en gång för mycket");
        citatLista[3] = ("Hide yo data, Hide yo IP");
        citatLista[4] = ("Zuckerberg sees all");
        
        InetAddress toAdr = InetAddress.getLocalHost();
        int toPort = 55555;
        DatagramSocket socket = new DatagramSocket();
        String message;
        System.out.println("Börjar sända citat");
        for (int i=0; i<=4; i++) {
            message = citatLista[i];
            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort);
            socket.send(packet);
            System.out.println("Citat skickat #"+(i+1));
            Thread.sleep(10000);
        }
        System.out.println("Slut på citat");
        System.exit(0);
                
    }
    
}
