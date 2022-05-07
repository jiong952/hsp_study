package com.zjh.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HomeWork02Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //读取用户指令
        System.out.println("请输入消息");
        Scanner scanner = new Scanner(System.in);
        String question = scanner.next();
        byte[] bytes = question.getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("10.33.223.237"),8888);
        datagramSocket.send(packet);
        //接收数据
        byte[] data = new byte[1024];
        packet = new DatagramPacket(data,data.length);
        datagramSocket.receive(packet);
        int length = packet.getLength();
        byte[] data1 = packet.getData();
        System.out.println(new String(data1,0,length));
        //退出
        datagramSocket.close();
    }
}
