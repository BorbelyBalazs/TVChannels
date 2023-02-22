public class Consumers {

    private String name;
    private int age;
    private boolean hasSub;

    public Consumers(String line) {
        String[] data = line.split(";");
        this.name = data[0];
        this.age = Integer.parseInt(data[1]);
        this.hasSub = Boolean.parseBoolean(data[2]);
    }

    public Consumers() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isHasSub() {
        return hasSub;
    }

    @Override
    public String toString() {
        return name + "; " + age + "; " + hasSub + "\n";
    }
}
