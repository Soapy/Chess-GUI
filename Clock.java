public class Clock {
    private int hour, minute, second;

    public Clock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public String getTime() {
        return String.format("%02d %02d %02d", hour, minute, second);
    }

    public void incrementTime() {
        if(second == 60) {
            minute++;
            if(minute == 60) {
                hour++;
            }
        }
    }

    public String toString() {
        return getTime();
    }
}
