/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package crio.hardware;
import edu.wpi.first.wpilibj.*;
import java.io.*;

/**
 *
 * @author Q
 */
public class CRIO {
    public static Client client;
    public static int[] virsysOutputMap;
    public static int[] virsysInputMap;
    public static boolean runWithPhysics = false;
    static Process proc;

    public static void init(boolean runWithPhysics, int[] virsysOutputMap, int[] virsysInputMap) throws IOException {
        if (runWithPhysics) {
            CRIO.runWithPhysics = runWithPhysics;
            File f = new File("../VIRSYSJ/VIRSYS_alpha");
            final String osName = System.getProperty("os.name").toLowerCase();
            if (osName.contains("linux")) {
                proc = Runtime.getRuntime().exec("./virsys", null, f);
            }
            else if (osName.contains("windows")) {
                proc = Runtime.getRuntime().exec("virsys.exe", null, f);
            }
            CRIO.client = new Client();
            CRIO.virsysOutputMap = virsysOutputMap;
            CRIO.virsysInputMap = virsysInputMap;
        }
    }

    public static void end() {
        if (CRIO.client != null) {
            CRIO.client.end();
        }
        if (proc != null) {
            proc.destroy();
        }
    }
    
    public static void run(RobotBase bot, int[] virsysOutputMap, int[] virsysInputMap) throws IOException {
        CRIO.init(true, virsysOutputMap, virsysInputMap);
        bot.startCompetition();
	client.end();
    }
}
