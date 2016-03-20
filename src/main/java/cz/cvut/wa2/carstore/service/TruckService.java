package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.Truck;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public interface TruckService {

    Truck findTruck(long id);

    Truck findTruckWithManufacturerAndOrders(long id);

    void persistTruck(Truck truck);

    void mergeTruck(Truck truck);

    void deleteTruck(long id);

}
