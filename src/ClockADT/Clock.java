package ClockADT;

/**
 * Clock data type. Write a data type Clock.java that
 * represents time on a 24-hour clock, such as 00:00, 13:30, or
 * 23:59. Time is measured in hours (00–23) and minutes (00–59).
 * To do so, implement the following public API:
 *
 * @author Siva Sankar
 */

public class Clock {
    String time;
    // Creates a clock whose initial time is h hrs and m min.
    /**
     * The parameterised constructor will instantiates the object with the values of
     * the parameters h and m to the respective hrs nad min.
     * @param h
     * @param m
     */
    public Clock(int h, int m) {
        String hrs = ""+h+"", mins = ""+m+"";
        if (h < 10)
            hrs = "0"+hrs;
        if (m < 10)
            mins = "0"+mins;
        time = hrs+":"+mins;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.

    public Clock(String s) {
        time = s;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return time;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        return time.compareTo(that.toString()) < 0;
    }

    private void check() {

    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        int minutes = Integer.parseInt(time.substring(time.indexOf(":")+1));
        if (minutes == 59){
            int hrs = Integer.parseInt(time.substring(0,time.indexOf(":")));
            if (hrs == 23){
                time = "00:00";
            }
            else{
                if (hrs < 10)
                    time = "0"+(hrs+1)+":"+"00";
                else
                    time = ""+(hrs+1)+":"+"00";
            }
        }
        else{
            if (minutes < 9){
                time = time.substring(0, time.indexOf(":") + 1) +"0"+(minutes + 1);
            }
            else {
                time = time.substring(0, time.indexOf(":") + 1) + (minutes + 1);
            }
        }
    }

    // Adds Δ min to the time on this clock.
    public void toc(int delta) {
        if (delta > 0) {
            int hours = delta / 60;
            int minutes = delta % 60;
            hours = (hours + Integer.parseInt(time.substring(0, time.indexOf(":")))) % 24;
            minutes = (minutes + Integer.parseInt(time.substring(time.indexOf(":") + 1))) % 60;
            if (minutes == 0 && Integer.parseInt(time.substring(time.indexOf(":") + 1)) != 0) {
                if (hours == 23)
                    hours = 0;
                else
                    hours++;
            }
            time = hours + ":" + minutes;
            if (hours < 10)
                time = "0" + hours + ":" + minutes;
            if (minutes < 10)
                time = time.substring(0, time.indexOf(":")) + ":" + "0" + minutes;
        }
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock clock = new Clock("00:00");
        clock.toc(120);
        //clock.tic();
        System.out.println(clock);
    }
}
