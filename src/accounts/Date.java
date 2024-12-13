package accounts;

import java.util.Comparator;
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

    @Override
    public int compareTo(Date other) {
        return Comparator.comparing((Date date) -> date.year)
                         .thenComparing((Date date) -> date.month)
                         .thenComparing((Date date) -> date.day)
                         .compare(this, other);
    }

    @Override
    public boolean equals(Object obj) {
        if( obj instanceof Date other) {
            return  Objects.equals(this.day, other.day)      &&
                    Objects.equals(this.month, other.month)  &&
                    Objects.equals(this.year, other.year);

        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%02d-%s-%02d", day, month, year);
    }

}
