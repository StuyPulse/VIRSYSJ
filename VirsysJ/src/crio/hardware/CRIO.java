/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package crio.hardware;
import edu.wpi.first.wpilibj.*;
import utilities.Channels;

/**
 *
 * @author Q
 */
public class CRIO {
    public static Client client;
    public static int[] virsysOutputMap;
    public static int[] virsysInputMap;
    public static boolean runWithPhysics = false;

    public static void init(int[] virsysOutputMap, int[] virsysInputMap) {
        runWithPhysics = true;
        CRIO.client = new Client();
        CRIO.virsysOutputMap = virsysOutputMap;
        CRIO.virsysInputMap = virsysInputMap;
    }

    public static void end() {
        if (CRIO.client != null) {
            CRIO.client.end();
        }
    }
    
    public static void run(RobotBase bot, int[] virsysOutputMap, int[] virsysInputMap){
        CRIO.init(virsysOutputMap, virsysInputMap);
        bot.startCompetition();
	client.end();
    }
}
