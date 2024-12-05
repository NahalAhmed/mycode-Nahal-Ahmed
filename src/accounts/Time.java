package accounts;

public class Time {
    int hour;
    int minutes;

    public Time(String time) {
        String[] times = time.split(":");
        hour = Integer.parseInt(times[0]);
        minutes = Integer.parseInt(times[1]);
    }

    public Time(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    //TODO: This overrides the definition of the Object class
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Time other) {
            return this.hour == other.hour && this.minutes == other.minutes;
        }
        return false;
    }

    //TODO: This overrides the definition of the Object class
    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minutes);
    }
}
