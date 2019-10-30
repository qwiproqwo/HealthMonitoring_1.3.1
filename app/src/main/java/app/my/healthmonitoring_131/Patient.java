package app.my.healthmonitoring_131;

public class Patient {
    public String name;
    public int age;

    Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void setName (String name) {
        this.name = name;
    }
    void setAge (int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return String.format("Пациент: %s%nВозраст: %d.", name, age);
    }
}
