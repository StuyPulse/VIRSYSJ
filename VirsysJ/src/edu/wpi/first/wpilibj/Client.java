/*file that sends input/output info to virsys in a specific order
refer to /doc/data_format.txt*/

package edu.wpi.first.wpilibj;
import java.io.*;
import java.net.*;

public class Client implements Networkconf {

    private Runnable sendThread, recieveThread;
    private Thread threadS, threadR;

    public Client() {
        sendThread = new Send();
        recieveThread = new Recieve();
        threadS = new Thread(sendThread);
        threadR = new Thread(recieveThread);
    }

    public void sendnrecieve() {
        threadS.start();
        threadR.start();
    }

    public class Send implements Runnable {

        boolean done;

        public void run() {
            done = false;
            while (true) {
                //what the thread will do when it's still running
                if (done) {
                    return;
                }
            }
        }
    }

    public class Recieve implements Runnable {

        boolean done;

        public void run() {
            done = false;
            while (true) {
                //what the thread will do when it's still running
                if (done) {
                    return;
                }
            }
        }
    }
}
