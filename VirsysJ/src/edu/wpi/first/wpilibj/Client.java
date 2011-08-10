/*file that sends input/output info to virsys in a specific order
refer to /doc/data_format.txt*/
package edu.wpi.first.wpilibj;

import java.io.*;
import java.net.*;

public class Client implements Networkconf {

    private Runnable sendThread, recieveThread;
    private Thread threadS, threadR;
    private Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    public Client() {
        sendThread = new Send();
        recieveThread = new Recieve();
        threadS = new Thread(sendThread);
        threadR = new Thread(recieveThread);
        try {
            socket = new Socket(VIRSYS_IP, VIRSYS_RECV_PORT);
        } catch (IOException ex) {
            System.out.println(" IOEXCEPTION" + ex.getMessage());
        }
    }

    public void sendnrecieve() {
        threadS.start();
        threadR.start();
    }

    public class Send implements Runnable {

        boolean done;

        public void run() {
            done = false;
            try {
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
            } catch (IOException ex) {
                System.out.println(" IOEXCEPTION" + ex.getMessage());
            }
            while (!done) {
                //what the thread will do when it's still running
            }
        }
    }

    public class Recieve implements Runnable {

        boolean done;

        public void run() {
            done = false;
            try {
                dataInputStream = new DataInputStream(socket.getInputStream());
            } catch (IOException ex) {
                System.out.println(" IOEXCEPTION" + ex.getMessage());
            }
            while (!done) {
                //what the thread will do when it's still running
            }
        }
    }
}
