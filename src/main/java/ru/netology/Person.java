package ru.netology;

import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age > 0;
    }

    public boolean hasAddress(){
        return !address.equals("");
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        this.age += 1;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder();
    }

    @Override
    public String toString() {
        return "name: " + name +
                " surname: " + surname +
                " age: " + age +
                " address: " + address;
    }

    @Override
    public int hashCode() {
        int nameHC = name == null ? 0 : name.hashCode();
        int surnameHC = surname == null ? nameHC : 31 * nameHC + surname.hashCode();
        int resultHC = age == 0 ? surnameHC : 31 * surnameHC + age;
        return address == null ? resultHC : 31 * resultHC + address.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return name == person.name
                && surname == person.surname
                && age == person.age
                && address == person.address;
    }
}
