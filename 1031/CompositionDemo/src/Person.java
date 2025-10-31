public class Person {

    private String name;
    private String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        //return "Name: " + name + ", ID: " + id;
        return  String.format("Name: %s, ID: %s", name, id);
    }
}
