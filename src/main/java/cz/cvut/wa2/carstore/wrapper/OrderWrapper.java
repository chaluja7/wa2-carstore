package cz.cvut.wa2.carstore.wrapper;

import cz.cvut.wa2.carstore.entities.Order;

/**
 * @author jakubchalupa
 * @since 20.03.16
 */
public class OrderWrapper extends Order {

    private static final long serialVersionUID = 5926028500766275664L;

    private Long carId;

    private Long personId;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
