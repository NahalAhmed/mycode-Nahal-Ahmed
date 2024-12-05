package accounts;

public enum Month {
    //Jan 12 2008 --> "12-Jan-08"
    JAN("Jan"),
    FEB("Feb"),
    MAR("Mar"),
    APR("Apr"),
    MAY("May"),
    JUN("Jun"),
    JUL("Jul"),
    AUG("Aug"),
    SEP("Sep"),
    OCT("Oct"),
    NOV("Nov"),
    DEC("Dec");

    final String value;

    Month(String value){
        this.value = value;
    }

    //TODO: This overrides the definition of the Object class
    @Override
    public String toString() {
        return value;
    }
}
