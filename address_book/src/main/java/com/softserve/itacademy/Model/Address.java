package com.softserve.itacademy.Model;

import java.util.Objects;

public class Address implements Comparable<Address> {

    private final int id;
    private String firstName;
    private String lastName;
    private String address;

    private int counter = 1;

    public Address() {
        this.id = counter++;
    }

    public Address(String firstName, String lastName, String address) {
        this.id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public int compareTo(Address address) {
        int result;
        if ((result = this.firstName.compareTo(address.firstName)) == 0)
            result = this.lastName.compareTo(address.lastName);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address that = (Address) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", counter=" + counter +
                '}';
    }


}
