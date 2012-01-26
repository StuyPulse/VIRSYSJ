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
    public static Channels channel;

    public static void init() {
        CRIO.client = new Client();
    }

    public static void end() {
        CRIO.client.end();
    }
    
    public static void setChannels(Channels channel) {
        CRIO.channel = channel;
    }
    
    public static void run(RobotBase bot, Channels channel){
        CRIO.init();
        setChannels(channel);
        bot.startCompetition();
	client.end();
    }
}
