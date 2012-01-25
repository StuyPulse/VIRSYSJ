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

    public static void run(RobotBase bot, Channels channel){
        CRIO.channel = channel;
        CRIO.client = new Client();

        bot.startCompetition();

	//client.end();
	//System.out.println("ended client");
    }
}
