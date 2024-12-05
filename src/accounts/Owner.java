package accounts;

public class Owner {

    String  name;
    int     age;

    public Owner() {
    //TODO: Update defaults in each class
    }

    public Owner(String ownerData){
        String[] data   = ownerData.split(",");
        name            = data[0];
        age             = Integer.parseInt(data[1]);
    }

    public Owner(String name, int age) {
        this.name   = name;
        this.age    = age;
    }

    //TODO: This overrides the definition of the Object class
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Owner other) {
            return this.name.equals(other.name) && this.age == other.age;
        }
        return false;
    }

    //TODO: This overrides the definition of the Object class
    @Override
    public String toString() {
        return "";
    }

}
