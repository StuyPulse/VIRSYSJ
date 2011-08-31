/*file that sends input/output info to virsys in a specific order
refer to /doc/data_format.txt*/
package edu.wpi.first.wpilibj;

import java.io.*;
import java.net.*;
import java.nio.*;

public class Client implements Networkconf {
    private Runnable recieveThread;
    private Thread  threadR;
    private Thread  threadS;
    private float[] receivedData;
    private float[] toSend;

    public Client() {
        recieveThread = new Recieve();
        threadR = new Thread(recieveThread);
        threadS = new Thread(new Send());
        toSend = new float[5];
        toSend[0] = toSend[1] = 600;
        receivedData = new float[10];
        threadR.start();
        threadS.start();
    }

    public float[] getdata() throws IOException{
        if(receivedData == null){
            throw new IOException("Recieve data null");
        }            
        return receivedData;
    }

    public void send(float left, float right, float arm, float wrist, float grip){
        send(new float[]{(float)Timer.getFPGATimestamp(),left,right,arm,wrist,grip});
    }

    private void send(float[] f) {
        try {
            if (f.length != 6) {
                System.out.print("error:need 6 floats in packet");
            } else {
                byte[] b = new byte[24];
                for (int i = 0; i < f.length; i++) {
                    byte[] test = float2arr(f[i]);
                    b[i * 4] = test[0];
                    b[i * 4 + 1] = test[1];
                    b[i * 4 + 2] = test[2];
                    b[i * 4 + 3] = test[3];
                }
                DatagramPacket dp = new DatagramPacket(b, b.length, InetAddress.getByName(Virsys_IP), VIRSYS_RECV_PORT);
                DatagramSocket sender = new DatagramSocket();
                sender.send(dp);
                sender.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    private float[] recieve() {
        float[] ans = new float[10];
        try {
            byte[] buffer = new byte[40];
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
            DatagramSocket ds = new DatagramSocket(LOCAL_RECV_PORT);
            ds.receive(incoming);
            byte[] datas = incoming.getData();
            for (int i = 0; i < datas.length / 4; i++) {
                ans[i] = arr2float(new byte[]{datas[4 * i], datas[4 * i + 1], datas[4 * i + 2], datas[4 * i + 3]});
            }
            ds.close();
        } catch (IOException e) {
            System.err.println(e);
        }
        return ans;
    }

    private float arr2float(byte[] buf) {
        byte[] asdf = new byte[4];
        for (int i = 0; i < 4; i++) {
            asdf[i] = buf[3 - i];
        }
        ByteBuffer bb = ByteBuffer.allocate(4);
        bb.put(asdf);
        float value = bb.getFloat(0);
        return value;
    }

    private byte[] float2arr(float f) {
        int bits = Float.floatToIntBits(f);
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (bits & 0xff);
        bytes[1] = (byte) ((bits >> 8) & 0xff);
        bytes[2] = (byte) ((bits >> 16) & 0xff);
        bytes[3] = (byte) ((bits >> 24) & 0xff);
        return bytes;
    }
    private class Recieve implements Runnable {

        public boolean done;

        public void run() {
            done = false;
            while (!done) {
                receivedData = recieve();
            }
        }
    }

    private class Send implements Runnable {

        public void run() {
            while (true) {
                send(toSend[0], toSend[1], toSend[2], toSend[3], toSend[4]);
            }
        }
    }
}
