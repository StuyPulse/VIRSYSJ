/* this is imported if the code is not on the real robot*/
public class FakeWpi implements Channels{
    public class RobotBase{
        public RobotBase(){

        }
        public void IsSystemActive(){

        }
        public void GetWatchdog(){

        }
        public void IsEnabled(){

        }
        public void IsDisabled(){

        }
        public void IsAutonomous(){

        }
        public void IsOperatorControlled(){
            
        }
        public void IsNewDataAvailable(){

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
}