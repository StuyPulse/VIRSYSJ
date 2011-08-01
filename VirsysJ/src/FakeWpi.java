/* this is imported if the code is not on the real robot*/
/*TODO:make Jaguar,Victor,Encoder and Gyro class*/
public class FakeWpi implements Channels{
    public class RobotBase{
        public RobotBase(){

        }
        public boolean isSystemActive(){
            return true;
        }
        public Watchdog getWatchdog(){
            return new Watchdog();
        }
        public boolean isEnabled(){
            return true;
        }
        public boolean isDisabled(){
            return false;
        }
        public boolean isAutonomous(){
            return false;
        }
        public boolean isOperatorControlled(){
            return true;
        }
        public boolean isNewDataAvailable(){
            return false;
        }
        public void startCompetition(){

        }
    }
    public class SimpleRobot extends RobotBase{
        SimpleRobot(){
            System.out.print("Default Constructor... Overload me!");
        }
        public void disabled(){
            System.out.print("Default Disabled method... Overload me!");
        }
        public void autonomous(){
            System.out.print("Default Autonomous method... Overload me!");
        }
        public void operatorControl(){
            System.out.print("Default OperatorControl method... Overload me!");
        }
        public void startCompetition(){
            System.out.print("Default StartCompetition method... Overload me!");
        }
    }
    public class IterativeRobot extends RobotBase{
        private int waittime;
        private Timer time;
        IterativeRobot(){
            waittime = 1;
            time = new Timer();
            System.out.print("Default Constructor... Overload me!");
        }
        public void autonomousContinuous(){
            while(isAutonomous()){

            }
            System.out.print("Default autonomousContinuous()... Overload me!");
        }
        public void autonomousInit(){
            System.out.print("Default autonomousInit()... Overload me!");
        }
        public void autonomousPeriodic(){
            while(isAutonomous()){
                time.delay(waittime);
            }
            System.out.print("Default autonomousPeriodic()... Overload me!");
        }
        public void disabledContinuous(){
            while(isDisabled()){

            }
            System.out.print("Default diasbledContinuous()... Overload me!");
        }
        public void disabledInit(){
            System.out.print("Default diasbledInit()... Overload me!");
        }
        public void disabledPeriodic(){
            while(isDisabled()){
                time.delay(waittime);
            }
        }
        public void startCompetition(){
            System.out.print("Default startCompetition()... Overload me!");
        }
        public void teleopContinuous(){
            while(isOperatorControlled()){

            }
            System.out.print("Default teleopContinuous()... Overload me!");
        }
        public void teleopInit(){
            System.out.print("Default teleopInit()... Overload me!");
        }
        public void teleopPeriodic(){
            while(isOperatorControlled()){
                time.delay(waittime);
            }
        }
    }
    public class Watchdog{
        private boolean enabled;
        private double begining,interval;
        private Timer time;
        public Watchdog(){
            time = new Timer();
            enabled = true;
            begining = time.getFPGATimestamp();
            interval = 5;
        }
        public void feed(){
            begining = time.getFPGATimestamp();
        }
        public boolean getEnabled(){
            return enabled;
        }
        public double getExpiration(){
            return interval;
        }
        public double getTimer(){
            return time.getFPGATimestamp() - begining;
        }
        public boolean isAlive(){
            return time.getFPGATimestamp() < begining + interval;
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
    public class Timer{
        private long beggining;
        private double time;
        Timer(){
            
        }
        public void delay(double seconds){
            try{
                Thread.currentThread().sleep((int)seconds * 1000);
            }
            catch(InterruptedException e){
                System.out.print("you did sonething really bad!!");
            }
        }
        public double get(){
            return time;
        }
        public double getFPGATimestamp(){
            return System.currentTimeMillis()/1000;
        }
        public void reset(){
            time = 0;
        }
        public void start(){
            beggining = System.currentTimeMillis();
        }
        public void stop(){
            time = (System.currentTimeMillis() - beggining)/1000;
        }
    }
}