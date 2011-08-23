package edu;

import edu.wpi.first.wpilibj.*;

public class Test {

    Client c;
    final int wheelradius = 3;

    public Test() {
        c = new Client();
        c.startRecieveing();
    }

    public void translate(int x, int y) {
        boolean done = false;
        c.send(x / 2, y / 2, 0, 0, 0);
        while (!done) {
            if (c.getdata()[6] > x / 2 || c.getdata()[7] > y / 2) {
                c.send(0, 0, 0, 0, 0);
                done = true;
            }
        }
        Timer.delay(2);
        while (c.getdata()[6] > 0 || c.getdata()[7] > 0) {
            c.send(-x / 2, -y / 2, 0, 0, 0);
        }
    }

    public static void main(String[] arg) {
        //Test bah = new Test();
        //bah.translate(10, 10);
        Client c = new Client();
        c.startRecieveing();
        float[] f = new float[10];
        while (true) {
            f = c.getdata();
            if (f != null) {
                for (int i = 0; i < f.length; i++) {
                    System.out.print(f[i] + " ");
                }
                System.out.print("\n");
            }
            c.send(1000, 0, -100, 0, 0);
        }
    }
}
