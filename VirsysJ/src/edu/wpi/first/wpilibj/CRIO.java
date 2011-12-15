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
    }

}
