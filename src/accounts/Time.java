package accounts;

import java.util.Comparator;

public class Time implements Comparable<Time>{
    int hour;
    int minutes;

    public Time(){
        this.hour    = 0;
        this.minutes = 0;
    }

    public Time(String time) {
        String[] times = time.split(":");
        hour    = Integer.parseInt(times[0]);
        minutes = Integer.parseInt(times[1]);
    }

    public Time(int hour, int minutes) {
    this.hour        = hour;
        this.minutes = minutes;
    }

    @Override
    public int compareTo(Time other) {
        return Comparator.comparing((Time time) -> time.hour)
                         .thenComparing((Time time) -> time.minutes)
                         .compare(this, other);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Time other) {
            return this.hour == other.hour && this.minutes == other.minutes;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minutes);
    }

}
