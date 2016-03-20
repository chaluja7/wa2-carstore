package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.Manufacturer;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public interface ManufacturerService {

    Manufacturer findManufacturer(long id);

    Manufacturer findManufacturerWithCarsAndSuppliers(long id);

    List<Manufacturer> findManufacturersWithSuppliers();

    void persistManufacturer(Manufacturer manufacturer);

    void mergeManufacturer(Manufacturer manufacturer);

    void deleteManufacturer(long id);

}
