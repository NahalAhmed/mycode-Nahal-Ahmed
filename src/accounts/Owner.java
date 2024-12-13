package accounts;

public class Owner {

    private final String name;
    private final int age;

    // Default Constructor
    public Owner() {
        this.name = "";
        this.age = 0;
    }

    public Owner(String ownerData){
        String[] data = ownerData.split(",");
        name = data[0];
        age = Integer.parseInt(data[1]);

    }

    // Constructor with Name and Age
    public Owner(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Owner other) {
            return this.name.equals(other.name) && this.age == other.age;
        }
        return false;
    }

    //Add getters
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


    //TODO: This is for the Account class
    public String toFile(){
        return String.join(",", name, String.valueOf(age));
    }

    //TODO: This overrides the definition of the Object class
    @Override
    public String toString() {
        return String.format("\nName:\t%s\nAge:\t%d", name, age);
    }
}
