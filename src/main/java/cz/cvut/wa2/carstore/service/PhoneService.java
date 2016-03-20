package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.Phone;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public interface PhoneService {

    Phone findPhone(long id);

    Phone findPhoneWithPerson(long id);

    void persistPhone(Phone phone);

    void mergePhone(Phone phone);

    void deletePhone(long id);

}
