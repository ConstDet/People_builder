package ru.netology;

public class PersonBuilder implements IPersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() {
        if (name == null || name.equals("")) {
            System.out.println("Незаполнено поле \"name\"");
            throw new IllegalStateException();
        }
        if (age <= 0) {
            System.out.println("Возраст не может быть равен нулю и быть отрицательным.");
            throw new IllegalArgumentException();
        }
        return new Person(name, surname, age, address);
    }
}
