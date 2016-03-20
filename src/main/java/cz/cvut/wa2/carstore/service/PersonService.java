package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.Person;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public interface PersonService {

    Person findPerson(long id);

    Person findPersonWithOrdersPhonesAndAddresses(long id);

    void persistPerson(Person person);

    void mergePerson(Person person);

    void deletePerson(long id);

}
