
public class Exercise10_01_Braithwaite {
//Declares a class, MyTime with hour, minute, second, and elapsed parameters
    public class MyTime {
        private int hour;
        private int minute;
        private int second;
        private long elapsed;
//No-arg constructor that sets the current time to milliseconds.
        public MyTime(){
            this.elapsed = System.currentTimeMillis();
        }
//Regular constructor that takes the current hour, minute, and second
        public MyTime(int hour, int minute, int second){
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
//Constructor that converts the the current UTC time.
        public MyTime(long  elapsedTime){
            this.hour = (int) ((elapsedTime / (1000 * 60 * 60)) % 24);
            this.minute = (int) (elapsedTime / 1000 / 60) % 60;
            this.second = (int) (elapsedTime / 1000) % 60;
        }
//Getters for hour, minute, second, respectively.
        public int getHour(){ return hour; }
        public int getMinute(){ return minute; }
        public int getSecond(){ return second; }
    }
//Main method testing each constructor with proper parameters.
    public static void main(String[] args){
        MyTime aMilliTime = new Exercise10_01_Braithwaite().new MyTime();
        System.out.println("The current time in milliseconds is: " + aMilliTime.elapsed);
        MyTime hourMinSec = new Exercise10_01_Braithwaite().new MyTime(5, 23, 55);
        System.out.println("The time is: " + hourMinSec.getHour() + ":" + hourMinSec.getMinute() + ":" + hourMinSec.getSecond());
        MyTime timeElapsed = new Exercise10_01_Braithwaite().new MyTime(System.currentTimeMillis());
        System.out.println("The elapsed time is: " + timeElapsed.hour + ":" + timeElapsed.minute + ":" + timeElapsed.second);
    }
}