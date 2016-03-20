package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.Car;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public interface CarService {

    Car findCar(long id);

    Car findCarWithManufacturerAndOrders(long id);

    Car findCarByName(String name);

    List<Car> findCarsWithManufacturerAndOrders();

    void persistCar(Car car);

    void mergeCar(Car car);

    void deleteCar(long id);

}
