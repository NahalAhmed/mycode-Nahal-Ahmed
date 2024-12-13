package accounts;

import java.util.Objects;

public class Date implements Comparable<Date> {
    private final int     day;
    private final Month   month;
    private final int     year;

    public Date() {
        this.day    = 1;
        this.month  = Month.DEC;
        this.year   = 24;
    }

    public Date(String date) {
        String[] parts  = date.split("-");
        this.day        = Integer.parseInt(parts[0]);
        this.month      = Month.valueOf(parts[1].toUpperCase());
        this.year       = Integer.parseInt(parts[2]);
    }

    public Date(int day, Month month, int year) {
        this.day    = day;
        this.month  = month;
        this.year   = year;
    }

    //TODO: This overrides the definition of the Object class
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Date other) {
            return this.day == other.day                    &&
                   Objects.equals(this.month, other.month)  &&
                   this.year == other.year;
        }
        return false;
    }

    //TODO: This overrides the definition of the Object class
    @Override
    public String toString() {
        return String.format("%02d-%s-%02d", day, month, year);
    }

    @Override
    public int compareTo(Date o) {
        return 0;
    }
}
