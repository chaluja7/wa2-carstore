package cz.cvut.wa2.carstore.wrapper;

import cz.cvut.wa2.carstore.entities.Car;

/**
 * @author jakubchalupa
 * @since 20.03.16
 */
public class CarWrapper extends Car {

    private static final long serialVersionUID = -8321766452566916946L;

    public Long manufacturerId;

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

}
