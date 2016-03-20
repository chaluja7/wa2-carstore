package cz.cvut.wa2.carstore.wrapper;

import cz.cvut.wa2.carstore.entities.Address;

/**
 * @author jakubchalupa
 * @since 20.03.16
 */
public class AddressWrapper extends Address {

    private static final long serialVersionUID = 5492932128625230179L;

    public Long personId;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
