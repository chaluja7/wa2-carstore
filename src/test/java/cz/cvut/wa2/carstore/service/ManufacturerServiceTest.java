package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public class ManufacturerServiceTest extends AbstractServiceTest {

    @Autowired
    protected ManufacturerService manufacturerService;

    @Autowired
    protected CarService carService;

    @Autowired
    protected SupplierService supplierService;

    @Test
    public void testManufacturer() {
        Manufacturer manufacturer = getManufacturer();
        Car car1 = CarServiceTest.getCar();
        Car car2 = CarServiceTest.getCar();
        Supplier supplier1 = SupplierServiceTest.getSupplier();
        Supplier supplier2 = SupplierServiceTest.getSupplier();

        manufacturer.addCar(car1);
        manufacturer.addCar(car2);
        manufacturer.addSupplier(supplier1);
        manufacturer.addSupplier(supplier2);

        manufacturerService.persistManufacturer(manufacturer);
        Manufacturer retrievedManufacturer = manufacturerService.findManufacturerWithCarsAndSuppliers(manufacturer.getId());
        Assert.assertFalse(retrievedManufacturer.getCars().isEmpty());
        Assert.assertFalse(retrievedManufacturer.getSuppliers().isEmpty());

        manufacturerService.deleteManufacturer(manufacturer.getId());
        Assert.assertNull(carService.findCar(car1.getId()));
        Assert.assertNull(carService.findCar(car2.getId()));
        Assert.assertNotNull(supplierService.findSupplier(supplier1.getId()));
        Assert.assertNotNull(supplierService.findSupplier(supplier2.getId()));
    }

    public static Manufacturer getManufacturer() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(System.currentTimeMillis() + random.nextInt(999) + "MA");

        return manufacturer;
    }

}
