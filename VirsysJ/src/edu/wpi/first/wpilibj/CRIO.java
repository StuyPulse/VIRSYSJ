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

    public static void main(String[] arg){
        Test YourBot = new Test();
        //please Replace SimpleRobot with the name of your class
        if(YourBot.getClass().getName() == "SimpleRobot"){
            System.out.println("please modify CRIO.java to comstruct your bot");
        }else{
            YourBot.startCompetition();
        }
    }

}
