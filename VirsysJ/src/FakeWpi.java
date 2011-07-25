/* this is imported if the code is not on the real robot*/
public class FakeWpi implements Channels{
    public class RobotBase{
        public RobotBase(){

        }
        public boolean IsSystemActive(){
            return true;
        }
        public Watchdog GetWatchdog(){
            return new Watchdog();
        }
        public boolean IsEnabled(){
            return true;
        }
        public boolean IsDisabled(){
            return false;
        }
        public boolean IsAutonomous(){
            return false;
        }
        public boolean IsOperatorControlled(){
            return true;
        }
        public boolean IsNewDataAvailable(){
            return false;
        }
        public void startCompetition(){

        }
    }
    public class SimpleRobot extends RobotBase{
        SimpleRobot(){
            System.out.print("Default Constructor... Overload me!");
        }
        public void Disabled(){
            System.out.print("Default Disabled method... Overload me!");
        }
        public void Autonomous(){
            System.out.print("Default Autonomous method... Overload me!");
        }
        public void OperatorControl(){
            System.out.print("Default OperatorControl method... Overload me!");
        }
        public void StartCompetition(){
            
        }
    }
    public class Watchdog{
        public Watchdog(){

        }
    }
}