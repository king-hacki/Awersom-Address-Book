package com.softserve.itacademy.Model;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class AddressBookDto {

    List<Address> addressBook = new LinkedList<>();

    private static AddressBookDto addressBookDto = null;

    private AddressBookDto() {}

    public static AddressBookDto getInstance() {
        if (addressBookDto == null) {
            addressBookDto = new AddressBookDto();
            return addressBookDto;
        }
        return addressBookDto;
    }

    public boolean create(Address address) throws AlreadyExist {
        if (address == null) return false;
        if (addressBook.contains(address)) throw new AlreadyExist();
        return addressBook.add(address);
    }

    public Address read(String firstName, String lastName) throws NotSuchAddress {
        return addressBook.stream()
                .filter(a -> a.getFirstName().equals(firstName) && a.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(NotSuchAddress::new);
    }

    public boolean update(String firstName, String lastName, Address address) throws NotSuchAddress {
        int index = addressBook.indexOf(read(firstName, lastName));
        System.out.println(index);
        System.out.println(address);
        return addressBook.set(index, address) != null;
    }

    public boolean delete(String firstName, String lastName) throws NotSuchAddress {
        return addressBook.remove(read(firstName, lastName));
    }

    public List<Address> readAll() {
        return addressBook;
    }

    public void sortedBy(SortOrder order) {
        switch (order) {
            case ASC:
                addressBook.sort(Address::compareTo);
                break;
            case DESC:
                addressBook.sort(Comparator.reverseOrder());

        }
    }

}
