/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj;
import edu.*;

/**
 *
 * @author Q
 */
public class CRIO {
    public static Client client;

    public static void main(String[] arg){
        client = new Client();

        MyBot bot = new MyBot();
        //please Replace SimpleRobot with the name of your class
        if(bot.getClass().getName() == "SimpleRobot"){
            System.out.println("please modify CRIO.java to construct your bot");
        }else{
            bot.startCompetition();
        }

	client.end();
	System.out.println("ended client");
    }


    public static class DigitalSidecar {
	public static final int NUM_CHANNELS = 16;
        public static boolean[] register = new boolean[NUM_CHANNELS]; // store value for each channel
	public static boolean[] inputBits = new boolean[NUM_CHANNELS]; // inputBits[i] is true if the i'th channel is an input
    }
}
