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
            System.out.print("Default StartCompetition method... Overload me!");
        }
    }
    public class Watchdog{
        boolean enabled;
        long begining,interval;
        public Watchdog(){
            enabled = true;
            begining = System.currentTimeMillis();
            interval = 5000;
        }
        public void feed(){
            begining = System.currentTimeMillis();
        }
        public boolean getEnabled(){
            return enabled;
        }
        public double getExpiration(){
            return interval;
        }
        public double getTimer(){
            return System.currentTimeMillis() - begining;
        }
        public boolean isAlive(){
            return System.currentTimeMillis() < begining + interval;
        }
        public void kill(){
            setEnabled(false);
            setExpiration(1000000000);
        }
        public void setEnabled(boolean enables){
            enabled = enables;
        }
        public void setExpiration(double expiration){
            interval = (long)expiration;
        }
    }
}