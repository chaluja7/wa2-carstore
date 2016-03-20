package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.Address;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public interface AddressService {

    Address findAddress(long id);

    Address findAddressWithPerson(long id);

    List<Address> findAddressesWithPersons();

    List<Address> findAddressesByCity(String city);

    void persistAddress(Address address);

    void mergeAddress(Address address);

    void deleteAddress(long id);

}
